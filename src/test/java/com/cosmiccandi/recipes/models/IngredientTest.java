package com.cosmiccandi.recipes.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.*;
import org.meanbean.test.BeanTester;

public class IngredientTest {
	Ingredient ingredient;
	Recipe recipe;
	Measure measure; 
	
	@Before
	public void setup() {
		recipe = new Recipe(1L, "Test Recipe", "Test Description", "http://via.placeholder.com/200x200");
		measure = new Measure(3L, 2, Unit.CUP);
		ingredient = new Ingredient(2L, "Avocado", "Halved", recipe, measure);
	}

	@Test
	public void testIngredient() {
		BeanTester beantester = new BeanTester();
		beantester.testBean(Ingredient.class);
	}

	@Test
	public void testThatAnIngredientHasARecipe() {
		assertThat(ingredient.getRecipe()).isNotNull();
		assertThat(ingredient.getRecipe()).isSameAs(recipe);
	}
	
	@Test
	public void testThatAnIngredientHasAMeasure() {	
		assertThat(ingredient.getMeasure()).isNotNull();
		assertThat(ingredient.getMeasure()).isSameAs(measure);
	}
}
