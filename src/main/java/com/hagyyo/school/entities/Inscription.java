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
	private Boolean isAllDocs;
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
	@ManyToOne
	@JoinColumn(name = "parent", referencedColumnName = "id")
	private Parent parent;

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

	public Boolean getAllDocs() {
		return isAllDocs;
	}

	public void setAllDocs(Boolean allDocs) {
		isAllDocs = allDocs;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public List<Information> getInformations() {
		return informations;
	}

	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}

	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}

	public void setAnneScolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Absence getAbsence() {
		return absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	public Retard getRetard() {
		return retard;
	}

	public void setRetard(Retard retard) {
		this.retard = retard;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
}
