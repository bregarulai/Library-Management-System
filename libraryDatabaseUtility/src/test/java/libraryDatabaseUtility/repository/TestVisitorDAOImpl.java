
package libraryDatabaseUtility.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
	public void setUp() {
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
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSearchVisitorReturnsCorrectResult() {
		try {		
			target.addVisitorToDb(source, visitor);
			List<Visitor> visitors = target.searchForVisitor(source, visitor.getLastName());
			Visitor visitor1 = visitors.get(0);
			assertEquals(visitor1.getLastName(), visitor.getLastName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
