/** @author Flavio Aquino June 2017
 *  
 *  class responsible to get a connection to database*/

package libraryDatabaseUtility.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private static DataSource instance = null;
	private Connection conn = null;
	private String url;
	private String dbUser;
	private String dbPassword;
	private String libraryUser;
	private String libraryPassword;
	
	// Initialization block to load the configuration file
	// and read the library and databse user's credentials
	{
		
	}
	
	
	/**
	 *  private constructor to create singleton class
	 */
	private DataSource() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @return the instance
	 */
	public static DataSource getInstance() {
		return instance;
	}

	/**
	 * @return the connection
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the dbUser
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * @return the dbPassword
	 */
	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * @return the libraryUser
	 */
	public String getLibraryUser() {
		return libraryUser;
	}

	/**
	 * @return the libraryPassword
	 */
	public String getLibraryPassword() {
		return libraryPassword;
	}
	
	
}
