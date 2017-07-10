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
	private final static long BOOK_ID = 1;
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
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void testBookAddedToDatabase()  {
		int result = 1;
		//book.setBookTitle("Los Ladrones Lloran");
		//book.setBookAuthor("Roberto Santos");
		try {
			assertEquals(target.addBookToDb(source, book), result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testListOfBooksGetsReturned() {
		List<Book> books = new ArrayList<Book>();
		try {
			books = target.getAllBooks(source);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(books);
	}
	
	@Test
	public void testRecordGetsDeletedFromDatabase() {
		int result = 1;
		try {
			assertEquals(target.deleteRecord(source, book.getBookId()), result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchBookReturnsCorrectResult() throws SQLException {
		//Book book1 = new Book(BOOK_ID, "To Kill a Mockingbird", "Harper Lee");
		target.addBookToDb(source, book);
		assertEquals(target.searchForBooks(source, book.getBookTitle()), book);
	}
	
	@Test
	public void testGetBookFromDatabase() {
		//Book book1 = target.getBook(source, BOOK_ID);
		assertNotNull(book);
		assertTrue(book instanceof Book);
	}
}
