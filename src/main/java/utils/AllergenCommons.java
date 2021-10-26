package utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import models.Descriptif;
import models.Produit;

public class AllergenCommons implements Predicate<Produit>, Consumer<Produit>, Comparator<Entry<String, Integer>>,
		Function<Entry<String, Integer>, String> {

	private HashMap<String, Integer> allergensCount = new HashMap<>();

	@Override
	public void accept(Produit produit) {

		List<Descriptif> allergens = produit.getAllergenes();
		allergens.forEach(a -> {
			String[] nomAllergens = a.getNom().replaceAll("Allergene |De:", "").split(",");
			for (String nom : nomAllergens) {
				allergensCount.merge(nom.trim(), 1, Integer::sum);
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

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o2.getValue() - o1.getValue();
	}

	/**
	 * Getter
	 * 
	 * @return the allergensCount
	 */
	public HashMap<String, Integer> getAllergensCount() {
		return allergensCount;
	}

	@Override
	public String apply(Entry<String, Integer> hashMap) {
		StringBuilder builderString = new StringBuilder();
		return builderString.append(hashMap.getKey()).append(" => ").append(hashMap.getValue()).toString();
	}

}