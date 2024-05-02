package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAL {
	private DatabaseConnection dbConnection;
	Connection cn;
	boolean status = false;

	public UserDAL() {
		dbConnection = new DatabaseConnection();
	}

	public boolean validateUser(String name, String pwd) {
		try {
			cn = dbConnection.getConnection();
			String query = "select * from usersdata where name = ? and password = ?";
			PreparedStatement st = cn.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, pwd);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

}
