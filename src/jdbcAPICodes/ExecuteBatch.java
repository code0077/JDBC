package jdbcAPICodes;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteBatch {
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
			System.out.println("BATCH UPDATE STARTED!!!...");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.addBatch("INSERT INTO teacher values(150,'rahul',55)");
			stmt.addBatch("INSERT INTO teacher values(160,'rakesh',56)");
			stmt.addBatch("INSERT INTO teacher values(170,'rajesh',57)");
			stmt.addBatch("INSERT INTO teacher values(180,'ravindra',58)");
			stmt.addBatch("INSERT INTO teacher values(190,'ram',59)");
			int batchUpdates[] = stmt.executeBatch();
			for (int up : batchUpdates) {
				System.out.println(up); // Returns 1.
			}
			stmt.close();
			conn.commit();
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				conn.setAutoCommit(true);
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
