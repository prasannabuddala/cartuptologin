package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/GetCartItemsServlet")
public class GetCartItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<CartItem> cartitems = (ArrayList<CartItem>) req.getSession().getAttribute("cartitems");
		res.setContentType("application/json");
		if (cartitems == null) {
			System.out.println("cart items are null from servlet");
			res.getWriter().println("{\"status\":\"null\"}");
		} else {
			Gson gson = new Gson();
			String json = gson.toJson(cartitems);
			res.getWriter().println(json);
		}
	}
}
