/**
 * 
 */
package libraryDatabaseUtility.repository;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		target = new BookDAOImpl();
		book = new Book();
		source = DataSource.getInstance();
	}

	@Test
	public void testBookAddedToDatabase() throws SQLException {
		int result = 1;
		assertEquals(target.addBookToDb(source, book), result);
		
	}
	
	@Test
	public void testListOfBooksGetsReturned() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		books = target.getAllBooks(source);
		assertNotNull(books);
	}
	
	@Test
	public void testRecordGetsDeletedFromDatabase() throws SQLException {
		int result = 1;
		assertEquals(target.deleteRecord(source, BOOK_ID), result);
	}

	@Test
	public void testSearchBookReturnsCorrectResult() throws SQLException {
		Book book1 = new Book(BOOK_ID, "To Kill a Mockingbird", "Harper Lee");
		target.addBookToDb(source, book1);
		assertEquals(target.searchForBooks(source, book1.getBookTitle()), book1);
	}
	
	@Test
	public void testGetBookFromDatabase() {
		Book book1 = target.getBook(source, BOOK_ID);
		assertNotNull(book1);
		assertTrue(book1 instanceof Book);
	}
}
