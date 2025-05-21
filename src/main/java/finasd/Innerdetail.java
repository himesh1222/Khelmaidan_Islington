package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.GroundDAO;
import model.GroundModel;
/**
 * Servlet implementation class Innerdetail
 */
@WebServlet("/Innerdetail")
public class Innerdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Innerdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
    	 String idStr = request.getParameter("futsal_id");

         try {
             int futsalId = Integer.parseInt(idStr);
             System.out.println("Received futsal_id: " + idStr);

             GroundDAO dao = new GroundDAO();
             GroundModel ground = dao.getGroundById(futsalId);

             request.setAttribute("ground", ground);
             request.getRequestDispatcher("/WEB-INF/page/innerdetail.jsp").forward(request, response);
         } catch (Exception e) {
             e.printStackTrace();
             response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching ground details");
         }
	  
	}}

	
