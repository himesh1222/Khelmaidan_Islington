package finasd;
import java.time.LocalDate;
import java.time.Period;

import jakarta.servlet.ServletException;
import model.Usermodel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import util.ValidationUtil;
import util.PasswordUtil;

@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class register extends HttpServlet {
    private static final long serialVersionUID = -1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        boolean isError = false;
        boolean otherError = false;
        // Fetching form parameters
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String plainPassword = request.getParameter("password");
        String Repassword = request.getParameter("rePassword");
        String dob = request.getParameter("dob");
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

        // === STEP 1: EMPTY FIELD VALIDATION ===
        if (ValidationUtil.isNullOrEmpty(email)) {
            System.out.println("Error: Email is required.");
            request.setAttribute("EmailError", "Email is required.");
            isError = true;
        }

        if (ValidationUtil.isNullOrEmpty(title)) {
            System.out.println("Error: Title is required.");
            request.setAttribute("TitleError", "Title is required.");
            isError = true;
        }

        if (ValidationUtil.isNullOrEmpty(firstName)) {
            System.out.println("Error: First name is required.");
            request.setAttribute("FirstError", "First name is required.");
            isError = true;
        }

        if (ValidationUtil.isNullOrEmpty(lastName)) {
            System.out.println("Error: Last name is required.");
            request.setAttribute("LastError", "Last name is required.");
            isError = true;
        }

        if (ValidationUtil.isNullOrEmpty(plainPassword)) {
            System.out.println("Error: Password is required.");
            request.setAttribute("PasswordError", "Password is required.");
            isError = true;
        }

        if (ValidationUtil.isNullOrEmpty(Repassword)) {
            System.out.println("Error: Re-enter password is required.");
            request.setAttribute("ReError", "Re-enter password is required.");
            isError = true;
        }

        if (ValidationUtil.isNullOrEmpty(dob)) {
            System.out.println("Error: Date of birth is required.");
            request.setAttribute("DOBError", "Date of birth is required.");
            isError = true;
        }
        if (ValidationUtil.isNullOrEmpty(dob)) {
            request.setAttribute("DOBError", "Date of birth is required.");
            isError = true;
        } else {
            try {
                LocalDate birthDate = LocalDate.parse(dob);
                if (!ValidationUtil.isAgeAtLeast16(birthDate)) {
                    request.setAttribute("DOBError", "You must be at least 16 years old.");
                    otherError = true;
                }
            } catch (Exception e) {
                request.setAttribute("DOBError", "Invalid date format.");
                otherError = true;
            }
        }

        // If any required field is empty, don't proceed further
        if (isError) {
            System.out.println("Validation failed due to empty fields. Forwarding to register.jsp.");
            request.getRequestDispatcher("/WEB-INF/page/register.jsp").forward(request, response);
            return;
        }

        /// === STEP 2: FORMAT & LOGIC VALIDATION ===
      

        if (!ValidationUtil.isValidEmail(email)) {
            System.out.println("Error: Invalid email format.");
            request.setAttribute("EmailError", "Invalid email format.");
            otherError = true;
        }

        if (!ValidationUtil.isAlphabetic(firstName)) {
            System.out.println("Error: First name must start with a letter and contain only letters and numbers.");
            request.setAttribute("FirstError", "First name must start with a letter and contain alphabet.");
            otherError = true;
        }
        
        if (!ValidationUtil.isAlphabetic(lastName)) {
            System.out.println("Error: First name must start with a letter and contain only letters and numbers.");
            request.setAttribute("FirstError", "First name must start with a letter and contain only alphabet.");
            otherError = true;
        }


        if (!plainPassword.equals(Repassword)) {
            System.out.println("Error: Passwords do not match.");
            request.setAttribute("ReError", "Passwords do not match.");
            otherError = true;
        }

        if (!ValidationUtil.isValidPassword(plainPassword)) {
            System.out.println("Error: Password must be at least 8 characters long, contain an uppercase letter, a digit, and a special character.");
            request.setAttribute("PasswordError", "Password must have 8+ characters, 1 uppercase, 1 number, and 1 special character.");
            otherError = true;
        }
       
     
			
        
        
       
        if (otherError) {
            System.out.println("Format validation failed. Forwarding to register.jsp.");
            request.getRequestDispatcher("/WEB-INF/page/register.jsp").forward(request, response);
            return;
        }

        // === STEP 3: SUCCESS PATH ===
        System.out.println("Encrypting password.");
        String encryptedPassword = PasswordUtil.encrypt(email, plainPassword);

        System.out.println("Creating User object.");
        Usermodel user = new Usermodel(email, title, firstName, lastName, encryptedPassword, dob, phone ,imagePath);

        System.out.println("Calling RegisterService to save user.");
        service.RegisterService registerService = new service.RegisterService();
        boolean success = registerService.registerUser(user);

        if (success) {
            System.out.println("Registration successful, redirecting to login.");
            response.sendRedirect("login");
        } else {
            System.out.println("Registration failed, forwarding to register.jsp.");
            request.setAttribute("error", "Registration failed, try again");
            request.getRequestDispatcher("/WEB-INF/page/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET request received for registration.");
        request.getRequestDispatcher("/WEB-INF/page/register.jsp").forward(request, response);
    }
}
