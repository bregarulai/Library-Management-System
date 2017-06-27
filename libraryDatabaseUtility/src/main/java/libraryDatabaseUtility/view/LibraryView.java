/* class responsible to display information
 * in the screen.
 * 
 */
package libraryDatabaseUtility.view;

import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis June 2017
 *
 */
public interface LibraryView {
	
	public boolean displayLoginScreen(String libraryUser, String libraryPassword);
	
	public void displayMenu();
	
	public void displayBooks(List<Book> books);
	
	public void displayMembers(List<Member> members);
	
	public void displayDeletedRecordMessage(int result);

}
