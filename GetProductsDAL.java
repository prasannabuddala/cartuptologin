package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProductsDAL {
	private DatabaseConnection dbConnection = new DatabaseConnection();;

	List<Products> productsList = new ArrayList<>();
	Connection cn;

	public GetProductsDAL() {
		try {
			Class.forName("org.postgresql.Driver");
			cn = dbConnection.getConnection();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Products> getProducts() {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from public.\"Products_pr\"");
			while (rs.next()) {
				int pid = rs.getInt("pid");
				int pcatid = rs.getInt("pcategoryid");
				String pname = rs.getString("pname");
				Double pprice = rs.getDouble("pprice");
				String pimag = rs.getString("pimg");
				int hsncode = rs.getInt("phsncode");
				Products product = new Products(pid, pname, pprice, pimag, pcatid, hsncode);
				productsList.add(product);
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return productsList;
	}

	public Products getProductById(int id) {
		String query = "select * from public.\"Products_pr\" where pid = ?";
		PreparedStatement pst;
		Products p = null;
		try {
			pst = cn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("pid");
				int pcatid = rs.getInt("pcategoryid");
				String pname = rs.getString("pname");
				Double pprice = rs.getDouble("pprice");
				String pimag = rs.getString("pimg");
				int hsncode = rs.getInt("phsncode");
				p = new Products(pid, pname, pprice, pimag, pcatid, hsncode);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
}
