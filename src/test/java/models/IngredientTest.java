package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class IngredientTest {

	@Test
	public void test_name() {
		Ingredient ingredient = new Ingredient("pains");
		String name="pains";
		assertEquals(ingredient.getNom(),name);
	}
	@Test
	public void test_name2() {
		Ingredient ingredient = new Ingredient("pains_");
		String name="pains";
		assertEquals(ingredient.getNom(),name);
	}
	@Test
	public void test_toString() {
		Ingredient ingredient = new Ingredient("pains");
		String name="pains";
		String nameTostring="Ingrédient "+name;
		assertEquals(ingredient.toString(), nameTostring);
	}

	@Test
	public void test_hashCode() {
		Ingredient ingredient =new Ingredient("hashCode");
		Ingredient ingredient2 =new Ingredient("hashCode");
		assertEquals(ingredient.hashCode(),ingredient2.hashCode());
	}

}
