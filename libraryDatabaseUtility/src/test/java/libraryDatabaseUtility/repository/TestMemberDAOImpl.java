/**
 * 
 */
package libraryDatabaseUtility.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;

import libraryDatabaseUtility.model.Book;
import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Member;

/**
 * @author Flavio Luis
 *
 */
public class TestMemberDAOImpl {
	private final static long MEMBER_ID = 1;
	MemberDAOImpl target;
	Book book;
	Member member;
	DataSource source;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		target = new MemberDAOImpl();
		book = new Book();
		member = new Member();
		source = DataSource.getInstance();
	}

	@Test
	public void testBookAddedToDatabase() {
		int result = 1;
		assertEquals(target.addCustomerToDb(source, member), result);
		
	}
	
	@Test
	public void testListOfBooksGetsReturned() {
		List<Member> members = new ArrayList<Member>();
		members = target.getAllMembers(source);
		assertNotNull(members);
	}
	
	@Test
	public void testRecordGetsDeletedFromDatabase() {
		int result = 1;
		assertEquals(target.deleteRecord(source, MEMBER_ID), result);
	}

	@Test
	public void testSearchBookReturnsCorrectResult() {
		Member member1 = new Member(MEMBER_ID, "Mike", "Myers");
		target.addCustomerToDb(source, member1);
		assertEquals(target.searchForMembers(source, member1.getLastName()), member1);
	}
	
	@Test
	public void testGetBookFromDatabase() {
		Member member1 = target.getMember(source, MEMBER_ID);
		assertNotNull(member1);
		assertTrue(member1 instanceof Member);
	}

}
