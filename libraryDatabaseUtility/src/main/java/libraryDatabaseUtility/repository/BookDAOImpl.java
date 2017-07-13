/* Implementation class for BookDAO interface*
 * 
 */
package libraryDatabaseUtility.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;

/**
 * @author Flavio Luis June 2017
 *
 */
public class BookDAOImpl implements BookDAO {
	
	private static final String INSERT_BOOK_SQL = "insert into books (title, author) values(?,?)";
	private static final String SELECT_ALL_BOOKS_SQL = "select * from books";
	private static final String DELETE_RECORD_SQL = "delete from books where ID = ?";
	private static final String SEARCH_BOOK_SQL = "select * from books where title = ?";
	private static final String UPDATE_AVAILABLE_COLUMN_SQL = "update books set available = ? where ID = ?";
	private static final String UPDATE_MEMBER_ID_COLUMN_SQL = "update books set memberId = ? where ID = ?";
	private static final String GET_BOOK_SQL = "select * from books where ID = ?";
	private static final String GET_CHECKOUT_BOOKS_SQL = "select * from books where available = false";
	private static final String GET_AVAILABLE_BOOKS_SQL = "select * from books where available = true";
	
	// no arg constructor
	public BookDAOImpl() {
		
	}
	
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
	public List<Book> getAllBooks(DataSource source) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		List<Book> books = new ArrayList<Book>();
		
		statement = connection.prepareStatement(SELECT_ALL_BOOKS_SQL,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery();
		
		// To map resultSet to book object
		while(resultSet.next()) {
			Book book = new Book();
			book.setBookId(resultSet.getLong("ID"));
			book.setBookTitle(resultSet.getString("title"));
			book.setBookAuthor(resultSet.getString("author"));
			book.setAvailable(resultSet.getBoolean("available"));
			books.add(book);
		}
		
		return books;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#deleteRecord(libraryDatabaseUtility.model.DataSource, long)
	 */
	public int deleteRecord(DataSource source, long bookId) throws SQLException {
		int result = 0;
		Connection connection = source.getConnection();
		PreparedStatement statement = null;
		
		statement = connection.prepareStatement(DELETE_RECORD_SQL);
		statement.setLong(1, bookId);
		result = statement.executeUpdate();
		
		return result;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#searchForBooks(libraryDatabaseUtility.model.DataSource, java.lang.String)
	 */
	public List<Book> searchForBooks(DataSource source, String title) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		statement = connection.prepareStatement(SEARCH_BOOK_SQL);
		statement.setString(1, title);
		resultSet = statement.executeQuery();
		
		// To map resultSet to book object
		while(resultSet.next()) {
			Book book = new Book();
			book.setBookId(resultSet.getLong("ID"));
			book.setBookTitle(resultSet.getString("title"));
			book.setBookAuthor(resultSet.getString("author"));
			book.setAvailable(resultSet.getBoolean("available"));
			books.add(book);
		}
		
		return books;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#getCheckoutBooks(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Book> getCheckoutBooks(DataSource source) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		statement = connection.prepareStatement(GET_CHECKOUT_BOOKS_SQL);
		
		resultSet = statement.executeQuery();
		
		// To map resultSet to book object
		while(resultSet.next()) {
			Book book = new Book();
			book.setBookId(resultSet.getLong("ID"));
			book.setBookTitle(resultSet.getString("title"));
			book.setBookAuthor(resultSet.getString("author"));
			book.setAvailable(resultSet.getBoolean("available"));
			book.setCheckoutDate(resultSet.getDate("checkout"));
			books.add(book);
		}
		return books;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.BookDAO#getAvailableBooks(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Book> getAvailableBooks(DataSource source) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		statement = connection.prepareStatement(GET_AVAILABLE_BOOKS_SQL);
		
		resultSet = statement.executeQuery();
		
		// To map resultSet to book object
		while(resultSet.next()) {
			Book book = new Book();
			book.setBookId(resultSet.getLong("ID"));
			book.setBookTitle(resultSet.getString("title"));
			book.setBookAuthor(resultSet.getString("author"));
			book.setAvailable(resultSet.getBoolean("available"));
			
			books.add(book);
		}
		return books;
	}

	public Book getBook(DataSource source, long id) throws SQLException {
		Book book = new Book();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		statement = connection.prepareStatement(GET_BOOK_SQL);
		statement.setLong(1, id);
		resultSet = statement.executeQuery();
		
		// To map resultSet to book object
		while(resultSet.next()) {			
			book.setBookId(resultSet.getLong("ID"));
			book.setBookTitle(resultSet.getString("title"));
			book.setBookAuthor(resultSet.getString("author"));
			book.setAvailable(resultSet.getBoolean("available"));			
		}
		return book;
	}

	public int updateBookAvailableColumn(DataSource source, Book book) throws SQLException {
		int result = 0;
		Connection connection = source.getConnection();
		PreparedStatement statement = null;
		
		statement = connection.prepareStatement(UPDATE_AVAILABLE_COLUMN_SQL);
		statement.setBoolean(1, book.isAvailable());
		statement.setLong(2, book.getBookId());
		
		result = statement.executeUpdate();
		
		return result;
	}

	public int updateBookMemberIdColumn(DataSource source, Long bookId, Long memberId) throws SQLException {
		int result = 0;
		Connection connection = source.getConnection();
		PreparedStatement statement = null;
		
		statement = connection.prepareStatement(UPDATE_MEMBER_ID_COLUMN_SQL);
		statement.setLong(1, memberId);
		statement.setLong(2, bookId);
		
		result = statement.executeUpdate();
		
		return result;
	}	
	
}
