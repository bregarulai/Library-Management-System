/**
 * 
 */
package libraryDatabaseUtility.service;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.repository.BookDAOImpl;
import libraryDatabaseUtility.repository.MemberDAOImpl;

/**
 * @author Flavio Luis
 *
 */
public class LibraryServiceImpl implements LibraryService {
	private BookDAOImpl bookDAOImpl;
	private MemberDAOImpl memberDAOImpl;
	
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.service.LibraryService#checkoutBook(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public boolean checkoutBook(DataSource source, Book book) {
		// TODO Auto-generated method stub
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
		return bookDAOImpl;
	}

	/**
	 * @param bookDAOImpl the bookDAOImpl to set
	 */
	public void setBookDAOImpl(BookDAOImpl bookDAOImpl) {
		this.bookDAOImpl = bookDAOImpl;
	}

	/**
	 * @return the memberDAOImpl
	 */
	public MemberDAOImpl getMemberDAOImpl() {
		return memberDAOImpl;
	}

	/**
	 * @param memberDAOImpl the memberDAOImpl to set
	 */
	public void setMemberDAOImpl(MemberDAOImpl memberDAOImpl) {
		this.memberDAOImpl = memberDAOImpl;
	}

	

}
