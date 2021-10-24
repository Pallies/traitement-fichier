package run;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class ReadFoodFact.
 *
 * @author Yvan Palliès Lecture du fichier
 */
public class ReadFoodFact {
	
	/**  emplacement du fichier source. */
	private static final String FILE_OPENFOODFACT = "C:/Users/Peac178/Documents/dev/Diginamic/Exercices/traitement-fichier/src/main/resources/open-food-facts.csv";

	/**
	 *  gestion de l'erreur
	 *  gestion de la liste vide.
	 *
	 * @return List<String> lignes du fichier
	 */
	public List<String> open() {
		List<String> fileList = Collections.emptyList();
		try {
			fileList = extractLines();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileList;
	}

	/**
	 * Ouverture du fichier.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private List<String> extractLines() throws IOException {
		Path path = Paths.get(FILE_OPENFOODFACT);
		List<String> file = Files.readAllLines(path,StandardCharsets.UTF_8);
		return file.stream().skip(1).collect(Collectors.toList());
	}
}
