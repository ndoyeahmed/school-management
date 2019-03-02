package com.hagyyo.school.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String libelle;
	
	@OneToMany(mappedBy = "matiere")
	private List<Cours> cours;
	@OneToMany(mappedBy = "matiere")
	private List<ProfMatiere> profMatieres;
	@OneToMany(mappedBy = "matiere")
	private List<MatiereClasse> matiereClasses;

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
