package com.cosmiccandi.recipes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Ingredient {
	
	//Instance Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ingredient_id_seq")
	@SequenceGenerator(name="ingredient_id_seq", sequenceName="ingredient_id_seq")
	private Long id;
	
	@Column(length=80, nullable=false)
	private String name;
	
	@Column(length=30)
	private String preparation;
	
	//Constructors
	public Ingredient () {}
	public Ingredient (String name, String preparation) {
		this.name = name;
		this.preparation = preparation;
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreparation() {
		return preparation;
	}
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}	

}
