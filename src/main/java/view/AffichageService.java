package view;

import java.util.List;

import models.Marque;
import models.Produit;
import services.Stock;

/**
 * The Class AffichageMain.
 *
 * @author Yvan Palliès Aide à l'affichage des menus stockage des constantes
 *         d'affichage
 */
public abstract class AffichageService {
	
	/** The Constant NB_PRODUIT_AFFICHE */
	public static final int NB_PRODUIT_AFF=10;
	/** The Constant HEADER_1. */
	public static final String HEADER_1 = "                       __--  MENU  --__                             \n";

	/** The Constant HEADER_2. */
	public static final String HEADER_2 = "                       __------------__                             \n";

	/** The Constant SPACE. */
	public static final String SPACE = "|                                                                    |\n";

	/** The Constant BORDER. */
	public static final String BORDER = "+--------------------------------------------------------------------+\n";

//	les produit les plus allergenes
	/** The Constant QUITER. */
	public static final String QUITER = "| - 0. Pour sortir de l'application                                  |\n";

	public abstract void menu();

	public abstract void builder();

	public void affichageList(List<Produit> list) {
		list.forEach(System.out::println);
	}

	public void affichageListMarque() {
		Stock.listingMarque().entrySet().forEach(System.out::println);
	}

	public void affichageListCategorie() {
		Stock.listingCategorie().entrySet().forEach(System.out::println);
	}

	public void affichageListMarqueCategorie(Marque marque) {
		Stock.listingMarqueCategorie(marque).entrySet().forEach(System.out::println);
	}
}
