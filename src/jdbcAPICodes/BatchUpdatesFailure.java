package jdbcAPICodes;

import java.sql.*;

public class BatchUpdatesFailure {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement prep = null;
		try {
			con.setAutoCommit(false);
			prep = con.prepareStatement("INSERT INTO examples VALUES( " + "?, ?)");
			prep.setInt(1, 19);
			prep.setString(2, "xyz");
			prep.addBatch();

			prep.setInt(1, 29);
			prep.setString(2, "Manojadfadfadsf");
			prep.addBatch();
			
			int c = 0;
			int updates[] = prep.executeBatch();
			for (int v : updates) {
				if (v == 1) {
					c++;
				}
			}
			if (c == 2) {
				con.commit();
			} else {
				System.out.println("TRANSACTION ABORTED!!!");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("TRANSACTION ABORTED!!!");
			e1.printStackTrace();
		} finally {
			try {
				prep.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
