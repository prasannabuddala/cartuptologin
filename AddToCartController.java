package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodId = Integer.parseInt(request.getParameter("pid"));

		HttpSession session = request.getSession();
		List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartitems");
		if (cartItems == null) {
			cartItems = new ArrayList<>();
		}

		boolean productExists = false;
		for (CartItem item : cartItems) {
			if (item.getPid() == prodId) {
				item.setQuantity(item.getQuantity() + 1);
				productExists = true;
				break;
			}
		}

		if (!productExists) {
			CartItem item = new CartItem(prodId, 1);
			cartItems.add(item);
		}

		session.setAttribute("cartitems", cartItems);

		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
