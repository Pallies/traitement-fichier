package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategorieTest {

	@Test
	public void test_name() {
		Categorie categorie = new Categorie("pains");
		String name="Pains";
		assertEquals(categorie.getNom(),name);
	}
	@Test
	public void test_name2() {
		Categorie categorie = new Categorie("Pains");
		String name="Pains";
		assertEquals(categorie.getNom(),name);
	}
	@Test
	public void test_toString() {
		Categorie categorie = new Categorie("Pains");
		String name="Pains";
		String nameTostring="Catégorie "+name;
		assertEquals(categorie.toString(), nameTostring);
	}
	@Test
	public void test_equals() {
		Categorie categorie =new Categorie("test");
		Categorie categorie2 =new Categorie("test");
		Categorie categorie3 =new Categorie("test_false");
		Additif additif = new Additif("test");
		assertEquals(categorie, categorie);
		assertEquals(categorie, categorie2);
		assertNotEquals(categorie, categorie3);
		assertNotEquals(categorie, categorie3);
		assertNotEquals(categorie, additif);
	}
	@Test
	public void test_hashCode() {
		Categorie categorie =new Categorie("hashCode");
		Categorie categorie2 =new Categorie("hashCode");
		assertEquals(categorie.hashCode(),categorie2.hashCode());
	}

}
