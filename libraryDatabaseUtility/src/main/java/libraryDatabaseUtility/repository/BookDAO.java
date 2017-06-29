/* Interface to access the book table*
 * 
 */
package libraryDatabaseUtility.repository;

import java.sql.SQLException;
import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;

/**
 * @author Flavio Luis
 *
 */
public interface BookDAO {
	
	public int addBookToDb(DataSource source, Book book) throws SQLException;
	
	public List<Book> getAllBooks(DataSource source) throws SQLException;
	
	public int deleteRecord(DataSource source, long bookId) throws SQLException;
	
	public List<Book> searchForBooks(DataSource source, String title) throws SQLException;
	
	public List<Book> getCheckoutBooks(DataSource source);
	
	public List<Book> getAvailableBooks(DataSource source);
	
	public Book getBook(DataSource source, long id);
}
