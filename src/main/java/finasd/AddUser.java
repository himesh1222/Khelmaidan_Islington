package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usermodel;
import util.PasswordUtil;

import java.io.IOException;

/**
 * Servlet implementation class AddUser
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddUser" })
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        boolean isError = false;
        boolean otherError = false;
        // Fetching form parameters
        String email = request.getParameter("email1");
        String title = request.getParameter("title1");
        String firstName = request.getParameter("firstname1");
        String lastName = request.getParameter("lastname1");
        String plainPassword = request.getParameter("password1");
        String Repassword = request.getParameter("rePassword");
        String dob = request.getParameter("dob1");
        String imagePath = "uploads/default.png";
        String phone = null; // Initially, phone is null

        System.out.println("Received parameters:");
        System.out.println("Email: " + email);
        System.out.println("Title: " + title);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Password: " + plainPassword);
        System.out.println("Re-entered Password: " + Repassword);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Encrypting password.");
        String encryptedPassword = PasswordUtil.encrypt(email, plainPassword);

        System.out.println("Creating User object.");
        Usermodel user = new Usermodel(email, title, firstName, lastName, encryptedPassword, dob, phone ,imagePath);

        System.out.println("Calling RegisterService to save user.");
        service.RegisterService registerService = new service.RegisterService();
        boolean success = registerService.registerUser(user);
        if (success) {
            System.out.println("Registration successful, redirecting to login.");
            response.sendRedirect("AdmindashboardController");
        } else {
            System.out.println("Registration failed, forwarding to register.jsp.");
            request.setAttribute("error", "Registration failed, try again");
            request.getRequestDispatcher("/WEB-INF/page/AddUser.jsp").forward(request, response);
        }
    
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    request.getRequestDispatcher("/WEB-INF/page/AddUser.jsp").forward(request, response);
	}}
