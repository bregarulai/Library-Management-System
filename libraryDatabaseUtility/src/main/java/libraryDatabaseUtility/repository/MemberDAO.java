/* Interface to access the member table*
 * 
 */
package libraryDatabaseUtility.repository;

import java.sql.SQLException;
import java.util.List;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis
 *
 */
public interface MemberDAO {

	public int addCustomerToDb(DataSource source, Member member) throws SQLException;
	
	public int deleteRecord(DataSource source, long memberId) throws SQLException;
	
	public List<Member> getAllMembers(DataSource source) throws SQLException;
	
	public List<Member> searchForMembers(DataSource source, String lastName) throws SQLException;
	
	public List<Member> getMembersWithLateFee(DataSource source);
	
	public Member getMember(DataSource source, long id);
}
