/* Interface to access the member table*
 * 
 */
package libraryDatabaseUtility.repository;

import java.util.List;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis
 *
 */
public interface MemberDAO {

	public int addCustomerToDb(DataSource source, Member member);
	
	public int deleteRecord(DataSource source, long memberId);
	
	public List<Member> getAllMembers(DataSource source);
	
	public List<Member> searchForMembers(DataSource source, String lastName);
	
	public List<Member> getMembersWithLateFee(DataSource source);
	
	public Member getMember(DataSource source, long id);
}
