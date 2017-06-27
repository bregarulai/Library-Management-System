/*Class responsible to check and return books
 * to the library.
 * 
 */
package libraryDatabaseUtility.service;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;

/**
 * @author Flavio Luis June 2017
 *
 */
public interface LibraryService {

	public boolean checkoutBook(DataSource source, Book book);
	
	public boolean returnBook(DataSource source, Book book);
}
