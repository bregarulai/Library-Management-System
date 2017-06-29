/** @author Flavio Aquino June 2017
 *  
 *  class responsible to get a connection to database*/

package libraryDatabaseUtility.model;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource instance = null;
	private Connection connection = null;
	private String url;
	private String dbUser;
	private String dbPassword;
	private String libraryUser;
	private String libraryPassword;
	
	// Initialization block to load the configuration file
	// and read the library and databse user's credentials
	{
		Properties properties = new Properties();
		
		
		try {
			InputStream input = getClass().getResourceAsStream("/config.properties");
			properties.load(input);
			this.url = properties.getProperty("url");
			this.dbUser = properties.getProperty("user");
			this.dbPassword = properties.getProperty("password");
			this.libraryUser = properties.getProperty("libraryUser");
			this.libraryPassword = properties.getProperty("libraryPassword");
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
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
		if(instance == null) {					// to make class lazily loaded
			synchronized(DataSource.class) {	// to make method thread safe
				if(instance == null) {
					instance = new DataSource();
				}
			}
		}
		
		return instance;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		if(connection == null) {
			synchronized(DataSource.class) {		// to make method thread safe
				if(connection == null) {
					try {
						connection = DriverManager.getConnection(url, dbUser, dbPassword);
					}
					catch(SQLException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		
		return connection;
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
