package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/GetProductsController")
public class GetProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Products> productsList = new ArrayList<>();
		GetProductsDAL obj = new GetProductsDAL();
		productsList = obj.getProducts();
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(productsList);
		pw.println(json);

	}

}
