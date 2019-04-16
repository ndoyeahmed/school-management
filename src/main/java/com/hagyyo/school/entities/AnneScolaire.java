package com.hagyyo.school.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AnneScolaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String annee;
	
	private boolean encours;
	private boolean archiver;
	private Timestamp dateAjout;

	@OneToMany(mappedBy = "anneScolaire")
	private List<Inscription> inscriptions;

	public Timestamp getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public boolean isEncours() {
		return encours;
	}

	public void setEncours(boolean encours) {
		this.encours = encours;
	}
	
	
	
}
