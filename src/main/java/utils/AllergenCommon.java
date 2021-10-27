package utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import models.Descriptif;
import models.Produit;

public class AllergenCommon extends FilterCommon implements Predicate<Produit>, Consumer<Produit>{


	@Override
	public void accept(Produit produit) {
		List<Descriptif> allergens = produit.getAllergenes();
		allergens.forEach(a -> {
			String[] nomAllergens = a.getNom().replaceAll("Allergene |De:", "").split(",");
			for (String nom : nomAllergens) {
				hahsMapCount.merge(nom.trim(), 1, Integer::sum);
			}
		});
	}

	/**
	 * Test. filtre les produits sans allergène
	 * 
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		return produit.getAllergenesSize() != 0;
	}







}