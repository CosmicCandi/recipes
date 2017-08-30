package com.cosmiccandi.recipes.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipe {
	
	//Instance Variables
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recipe_id_seq")
	@SequenceGenerator(name="recipe_id_seq", sequenceName="recipe_id_seq")
	private Long id;
	
	@Column(length=80, nullable=false)
	private String name;
	
	@Column(length=255)
	private String description;
	
	@ManyToMany
	@JoinTable(name="RECIPES_INSTRUCTIONS_JOIN")
	private List<Instruction> instructions;
		
	//Constructors
	public Recipe () {}
	public Recipe (String name, String description) {
		this.name = name;
		this.description = description;
		
		
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
