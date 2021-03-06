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
public class Instruction {
	
	//Instance Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instruction_id_seq")
	@SequenceGenerator(name="instruction_id_seq", sequenceName="instruction_id_seq")
	private long id;
	
	@Column(length=500, nullable=false)
	private String instructionText;	
	
	@ManyToOne
	@JsonIgnore
	private Recipe recipe;
	
	//Constructors
	public Instruction () {}
	public Instruction (Long id, String instructionText) {
		this.id = id;
		this.instructionText = instructionText;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
		
	public String getInstructionText() {
		return instructionText;
	}
	
	public void setInstructionText(String instructionText) {
		this.instructionText = instructionText;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
}
