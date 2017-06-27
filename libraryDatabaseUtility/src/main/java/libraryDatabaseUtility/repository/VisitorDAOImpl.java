/* Implementation class for VisitorDAO interface*
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
public class VisitorDAOImpl implements VisitorDAO {

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.VisitorDAO#addVisitorToDb(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Visitor)
	 */
	public int addVisitorToDb(DataSource source, Visitor member) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.VisitorDAO#searchForVisitor(libraryDatabaseUtility.model.DataSource, java.lang.String)
	 */
	public List<Visitor> searchForVisitor(DataSource source, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.VisitorDAO#getVisitorsForThisDate(libraryDatabaseUtility.model.DataSource, java.util.Date)
	 */
	public List<Visitor> getVisitorsForThisDate(DataSource source, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
