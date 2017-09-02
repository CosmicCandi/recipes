package com.cosmiccandi.recipes.api;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{recipe_id}")
	public Recipe getRecipeById(@PathVariable Long recipe_id) {
		Recipe recipe = recipeRepo.findOne(recipe_id);
		return recipe;
	}
	
	//Create
	@PostMapping("")
	public Recipe createRecipe (@RequestBody Recipe recipe) {
		return recipeRepo.save(recipe);
		
	}
	
	//Update
	
	@PutMapping("/{recipe_id}")
	public Recipe updateRecipeById(@RequestBody Recipe recipe, @PathVariable Long recipe_id) {
		recipe.setId(recipe_id);
		return recipeRepo.save(recipe);	
	}
	
	//Delete
	
	@DeleteMapping("/{recipe_id}")
	public Recipe deleteRecipeById(@PathVariable Long recipe_id) {
		try {
			Recipe recipe = recipeRepo.findOne(recipe_id);
			recipeRepo.delete(recipe);
			return recipe;
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		}
	}
	
	
}
