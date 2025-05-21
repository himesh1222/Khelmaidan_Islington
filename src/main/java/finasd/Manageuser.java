package finasd;

import service.UserService;
import model.Usermodel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = { "/Manageuser" })
public class Manageuser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Manageuser() {
        super();
    }

    // GET: Fetch and show users
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserService userService = new UserService();
            List<Usermodel> users = userService.getAllUsers();
            request.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/ManageUser.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching users from database.");
        }
    }

    // POST: Handle delete action
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("userId");

        if (userIdStr != null && !userIdStr.isEmpty()) {
            try {
                int userId = Integer.parseInt(userIdStr);
                UserService userService = new UserService();
                userService.deleteUserById(userId);  // delete user
            } catch (NumberFormatException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Redirect to refresh user list
        response.sendRedirect(request.getContextPath() + "/Manageuser");
    }
}
