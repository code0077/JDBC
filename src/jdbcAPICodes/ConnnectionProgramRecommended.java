package jdbcAPICodes;

import java.sql.*;

public class ConnnectionProgramRecommended {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/first", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Statement smt = con.createStatement()) {
			ResultSet rs = smt.executeQuery("SELECT * FROM emp");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Name: " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
