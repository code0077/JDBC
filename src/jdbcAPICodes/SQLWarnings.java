package jdbcAPICodes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Properties;

public class SQLWarnings {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:mysql://localhost/dsfasdf";
		java.sql.Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			Properties conProps = new Properties();
			conProps.put("user","root");
			conProps.put("password", "root");
			conn = DriverManager.getConnection(DB_URL, conProps);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM emp";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Nmae: " + name);
				// Get Warnings from result set object.
				printWarnings(rs.getWarnings());
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {

			se.printStackTrace();
			System.out.println(se.getSQLState() + " SQL STATE");
			System.out.println(se.getErrorCode() + " SQL ERROR CODE");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("\n");
		System.out.println("Goodbye!");
	}

	private static void printWarnings(SQLWarning warning) {
		if (warning != null) {
			System.out.println("WARNINGS!!!");
			while (warning != null) {
		        System.out.println("Message: " + warning.getMessage());
		        System.out.println("SQLState: " + warning.getSQLState());
		        System.out.print("Vendor error code: ");
		        System.out.println(warning.getErrorCode());
		        System.out.println("");
		        warning = warning.getNextWarning();
		    }
		} else {
			System.out.println("NO WARNINGS!!!");
		}
		
	}
}
