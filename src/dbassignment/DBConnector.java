/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbassignment;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lene_
 */
public class DBConnector {
    
	private Connection connection = null;
	
	//Constants
	private static final String IP	= "localhost";
	private static final String PORT	= "3306";
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

    
 
