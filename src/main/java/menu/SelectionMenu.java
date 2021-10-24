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
			viewSelection.affichageList(list.selectionByNutriScoreA(AffichageService.NB_PRODUIT_AFF));
			break;
		case 2:
//			"| - 2. Rechercher les produits à éviter  ( nutriScore F )
			viewSelection.affichageList(list.selectionByNutriScoreF(AffichageService.NB_PRODUIT_AFF));
			break;
		case 3:
//			"| - 3. Rechercher les plus Allergissants
			break;
		case 4:
//			"| - 4. Afficher les produits avec le plus d'ingredients 
			break;
		case 5:
//			"| - 5. Afficher les produits avec le plus additifs
			break;
		default:
			break;
		}
		key=0;
	}

	@Override
	public void affichageMenu() {
		viewSelection = new AffichageSelection();
	}

	public ProduitService getList() {
		return list;
	}

	public void setList(ProduitService list) {
		this.list = list;
	}

}
