/**
 * 
 */
package libraryDatabaseUtility.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis
 *
 */
public class TestMemberDAOImpl {

	MemberDAOImpl target;
	Book book;
	Member member;
	DataSource source;
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	
	@BeforeClass
	public static void beforeClass() {
		connection = null;
		statement = null;
		
	}
	
	@AfterClass
	public static void afterClass() {
		
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		target = new MemberDAOImpl();
		member = new Member();
		member.setFirstName("Carlos");
		member.setLastName("Perez");
		source = DataSource.getInstance();
		
	}
	
	@After
	public void tearDown() {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMemberAddedToDatabase() {
		int result = 1;
		try {
			assertEquals(target.addCustomerToDb(source, member), result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testListOfMembersGetsReturned() {
		List<Member> members = new ArrayList<Member>();
		try {
			members = target.getAllMembers(source);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(members);
	}
	
	@Test
	public void testRecordGetsDeletedFromDatabase() {
		try {
			target.addCustomerToDb(source, member);
			target.deleteRecord(source, member.getMemberId());
			List<Member> members = target.searchForMembers(source, member.getLastName());
			assertNotNull(members);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchMemberReturnsCorrectResult() {
		try {		
			target.addCustomerToDb(source, member);
			List<Member> members = target.searchForMembers(source, member.getLastName());
			Member member1 = members.get(0);
			assertEquals(member1.getLastName(), member.getLastName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMemberFromDatabase() {
		try {
			target.addCustomerToDb(source, member);
			
			List<Member> members = target.searchForMembers(source, member.getLastName());
			Member member1 = members.get(0);
			assertNotNull(member1);
			assertTrue(member1 instanceof Member);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
