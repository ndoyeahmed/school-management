package com.hagyyo.school.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String libelle;

	private Boolean archiver;
	
	@OneToMany(mappedBy = "classe")
	private List<Inscription> inscriptions;
	@OneToOne(mappedBy = "classe")
	private Cours cours;
	@ManyToOne
	@JoinColumn(name = "serie", referencedColumnName = "id")
	private Serie serie;
	@OneToMany(mappedBy = "classe")
	private List<MatiereClasse> matiereClasses;
	@ManyToOne
	@JoinColumn(name = "niveau", referencedColumnName = "id")
	private Niveau niveau;
	@ManyToOne
	@JoinColumn(name = "utilisateur", referencedColumnName = "id")
	private Utilisateur utilisateur;

	public Boolean getArchiver() {
		return archiver;
	}

	public void setArchiver(Boolean archiver) {
		this.archiver = archiver;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
}
