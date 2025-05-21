package contriller;

import jakarta.servlet.ServletException;
import studentMOdel.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import util.password;
import service.RegisterService;

@WebServlet(urlPatterns = { "/reg" })
public class reg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Get form values
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");
        String imagePath = "uploads/default.png";
        String phone = null; // Initially, phone is null

        // Encrypt password
        String encryptedPassword = password.encrypt(email, plainPassword);

        // Create User object
        User user = new User(fname, lname, dob, email, encryptedPassword, imagePath, phone);

        // Register user
        RegisterService registerService = new RegisterService();
        boolean success = registerService.registerUser(user);

        if (success) {
            response.sendRedirect("login"); // Redirect to login page
        } else {
            request.setAttribute("error", "Registration failed. Please try again.");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/reg.jsp").forward(request, response);
    }
}
