/*class responsible to run the application*
 * 
 */
package libraryDatabaseUtility;

import java.util.Scanner;

import libraryDatabaseUtility.controller.LibraryControllerImpl;

/**
 * @author Flavio Luis June 2017
 *
 */
public class App {
	private static final int MAX_LOGIN_ATTEMPTS = 5;
	private static final int QUIT_SENTINEL = 9;

	public static void main(String[] args) {
		
		LibraryControllerImpl libraryController = new LibraryControllerImpl();
		
		// to set library user credentials
		String userName = libraryController.getSource().getLibraryUser();
		String password = libraryController.getSource().getLibraryPassword();
		boolean validLogin;
		
		// to validate library user credential and display
		// login screen
		validLogin = libraryController.displayLoginScreen(userName, password);
		int counter = 0;
		
		// to keep asking for valid login info
		while(!validLogin) {
			counter++;
			
			if(counter >= MAX_LOGIN_ATTEMPTS) {
				System.out.println("\nYou have reached your limit of attempts.  \nGood Bye!");
				System.exit(0);
			}
			validLogin = libraryController.displayLoginScreen(userName, password);
		}
		
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.println("Enter choice: ");
		choice = input.nextInt();
		
		// to keep displaying main menu to the user
		// until a sentinel value is entered
		while(choice != QUIT_SENTINEL) {
			input.nextLine();
			
			processUserChoice(libraryController, input, choice);
			
			libraryController.displayMenu();
			System.out.print("Enter choice: ");
			choice = input.nextInt();
		}

	}
	
	private static void processUserChoice(LibraryControllerImpl libraryController, Scanner input, int choice) {
		
		
	}

}
