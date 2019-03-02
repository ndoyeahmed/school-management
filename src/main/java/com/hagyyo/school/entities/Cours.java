package com.hagyyo.school.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String jours;
	
	private String heureDebut;
	
	private String heureFin;
	
	@OneToMany(mappedBy = "cours")
	private List<Absence> absences;
	@OneToMany(mappedBy = "cours")
	private List<Retard> retards;
	@ManyToOne
	@JoinColumn(name = "bulletin", referencedColumnName = "id")
	private Bulletin bulletin;
	@ManyToOne
	@JoinColumn(name = "professeur", referencedColumnName = "id")
	private Professeur professeur;
	@ManyToOne
	@JoinColumn(name = "matiere", referencedColumnName = "id")
	private Matiere matiere;
	@OneToMany(mappedBy = "cours")
	private List<Evaluation> evaluations;
	@ManyToOne
	@JoinColumn(name = "semestre",referencedColumnName = "id")
	private Semestre semestre;
	@OneToOne(cascade = CascadeType.ALL)
	private Classe classe;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJours() {
		return jours;
	}

	public void setJours(String jours) {
		this.jours = jours;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	
}
