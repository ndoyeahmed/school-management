package com.hagyyo.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    @Column(unique = true)
    private String telephone;
    private Timestamp date;
    private Boolean etat;
    private Boolean isArchiver;
    private boolean enabled;

    @OneToMany(mappedBy = "utilisateur")
    private List<ProfilUtilisateur> profilUtilisateurs;

    @OneToOne(mappedBy = "utilisateur")
    @PrimaryKeyJoinColumn
    private Compte compte;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Paiement> paiements;
    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Classe> classes;
    @ManyToOne
    @JoinColumn(name = "etablissement", referencedColumnName = "id")
    private Etablissement etablissement;

    public Utilisateur() {
        super();
        this.enabled = false;
    }

    public Utilisateur(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getArchiver() {
        return isArchiver;
    }

    public void setArchiver(Boolean archiver) {
        isArchiver = archiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Boolean getEtat() { return etat; }

    public void setEtat(Boolean etat) { this.etat = etat; }

    public String getNom_complet() {
        return prenom + " " + nom;
    }

    public List<ProfilUtilisateur> getProfilUtilisateurs() { return profilUtilisateurs; }

    public void setProfilUtilisateurs(List<ProfilUtilisateur> profilUtilisateurs) {
        this.profilUtilisateurs = profilUtilisateurs;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
