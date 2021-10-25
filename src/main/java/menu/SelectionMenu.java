package menu;

import java.util.Scanner;

import services.ProduitService;
import view.AffichageSelection;
import view.AffichageService;

public class SelectionMenu extends MenuService {

	private AffichageService viewSelection;
	private ProduitService list;

	protected SelectionMenu(ProduitService list) {
		super();
		this.setList(list);
	}

	@Override
	public void choixUser(Scanner scanner, int key) {
		switch (key) {
		case 1:
//			"| - 1. Rechercher les meilleurs produits ( nutriScore A )
			viewSelection.affichageList(list.selectionByNutriScoreA(AffichageService.NB_PRODUIT_A_AFFICHER));
			break;
		case 2:
//			"| - 2. Rechercher les produits à éviter  ( nutriScore F )
			viewSelection.affichageList(list.selectionByNutriScoreF(AffichageService.NB_PRODUIT_A_AFFICHER));
			break;
		case 3:
//			"| - 3. Rechercher les plus Allergissants
			viewSelection.affichageList(list.selectionByAllergens(AffichageService.NB_PRODUIT_A_AFFICHER));
			break;
		default:
			break;
		}
	}

	public ProduitService getList() {
		return list;
	}

	public void setList(ProduitService list) {
		this.list = list;
	}

	/**
	 * Affichage menu.
	 */
	@Override
	public void affichageMenu() {
		viewSelection = new AffichageSelection();
	}

	/**
	 * Affichage erreur.
	 */
	@Override
	public void affichageErreur() {
		viewSelection.affichageErreur();
	}

	/**
	 * Affichage erreur.
	 *
	 * @param max the max
	 */
	@Override
	public void affichageErreur(int max) {
		viewSelection.affichageErreur(max);
	}

}
