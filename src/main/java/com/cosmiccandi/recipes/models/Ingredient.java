/*	Recipe Relations
	Recipe 1 : M Instructions
	Recipe 1 : M Ingredients
	Ingredients 1 : M Measure
*/

package com.cosmiccandi.recipes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@ManyToOne
	private Recipe recipe;
	
	@ManyToOne
	private Measure measure;
	
	//Constructors
	public Ingredient () {}
	public Ingredient (Long id, String name, String preparation, Recipe recipe, Measure measure) {
		this.id = id;
		this.name = name;
		this.preparation = preparation;
		this.recipe = recipe;
		this.measure = measure;
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
	public Measure getMeasure() {
		return measure;
	}
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}	

}
