package services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import models.Categorie;
import models.Produit;

/**
 * The Class ProduitCategorie. création d'une liste à partir d'une Catégorie
 *
 * @author Yvan Palliès
 */
public class CategorieProduit extends ProduitService implements Predicate<Produit> {

	/** The list. */
	private List<Produit> list;

	/** The categorie. */
	private Categorie categorie;

	/**
	 * Instantiates a new produit categorie.
	 *
	 * @param categorie the categorie
	 */
	public CategorieProduit(Categorie categorie, List<Produit> list) {
		super();
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
	 * Selection by allergens.
	 * trie en fonction des produits les plus allergènes
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByAllergens(int nb) {
		Collections.sort(list,Comparator.comparing(Produit::getAllergenesSize));
		return list.stream().limit(nb).collect(Collectors.toList());
	}
	/**
	 * Test.
	 *
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		return categorie.getNom().equals(produit.getCategorie().getNom());
	}

	@Override
	public List<Produit> selectionByAdditif(int nb) {
		Collections.sort(list,Comparator.comparing(Produit::getAdditifsSize));
		return list.stream().limit(nb).collect(Collectors.toList());
	}



}
