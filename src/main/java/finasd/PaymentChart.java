package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PaymentModel;
import service.PaymentDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class PaymentChart
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/PaymentChart" })
public class PaymentChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        PaymentDAO dao = new PaymentDAO();
	        List<PaymentModel> payments;
	        try {
	            payments = dao.getAllPayments();

	            // Convert data to JSON format
	            List<String> dates = new ArrayList<>();
	            List<Double> amounts = new ArrayList<>();

	            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
	            for (PaymentModel p : payments) {
	                dates.add(sdf.format(p.getPaymentDate()));
	                amounts.add(p.getAmount());
	            }

	            request.setAttribute("dates", dates);
	            request.setAttribute("amounts", amounts);
	            request.getRequestDispatcher("payment.jsp").forward(request, response);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
