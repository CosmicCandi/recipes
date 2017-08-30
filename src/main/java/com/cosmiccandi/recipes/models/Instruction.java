package com.cosmiccandi.recipes.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy="instructions")
	private List<Recipe> recipes;
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
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
