package services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import models.Categorie;
import models.Marque;
import models.Produit;

/**
 * The Class ProduitCategorieMarque. création d'une liste à partir d'une
 * Catégorie et d'une marque
 * 
 * @author Yvan Palliès
 */
public class MarqueCategorieProduit extends ProduitService implements Predicate<Produit> {

	/** The list. */
	private List<Produit> list;

	/** The categorie. */
	private Categorie categorie;

	/** The marque. */
	private Marque marque;

	/**
	 * Instantiates a new produit categorie marque.
	 *
	 * @param categorie the categorie
	 * @param marque    the marque
	 */
	public MarqueCategorieProduit(Marque marque, Categorie categorie, List<Produit> list) {
		super();
		this.marque = marque;
		this.categorie = categorie;
		this.list = list.stream().filter(this::test).collect(Collectors.toList());
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
	 * Predicate Test.
	 * 
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		String categorieName = produit.getCategorie().getNom();
		String marqueName = produit.getMarque().getNom();
		return categorie.getNom().equals(categorieName) && marque.getNom().equals(marqueName);
	}

}
