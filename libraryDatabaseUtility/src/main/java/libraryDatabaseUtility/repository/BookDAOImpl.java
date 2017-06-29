/* Implementation class for BookDAO interface*
 * 
 */
package libraryDatabaseUtility.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;

/**
 * @author Flavio Luis June 2017
 *
 */
public class BookDAOImpl implements BookDAO {
	
	private static final String INSERT_BOOK_SQL = "insert into books (title, author) values(?,?)";
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#addBookToDb(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public int addBookToDb(DataSource source, Book book) throws SQLException {
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		statement = connection.prepareStatement(INSERT_BOOK_SQL);
		
		statement.setString(1, book.getBookTitle());
		statement.setString(2, book.getBookAuthor());
		
		result = statement.executeUpdate();
		
		return result;
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
