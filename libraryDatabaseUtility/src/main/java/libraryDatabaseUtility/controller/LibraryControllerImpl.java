/* class responsible for implementation of LibraryController interface*
 * 
 */
package libraryDatabaseUtility.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;
import libraryDatabaseUtility.model.Visitor;
import libraryDatabaseUtility.repository.BookDAOImpl;
import libraryDatabaseUtility.repository.MemberDAO;
import libraryDatabaseUtility.repository.MemberDAOImpl;
import libraryDatabaseUtility.repository.VisitorDAOImpl;
import libraryDatabaseUtility.view.LibraryViewImpl;

/**
 * @author Flavio Luis June 2017
 *
 */
public class LibraryControllerImpl implements LibraryController {
	
	DataSource source = DataSource.getInstance();
	LibraryViewImpl view = new LibraryViewImpl();
	MemberDAOImpl memberDao = new MemberDAOImpl();
	BookDAOImpl bookDao = new BookDAOImpl();
	VisitorDAOImpl visitorDao = new VisitorDAOImpl();

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#addBook(java.lang.String, java.lang.String)
	 */
	public void addBook(String title, String author) {
		Book book = new Book();
		book.setBookTitle(title);
		book.setBookAuthor(author);
		int result = 0;
		try {
			result = bookDao.addBookToDb(source, book);
			view.displayAddedRecordMessage(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayBooks()
	 */
	public void displayBooks() {
		List<Book> books;
		try {
			books = bookDao.getAllBooks(source);
			view.displayBooks(books);
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayLoginScreen(java.lang.String, java.lang.String)
	 */
	public boolean displayLoginScreen(String libraryUser, String libraryPassword) {
		boolean isValid = view.displayLoginScreen(libraryUser, libraryPassword);
		return isValid;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayMenu()
	 */
	public void displayMenu() {
		view.displayMenu();

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#deleteBook(long)
	 */
	public void deleteBook(long bookId) {
		try {
			int result = bookDao.deleteRecord(source, bookId);
			view.displayDeletedRecordMessage(result);
		} catch (SQLException e) {	
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#searchBook(java.lang.String)
	 */
	public void searchBook(String title) {
		List<Book> books;
		try {
			books = bookDao.searchForBooks(source, title);
			view.displayBooks(books);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#addMember(java.lang.String, java.lang.String)
	 */
	public void addMember(String firstName, String lastName) {
		Member member = new Member();
		member.setFirstName(firstName);
		member.setLastName(lastName);
		try {
			int result = memberDao.addCustomerToDb(source, member);
			view.displayAddedRecordMessage(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#displayMembers()
	 */
	public void displayMembers() {
		List<Member> members;
		try {
			members = memberDao.getAllMembers(source);
			view.displayMembers(members);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#deleteMember(long)
	 */
	public void deleteMember(long memberId) {
		try {
			int result = memberDao.deleteRecord(source, memberId);
			view.displayDeletedRecordMessage(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#searchMember(java.lang.String)
	 */
	public void searchMember(String lastName) {
		List<Member> members;
		try {
			members = memberDao.searchForMembers(source, lastName);
			view.displayMembers(members);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#registerVisitor(java.lang.String, java.lang.String)
	 */
	public void registerVisitor(String firstName, String lastName) {
		Visitor visitor = new Visitor();
		visitor.setFirstName(firstName);
		visitor.setLastName(lastName);
		
		try {
			int result = visitorDao.addVisitorToDb(source, visitor);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.controller.LibraryController#signoutVisitor(long)
	 */
	public void signoutVisitor(long visitorId) {
		// TODO Auto-generated method stub

	}

}
