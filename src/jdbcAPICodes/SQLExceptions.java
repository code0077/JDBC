package jdbcAPICodes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLExceptions {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:mysql://localhost/xvzxcvz";
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
		System.out.println();
		System.out.println("Goodbye!");
	}
}
