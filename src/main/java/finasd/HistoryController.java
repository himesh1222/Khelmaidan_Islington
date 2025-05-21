package finasd;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import model.HistoryModel;
import service.HistoryService;

@WebServlet("/HistoryController")
public class HistoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer userId = (Integer) request.getSession().getAttribute("userId");

            if (userId == null) {
            	response.sendRedirect(request.getContextPath() + "/login");

                return;
            }

            HistoryService service = new HistoryService(); // No connection needed
            List<HistoryModel> historyList = service.getBookingHistoryByUserId(userId);

            request.setAttribute("historyList", historyList);
           request.getRequestDispatcher("/WEB-INF/page/history.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
