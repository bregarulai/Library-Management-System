package libraryDatabaseUtility.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;
import libraryDatabaseUtility.repository.BookDAOImpl;
import libraryDatabaseUtility.repository.MemberDAOImpl;


public class LibraryServiceTests {
	private final static long MEMBER_ID = 1;
	private final static long BOOK_ID = 1;
	LibraryServiceImpl target;
	DataSource source;
	Book book;
	MemberDAOImpl memberDAO;
	Member member;
	
	
	@Before
	public void setUp() {
		target = new LibraryServiceImpl();
		source = DataSource.getInstance();
		book = new Book();
		memberDAO = new MemberDAOImpl();
		member = new Member();
	}

	

	@Test
	public void testCheckoutBookSuccessfully() {

		boolean result = true;
		
		assertTrue("book is available", book.isAvailable());
		try {
			assertEquals(target.checkoutBook(source, book), result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckoutDateInBookIsNull() {
		assertNull(book.getCheckoutDate());
	}
	
	@Test
	public void testPersonCheckingoutIsAMember() {
		Member member = memberDAO.getMember(source, MEMBER_ID);
		
		assertNotNull(member);
		assertTrue(member instanceof Member);
		
	}
	
	@Test
	public void testBookExistOnDatabase() {
		BookDAOImpl bookDAO = new BookDAOImpl();
		try {
			book = bookDAO.getBook(source, BOOK_ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(book);
		assertTrue(book instanceof Book);		
	}
	
	@Test 
	public void testReturnBookSuccessfully() {
		boolean result = true;
		String lastName = "valera";
		
		assertFalse("book is not available", book.isAvailable());
		try {
			assertEquals(target.returnBook(source, book, lastName), result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAppliesLateFees() {
		int checkoutPeriodMax = 5;
		Date checkoutDate = book.getCheckoutDate();
		Date returnedDate = book.getReturnedDate();

		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		
		day1.setTime(checkoutDate);
		day2.setTime(returnedDate);
		
		int daysBetween = day1.get(Calendar.DAY_OF_YEAR) - day2.get(Calendar.DAY_OF_YEAR);
		
		
		if(daysBetween > checkoutPeriodMax) {
			assertNotNull(member.getFees());
		}
	}
	
	
}
