package com.cosmiccandi.recipes.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmiccandi.recipes.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
