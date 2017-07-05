/* class responsible for implementation of LibraryController interface*
 * 
 */
package libraryDatabaseUtility.controller;

import java.sql.SQLException;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.repository.BookDAOImpl;
import libraryDatabaseUtility.repository.MemberDAO;
import libraryDatabaseUtility.repository.MemberDAOImpl;
import libraryDatabaseUtility.view.LibraryViewImpl;

/**
 * @author Flavio Luis June 2017
 *
 */
public class LibraryControllerImpl implements LibraryController {
	
	DataSource source;
	LibraryViewImpl view;
	MemberDAOImpl memberDao;
	BookDAOImpl bookDao;

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#addBook(java.lang.String, java.lang.String)
	 */
	public void addBook(String title, String author) {
		source = DataSource.getInstance();
		view = new LibraryViewImpl();
		Book book = new Book();
		book.setBookTitle(title);
		book.setBookAuthor(author);
		int result = 0;
		try {
			result = bookDao.addBookToDb(source, book);
			view.displayAddedRecordMessage(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayBooks()
	 */
	public void displayBooks() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayLoginScreen(java.lang.String, java.lang.String)
	 */
	public boolean displayLoginScreen(String libraryUser, String libraryPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayMenu()
	 */
	public void displayMenu() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#deleteBook(long)
	 */
	public void deleteBook(long bookId) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#searchBook(java.lang.String)
	 */
	public void searchBook(String title) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#addMember(java.lang.String, java.lang.String)
	 */
	public void addMember(String firstName, String lastName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayMembers()
	 */
	public void displayMembers() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#deleteMember(long)
	 */
	public void deleteMember(long memberId) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#searchMember(java.lang.String)
	 */
	public void searchMember(String lastName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#registerVisitor(java.lang.String, java.lang.String)
	 */
	public void registerVisitor(String firstName, String lastName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#signoutVisitor(long)
	 */
	public void signoutVisitor(long visitorId) {
		// TODO Auto-generated method stub

	}

}
