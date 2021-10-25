package services;

import java.util.List;

import models.Produit;

/**
 * The Class ProduitService.
 */
public abstract class ProduitService {
	

	/**
	 * Selection by nutri score.
	 *
	 * @param nb the nb
	 * @return the list
	 */
	public abstract List<Produit> selectionByNutriScoreA(int nb);
	public abstract List<Produit> selectionByNutriScoreF(int nb);
	public abstract List<Produit> selectionByAllergens(int nb);
	public abstract List<Produit> selectionByAdditif(int nb);
}
