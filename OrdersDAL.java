package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class OrdersDAL {
	private DatabaseConnection dbConnection;

	public OrdersDAL() {
		dbConnection = new DatabaseConnection();
	}

	public int insertOrder(double totalCost, int customerId) {
		String sql = "INSERT INTO orders_pr(o_total,cust_id,o_date) VALUES (?, ?,?) returning o_id";
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
		int orderid = 0;

		try {
			Connection conn = dbConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setDouble(1, totalCost);
			pstmt.setInt(2, customerId);
			pstmt.setDate(3, sqlDate);

			pstmt.executeUpdate();
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				orderid = generatedKeys.getInt(1);
			}
			return orderid;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderid;

	}

}