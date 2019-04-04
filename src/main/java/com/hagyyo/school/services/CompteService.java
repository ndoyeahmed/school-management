package com.hagyyo.school.services;

import com.hagyyo.school.entities.*;
import com.hagyyo.school.repositories.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CompteService {

    @Value("${app.env.address}")
    private String url;

    @Autowired
    private UtilisateurRepository urepository;
    @Autowired
    private CompteRepository crepository;
    @Autowired
    private ProfilRepository prepository;
    @Autowired
    private ProfilUtilisateurRepository p_urepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    MailService mailService;

    public Utilisateur connectedUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String login = "";
        if(authentication.getPrincipal() instanceof UserDetails){
            UserDetails user = (UserDetails)authentication.getPrincipal();
            login = user.getUsername();
        }if(authentication.getPrincipal() instanceof String)
            login = (String)authentication.getPrincipal();
        return urepository
                .connexion(login, true)
                .map(user -> user)
                .orElse(null);
    }

    public boolean addUser(Utilisateur utilisateur, String profil, Compte compte, Boolean isAdd, Etablissement etablissement) throws Exception {

        if (isAdd || (!isAdd && urepository.findAll().size() == 0)) {
            Profil p = prepository.getDistinctByNom(profil).orElseThrow(() -> new Exception("Profil Inexistant"));
            String password = "passer@123"; //generatePassword();
            // insertion de l'utilisateur
            utilisateur.setDate(Timestamp.valueOf(LocalDateTime.now()));
            utilisateur.setEtat(true);
            utilisateur.setArchiver(false);
            utilisateur.setEtablissement(etablissement);
            //urepository.save(utilisateur);
            utilisateur = urepository.save(utilisateur);
            // Creation du compte de l'utilisateur
            compte.setPassword(encoder.encode(password));
            compte.setPasswordSet(false);
            compte.setUtilisateur(utilisateur);
            crepository.save(compte);
            // Ajout du profil
            ProfilUtilisateur pu = p_urepository.getDistinctByProfilIdAndUtilisateurId(p.getId(), utilisateur.getId()).orElse(new ProfilUtilisateur());
            pu.setProfil(p);
            pu.setDateAjout(Timestamp.valueOf(LocalDateTime.now()));
            pu.setUtilisateur(utilisateur);
            p_urepository.save(pu);
            // send a mail to confirm the creation af the account
            email(utilisateur, compte, password);
        }
        return true;
    }

    public void email(Utilisateur utilisateur, Compte compte, String password){
        try {
            String subject = "Confirmation de la creation du compte";
            String body = "Bonjour " + utilisateur.getPrenom() + " " + utilisateur.getNom() + ". Vous recevez ce mail  pour confirmer la creation de votre" +
                    " compte sur la plateforme School-management.<br/></br> Votre mot de passe est " + password;
            mailService.send(compte.getEmail(), subject, body);
            // utilisateur.setEtat(true);
            //urepository.save(utilisateur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public Boolean forgotEmail(String email, String token) throws Exception {
        Utilisateur utilisateur = urepository.connexion(email, true).orElseThrow(() -> new Exception("Utilisateur Inexistant"));
        Compte compte = utilisateur.getCompte();
        try {
            String subject = "Reinitialisation du mot de passe";
            String body = "Bonjour " + utilisateur.getPrenom() + " " + utilisateur.getNom() + ". Vous recevez ce mail  pour vous permettre de reinitialiser votre" +
                    " mot de passe sur la plateforme Madjindo. Veillez <a href='"+ url + "/change-password/" + token +"'>cliquer ici</a>.<br/></br> afin de commencer.";
            mailService.send(compte.getEmail(), subject, body);
            utilisateur.setEtat(true);
            urepository.save(utilisateur);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }*/

    public List<Profil> profilList() {
        Utilisateur u = connectedUser();
        if (u.getProfilUtilisateurs().get(0).getProfil().getNom().equals("Administrateur")) {
            return prepository.allForAdministrateur().orElse(new ArrayList<>());
        }
        return prepository.findAll() != null ? prepository.findAll() : new ArrayList<>();
    }

    // Generate a radom String
    private String generatePassword() {
        String generatedString = RandomStringUtils.random(10, true, true);
        System.out.println(generatedString);
        return generatedString;
    }

    public List<Utilisateur> utilisateurList(){
        Utilisateur utilisateur = connectedUser();

        if (utilisateur.getProfilUtilisateurs().get(0).getProfil().getNom().equals("Super Administrateur"))
            return urepository.all().orElse(new ArrayList<>());
        else if (utilisateur.getProfilUtilisateurs().get(0).getProfil().getNom().equals("Administrateur"))
            return urepository.getAllByEtablissement(utilisateur.getEtablissement().getId()).orElse(new ArrayList<>());
        else
            return new ArrayList<>();
    }

    public Boolean forgotPassword(String email, String password) throws Exception {
        Utilisateur utilisateur = urepository.connexion(email, true).orElseThrow(() -> new Exception("Utilisateur Inexistant"));
        Compte compte = utilisateur.getCompte();
        compte.setPassword(encoder.encode(password));
        crepository.save(compte);
        return true;
    }

    public Boolean changeStatusUser(String email, Boolean etat) {
        Utilisateur utilisateur = urepository.findByEmail(email).orElse(null);
        if (utilisateur != null) {
            utilisateur.setEtat(etat);
            urepository.save(utilisateur);
            return true;
        } else
            return false;
    }

    public Boolean changeUserProfil(String email, String profil) {
        Utilisateur utilisateur = urepository.findByEmail(email).orElse(null);
        if (utilisateur != null) {
           ProfilUtilisateur profilUtilisateur = utilisateur.getProfilUtilisateurs().get(0);
           Profil distinctByNom = prepository.getDistinctByNom(profil).orElse(null);
           if (distinctByNom != null) {
               profilUtilisateur.setProfil(distinctByNom);
               p_urepository.save(profilUtilisateur);
               return true;
           } else {
               return false;
           }

        } else
            return false;
    }

    public Boolean archiverUser(String email) {
        Utilisateur utilisateur = urepository.findByEmail(email).orElse(null);
        if (utilisateur != null) {
           utilisateur.setArchiver(true);
            urepository.save(utilisateur);
            return true;
        } else
            return false;
    }

    public Boolean updatePassword(String email, String password, String newpassword) throws Exception  {
        Utilisateur utilisateur = urepository.connexion(email, true).orElseThrow(() -> new Exception("Utilisateur Inexistant"));
        Compte compte = utilisateur.getCompte();
        if (encoder.matches(password, compte.getPassword())) {
            compte.setPassword(encoder.encode(newpassword));
            crepository.save(compte);
        } else {
            throw new Exception("Mot de passe Incorrect");
        }
        return true;
    }

    public Boolean hasProfile(String[] profils) {
        Utilisateur utilisateur = connectedUser();
        for (ProfilUtilisateur pf: utilisateur.getProfilUtilisateurs()) {
            if (Arrays.asList(profils).contains(pf.getProfil().getNom())) {
                return true;
            }
        }
        return false;
    }
}
