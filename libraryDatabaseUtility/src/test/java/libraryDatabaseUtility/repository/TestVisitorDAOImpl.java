
package libraryDatabaseUtility.repository;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
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


	@Before
	public void setUp() throws Exception {
		target = new VisitorDAOImpl();
		source = DataSource.getInstance();
		visitor = new Visitor();
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
