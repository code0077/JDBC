package jdbcAPICodes;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteUpdate {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:mysql://localhost/first";
		java.sql.Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			Properties conProps = new Properties();
			conProps.put("user", "root");
			conProps.put("password", "root");
			conn = DriverManager.getConnection(DB_URL, conProps);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "CREATE TABLE teacher(salary int(10), name varchar(40), age int(4))";
			int result = stmt.executeUpdate(sql);
			if (result >= 0) {
				System.out.println("TABLE CREATED!!!");
			}
			stmt.close();
			conn.close();
		} catch (SQLException se) {

			se.printStackTrace();
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
		System.out.println();
		System.out.println("Goodbye!");
	}
}
