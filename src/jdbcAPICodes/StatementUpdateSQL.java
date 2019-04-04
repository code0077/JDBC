package jdbcAPICodes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StatementUpdateSQL {
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
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT salary, name, age FROM teacher";
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				int salary = res.getInt(1);
				res.updateInt(1, salary * 2);
				res.updateRow();
			}
			System.out.println("STATEMENT UPDATED!!!");
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
