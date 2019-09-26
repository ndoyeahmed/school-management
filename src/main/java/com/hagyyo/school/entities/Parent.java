package com.hagyyo.school.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent extends Personne{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String matricule;
	private String jeSuis;
	@OneToMany(mappedBy = "parent")
	private List<Eleve> eleves;
	@OneToMany(mappedBy = "parent")
	private List<Inscription> inscriptions;

	public Parent() {}

	public Parent(String nom, String prenom, String telephone, String email, String adresse, String genre, String nationalite) {
		super(nom, prenom, telephone, email, adresse, genre, nationalite);
	}

	public String getJeSuis() {
		return jeSuis;
	}

	public void setJeSuis(String jeSuis) {
		this.jeSuis = jeSuis;
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
}
