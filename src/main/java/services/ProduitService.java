package services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import models.Produit;

/**
 * The Class ProduitService.
 */
public abstract class ProduitService {
	
	/** The produits. */
	private List<Produit> produits=new ArrayList<>();
	protected Comparator<Produit> sortByNumberAllergens= Comparator.comparing(
			Produit::getAllergenes,(all1,all2)-> all2.size()-all1.size());
	/**
	 * Selection by nutri score.
	 *
	 * @param nb the nb
	 * @return the list
	 */
	public abstract List<Produit> selectionByNutriScoreA(int nb);
	public abstract List<Produit> selectionByNutriScoreF(int nb);
	public abstract List<Produit> selectionByAllergens(int nb);

	/**Getter
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	public Produit getProduit(int index) {
		return produits.get(index);
	}

	/**Setter
	 * @param produits the produits to set
	 */
	protected void setProduits(List<Produit> produits) {
		this.produits = produits;
	}


}
