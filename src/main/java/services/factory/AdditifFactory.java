package services.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Additif;
import utils.FilterNotNull;

/**
 * Class servant à la fabrication d'un produit.
 *
 * @author Yvan Palliès
 * Création de liste Additif
 */
public class AdditifFactory implements Services<Stream<String>, List<Additif>> {

	/**
	 * Builder.
	 *
	 * @param data the data
	 * @return the list
	 */
	@Override
	public List<Additif> builder(Stream<String> data) {
		String lineAdditif = data.collect(Collectors.joining());
		
//		un additif est toujours composé du préfix E
		if (!lineAdditif.startsWith("E"))
			return new ArrayList<Additif>();
		
		List<String> linesAdditifs = Arrays.asList(lineAdditif.replace(",", " ").split("E"));
		
		return linesAdditifs.stream()
				.filter(new FilterNotNull())
				.map(new AdditifBuilder())
				.collect(Collectors.toList());
	}

}
class AdditifBuilder implements Function<String, Additif> {

	@Override
	public Additif apply(String value) {
//		rajoute le E supprimé par la function split("E")
		return new Additif("E"+value);
	}

}