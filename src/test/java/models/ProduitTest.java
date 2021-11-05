package models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import services.factory.ProductFactory;

public class ProduitTest {

	private static final String LINE = "Aliments et boissons à base de végétaux|Auchan|Soja Cuisine 5%|a|jus de _soja_ 95 %, huile de tournesol, sucre, émulsifiant : lécithine de _soja_, épaississants : gomme xanthane, carraghénanes.|285|5|1.9|0.5|3.1|0.04|||||||||||||||||0|en:soybeans|E322 - Lécithines,E322i - Lécithine,E407 - Carraghénanes,E415 - Gomme xanthane|";

	@Test
	public void test_Produit() {
		List<String> linesString = Arrays.asList(LINE.split("[|]"));
		ProductFactory produits = new ProductFactory();
		Produit produit = produits.builder(linesString);
		Categorie categorie = new Categorie("Aliments et boissons à base de végétaux");
		Marque marque = new Marque("Auchan");
		String nom = "Soja cuisine 5%";
		String nutriScore = "A";
		System.out.println(produit.getNom());
		assertEquals(categorie, produit.getCategorie());
		assertEquals(marque, produit.getMarque());
		assertEquals(nom, produit.getNom());
		assertEquals(nutriScore, produit.getNutritionGradeFr());
		assertEquals(4, produit.getAdditifsSize());
		assertEquals(1, produit.getAllergenesSize());
		assertEquals(6, produit.getIgredientsSize());
	}

	@Test
	public void test_JoiningCollection() {
		Descriptif additif = new Additif("E322i - Lécithine");
		Descriptif allergene = new Allergene("soybeans");

		List<Descriptif> descriptifList = new ArrayList<>();
		descriptifList.add(allergene);
		descriptifList.add(additif);
		
		List<String> linesString = Arrays.asList(LINE.split("[|]"));
		ProductFactory produits = new ProductFactory();
		Produit produit = produits.builder(linesString);
		String descriptifToString = produit.joiningCollection(descriptifList);
		System.out.println(descriptifToString);
		assertEquals("Soybeans\n E322i - lécithine", descriptifToString);
	}
}
