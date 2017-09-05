package com.cosmiccandi.recipes.api;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cosmiccandi.recipes.models.Ingredient;
import com.cosmiccandi.recipes.models.Measure;
import com.cosmiccandi.recipes.models.Recipe;
import com.cosmiccandi.recipes.services.IngredientRepository;
import com.cosmiccandi.recipes.services.MeasureRepository;
import com.cosmiccandi.recipes.services.RecipeRepository;

@RestController
@RequestMapping("/api/ingredients/{ingredientId}/measures")
public class MeasuresController {

	// Instance Variables
	RecipeRepository recipeRepo;
	IngredientRepository ingredientRepo;
	MeasureRepository measureRepo;

	// Constructor
	public MeasuresController(RecipeRepository recipeRepo, IngredientRepository ingredientRepo,
			MeasureRepository measureRepo) {
		this.recipeRepo = recipeRepo;
		this.ingredientRepo = ingredientRepo;
		this.measureRepo = measureRepo;
	}

	// Create
	@PostMapping("")
	public Recipe addMeasureToRecipe(@PathVariable Long ingredientId, @RequestBody Measure measure) {
		Ingredient ingredient = ingredientRepo.findOne(ingredientId);
		ingredient.setMeasure(measure);
		measureRepo.save(measure);
		ingredientRepo.save(ingredient);
		return ingredient.getRecipe();
	}

	// Read
	@GetMapping("/{measureId}")
	public Measure getOneMeasure(@PathVariable Long recipeId, @PathVariable Long measureId) {
		return measureRepo.findOne(measureId);
	}

	// Update
	@PutMapping("/{measureId}")
	public Measure updateMeasureById(@PathVariable Long measureId, @PathVariable Long ingredientId, @RequestBody Measure measure) {
//		Ingredient ingredient = ingredientRepo.findOne(ingredientId);
		measure.setId(measureId);
		measureRepo.save(measure);
		measureRepo.flush();
		return measure;
	}

	// Destroy
	@DeleteMapping("/{measureId}")
	public Ingredient deleteMeasureById(@PathVariable Long measureId, @PathVariable Long ingredientId) {
		Ingredient ingredient = ingredientRepo.findOne(ingredientId);
		try {
			Measure measure = measureRepo.findOne(measureId);
			
			for (Ingredient i : measure.getIngredients()) {
				i.setMeasure(null);
				ingredientRepo.save(i);
			}
			measureRepo.delete(measure);
			ingredientRepo.flush();
			return ingredient;
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		}
	}

}
