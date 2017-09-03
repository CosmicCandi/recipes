package com.cosmiccandi.recipes.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmiccandi.recipes.models.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {

	@Query("select m from Measure m join m.ingredients mi where mi.recipe.id = ?1")
	List<Measure> findByIngredientRecipeId(Long recipeId);
	
}
