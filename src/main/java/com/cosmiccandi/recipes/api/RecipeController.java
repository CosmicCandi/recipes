package com.cosmiccandi.recipes.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmiccandi.recipes.models.Ingredient;
import com.cosmiccandi.recipes.models.Instruction;
import com.cosmiccandi.recipes.models.Measure;
import com.cosmiccandi.recipes.models.Recipe;
import com.cosmiccandi.recipes.services.IngredientRepository;
import com.cosmiccandi.recipes.services.InstructionRepository;
import com.cosmiccandi.recipes.services.MeasureRepository;
import com.cosmiccandi.recipes.services.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

	private RecipeRepository recipeRepo;
	private IngredientRepository ingredientRepo;
	private InstructionRepository instructionRepo;
	private MeasureRepository measureRepo;
	
	public RecipeController (RecipeRepository recipeRepo, IngredientRepository ingredientRepo, InstructionRepository instructionRepo, MeasureRepository measureRepo) {
		this.recipeRepo = recipeRepo;		
	}
	
	//Read
	@GetMapping("")
	public List<Recipe> getAllRecipes() {
		return recipeRepo.findAll();
	}
	
	//Create
	@PostMapping("")
	public Recipe createRecipe (@RequestBody Recipe recipe) {
		return recipeRepo.save(recipe);
		
	}
		
	//Update
	
	//Delete
	
	
	
}
