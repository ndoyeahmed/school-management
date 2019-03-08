package com.hagyyo.school.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Niveau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String libelle;

	private Boolean archiver;
	
	@OneToMany(mappedBy = "niveau")
	private List<Classe> classes;
	@ManyToOne
	@JoinColumn(name = "cycle", referencedColumnName = "id")
	private Cycle cycle;

	public Boolean getArchiver() {
		return archiver;
	}

	public void setArchiver(Boolean archiver) {
		this.archiver = archiver;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
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
