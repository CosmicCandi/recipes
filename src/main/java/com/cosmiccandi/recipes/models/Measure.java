package com.cosmiccandi.recipes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Measure {

	//Instance Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="measure_id_seq")
	@SequenceGenerator(name="measure_id_seq", sequenceName="measure_id_seq")
	private Long id;
	
	private int quantity;
	
	private Unit units;
		
	//Constructors
	public Measure () {}
	public Measure (int quantity, Unit units) {
		this.quantity = quantity;
		this.units = units;		
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Unit getUnits() {
		return units;
	}
	public void setUnits(Unit units) {
		this.units = units;
	}
	
}
