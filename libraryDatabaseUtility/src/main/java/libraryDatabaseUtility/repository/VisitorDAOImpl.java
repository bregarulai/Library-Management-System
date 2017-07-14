/* Implementation class for VisitorDAO interface*
 * 
 */
package libraryDatabaseUtility.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Visitor;

/**
 * @author Flavio Luis
 *
 */
public class VisitorDAOImpl implements VisitorDAO {
	private static final String INSERT_VISITOR_SQL = "insert into visitors (firstName, lastName, dateOfvisit, timeIn) values (?, ?, ?, ?)";
	private static final String SEARCH_VISITOR_SQL = "select * from visitors where lastName = ?";
	private static final String SEARCH_VISITOR_BY_DATE_SQL = "select * from visitors where date(dateOfVisit) = ?";
	private static final String UPDATE_VISITOR_TIME_OUT_SQL = "update visitors set timeOut = ? where ID = ?";
	
	
	public VisitorDAOImpl() {
		
	}
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.VisitorDAO#addVisitorToDb(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Visitor)
	 */
	public int addVisitorToDb(DataSource source, Visitor member) throws SQLException {
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		java.util.Date today = new java.util.Date();
		java.sql.Time time = new java.sql.Time(today.getTime());
		java.sql.Date date = new java.sql.Date(today.getTime());
		member.setTimeIn(time);
		member.setDateOfvisit(date);
		
		statement = connection.prepareStatement(INSERT_VISITOR_SQL);
		statement.setString(1, member.getFirstName());
		statement.setString(2, member.getLastName());
		statement.setDate(3, member.getDateOfvisit());
		statement.setTime(4, member.getTimeIn());
		
		result = statement.executeUpdate();
		
		return result;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.VisitorDAO#searchForVisitor(libraryDatabaseUtility.model.DataSource, java.lang.String)
	 */
	public List<Visitor> searchForVisitor(DataSource source, String lastName) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		List<Visitor> visitors = new ArrayList<Visitor>();
		
		statement = connection.prepareStatement(SEARCH_VISITOR_SQL, 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		statement.setString(1, lastName);
		resultSet = statement.executeQuery();
		
		// to map resultSet to visitor object
		while(resultSet.next()) {
			Visitor visitor = new Visitor();
			visitor.setVisitorId(resultSet.getLong("ID"));
			visitor.setFirstName(resultSet.getString("firstName"));
			visitor.setLastName(resultSet.getString("lastName"));
			visitor.setDateOfvisit(resultSet.getDate("dateOfVisit"));
			visitor.setTimeIn(resultSet.getTime("timeIn"));
			visitor.setTimeout(resultSet.getTime("timeOut"));
			visitors.add(visitor);
		}
			
		return visitors;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.VisitorDAO#getVisitorsForThisDate(libraryDatabaseUtility.model.DataSource, java.util.Date)
	 */
	public List<Visitor> getVisitorsForThisDate(DataSource source, String date) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		List<Visitor> visitors = new ArrayList<Visitor>();
		
		statement = connection.prepareStatement(SEARCH_VISITOR_BY_DATE_SQL, 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		statement.setString(1, date);
		resultSet = statement.executeQuery();
		
		// to map resultSet to visitor object
		while(resultSet.next()) {
			Visitor visitor = new Visitor();
			visitor.setVisitorId(resultSet.getLong("ID"));
			visitor.setFirstName(resultSet.getString("firstName"));
			visitor.setLastName(resultSet.getString("lastName"));
			visitor.setDateOfvisit(resultSet.getDate("dateOfVisit"));
			visitor.setTimeIn(resultSet.getTime("timeIn"));
			visitor.setTimeout(resultSet.getTime("timeOut"));
			visitors.add(visitor);
		}
				
		return visitors;
	}
	
	public int updateVisitorTimeOutColumn(DataSource source, Visitor visitor) throws SQLException {
		int result = 0;
		Connection connection = source.getConnection();
		PreparedStatement statement = null;
		
		java.util.Date today = new java.util.Date();
		java.sql.Time time = new java.sql.Time(today.getTime());
		visitor.setTimeout(time);
		
		statement = connection.prepareStatement(UPDATE_VISITOR_TIME_OUT_SQL);
		statement.setTime(1, visitor.getTimeout());
		statement.setLong(2, visitor.getVisitorId());
		
		result = statement.executeUpdate();
		
		if(result == 1) {
			System.out.println("Visitor Time Out updated successfully!");
		}
		else {
			System.out.println("Error while updating visitor's time out!");
		}
		
		return result;
	}

}
