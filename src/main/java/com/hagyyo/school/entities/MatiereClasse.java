package com.hagyyo.school.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MatiereClasse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "classe", referencedColumnName = "id")
	private Classe classe;
	@ManyToOne
	@JoinColumn(name = "matiere", referencedColumnName = "id")
	private Matiere matiere;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
