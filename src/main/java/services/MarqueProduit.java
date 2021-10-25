package services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import models.Marque;
import models.Produit;

/**
 * The Class ProduitMarque.
 *
 * @author Yvan Palliès Création de liste à partir d'une marque
 */
public class MarqueProduit extends ProduitService implements Predicate<Produit> {

	/** The marque. */
	private Marque marque;
	
	/** The list. */
	private List<Produit> list;
	/**
	 * Instantiates a new produit marque.
	 *
	 * @param marque the marque
	 */
	public MarqueProduit(Marque marque, List<Produit> list) {
		super();
		this.marque = marque;
		this.list=list.stream().filter(this::test).collect(Collectors.toList());
	}

	/**
	 * Selection by nutri score A.
	 *
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByNutriScoreA(int nb) {
		Collections.sort(list, Comparator.comparing(Produit::getNutritionGradeFr));
		return list.stream().limit(nb).collect(Collectors.toList());
	}

	/**
	 * Selection by nutri score F. reversed list
	 * 
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByNutriScoreF(int nb) {
		List<Produit> orderList = selectionByNutriScoreA(nb);
		Collections.reverse(orderList);
		return orderList;
	}

	/**
	 * Selection by allergens. trie en fonction des produits les plus allergènes
	 * 
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByAllergens(int nb) {
		Collections.sort(list, sortByNumberAllergens);
		return list.stream().limit(nb).collect(Collectors.toList());
	}

	/**
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		return marque.getNom().equals(produit.getMarque().getNom());
	}

}
