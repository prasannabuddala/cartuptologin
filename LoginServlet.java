package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		res.setContentType("application/json");
		PrintWriter pw = res.getWriter();
		String status;
		UserDAL user = new UserDAL();
		System.out.println(name + " " + pwd);
		boolean loggedIn = user.validateUser(name, pwd);
		if (loggedIn == true) {
			req.getSession().setAttribute("loggedIn", "yes");
			status = "{\"status\":\"success\"}";
			pw.println(status);
		} else {
			status = "{\"status\":\"failure\"}";
			pw.println(status);
		}
	}
}
