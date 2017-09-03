package com.cosmiccandi.recipes.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmiccandi.recipes.models.Ingredient;
import com.cosmiccandi.recipes.models.Measure;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	List<Ingredient> findByRecipeId(Long recipeId);
}
