
package menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import view.AffichageService;

/**
 * The Class MenuService.
 */
public abstract class MenuService {

	/**
	 * Traiter.
	 *
	 * @param scanner the scanner
	 */
	public void traiter(Scanner scanner) {
		int key = Integer.MAX_VALUE;
		do {
			affichageMenu();
			try {
				key = scanner.nextInt();
				choixUser(scanner, key);
			} catch (InputMismatchException e) {
				affichageErreur();
			}
			scanner.nextLine();
//			Retour au menu pricipal
			if (this instanceof SelectionMenu)
				break;
		} while (key != 0);

	}

	public String traitement(Scanner scanner, Map<Integer, String> map) {
		int limit = map.size();
		int key = limit + 1;
		do {
			try {
				key = scanner.nextInt();
			} catch (InputMismatchException e) {
				affichageErreur(limit);
			}
			scanner.nextLine();
		} while (key < 0 || key > limit);

		return map.get(key);
	}

	/**
	 * Choix user.
	 *
	 * @param scanner the scanner
	 * @param key     the key
	 */

	public abstract void choixUser(Scanner scanner, int key);

	public abstract void affichageMenu();

	public abstract void affichageErreur();

	public abstract void affichageErreur(int max);

}
