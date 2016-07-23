import java.io.*;
import java.util.*;
import java.sql.*;


public class Query {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/edureka_project_mukul";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";


	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		Connection conn = null;
		PreparedStatement pstmt = null;

		//STEP 1: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		//STEP 2: Open a connection
		conn = DriverManager.getConnection(DB_URL, USER, PASS);


		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 1. Find out the name of Director who directed movie A Walk to Remember #####");

		System.out.println(); //new line
		System.out.println(); //new line



		//1. Find out the name of Director who directed movie A Walk to Remember


		String query = "select director from movies where title=?";

		pstmt = conn.prepareStatement(query); // create a statement
		pstmt.setString(1, "A Walk to Remember");
		ResultSet rs = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs.next()) {

			String director = rs.getString(1);


			System.out.println("The Director who directed movie A Walk to Remember is " + director);
			System.out.println(); //new line
		}



		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 2. List down the names of all the documentary movies #####");

		System.out.println(); //new line
		System.out.println(); //new line



		//2. List down the names of all the documentary movies

		String query1 = "select title from movies where titletype=?";

		pstmt = conn.prepareStatement(query1);
		pstmt.setString(1, "Documentary");

		ResultSet rs1 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs1.next()) {

			String title = rs1.getString(1);


			System.out.println(title);
		}

		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 3. List down the names of all documentary movies released in 2000 #####");

		System.out.println(); //new line
		System.out.println(); //new line



		//3. List down the names of all documentary movies released in 2000

		String query2 = "select title from movies where titletype=? and year=?";

		pstmt = conn.prepareStatement(query2);
		pstmt.setString(1, "Documentary");
		pstmt.setString(2, "2000");

		ResultSet rs2 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs2.next()) {

			String title = rs2.getString(1);


			System.out.println(title);
		}


		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 4. Find out the names of all movies directed by Steven Spielberg #####");

		System.out.println(); //new line
		System.out.println(); //new line

		//4. Find out the names of all movies directed by Steven Spielberg

		String query3 = "select title from movies where director=?";

		pstmt = conn.prepareStatement(query3);
		pstmt.setString(1, "Steven Spielberg");

		ResultSet rs3 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs3.next()) {

			String title = rs3.getString(1);


			System.out.println(title);
		}


		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 5. Find out the names of all movies directed by Steven Spielberg and were released in 2012 #####");

		System.out.println(); //new line
		System.out.println(); //new line

		//5. Find out the names of all movies directed by Steven Spielberg and were released in 2012

		String query4 = "select title from movies where director=? and year=?";

		pstmt = conn.prepareStatement(query4);
		pstmt.setString(1, "Steven Spielberg");
		pstmt.setString(2, "2012");

		ResultSet rs4 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs4.next()) {

			String title = rs4.getString(1);


			System.out.println(title);
		}


		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 6. Find out the year in which maximum number of movies were released #####");

		System.out.println(); //new line
		System.out.println(); //new line

		//	      6. Find out the year in which maximum number of movies were released

		String query5 = "SELECT year FROM movies GROUP BY year HAVING COUNT(*) = (SELECT MAX(Members) FROM (SELECT COUNT(*) AS Members FROM movies GROUP BY year) AS Max_Emp);";

		pstmt = conn.prepareStatement(query5);

		ResultSet rs5 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs5.next()) {

			int year = rs5.getInt(1);


			System.out.println(year);
		}



		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 7. Find out the movie names which belongs to Genre 'romance' #####");

		System.out.println(); //new line
		System.out.println(); //new line

		String query6 = "select title from movies where genre=?";

		pstmt = conn.prepareStatement(query6);
		pstmt.setString(1, "romance");


		ResultSet rs6 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs6.next()) {

			String title = rs6.getString(1);


			System.out.println(title);
		}


		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("######8. Find out the top 10 movies with Genre 'romance' which got highest number of votes on IMDb #####");

		System.out.println(); //new line
		System.out.println(); //new line


		String query7 = "SELECT title,MAX(votes) FROM movies WHERE genre=? LIMIT 10";

		pstmt = conn.prepareStatement(query7);
		pstmt.setString(1, "romance");


		ResultSet rs7 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs7.next()) {

			String title = rs7.getString(1);


			System.out.println(title);
		}




		System.out.println(); //new line
		System.out.println(); //new line
		System.out.println(); //new line


		System.out.println("###### 9. Find out the movie with Genre 'thriller' which have the highest runtime and released after 2005 #####");

		System.out.println(); //new line
		System.out.println(); //new line


		String query8 = "select title,runtime from movies where genre=? AND runtime IN(SELECT MAX(runtime) from movies where genre='thriller' AND year>2005)";

		pstmt = conn.prepareStatement(query8);
		pstmt.setString(1, "thriller");


		ResultSet rs8 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs8.next()) {

			String title = rs8.getString(1);
			String runtime = rs8.getString(2);


			System.out.println(title);
			System.out.println(runtime);
		}




		System.out.println("###### 10. Find out average IMDb rating for movies (While calculating average exclude the movies for which IMDb rating is not known) #####");

		System.out.println(); //new line
		System.out.println(); //new line


		String query9 = "SELECT AVG(rating) FROM movies WHERE rating!=?";

		pstmt = conn.prepareStatement(query9);
		pstmt.setInt(1, 0);


		ResultSet rs9 = pstmt.executeQuery();
		// extract data from the ResultSet
		while (rs9.next()) {

			Float rating = rs9.getFloat(1);

			System.out.println(rating);

		}









	}

}