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
		
		MainMenu menu = new MainMenu();
		Scanner scanner = new Scanner(System.in);
		
		menu.traiter(scanner);
	}

}
