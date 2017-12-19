package com.revature.ERC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


// Serves as a factory. Also manages a single instance of the database connection.

public class ConnectionDAO {

	private static final String CONNECTION_USERNAME = "ercDemo";
	private static final String CONNECTION_PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	/*
	OLD LINK (for PubHub100)
	private static final String URL = "jdbc:postgresql://localhost:5432/PubHub";
		 
	NEW LINK (for Oracle JDBC)
	private static final String URL = "jdbc:oracle:thin:@//host:port/service";
		host: the hostname of the machine running Oracle
		port: the port that Oracle is listening for connections on
		service: the database instance to connect to
	*/
	
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
}
