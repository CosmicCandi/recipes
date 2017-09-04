package com.cosmiccandi.recipes.models;

import static org.assertj.core.api.Assertions.*;
import org.junit.*;
import org.meanbean.test.BeanTester;

public class RecipeTest {
	private Recipe recipe;
	
	@Before
	public void setup() {
		recipe = new Recipe(4L, "Baloney Manicotti", "A disgusting dish!", "http://via.placeholder.com/200x200" );
	}
	
	@Test
	public void testRecipe() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(Recipe.class);
	}
	
	@Test
	public void testThatARecipeHasAnId() {
		//Assert
		assertThat(recipe.getId()).isEqualTo(4L);
	}
	

	@Test
	public void testThatARecipeHasAName() {
		//Assert
		assertThat(recipe.getName()).isNotNull();
		assertThat(recipe.getName()).isEqualTo("Baloney Manicotti");
	}
	
	@Test
	public void testThatARecipeHasADescription() {
		//Assert
		assertThat(recipe.getDescription()).isNotNull();
		assertThat(recipe.getDescription()).isEqualTo("A disgusting dish!");
	}
	
}
