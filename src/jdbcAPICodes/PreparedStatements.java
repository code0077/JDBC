package jdbcAPICodes;

import java.sql.*;

public class PreparedStatements {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement prep = null;
		try {
			prep = con.prepareStatement("SELECT * FROM examples WHERE id = ?");
			prep.setInt(1, 17);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
