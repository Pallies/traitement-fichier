package services.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import models.Ingredient;

/**
 * Class servant à la fabrication d'un produit.
 *
 * @author Yvan Palliès
 * Création d'une liste d'ingrédients
 */
public class IngredientFactory implements Services<String,List<Ingredient>> {
	
	/**
	 * Builder.
	 *
	 * @param data ligne des ingrédients
	 * @return liste formatté d'ingrédients
	 */
	@Override
	public List<Ingredient> builder(String data) {
		return Arrays.asList(data.split(",")).stream()
				.map(Ingredient::new)
				.collect(Collectors.toList());
	}

}
