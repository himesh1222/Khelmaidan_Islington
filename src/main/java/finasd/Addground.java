package finasd;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.GroundModel;
import service.GroundDAO;

@WebServlet("/AddGround")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  // 1MB
    maxFileSize = 1024 * 1024 * 5,     // 5MB
    maxRequestSize = 1024 * 1024 * 10  // 10MB
)
public class Addground extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form values
        String groundName = request.getParameter("groundName");
        String location = request.getParameter("location");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String description = request.getParameter("description");
        double pricePerHour = Double.parseDouble(request.getParameter("pricePerHour"));

        // Handle ground image upload
        Part filePart = request.getPart("groundImage");
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = "uploads/" + fileName;
        String realPath = getServletContext().getRealPath("/") + File.separator + "uploads";

        if (fileName != null && !fileName.isEmpty()) {
            File uploadDir = new File(realPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            filePart.write(realPath + File.separator + fileName);
        } else {
            uploadPath = null; // No image uploaded
        }

        // Create GroundModel and populate it
        GroundModel ground = new GroundModel();
        ground.setGroundName(groundName);
        ground.setLocation(location);
        ground.setCapacity(capacity);
        ground.setDescription(description);
        ground.setPricePerHour(pricePerHour);
        ground.setGroundImage(uploadPath);

        // Save using GroundDAO inside try-catch to handle exceptions
        try {
            GroundDAO groundDAO = new GroundDAO();
            boolean success = groundDAO.addGround(ground);

            if (success) {
                response.sendRedirect("AdmindashboardController");
            } else {
                request.setAttribute("error", "Ground insertion failed. Try again.");
                request.getRequestDispatcher("/WEB-INF/page/AddGround.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Server error: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/page/AddFutsal.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/page/AddFutsal.jsp").forward(request, response);
    }
}
