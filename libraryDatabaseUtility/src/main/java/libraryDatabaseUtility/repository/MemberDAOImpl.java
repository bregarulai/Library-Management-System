/* Implementation class for MemberDAO interface*
 * 
 */
package libraryDatabaseUtility.repository;

import java.util.List;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis June 2017
 *
 */
public class MemberDAOImpl implements MemberDAO {

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#addCustomerToDb(libraryDatabaseUtility.model.DataSource, libraryDatabaseUtility.model.Member)
	 */
	public int addCustomerToDb(DataSource source, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see libraryDatabaseUtility.repository.MemberDAO#deleteRecord(libraryDatabaseUtility.model.DataSource, long)
	 */
	public int deleteRecord(DataSource source, long memberId) {
		// TODO Auto-generated method stub
		return 0;
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
