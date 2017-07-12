/**
 * 
 */
package libraryDatabaseUtility.service;

import java.sql.SQLException;

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
	private MemberDAOImpl memberDao;
	
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.service.LibraryService#checkoutBook(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public boolean checkoutBook(DataSource source, Book book, String lastName) throws SQLException {
		Member member = new Member()
		if(book.isAvailable()) {
			book.setAvailable(false);
			bookDao.updateBookAvailableColumn(source, book);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.service.LibraryService#returnBook(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public boolean returnBook(DataSource source, Book book) {
		// TODO Auto-generated method stub
		return false;
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

	

}
