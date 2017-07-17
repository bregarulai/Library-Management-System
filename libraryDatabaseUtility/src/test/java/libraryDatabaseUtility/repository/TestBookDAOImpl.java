/**
 * 
 */
package libraryDatabaseUtility.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;

/**
 * @author Flavio Luis June 2017
 *
 */
public class TestBookDAOImpl {
	BookDAOImpl target;
	Book book;
	DataSource source;
	private static PreparedStatement statement = null;
	private static Connection connection = null;
	
	
	@BeforeClass
	public static void beforeClass() {
		connection = null;
		statement = null;
		
	}
	
	@AfterClass
	public static void afterClass() {
		
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp()  {
		target = new BookDAOImpl();
		book = new Book();
		book.setBookAuthor("Juan Pedro");
		book.setBookTitle("Los Ladrones del Barrio");
		source = DataSource.getInstance();
		
		connection = source.getConnection();
		
		try {
			statement = connection.prepareStatement("insert into books (title, author) values (?, ?)");
			statement.setString(1, book.getBookTitle());
			statement.setString(2, book.getBookAuthor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@After
	public void tearDown() {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void testBookAddedToDatabase()  {
		int result = 1;
		try {
			assertEquals(target.addBookToDb(source, book), result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testListOfBooksGetsReturned() {
		List<Book> books = new ArrayList<Book>();
		try {
			books = target.getAllBooks(source);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(books);
	}
	
	@Test
	public void testRecordGetsDeletedFromDatabase() {
		try {
			target.addBookToDb(source, book);
			target.deleteRecord(source, book.getBookId());
			List<Book> books = target.searchForBooks(source, book.getBookTitle());
			assertNotNull(books);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchBookReturnsCorrectResult() throws SQLException {
		target.addBookToDb(source, book);
		List<Book> books = target.searchForBooks(source, book.getBookTitle());
		Book book1 = books.get(0);
 		assertEquals(book1.getBookTitle(), book.getBookTitle());
	}
	
	@Test
	public void testGetBookFromDatabase() {
		try {
			target.addBookToDb(source, book);
			String title = book.getBookTitle();
			List<Book> books = target.searchForBooks(source, title);
			Book book1 = books.get(0);
			assertNotNull(book1);
			assertTrue(book1 instanceof Book);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
