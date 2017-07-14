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
	private static final int QUIT_SENTINEL = 17;

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
		
		System.out.print("\nEnter choice: ");
		choice = input.nextInt();
		
		// to keep displaying main menu to the user
		// until a sentinel value is entered
		while(choice != QUIT_SENTINEL) {
			input.nextLine();
			
			processUserChoice(libraryController, input, choice);
			
			libraryController.displayMenu();
			System.out.print("\nEnter choice: ");
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
			System.out.print("\nEnter book title: ");
			String title = input.nextLine();
			System.out.print("Enter book author: ");
			String author = input.nextLine();
			libraryController.addBook(title, author);
			break;
		
		// menu option to display all books from the database
		case 2:
			libraryController.displayBooks();
			break;
			
		// menu option to delete a boook from database
		case 3:
			System.out.print("\nEnter book Id: ");
			int bookId = input.nextInt();
			libraryController.deleteBook(bookId);
			break;
			
		// menu option to search a book from database
		case 4:
			System.out.print("\nEnter book's title: ");
			String bookTitle = input.nextLine();
			libraryController.searchBook(bookTitle);
			break;
			
		// menu option to display checkout books
		case 5:
			libraryController.displayCheckoutBooks();
			break;
			
		// menu option to display available books
		case 6:
			libraryController.displayAvailableBooks();
			break;
			
		//menu option to add member to database
		case 7:
			System.out.print("\nEnter first name: ");
			String firstName = input.nextLine();
			System.out.print("Enter last name: ");
			String lastName = input.nextLine();
			libraryController.addMember(firstName, lastName);
			break;
			
		// menu option to display all members in database
		case 8:
			libraryController.displayMembers();
			break;
			
		// menu option to delete a member from database
		case 9:
			System.out.print("\nEnter member Id: ");
			int customerId = input.nextInt();
			libraryController.deleteMember(customerId);
			break;
			
		// menu option to search a member
		case 10:
			System.out.print("\nEnter member's last name: ");
			String memberLastName = input.nextLine();
			libraryController.searchMember(memberLastName);
			break;
			
		// menu option to display members with late fees
		case 11:
			
			break;
			
		// menu option to display members with no fees
		case 12:
			
			break;
			
		// menu option to register visitor
		case 13:
			System.out.print("\nEnter first name: ");
			String visitorFirstName = input.nextLine();
			System.out.print("Enter last name");
			String visitorLastName = input.nextLine();
			libraryController.registerVisitor(visitorFirstName, visitorLastName);
			break;
			
		// menu option to display visitors for a date
		case 14:
			System.out.println("\nEnter date: ");
			String dateInput = input.nextLine();
			libraryController.getVisitorForDate(dateInput);
			break;
			
		// menu option to checkout a book
		case 15:
			System.out.print("\nEnter member last name: ");
			String memberLname = input.nextLine();
			System.out.print("Enter book title: ");
			String bTitle = input.nextLine();
			libraryController.checkoutBook(bTitle, memberLname);
			break;
			
		// menu option to return a book
		case 16:
			System.out.print("\nEnter member last name: ");
			String memLastName = input.nextLine();
			System.out.print("Enter book title: ");
			String bookTitle2 = input.nextLine();
			libraryController.returnBook(bookTitle2, memLastName);
			break;
			
		default:
			System.out.println("\nInvalid choice");
			break;
			
		}
		
	}

}
