package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.BookingModel;
import service.BookingService;
import service.GroundDAO;
import model.GroundModel;
import model.Usermodel;

@WebServlet("/AdminBooking")
public class AdminBooking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int futsalId = Integer.parseInt(request.getParameter("futsal_id"));
            GroundDAO dao = new GroundDAO();
            GroundModel ground = dao.getGroundById(futsalId);
            request.setAttribute("ground", ground);
            request.getRequestDispatcher("/WEB-INF/page/AdminBooking.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Create the booking model
            BookingModel booking = new BookingModel();
            booking.setBookingDate(request.getParameter("bookingDate"));
            booking.setSlotTime(request.getParameter("slotTime"));
            booking.setDurationHours(Integer.parseInt(request.getParameter("durationHours")));
            booking.setBookingStatus(request.getParameter("bookingStatus"));
            booking.setUserId(Integer.parseInt(request.getParameter("userId")));
            booking.setFutsalId(Integer.parseInt(request.getParameter("futsalId")));

            // Save booking and return success or failure
            BookingService service = new BookingService();
            boolean success = service.saveBooking(booking);

            if (success) {
                // If booking is saved successfully, save the booking-ground relationship
                boolean groundSuccess = service.saveBookingGround(booking);

                if (groundSuccess) {
                    // Store bookingId in session for further use
                    HttpSession session = request.getSession();
                    session.setAttribute("bookingId", booking.getBookingId());

                    // Redirect to Payment page (pass futsal_id)
                    response.sendRedirect("payment?futsal_id=" + booking.getFutsalId());
                } else {
                    request.setAttribute("errorMessage", "Booking-ground relationship failed. Please try again.");
                    request.getRequestDispatcher("/booking.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Booking failed. Please try again.");
                request.getRequestDispatcher("/booking.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Internal error: " + e.getMessage());
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
        }
    }
}
