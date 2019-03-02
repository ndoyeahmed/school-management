package com.hagyyo.school.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hagyyo.school.entities.Compte;
import com.hagyyo.school.entities.Utilisateur;
import com.hagyyo.school.security.TokenProvider;
import com.hagyyo.school.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CompteController {

    @Autowired
    private CompteService compteService;
    @Autowired
    private AuthenticationManager authenticationManager;

    //@Bean
    public TokenProvider tokenProvider() { return new TokenProvider(); }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginVM userVM, HttpServletResponse response) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userVM.getLogin(), userVM.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider().createToken(authentication);
            response.addHeader(TokenProvider.HEADER, "Bearer " + jwt);
            return ResponseEntity.ok(new JWTToken(jwt));
        }catch (Exception ae){
            return new ResponseEntity<>(Collections.singletonMap("AuthenticationException",
                    ae.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    /*@PostMapping("/forgot-password")
    public ResponseEntity forgotPassword(@RequestBody @Email String email) {
        try {
            return new ResponseEntity<>(
                    Collections.singletonMap("success", compteService.forgotEmail(email, tokenProvider().createForgotToken(email))), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }*/

    @PostMapping("/change-password")
    public ResponseEntity changePassword(@RequestBody Map<String, String> body) {
        try {
            return new ResponseEntity<>(
                    Collections.singletonMap("success", compteService.forgotPassword(body.get("email"), body.get("password"))), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update-password")
    public ResponseEntity updatePassword(@RequestBody Map<String, String> body) {
        try {
            return new ResponseEntity<>(
                    Collections.singletonMap("success", compteService.updatePassword(body.get("email"), body.get("password"), body.get("newpassword"))), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/retrieve-email")
    public ResponseEntity emailIdentity(@RequestBody String token) {
        return new ResponseEntity<>(Collections.singletonMap("email", tokenProvider().decodeForgetToken(token)), HttpStatus.OK);
    }

    @GetMapping("/utilisateur-connecte")
    public ResponseEntity getUser() {
        return ResponseEntity.ok(compteService.connectedUser());
    }

    // Token Class
    static class JWTToken {
        private String idToken;
        JWTToken(String idToken) {
            this.idToken = idToken;
        }
        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }
        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }

    static class LoginVM {
        @NotNull
        private String login;
        @NotNull
        private String password;

        private Boolean rememberMe;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getRememberMe() { return rememberMe; }

        public void setRememberMe(Boolean rememberMe) { this.rememberMe = rememberMe; }
    }

    @GetMapping("/liste-profils")
    @PreAuthorize("hasAuthority('Administrateur')")
    public ResponseEntity profilList() {
        return ResponseEntity.ok(compteService.profilList());
    }

    @PostMapping("/ajouter-utilisateur")
    @PreAuthorize("hasAuthority('Administrateur')")
    public ResponseEntity createUser(@RequestBody Map<String, String> body) {
        try {
            Utilisateur utilisateur = new Utilisateur(body.get("nom"), body.get("prenom"), body.get("adresse"), body.get("telephone"));
            Compte compte = new Compte(body.get("email"));
            return new ResponseEntity<>
                    (Collections.singletonMap("success", compteService.addUser(utilisateur, body.get("profil"), compte, true))
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/liste-utilisateurs")
    @PreAuthorize("hasAuthority('Administrateur')")
    public ResponseEntity<List<Utilisateur>> listFicheDistribution() {
        List<Utilisateur> utilisateurs = compteService.utilisateurList() != null ? compteService.utilisateurList() : new ArrayList<>();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/liste-commercials")
    @PreAuthorize("hasAnyAuthority('Administrateur', 'Mgr Commercial')")
    public ResponseEntity<List<Utilisateur>> listCommercials() {
        List<Utilisateur> commercials = compteService.listCommercials() != null ? compteService.listCommercials() : new ArrayList<>();
        return ResponseEntity.ok(commercials);
    }

}