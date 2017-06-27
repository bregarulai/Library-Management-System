/*Implementation class for LibraryView interface*
 * 
 */
package libraryDatabaseUtility.view;

import java.util.List;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis June 2017
 *
 */
public class LibraryViewImpl implements LibraryView {

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayLoginScreen(java.lang.String, java.lang.String)
	 */
	public boolean displayLoginScreen(String libraryUser, String libraryPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayMenu()
	 */
	public void displayMenu() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayBooks(java.util.List)
	 */
	public void displayBooks(List<Book> books) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayMembers(java.util.List)
	 */
	public void displayMembers(List<Member> members) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.view.LibraryView#displayDeletedRecordMessage(int)
	 */
	public void displayDeletedRecordMessage(int result) {
		// TODO Auto-generated method stub

	}

}
