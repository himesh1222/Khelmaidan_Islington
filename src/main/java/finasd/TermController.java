package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TermController
 */
@WebServlet("/TermController")
public class TermController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TermController() {
        super();
        // TODO Auto-generated constructor stub
    }


	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        System.out.println("GET request received for registration.");
	        request.getRequestDispatcher("/WEB-INF/page/term.jsp").forward(request, response);
	    }
	}