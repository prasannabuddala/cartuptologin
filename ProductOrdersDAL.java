package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOrdersDAL {
	private DatabaseConnection dbConnection;

	public ProductOrdersDAL() {
		dbConnection = new DatabaseConnection();
	}

	public boolean insertIntoProductOrder(int orderid, List<CartItem> cartitems) {
		List<ProductOrder> productorders = new ArrayList<>();

		for (CartItem item : cartitems) {
			Products product = new GetProductsDAL().getProductById(item.getPid());
			ProductOrder po = new ProductOrder(orderid, item.getPid(), item.getQuantity(), product.getPprice());
			productorders.add(po);
		}

		try (Connection conn = dbConnection.getConnection()) {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into productorder_pr(p_id,o_id,quantity,price) values(?,?,?,?)");
			conn.setAutoCommit(false);

			for (ProductOrder po : productorders) {
				pstmt.setInt(1, po.getPid());
				pstmt.setInt(2, po.getOid());
				pstmt.setInt(3, po.getQuanity());
				pstmt.setDouble(4, po.getPrice());
				// Add the parameters to the batch
				pstmt.addBatch();
			}

			// Execute the batch
			pstmt.executeBatch();

			// Commit the transaction
			conn.commit();

			// Close the connection
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL Errorr: " + e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println("IO Error: " + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

}