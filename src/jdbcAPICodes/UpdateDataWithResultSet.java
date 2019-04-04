package jdbcAPICodes;

import java.sql.*;

public class UpdateDataWithResultSet {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Statement stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet res = stmt.executeQuery("SELECT * FROM examples");
			while (res.next()) {
				String str = res.getString("name");
				str = "hello";
				res.updateString("name", str);
				res.updateRow();
				System.out.println(res.getString("name") + " <---- the updated value");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
