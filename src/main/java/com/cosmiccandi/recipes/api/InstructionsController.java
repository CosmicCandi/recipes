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

import com.cosmiccandi.recipes.models.Instruction;
import com.cosmiccandi.recipes.models.Recipe;
import com.cosmiccandi.recipes.services.InstructionRepository;
import com.cosmiccandi.recipes.services.RecipeRepository;

@RestController
@RequestMapping("/api/recipes/{recipeId}/instructions")
public class InstructionsController {

	// Instance Variables
	private RecipeRepository recipeRepo;
	private InstructionRepository instructionRepo;

	//Constructor
	public InstructionsController(InstructionRepository instructionRepo, RecipeRepository recipeRepo) {
		this.instructionRepo = instructionRepo;
		this.recipeRepo = recipeRepo;
	}

	//Create
	@PostMapping("")
	public Recipe addInstructionsToRecipe(@PathVariable Long recipeId, @RequestBody List<Instruction> instructions) {
		Recipe recipe = recipeRepo.findOne(recipeId);
		for (Instruction i : instructions) {
			i.setRecipe(recipe);
			instructionRepo.save(i);
			recipe.getInstructions().add(i);
		}
		recipeRepo.flush();
		return recipe;
	}
	
	// Read
	@GetMapping("")
	public List<Instruction> getAllInstructions() {
		return instructionRepo.findAll();
	}
	
	@GetMapping("/{instructionId}")
	public Instruction getAnInstructionByRecipeId (@PathVariable Long recipeId, @PathVariable Long instructionId) {
		return instructionRepo.findOne(instructionId);
	}

	// Update
	@PutMapping("/{instructionId}")
	public Recipe updateInstructionForRecipe(@PathVariable Long recipeId, @PathVariable Long instructionId, @RequestBody Instruction instruction) {
		Recipe recipe = recipeRepo.findOne(recipeId);
		instruction.setRecipe(recipe);
		instruction.setId(instructionId);
		instructionRepo.save(instruction);
		recipeRepo.flush();
		return recipe;
	}
	
	//Destroy
	@DeleteMapping("/{instructionId}")
	public Recipe deleteInstructionbyInstructionId(@PathVariable Long recipeId, @PathVariable Long instructionId) {
		Recipe recipe = recipeRepo.findOne(recipeId);
		try {
			Instruction instruction = instructionRepo.findOne(instructionId);
			instruction.setRecipe(null);
			instructionRepo.delete(instruction);
			recipeRepo.flush();
			return recipe;
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		}
	}
}
