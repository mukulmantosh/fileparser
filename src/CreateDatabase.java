import java.io.*;
import java.util.*;
import java.sql.*;

public class CreateDatabase {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "jackie987";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {

			//STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//STEP 3: Execute a query
			System.out.println("Creating database...");
			stmt = conn.createStatement();

			String sql = "CREATE DATABASE edureka_project_mukul";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");


		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			//finally block used to close resources
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException se2) {} // nothing we can do
			try {
				if (conn != null) conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} //end finally try
		} //end try
	}

}