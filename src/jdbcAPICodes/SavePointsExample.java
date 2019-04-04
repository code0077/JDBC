package jdbcAPICodes;

import java.sql.*;

public class SavePointsExample {
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
			prep.setInt(1, 10009);
			prep.setString(2, "Ravi");
			prep.executeUpdate();

			Savepoint save = con.setSavepoint();
			prep.setInt(1, 4009);
			prep.setString(2, "Rajesh");
			prep.executeUpdate();
			
			String str = "Rahulee";
			prep.setInt(1, 3119);
			prep.setString(2, str);

			if (str == "Rahul") {
				System.out.print("Roll back save point!!");
				con.rollback(save);
				System.out.println("Only ravi inserted into table!!!");
			} else {
				prep.executeUpdate();
				con.commit();
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
