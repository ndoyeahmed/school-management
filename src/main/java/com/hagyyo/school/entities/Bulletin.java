package com.hagyyo.school.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bulletin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double moyenne;
	
	@OneToMany(mappedBy = "bulletin")
	private List<Cours> cours;  
	@OneToMany(mappedBy = "bulletin")
	private List<Appreciation> appreciations;  

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	
}
