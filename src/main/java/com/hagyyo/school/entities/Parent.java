package com.hagyyo.school.entities;

import org.springframework.data.repository.query.Param;

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
	
	@OneToMany(mappedBy = "parent")
	private List<Eleve> eleves;

	public Parent() {}

	public Parent(String nom, String prenom, String telephone, String email, String adresse, String genre, String nationalite) {
		super(nom, prenom, telephone, email, adresse, genre, nationalite);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
