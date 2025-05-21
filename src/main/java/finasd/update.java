package finasd;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Usermodel;
import service.updateservice;
import util.PasswordUtil;
import service.UserService;
@WebServlet("/update")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get user details from the form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String newP = request.getParameter("newPassword");
        String phone = request.getParameter("phone");

        // Get the logged-in user's email from the session (not from the form)
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("userEmail"); // email should be stored during login

        if (email == null) {
            // If session is invalid or email not found, show an error message
            response.getWriter().println("Session expired. Please login again.");
            return;
        }
        String encryptedPassword = PasswordUtil.encrypt(email, newP);
        // Handle photo upload
        Part filePart = request.getPart("profileImage");
       String fileName = filePart.getSubmittedFileName();
        String uploadPath = "uploads/" + fileName;

        if (fileName != null && !fileName.isEmpty()) {
            String realPath = getServletContext().getRealPath("/") + File.separator + "uploads";
            File uploadDir = new File(realPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            filePart.write(realPath + File.separator + fileName);
        } else {
            uploadPath = null; // No new photo uploaded
        }

        // Create User object with updated details
        Usermodel user = new Usermodel();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(encryptedPassword);
        user.setPhone(phone);
        user.setEmail(email);  // Email set from session, not from form
        user.setImagePath(uploadPath);

        // Call update service
        updateservice service = new updateservice();
        boolean updated = service.updateUser(user);

        if (updated) {
            response.sendRedirect("/update"); // Redirect to success page
        } else {
            response.getWriter().println("Profile update failed!");
        }
    }

    // For GET request, we can just forward to the home page or wherever you want
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
        	request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request, response);
            return;
        }

        UserService service = new UserService();
        try {
            Usermodel user = service.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/page/Userprofile.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error fetching user data");
        }
    }
}
