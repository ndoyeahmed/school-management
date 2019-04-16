package com.hagyyo.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
public class Etablissement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String libelle;
	
	private Boolean etat;

	private Boolean isArchiver;
	
	@OneToMany(mappedBy = "etablissement")
	@JsonIgnore
	private List<Cycle> cycles;
	
	@OneToMany(mappedBy = "etablissement")
	@JsonIgnore
	private List<Utilisateur> utilisateurs;
	
	@OneToMany(mappedBy = "etablissement")
	@JsonIgnore
	private List<FonctionnaliteEtablissement> fonctionnaliteEtablissements;

	@ManyToOne
	@JoinColumn(name = "ville", referencedColumnName = "id")
	private Ville ville;

	public Boolean getArchiver() {
		return isArchiver;
	}

	public void setArchiver(Boolean archiver) {
		isArchiver = archiver;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public List<Cycle> getCycles() {
		return cycles;
	}

	public void setCycles(List<Cycle> cycles) {
		this.cycles = cycles;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
}
