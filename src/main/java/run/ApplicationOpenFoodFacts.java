package run;

import java.util.Scanner;

import menu.MainMenu;

/**
 * The Class ApplicationOpenFoodFacts.
 */
public class ApplicationOpenFoodFacts {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MainMenu menu = new MainMenu();
		menu.traiter(scanner);
	}

}
