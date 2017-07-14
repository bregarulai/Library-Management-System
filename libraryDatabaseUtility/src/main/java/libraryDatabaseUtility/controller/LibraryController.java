/* Interface that interact with main class, 
 * the view class and data class*
 * 
 */
package libraryDatabaseUtility.controller;

/**
 * @author Flavio Luis June 2017
 *
 */
public interface LibraryController {
	
	public void addBook(String title, String author);
	
	public void displayBooks();
	
	public boolean displayLoginScreen(String libraryUser, String libraryPassword);
	
	public void displayMenu();
	
	public void deleteBook(long bookId);
	
	public void searchBook(String title);
	
	public void addMember(String firstName, String lastName);
	
	public void displayMembers();
	
	public void deleteMember(long memberId);
	
	public void searchMember(String lastName);
	
	public void registerVisitor(String firstName, String lastName);
	
	public void signoutVisitor(String lastName);

}
