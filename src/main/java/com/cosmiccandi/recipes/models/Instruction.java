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

@Entity
public class Instruction {
	
	//Instance Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recipe_id_seq")
	@SequenceGenerator(name="recipe_id_seq", sequenceName="recipe_id_seq")
	private long id;
	
	@Column(length=500, nullable=false)
	private String instructionText;	
	
	@ManyToOne
	private Recipe recipe;
	
	//Constructors
	public Instruction () {}
	public Instruction (String instructionText) {
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
	
}
