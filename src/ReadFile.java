import java.io.*;
import java.util.*;
import java.sql.*;

public class ReadFile {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/edureka_project_mukul";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";


	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		//STEP 1: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		//STEP 2: Open a connection
		conn = DriverManager.getConnection(DB_URL, USER, PASS);


		BufferedReader in = new BufferedReader(new FileReader("movies.txt")); // Read File
		String input;



		while ((input = in .readLine()) != null) {

			StringTokenizer tokenizer = new StringTokenizer(input, ";");
			String title = tokenizer.nextToken();
			String titletype = tokenizer.nextToken();
			String director = tokenizer.nextToken();
			String rating = tokenizer.nextToken();
			String runtime = tokenizer.nextToken();
			String year = tokenizer.nextToken();
			String genre = tokenizer.nextToken();
			String votes = tokenizer.nextToken();
			String top250 = tokenizer.nextToken();
			String mustsee = tokenizer.nextToken();
			String url = tokenizer.nextToken();



			float rating1 = 0.0f;
			int runtime1 = 0;
			int year1 = 0000;
			int votes1 = 0;


			try {
				if (input != null) rating1 = Float.parseFloat(rating);
			} catch (NumberFormatException e) {
				rating1 = 0;
			}



			try {
				if (input != null) runtime1 = Integer.parseInt(runtime);
			} catch (NumberFormatException e) {
				runtime1 = 0;
			}


			try {
				if (input != null) runtime1 = Integer.parseInt(runtime);
			} catch (NumberFormatException e) {
				runtime1 = 0;
			}


			try {
				if (input != null) year1 = Integer.parseInt(year);
			} catch (NumberFormatException e) {
				year1 = 0000;
			}


			try {
				if (input != null) votes1 = Integer.parseInt(votes);
			} catch (NumberFormatException e) {
				votes1 = 0;
			}







			String chk = "";
			String chk1 = "";

			if (top250.indexOf("Y") == 0) {

				chk1 = chk1 + "Y";
			} else {

				chk1 = chk1 + "N";
			}


			if (mustsee.indexOf("Y") == 0) {

				chk = chk + "Y";
			} else {

				chk = chk + "N";
			}



			String sqlcode = "insert into movies values(?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sqlcode); // create a statement

			pstmt.setString(1, title);
			pstmt.setString(2, titletype);
			pstmt.setString(3, director);
			pstmt.setFloat(4, rating1);
			pstmt.setInt(5, runtime1);
			pstmt.setInt(6, year1);
			pstmt.setString(7, genre);
			pstmt.setInt(8, votes1);
			pstmt.setString(9, chk1);
			pstmt.setString(10, chk);
			pstmt.setString(11, url);


			pstmt.executeUpdate();

			System.out.println("Inserting Data..........");




		}

		System.out.println("All Data Inserted...");




	}

}