/*
 * Creates the connection to the database
 */
package dbassignment;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    
	private Connection connection = null;
	
	//Constants
	private static final String IP	= "127.0.0.1";
	private static final int PORT	= 3306;
	private static final String DATABASE	= "dbaflevering";
	private static final String USERNAME	= "root";
	private static final String PASSWORD	= "LeneAnnetteSkov";      	
	
	public DBConnector() throws Exception {
  		Class.forName("com.mysql.jdbc.Driver").newInstance();
  		String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
  		this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
	}
	
	public Connection getConnection() {
  		return this.connection;
	}
}

    
 
