
package libraryDatabaseUtility.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import libraryDatabaseUtility.model.DataSource;
import libraryDatabaseUtility.model.Visitor;

/**
 * @author Flavio Luis
 *
 */
public class TestVisitorDAOImpl {
	VisitorDAOImpl target;
	DataSource source;
	Visitor visitor;
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


	@Before
	public void setUp() throws Exception {
		target = new VisitorDAOImpl();
		source = DataSource.getInstance();
		visitor = new Visitor();
		visitor.setFirstName("Juan");
		visitor.setLastName("Miranda");
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
	public void testVisitorAddedToDatabase() {
		int result = 1;
		try {
			assertEquals(target.addVisitorToDb(source, visitor), result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSearchVisitorReturnsCorrectResult() {
		visitor.setFirstName("Mike");
		visitor.setLastName("Myers");
		try {
			target.addVisitorToDb(source, visitor);
			assertEquals(target.searchForVisitor(source, visitor.getLastName()), visitor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
