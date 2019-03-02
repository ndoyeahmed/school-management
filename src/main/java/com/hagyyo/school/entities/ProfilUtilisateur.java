package com.hagyyo.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class ProfilUtilisateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Timestamp dateAjout;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur" , referencedColumnName = "id")
	// @JsonBackReference
	@JsonIgnore
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "profil", referencedColumnName = "id")
	// @JsonManagedReference
	private Profil profil;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Utilisateur getUtilisateur() { return utilisateur; }

	public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

	public Profil getProfil() { return profil; }

	public void setProfil(Profil profil) { this.profil = profil; }
}
