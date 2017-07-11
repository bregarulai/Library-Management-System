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
		
		System.out.println("\nGood Bye!");
		input.close();
	}
	
	private static void processUserChoice(LibraryControllerImpl libraryController, Scanner input, int choice) {
		
		// To execute different menu choices
		switch(choice) {
		// menu option to add book to the database
		case 1:
			System.out.println("\nEnter book title: ");
			String title = input.nextLine();
			System.out.println("Enter book author: ");
			String author = input.nextLine();
			libraryController.addBook(title, author);
			break;
		
		// menu option to display all books from the database
		case 2:
			libraryController.displayBooks();
			break;
			
		// menu option to delete a boook from database
		case 3:
			System.out.println("\nEnter book Id: ");
			int bookId = input.nextInt();
			libraryController.deleteBook(bookId);
			break;
			
		// menu option to search a book from database
		case 4:
			System.out.println("\nEnter book's title: ");
			String bookTitle = input.nextLine();
			libraryController.searchBook(bookTitle);
			break;
			
		// menu option to display checkout books
		case 5:
			
			break;
			
		// menu option to display available books
		case 6:
			
			break;
			
		//menu option to add member to database
		case 7:
			System.out.println("\nEnter first name: ");
			String firstName = input.nextLine();
			System.out.println("Enter last name: ");
			String lastName = input.nextLine();
			libraryController.addMember(firstName, lastName);
			break;
			
		// menu option to display all members in database
		case 8:
			libraryController.displayMembers();
			break;
			
		
			
		}
		
	}

}
