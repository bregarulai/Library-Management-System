/* Implementation class for MemberDAO interface*
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
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis June 2017
 *
 */
public class MemberDAOImpl implements MemberDAO {
	
	private static final String INSERT_MEMBER_SQL = "insert into members (firstName, lastName) values (?, ?)";
	private static final String DELETE_RECORD_SQL = "delete from members where ID = ?";
	private static final String SELECT_ALL_MEMBERS_SQL = "select * from members";
	private static final String SEARCH_MEMBER_SQL = "select * from members where lastName = ?";
	private static final String UPDATE_FEES_COLUMN_SQL = "update members set fees = ? where ID = ?";
	
	public MemberDAOImpl() {
		
	}
	
	
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
		
		return result;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#getAllMembers(libraryDatabaseUtility.model.DataSource)
	 */
	public List<Member> getAllMembers(DataSource source) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		List<Member> members = new ArrayList<Member>();
		
		statement = connection.prepareStatement(SELECT_ALL_MEMBERS_SQL, 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		resultSet = statement.executeQuery();
		
		// to map result set to member object
		while(resultSet.next()) {
			Member member = new Member();
			member.setMemberId(resultSet.getLong("ID"));
			member.setFirstName(resultSet.getString("firstName"));
			member.setLastName(resultSet.getString("lastName"));
			member.setFees(resultSet.getLong("fees"));
			members.add(member);
		}
		
		return members;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#searchForMembers(libraryDatabaseUtility.model.DataSource, java.lang.String)
	 */
	public List<Member> searchForMembers(DataSource source, String lastName) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = source.getConnection();
		List<Member> members = new ArrayList<Member>();
		
		statement = connection.prepareStatement(SEARCH_MEMBER_SQL, 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		statement.setString(1, lastName);
		resultSet = statement.executeQuery();
		
		// to map resultset to Member object
		while(resultSet.next()) {
			Member member = new Member();
			member.setMemberId(resultSet.getLong("ID"));
			member.setFirstName(resultSet.getString("firstName"));
			member.setLastName(resultSet.getString("lastName"));
			member.setFees(resultSet.getLong("fees"));
			members.add(member);
		}
		
		return members;
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

	public int updateMemberFees(DataSource source, Member member) throws SQLException {
		int result = 0;
		Connection connection = source.getConnection();
		PreparedStatement statement = null;
		
		statement = connection.prepareStatement(UPDATE_FEES_COLUMN_SQL);
		statement.setDouble(1, member.getFees());
		statement.setLong(2, member.getMemberId());
		
		result = statement.executeUpdate();
		
		return result;
	}
}
