package jdbcAPICodes;

import java.sql.*;

public class DatabaseMetaDataExample {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/concepts", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			DatabaseMetaData dbm = con.getMetaData();
			System.out.println(dbm.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
			System.out.println(dbm.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println(dbm.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
