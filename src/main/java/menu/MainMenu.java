package menu;

import java.util.List;
import java.util.Scanner;

import models.Categorie;
import models.Marque;

import services.CategorieProduit;
import services.MarqueCategorieProduit;
import services.MarqueProduit;
import services.ProduitService;
import services.Stock;
import view.AffichageMain;
import view.AffichageService;

public class MainMenu extends MenuService {

	private AffichageService viewMain;

	public MainMenu() {
		super();
	}

	@Override
	public void choixUser(Scanner scanner, int key) {

		switch (key) {
		case 1:
			viewMain.affichageListMarque();
			String nomMarque = traitement(scanner, Stock.listingMarque());
			ProduitService produitMarque = new MarqueProduit(new Marque(nomMarque), Stock.toList());
			MenuService selectMarque = new SelectionMenu(produitMarque);
			selectMarque.traiter(scanner);
			break;
		case 2:
			viewMain.affichageListCategorie();
			String nomCategorie = traitement(scanner, Stock.listingCategorie());
			ProduitService produitCategorie = new CategorieProduit(new Categorie(nomCategorie), Stock.toList());
			MenuService selectCategorie = new SelectionMenu(produitCategorie);
			selectCategorie.traiter(scanner);
			break;
		case 3:
			viewMain.affichageListMarque();
			String nomMark = traitement(scanner, Stock.listingMarque());
			Marque marque = new Marque(nomMark);
			viewMain.affichageListMarqueCategorie(marque);
			String nomMarkCategorie = traitement(scanner, Stock.listingMarqueCategorie(marque));
			ProduitService produitMarkCategorie = new MarqueCategorieProduit(marque, new Categorie(nomMarkCategorie),
					Stock.toList());
			MenuService selectMarkCategorie = new SelectionMenu(produitMarkCategorie);
			selectMarkCategorie.traiter(scanner);
			break;
		default:
			break;
		}
	}

	@Override
	public void affichageMenu() {
		viewMain = new AffichageMain();
	}

}
