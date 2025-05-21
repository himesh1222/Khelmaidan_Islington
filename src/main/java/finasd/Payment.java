package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.GroundModel;
import model.PaymentModel;
import service.GroundDAO;
import service.PaymentDAO;
import service.BookingService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/payment")
public class Payment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Payment() {
        super();
    }

    // Load payment form with ground details
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int futsalId = Integer.parseInt(request.getParameter("futsal_id"));
            GroundDAO dao = new GroundDAO();
            GroundModel ground = dao.getGroundById(futsalId);
            request.setAttribute("ground", ground);

            // Flag to show success message if redirected from booking
            boolean bookingSuccess = "true".equals(request.getParameter("bookingSuccess"));
            request.setAttribute("bookingSuccess", bookingSuccess);

            request.getRequestDispatcher("/WEB-INF/page/payment.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error1.jsp");
        }
    }

    // Handle payment submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Integer bookingId = (Integer) session.getAttribute("bookingId");
            Integer userId = (Integer) session.getAttribute("userId");

            if (bookingId == null || userId == null) {
                response.sendRedirect("errorsdfg.jsp");
                return;
            }

            int futsalId = Integer.parseInt(request.getParameter("futsalId"));
            double amount = Double.parseDouble(request.getParameter("amount"));
           

            String paymentMethod = request.getParameter("paymentMethod");

            PaymentModel payment = new PaymentModel();
            payment.setPaymentDate(new Date());
            payment.setAmount(amount);  // Make sure your model accepts double
            payment.setPaymentStatus("Completed");
            payment.setPaymentMethod(paymentMethod);

            PaymentDAO paymentDAO = new PaymentDAO();
            int paymentId = paymentDAO.savePayment(payment);
            paymentDAO.saveBookingPayment(bookingId, paymentId);
            request.setAttribute("sucess", "payment sucessful.");
            // ✅ Update booking status to 'Confirmed'
          

            response.sendRedirect(request.getContextPath() + "/HistoryController");

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
