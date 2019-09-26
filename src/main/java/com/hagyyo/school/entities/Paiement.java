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
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private double montant;
	
	@ManyToOne
	@JoinColumn(name = "mois", referencedColumnName = "id")
	private Mois mois;
	@ManyToOne
	@JoinColumn(name = "typePaiement", referencedColumnName = "id")
	private TypePaiement typePaiement;
	@OneToOne(mappedBy = "paiement")
	private Derrogation derrogation;
	@ManyToOne
	@JoinColumn(name = "utilisateur", referencedColumnName = "id")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "paiement")
	private List<Inscription> inscriptions;

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

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
}
