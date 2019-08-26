package com.hagyyo.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cycle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String libelle;

	private Boolean archiver;
	
	@OneToMany(mappedBy = "cycle")
	@JsonIgnore
	private List<Niveau> niveaus;
	
	@ManyToOne
	@JoinColumn(name = "etablissement", referencedColumnName = "id")
	private Etablissement etablissement;

	public List<Niveau> getNiveaus() {
		return niveaus;
	}

	public void setNiveaus(List<Niveau> niveaus) {
		this.niveaus = niveaus;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Boolean getArchiver() {
		return archiver;
	}

	public void setArchiver(Boolean archiver) {
		this.archiver = archiver;
	}

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
