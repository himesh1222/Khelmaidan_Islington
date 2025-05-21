package finasd;

import service.GroundDAO;
import model.GroundModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/searchGround")
public class GroundSearchController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchQuery = request.getParameter("query");

        try {
            GroundDAO dao = new GroundDAO();
            List<GroundModel> searchResults = dao.searchGrounds(searchQuery);

            request.setAttribute("groundList", searchResults);
            request.setAttribute("searchQuery", searchQuery);

            request.getRequestDispatcher("/WEB-INF/page/groundDetails.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Search error: " + e.getMessage());
        }
    }
}
