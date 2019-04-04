package jdbcAPICodes;

import java.sql.*;

public class ResultSetScrollProperties {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Statement stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = stmt.executeQuery("SELECT * FROM examples");
			while (res.next()) {
				res.last();
				System.out.println("AT THE LAST POINT IN DATABASE TABLE");
				System.out.println(res.getString("name") + " === " + res.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
