/*Implementation class for LibraryView interface*
 * 
 */
package libraryDatabaseUtility.view;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.Member;
import libraryDatabaseUtility.model.Visitor;

/**
 * @author Flavio Luis June 2017
 *
 */
public class LibraryViewImpl implements LibraryView {
	private String userName;
	private String password;
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayLoginScreen(java.lang.String, java.lang.String)
	 */
	public boolean displayLoginScreen(String libraryUser, String libraryPassword) {
		final String message = "Enter password: ";
		boolean isValid = false;
		final String user = JOptionPane.showInputDialog(null, "Enter Username: ");
		this.userName = user;
		
		// Work around Eclipse ID# not having a real console.
		// Instead I used JOptionpane
		final JPasswordField passwordField = new JPasswordField();
		this.password = JOptionPane.showConfirmDialog(null, passwordField, message,
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION
				? new String(passwordField.getPassword()) : "";
				
		// to validate user input data with the data 
		// stored in the configuration file
		if(this.password.equals(libraryPassword) && this.userName.equals(libraryUser)) {
			displayMenu();
			isValid = true;
		}
		else {
			System.out.println("\nInvalid Username, password combination.");
		}
		
		return isValid;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayMenu()
	 */
	public void displayMenu() {
		System.out.println("\n-------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\tMAIN MENU");
		System.out.println("-------------------------------------------------------------------------------------------------------------\n");
		System.out.println("[1] Add Book\t\t\t\t[7] Add Member\t\t\t\t[13] Register Visitor");
		System.out.println("[2] Display All Books\t\t\t[8] Display All Member\t\t\t[14] Display Visitors for a Date");
		System.out.println("[3] Delete a Book\t\t\t[9] Delete a Member\t\t\t[15] Checkout Book");
		System.out.println("[4] Search a Book\t\t\t[10] Search a Member\t\t\t[16] Return Book");
		System.out.println("[5] Display checkout Books\t\t[11] Dislay Member with Late Fees\t[17] Quit");
		System.out.println("[6] Display available Books\t\t[12] Display Member with no Fees");
		
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayBooks(java.util.List)
	 */
	public void displayBooks(List<Book> books) {
		String format = "%-15s%-30s%-25s%-4s\n";
		System.out.format(format, "\nBook Id", " Book Title", " Book Author", " Available");
		System.out.format(format, "========", "==========", "===========", "=========");
		
		for(Book book : books) {
			System.out.format(format, book.getBookId(), book.getBookTitle(),
					book.getBookAuthor(), book.isAvailable());
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayMembers(java.util.List)
	 */
	public void displayMembers(List<Member> members) {
		String format = "%-20s%-25s%-25s%-25s\n";
		System.out.format(format, "\nMember Id", "First Name", "Last Name", "Fees");
		System.out.format(format, "==========", "============", "===========", "=========");
		
		for(Member member : members) {
			System.out.format(format, member.getMemberId(), member.getFirstName(),
					member.getLastName(), member.getFees());
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayDeletedRecordMessage(int)
	 */
	public void displayDeletedRecordMessage(int result) {
		if(result == 1) {
			System.out.println("\n" + result + " record deleted sucessfully");
		}
		else {
			System.out.println("\nError while attempting to delete record!");
		}

	}
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayAddedRecordMessage(int)
	 */
	public void displayAddedRecordMessage(int result) {
		if(result == 1) {
			System.out.println(result + " record added sucessfully");
		}
		else {
			System.out.println("\nError while attempting to add record!");
		}
	}

	public void displayVisitors(List<Visitor> visitors) {
		String format = "%-20s%-25s%-25s%-25s%-25s%-25s\n";
		System.out.format(format, "\nVisitor Id", " First Name", " Last Name", " Date of Visit", " Time In", " Time Out");
		System.out.format(format, "==========", "============", "===========", "=============", "=========", "=========");
		
		for(Visitor visitor : visitors) {
			System.out.format(format, visitor.getVisitorId(), visitor.getFirstName(),
					visitor.getLastName(), visitor.getDateOfvisit().toString(), 
					visitor.getTimeIn().toString(), visitor.getTimeout().toString());
		}
		
	}
	
	public void displayBookCheckoutMessage(boolean available) {
		if(available) {
			System.out.println("\nBook checkout successfully!");
		}
		else {
			System.out.println("Book could not be checkout!");
		}
	}
}
