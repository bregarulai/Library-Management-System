/**
 * 
 */
package libraryDatabaseUtility.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;
import libraryDatabaseUtility.repository.BookDAOImpl;
import libraryDatabaseUtility.repository.MemberDAOImpl;
	

/**
 * @author Flavio Luis
 *
 */
public class LibraryServiceImpl implements LibraryService {
	private BookDAOImpl bookDao = new BookDAOImpl();
	private MemberDAOImpl memberDao = new MemberDAOImpl();
	private static double FEES_RATE = 5;
	private static int MAX_CHECKOUT_DAYS = 5;
	
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.service.LibraryService#checkoutBook(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public boolean checkoutBook(DataSource source, Book book, String lastName) throws SQLException {
		Member member;
		boolean flag = false;
		int availableUpdate = 0;
		int memberIdUpdate = 0;
		int checkoutDateUpdate = 0;
		List<Member> members = new ArrayList<Member>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 0);
		java.sql.Date sqlDate = new java.sql.Date(calendar.getTime().getTime());
		
		members = memberDao.searchForMembers(source, lastName);
		member = members.get(0);
		
		if(book.isAvailable()) {
			book.setAvailable(false);
			book.setCheckoutDate(sqlDate);
			book.setReturnedDate(null);
			checkoutDateUpdate = bookDao.updateBookCheckoutDate(source, book);
			availableUpdate = bookDao.updateBookAvailableColumn(source, book);
			memberIdUpdate = bookDao.updateBookMemberIdColumn(source, book.getBookId(), member.getMemberId());
			bookDao.updateBookReturnedDate(source, book);
			if(availableUpdate == 1 && memberIdUpdate == 1 && checkoutDateUpdate == 1) {
				flag = true;
			}
		}
		else {
			System.out.println("\nBook is not available at this moment.");
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.service.LibraryService#returnBook(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public boolean returnBook(DataSource source, Book book, String lastName) throws SQLException {
		boolean flag = false;
		int availableUpdate;
		int memberIdUpdate;
		int returnedDateUpdate;
		List<Member> members = memberDao.searchForMembers(source, lastName);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 0);
		java.sql.Date sqlDate = new java.sql.Date(calendar.getTime().getTime());
		
		Member member = members.get(0);
		
		if(member != null && member.getMemberId() == book.getMemberId()) {
			book.setAvailable(true);
			book.setReturnedDate(sqlDate);
			
			availableUpdate = bookDao.updateBookAvailableColumn(source, book);
			memberIdUpdate = bookDao.updateBookMemberIdColumnToNull(source, book);
			returnedDateUpdate = bookDao.updateBookReturnedDate(source, book);
			if(availableUpdate == 1 && memberIdUpdate == 1 && returnedDateUpdate == 1) {
				flag = true;
			}
			
			double fees = calculateFees(book);
			member.setFees(fees);
			int updateFees = memberDao.updateMemberFees(source, member);
			if(updateFees == 1) {
				System.out.println("\nMember fees updated Successfully!");
			}
			else {
				System.out.println("\nError while updating member fees!");
			}
		}
		else {
			System.out.println("\nMember does not exist");
		}
		
		
		
		return flag;
	}

	/**
	 * @return the bookDAOImpl
	 */
	public BookDAOImpl getBookDAOImpl() {
		return bookDao;
	}

	/**
	 * @param bookDAOImpl the bookDAOImpl to set
	 */
	public void setBookDAOImpl(BookDAOImpl bookDAOImpl) {
		this.bookDao = bookDAOImpl;
	}

	/**
	 * @return the memberDAOImpl
	 */
	public MemberDAOImpl getMemberDAOImpl() {
		return memberDao;
	}

	/**
	 * @param memberDAOImpl the memberDAOImpl to set
	 */
	public void setMemberDAOImpl(MemberDAOImpl memberDAOImpl) {
		this.memberDao = memberDAOImpl;
	}

	
	
	private static double calculateFees(Book book) {
	
		GregorianCalendar checkoutDate = new GregorianCalendar();
		GregorianCalendar returnedDate = new GregorianCalendar();
		
		checkoutDate.setTime(book.getCheckoutDate());
		returnedDate.setTime(book.getReturnedDate());
		
		double fees = 0;
		int checkoutDay = checkoutDate.get(Calendar.DAY_OF_YEAR);
		int returnedDay = returnedDate.get(Calendar.DAY_OF_YEAR);
		
		int daysDifference = returnedDay - checkoutDay;
		
		if(daysDifference > MAX_CHECKOUT_DAYS) {
			fees = FEES_RATE;
		}
		else if (daysDifference > MAX_CHECKOUT_DAYS * 2) {
			fees = FEES_RATE * 2;
		}
		
		return fees;		
	}

}
