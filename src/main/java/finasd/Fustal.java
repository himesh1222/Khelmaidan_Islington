package finasd;

import jakarta.servlet.ServletException;
import service.GroundDAO;
import model.GroundModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Fustal
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Fustal" })
public class Fustal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fustal() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GroundDAO dao = new GroundDAO();
        try {
            List<GroundModel> grounds = dao.getAllGrounds();
            request.setAttribute("grounds", grounds);
            request.getRequestDispatcher("/WEB-INF/page/FUSTAL.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch futsal data.");
        }
    }}

	


