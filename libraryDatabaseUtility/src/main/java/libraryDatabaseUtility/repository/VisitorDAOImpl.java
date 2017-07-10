/* Implementation class for VisitorDAO interface*
 * 
 */
package libraryDatabaseUtility.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Visitor;

/**
 * @author Flavio Luis
 *
 */
public class VisitorDAOImpl implements VisitorDAO {
	private static final String INSERT_VISITOR_SQL = "insert into visitors (firstName, lastName) values (?, ?)";
	
	public VisitorDAOImpl() {
		
	}
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.VisitorDAO#addVisitorToDb(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Visitor)
	 */
	public int addVisitorToDb(DataSource source, Visitor member) throws SQLException {
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		statement = connection.prepareStatement(INSERT_VISITOR_SQL);
		statement.setString(1, member.getFirstName());
		statement.setString(2, member.getLastName());
		
		result = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return result;
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
