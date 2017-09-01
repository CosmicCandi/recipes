package com.cosmiccandi.recipes.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmiccandi.recipes.models.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
