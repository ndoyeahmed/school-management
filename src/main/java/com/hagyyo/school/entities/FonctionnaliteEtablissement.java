package com.hagyyo.school.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FonctionnaliteEtablissement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	private Boolean etat;
	
	@ManyToOne
	@JoinColumn(name = "etablissement", referencedColumnName = "id")
	private Etablissement etablissement;
	
	@ManyToOne
	@JoinColumn(name = "fonctionnalite", referencedColumnName = "id")
	private Fonctionnalite fonctionnalite;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Fonctionnalite getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(Fonctionnalite fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}
	
}
