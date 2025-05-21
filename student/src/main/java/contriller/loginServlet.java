 package contriller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import service.loginservice;
import session.Sessionutil;
import cookie.Cookieutil;

@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles login form submission
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        loginservice loginService = new loginservice();
        boolean loginStatus = loginService.validateUser(email, password);

        if (loginStatus) {
            HttpSession session = req.getSession();
            session.setAttribute("userEmail", email);
            Sessionutil.setAttribute(req, "username", email);

            if (email.equalsIgnoreCase("aaa@gmail.com")) {
                Cookieutil.addCookie(resp, "role", "admin", 5 * 60);
                resp.sendRedirect(req.getContextPath() + "/dashboard");
            } else {
                Cookieutil.addCookie(resp, "role", "student", 5 * 60);
                req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("errorMessage", "Invalid email or password.");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }}