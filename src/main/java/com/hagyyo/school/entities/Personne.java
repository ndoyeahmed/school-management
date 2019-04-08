package com.hagyyo.school.entities;

import javax.persistence.*;

@MappedSuperclass
public class Personne {

	protected String nom;

	protected String prenom;

	protected String telephone;

	protected String email;

	protected String adresse;

	protected String genre;

	protected String nationalite;

	public Personne() {}

	public Personne(String nom, String prenom, String telephone, String email, String adresse, String genre, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone =  telephone;
		this.email = email;
		this.adresse = adresse;
		this.genre = genre;
		this.nationalite = nationalite;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

}
