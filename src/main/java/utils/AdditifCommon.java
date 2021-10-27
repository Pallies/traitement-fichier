package utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import models.Produit;

public class AdditifCommon extends FilterCommon implements Consumer<Produit>, Predicate<Produit>, Function<Entry<String, Integer>, String>,
		Comparator<Entry<String, Integer>> {

	@Override
	public boolean test(Produit produit) {
		return produit.getAdditifsSize() != 0;
	}

	@Override
	public void accept(Produit produit) {
		produit.getAdditifs().forEach(additif->{
			String[] additifsName =additif.getNom().replaceAll("Additif ", "").split(",");
			for(String name : additifsName) {
				hahsMapCount.merge(name.trim().replaceAll("[^E[0-9A-Z]]{0,4} -", " - "), 1, Integer::sum);
			}
		});
	}

	/**Getter
	 * @return the additifsCount
	 */
	public HashMap<String, Integer> getAdditifsCount() {
		return hahsMapCount;
	}

}
