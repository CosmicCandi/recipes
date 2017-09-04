/*	Recipe Relations
	Recipe 1 : M Instructions
	Recipe 1 : M Ingredients
	Ingredients 1 : M Measure
*/

package com.cosmiccandi.recipes.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	
	private String pictureUrl;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="recipe", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Instruction> instructions;
	
	@OneToMany(mappedBy="recipe", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Ingredient> ingredients;

	//Constructors
	public Recipe () {}
	public Recipe (Long id, String name, String description, String pictureUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.pictureUrl = pictureUrl;
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
	public List<Instruction> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getRecipePicture() {
		return pictureUrl;
	}
	
	public void setRecipePicture(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
}
