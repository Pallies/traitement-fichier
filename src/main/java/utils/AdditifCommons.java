package utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import models.Produit;

public class AdditifCommons implements Consumer<Produit>, Predicate<Produit>, Function<Entry<String, Integer>, String>,
		Comparator<Entry<String, Integer>> {

	private HashMap<String, Integer> additifsCount = new HashMap<>();

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o2.getValue() - o1.getValue();
	}

	@Override
	public String apply(Entry<String, Integer> hashmap) {
		StringBuilder builderString = new StringBuilder();
		return builderString.append(hashmap.getKey()).append(" => ").append(hashmap.getValue()).toString();
	}

	@Override
	public boolean test(Produit produit) {
		return produit.getAdditifsSize() != 0;
	}

	@Override
	public void accept(Produit produit) {
		produit.getAdditifs().forEach(additif->{
			String[] additifsName =additif.getNom().replaceAll("Additif ", "").split(",");
			for(String name : additifsName) {
				additifsCount.merge(name.trim().replaceAll("[^E[0-9A-Z]]{0,4} -", " - "), 1, Integer::sum);
			}
		});
	}

	/**Getter
	 * @return the additifsCount
	 */
	public HashMap<String, Integer> getAdditifsCount() {
		return additifsCount;
	}

}
