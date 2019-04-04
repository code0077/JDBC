package jdbcAPICodes;

import java.sql.*;

public class ResultSetMetaDataExample {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/concepts", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try (Statement stmt = con.createStatement()) {
			ResultSet res = stmt.executeQuery("SELECT * FROM distinctexample");
			ResultSetMetaData resMeta = res.getMetaData();
			int count = resMeta.getColumnCount();
			System.out.println(count);
			res.next();
			for (int i = 1; i <= count; i++) {
				System.out.println(resMeta.getTableName(i));
				System.out.println(resMeta.getColumnName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
