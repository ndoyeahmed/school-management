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
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double note;
	
	@ManyToOne
	@JoinColumn(name = "inscription", referencedColumnName = "id")
	private Inscription inscription;
	@OneToMany(mappedBy = "note")
	private List<Reclamation> reclamations;
	@ManyToOne
	@JoinColumn(name = "evaluation", referencedColumnName = "id")
	private Evaluation evaluation;;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
	
	
	
}
