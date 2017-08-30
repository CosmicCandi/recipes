package com.cosmiccandi.recipes.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmiccandi.recipes.models.Recipe;
import com.cosmiccandi.recipes.services.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

	private RecipeRepository recipeRepo;
	
	public RecipeController (RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
		Recipe recipe;
		recipeRepo.save(new Recipe("The good stuff", "A great recipe"));
		recipeRepo.save(new Recipe("Not so good stuff", "Makes for a horrible recipe!"));
	}
	
	@GetMapping("")
	public List<Recipe> getAllRecipes() {
		return recipeRepo.findAll();
	}
	
}
