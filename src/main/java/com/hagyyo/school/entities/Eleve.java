package com.hagyyo.school.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Eleve extends Personne{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String matricule;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datenaissance;
	
	private String lieunaissance;
	
	@OneToMany(mappedBy = "eleve")
	private List<Inscription> inscriptions;
	@ManyToOne
	@JoinColumn(name = "parent", referencedColumnName = "id")
	private Parent parent;

	public Eleve() {}

	public Eleve(String nom, String prenom, String telephone, String email, String adresse, String genre, String nationalite, String matricule, Date datenaissance, String lieunaissance) {
		super(nom, prenom, telephone, email, adresse, genre, nationalite);
		this.matricule = matricule;
		this.datenaissance = datenaissance;
		this.lieunaissance = lieunaissance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getLieunaissance() {
		return lieunaissance;
	}

	public void setLieunaissance(String lieunaissance) {
		this.lieunaissance = lieunaissance;
	}

}
