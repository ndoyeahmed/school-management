package com.hagyyo.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Profil implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String description;
	private Boolean etat;
	private Boolean isArchiver;
	
	@OneToMany(mappedBy = "profil")
	// @JsonBackReference
	@JsonIgnore
    private List<ProfilUtilisateur> profilUtilisateurs;

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Boolean getArchiver() {
		return isArchiver;
	}

	public void setArchiver(Boolean archiver) {
		isArchiver = archiver;
	}

	public List<ProfilUtilisateur> getProfilUtilisateurs() {
		return profilUtilisateurs;
	}

	public void setProfilUtilisateurs(List<ProfilUtilisateur> profilUtilisateurs) {
		this.profilUtilisateurs = profilUtilisateurs;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
