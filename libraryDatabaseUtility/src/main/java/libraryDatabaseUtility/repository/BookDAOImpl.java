/* Implementation class for BookDAO interface*
 * 
 */
package libraryDatabaseUtility.repository;

import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;

/**
 * @author Flavio Luis June 2017
 *
 */
public class BookDAOImpl implements BookDAO {

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#addBookToDb(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public int addBookToDb(DataSource source, Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#getAllBooks(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Book> getAllBooks(DataSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#deleteRecord(libraryDatabaseUtility.model.DataSource, long)
	 */
	public int deleteRecord(DataSource source, long bookId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#searchForBooks(libraryDatabaseUtility.model.DataSource, java.lang.String)
	 */
	public List<Book> searchForBooks(DataSource source, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#getCheckoutBooks(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Book> getCheckoutBooks(DataSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#getAvailableBooks(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Book> getAvailableBooks(DataSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book getBook(DataSource source, long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
