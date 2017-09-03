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

import com.cosmiccandi.recipes.models.Measure;
import com.cosmiccandi.recipes.models.Recipe;
import com.cosmiccandi.recipes.services.MeasureRepository;
import com.cosmiccandi.recipes.services.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {

	private RecipeRepository recipeRepo;
	private MeasureRepository measureRepo;
	
	public RecipesController (RecipeRepository recipeRepo, MeasureRepository measureRepo) {
		this.recipeRepo = recipeRepo;
		this.measureRepo = measureRepo;
	}
	
	//Read
	@GetMapping("")
	public List<Recipe> getAllRecipes() {
		return recipeRepo.findAll();
	}
	
	@GetMapping("/{recipeId}")
	public Recipe getRecipeById(@PathVariable Long recipeId) {
		Recipe recipe = recipeRepo.findOne(recipeId);
		return recipe;
	}
	
	@GetMapping("/{recipeId}/measures")
	public List<Measure> getAllMeasures(@PathVariable Long recipeId) {
		return measureRepo.findByIngredientRecipeId(recipeId);
	}
	
	//Create
	@PostMapping("")
	public Recipe createRecipe (@RequestBody Recipe recipe) {
		return recipeRepo.save(recipe);
	}
	
	//Update
	
	@PutMapping("/{recipeId}")
	public Recipe updateRecipeById(@RequestBody Recipe recipe, @PathVariable Long recipeId) {
		recipe.setId(recipeId);
		return recipeRepo.save(recipe);	
	}
	
	//Delete
	
	@DeleteMapping("/{recipeId}")
	public Recipe deleteRecipeById(@PathVariable Long recipeId) {
		try {
			Recipe recipe = recipeRepo.findOne(recipeId);
			recipeRepo.delete(recipe);
			return recipe;
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		}
	}
	
	
}
