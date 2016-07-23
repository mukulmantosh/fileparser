import java.io.*;
import java.util.*;
import java.sql.*;

public class CreateTable {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/edureka_project_mukul";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

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
			System.out.println("Creating Tables...");
			stmt = conn.createStatement();



			String sql1 = "CREATE TABLE movies" +
				"(title VARCHAR(255), " +
				" titletype VARCHAR(255), " +
				" director VARCHAR(255), " +
				" rating INT, " +
				" runtime INT, " +
				" year INT, " +
				" genre VARCHAR(255), " +
				" votes INT, " +
				" top250 VARCHAR(255), " +
				" mustsee VARCHAR(255), " +
				" url VARCHAR(400))";

			stmt.executeUpdate(sql1);
			System.out.println("Created table MOVIES in given database...");



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