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
	
	public List<Book> getAllBooks(DataSource source);
	
	public int deleteRecord(DataSource source, long bookId);
	
	public List<Book> searchForBooks(DataSource source, String title);
	
	public List<Book> getCheckoutBooks(DataSource source);
	
	public List<Book> getAvailableBooks(DataSource source);
	
	public Book getBook(DataSource source, long id);
}
