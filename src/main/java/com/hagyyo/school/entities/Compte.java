package com.hagyyo.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private Boolean isPasswordSet;
    
    @OneToOne(cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    // @JsonBackReference
    @JsonIgnore
    private Utilisateur utilisateur;

    public Compte(){}

    public Compte(String email) {
        this.email = email;
    }

    public Boolean getPasswordSet() {
        return isPasswordSet;
    }

    public void setPasswordSet(Boolean passwordSet) {
        isPasswordSet = passwordSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
