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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private double montantInscription;
	
	@ManyToOne
	@JoinColumn(name = "paiement", referencedColumnName = "id")
	private Paiement paiement;
	@OneToMany(mappedBy = "inscription")
	private List<Information> informations;
	@ManyToOne
	@JoinColumn(name = "anneScolaire", referencedColumnName = "id")
	private AnneScolaire anneScolaire;
	@OneToMany(mappedBy = "inscription")
	private List<Note> notes;
	@ManyToOne
	@JoinColumn(name = "classe", referencedColumnName = "id")
	private Classe classe;
	@ManyToOne
	@JoinColumn(name = "absence", referencedColumnName = "id")
	private Absence absence;
	@ManyToOne
	@JoinColumn(name = "retard", referencedColumnName = "id")
	private Retard retard;
	@ManyToOne
	@JoinColumn(name = "eleve", referencedColumnName = "id")
	private Eleve eleve;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontantInscription() {
		return montantInscription;
	}

	public void setMontantInscription(double montantInscription) {
		this.montantInscription = montantInscription;
	}
	
}
