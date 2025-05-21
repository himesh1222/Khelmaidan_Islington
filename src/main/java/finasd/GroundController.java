package finasd;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.GroundDAO;
import model.GroundModel;

import java.io.IOException;
import java.util.List;

@WebServlet("/showGrounds")
public class GroundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    
            throws ServletException, IOException {
        try {
            GroundDAO dao = new GroundDAO();
            List<GroundModel> groundList = dao.getAllGrounds();
            request.setAttribute("groundList", groundList);
            request.getRequestDispatcher("/WEB-INF/page/groundDetails.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }}}
    
 

