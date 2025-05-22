package contriller;

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
import studentMOdel.User;
import service.updateservice;

@WebServlet("/update")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get user details from the form
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");

        // Get the logged-in user's email from the session (not from the form)
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("userEmail"); // email should be stored during login

        if (email == null) {
            // If session is invalid or email not found, show an error message
            response.getWriter().println("Session expired. Please login again.");
            return;
        }

        // Handle photo upload
        Part filePart = request.getPart("photo");
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
        User user = new User();
        user.setFname(firstName);
        user.setLname(lastName);
        user.setDob(dob);
        user.setPhone(phone);
        user.setEmail(email);  // Email set from session, not from form
        user.setImage(uploadPath);

        // Call update service
        updateservice service = new updateservice();
        boolean updated = service.updateUser(user);

        if (updated) {
            response.sendRedirect("profileUpdated.jsp"); // Redirect to success page
        } else {
            response.getWriter().println("Profile update failed!");
        }
    }

    // For GET request, we can just forward to the home page or wherever you want
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
