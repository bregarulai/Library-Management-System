/* Interface to access visitor table*
 * 
 */
package libraryDatabaseUtility.repository;

import java.util.Date;
import java.util.List;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Visitor;

/**
 * @author Flavio Luis
 *
 */
public interface VisitorDAO {

	public int addVisitorToDb(DataSource source, Visitor member);
	
	public List<Visitor> searchForVisitor(DataSource source, String lastName);
	
	public List<Visitor> getVisitorsForThisDate(DataSource source, Date date);
}
