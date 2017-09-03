package com.cosmiccandi.recipes.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmiccandi.recipes.models.Ingredient;
import com.cosmiccandi.recipes.services.IngredientRepository;
import com.cosmiccandi.recipes.services.MeasureRepository;
import com.cosmiccandi.recipes.services.RecipeRepository;

@RestController
@RequestMapping ("/api/recipes/{recipeId}/ingredients")
public class IngredientsController {
	
	//Instance Variables
	RecipeRepository recipeRepo;
	IngredientRepository ingredientRepo;
	MeasureRepository measureRepo;
	
	//Constructor
	public IngredientsController (RecipeRepository recipeRepo, IngredientRepository ingredientRepo, MeasureRepository measureRepo) {
		this.recipeRepo = recipeRepo;
		this.ingredientRepo = ingredientRepo;
		this.measureRepo = measureRepo;
	}
	
	//Create
	//Read
	@GetMapping("")
	public List<Ingredient> getAllIngredients() {
		return ingredientRepo.findAll();
	}
	
	@GetMapping("/{ingredientId}")
	public Ingredient getOneIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
		return ingredientRepo.findOne(ingredientId);
	}
	//Update
	//Destroy

}
