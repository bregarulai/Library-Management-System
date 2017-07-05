/* Implementation class for MemberDAO interface*
 * 
 */
package libraryDatabaseUtility.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis June 2017
 *
 */
public class MemberDAOImpl implements MemberDAO {
	
	private static final String INSERT_MEMBER_SQL = "insert into members (firstName, lastName) values (?, ?)";
	private static final String DELETE_RECORD_SQL = "delete from members where ID = ?";
	
	
	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#addCustomerToDb(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Member)
	 */
	public int addCustomerToDb(DataSource source, Member member) throws SQLException {
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		statement = connection.prepareStatement(INSERT_MEMBER_SQL);
		
		statement.setString(1, member.getFirstName());
		statement.setString(2, member.getLastName());
		
		result = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return result;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#deleteRecord(libraryDatabaseUtility.model.DataSource, long)
	 */
	public int deleteRecord(DataSource source, long memberId) throws SQLException {
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		
		statement = connection.prepareStatement(DELETE_RECORD_SQL);
		statement.setLong(1, memberId);
		
		result = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return result;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#getAllMembers(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Member> getAllMembers(DataSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#searchForMembers(libraryDatabaseUtility.model.DataSource, java.lang.String)
	 */
	public List<Member> searchForMembers(DataSource source, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#getMembersWithLateFee(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Member> getMembersWithLateFee(DataSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	public Member getMember(DataSource source, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
