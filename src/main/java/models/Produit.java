package models;

import java.util.List;
import java.util.Objects;

import utils.FormatTo;

/**
 * The Class Produit.
 */
public class Produit  {

	/**  Categorie du poduit. */
	private Categorie categorie;
	
	/**  Marque du produit. */
	private Marque marque;
	
	/**  nom du produit. */
	private String nom;
	
	/**  nutri Score note de A<->F. */
	private String nutritionGradeFr;
	
	/**  ingrédients dans le produit. */
	private List<Ingredient> ingredients;
	
	/**  quantité pour chaque élement pour 100g. */
	private List<Element> elements;
	
	/**  list d'allergenes. */
	private List<Allergene> allergenes;
	
	/**  list d'additifs. */
	private List<Additif> additifs;

	/**
	 * #Constructor.
	 *
	 * @param categorie the categorie
	 * @param marque the marque
	 * @param nom the nom
	 * @param nutritionGradeFr the nutrition grade fr
	 * @param ingredients the ingredients
	 * @param elements the elements
	 * @param allergenes the allergenes
	 * @param additifs the additifs
	 */
	public Produit(Categorie categorie, Marque marque, String nom, String nutritionGradeFr,
			List<Ingredient> ingredients, List<Element> elements, List<Allergene> allergenes, List<Additif> additifs) {
		this.categorie = categorie;
		this.marque = marque;
		this.nom = FormatTo.nom(nom);
		this.nutritionGradeFr = nutritionGradeFr.toUpperCase();
		this.ingredients = ingredients;
		this.elements = elements;
		this.allergenes = allergenes;
		this.additifs = additifs;
	}

	/**
	 * Getter.
	 *
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Getter.
	 *
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * Getter.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter.
	 *
	 * @return the nutritionGradeFr
	 */
	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	/**
	 * Getter.
	 *
	 * @return the elements
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * Getter.
	 *
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Getter.
	 *
	 * @return the allergenes
	 */
	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	/**
	 * Getter.
	 *
	 * @return the additifs
	 */
	public List<Additif> getAdditifs() {
		return additifs;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder produitString = new StringBuilder();
		produitString.append(getNom()).append("\n").append(getMarque()).append("\n").append(getCategorie()).append("\n")
				.append(getNutritionGradeFr()).append("\n").append(getIngredients()).append("\n").append(getElements())
				.append("\n").append(getAdditifs()).append("\n").append(getAllergenes());

		return produitString.toString();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(marque, nom, nutritionGradeFr);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Produit))
			return false;
		Produit objProduit = (Produit) obj;
		return marque.equals(objProduit.marque) && nom.equals(objProduit.nom)
				&& nutritionGradeFr.equals(objProduit.nutritionGradeFr);
	}

}
