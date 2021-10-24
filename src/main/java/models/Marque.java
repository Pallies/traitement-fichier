package models;

import utils.FormatTo;

/**
 * The Class Marque.
 *
 * @author Yvan Palliès Indique la Marque du produit
 */
public class Marque extends Descriptif {

	/**
	 * Instantiates a new marque.
	 *
	 * @param nom the nom
	 */
	public Marque(String nom) {
		super(FormatTo.nom(nom));
	}



	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Marque " + getNom();
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Marque))
			return false;
		Marque objMarque = (Marque) obj;
		return objMarque.getNom().equals(this.getNom());

	}
}
