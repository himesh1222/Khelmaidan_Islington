package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import service.LoginService;
import util.SessionUtil;
import util.Cookieutil;

@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Handles login form submission
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		LoginService loginService = new LoginService();
		HttpSession session = req.getSession(); // Get the session

		// Validate user
		boolean loginStatus = loginService.validateUser(email, password, session);

		if (loginStatus) {
			// Get the userId from the session and set it
			int userId = (int) session.getAttribute("userId");

			session.setAttribute("userEmail", email); // Store email in session
			session.setAttribute("userId", userId); // Store user ID in session
			SessionUtil.setAttribute(req, "username", email); // Optional for another use case

			// Check for admin user
			if (email.equalsIgnoreCase("admin1@gmail.com")) {
				Cookieutil.addCookie(resp, "role", "admin", 5 * 60);
				resp.sendRedirect(req.getContextPath() + "/AdmindashboardController");
			} else {
				Cookieutil.addCookie(resp, "role", "customer", 5 * 60);
				resp.sendRedirect(req.getContextPath() + "/Fustal");
				;
			}

		} else {
			req.setAttribute("errorMessage", "Invalid email or password.");
			req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req, resp);
	}
}
