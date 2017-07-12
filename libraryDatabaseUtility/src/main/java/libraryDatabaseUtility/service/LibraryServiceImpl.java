/**
 * 
 */
package libraryDatabaseUtility.service;

import java.sql.SQLException;
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
	private MemberDAOImpl memberDao;
	
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.service.LibraryService#checkoutBook(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Book)
	 */
	public boolean checkoutBook(DataSource source, Book book, String lastName) throws SQLException {
		Member member;
		boolean flag = false;
		int availableUpdate = 0;
		int memberIdUpdate = 0;
		List<Member> members = memberDao.searchForMembers(source, lastName);
		member = members.get(0);
		
		if(book.isAvailable()) {
			book.setAvailable(false);
			availableUpdate = bookDao.updateBookAvailableColumn(source, book);
			memberIdUpdate = bookDao.updateBookMemberIdColumn(source, book.getBookId(), member.getMemberId());
			if(availableUpdate == 1 && memberIdUpdate == 1) {
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

	public boolean checkoutBook(DataSource source, Book book) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
