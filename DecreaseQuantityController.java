package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DecreaseQuantityController")
public class DecreaseQuantityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodId = Integer.parseInt(request.getParameter("pid"));

		HttpSession session = request.getSession();
		List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartitems");
		if (cartItems != null) {
			for (CartItem item : cartItems) {
				if (item.getPid() == prodId) {
					int newQuantity = item.getQuantity() - 1;
					if (newQuantity >= 0) {
						item.setQuantity(newQuantity);
						break;
					}
				}
			}
		}

		session.setAttribute("cartitems", cartItems);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("success");
	}
}
