package com.cosmiccandi.recipes.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmiccandi.recipes.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
