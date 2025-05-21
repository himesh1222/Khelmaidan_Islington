package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.BookingModel;
import service.BookingService;

import java.io.IOException;
import java.util.List;

@WebServlet(asyncSupported = true, urlPatterns = { "/ViewBooking" })
public class ViewBooking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookingService bookingService = new BookingService();

    public ViewBooking() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the bookings from the service
        List<BookingModel> bookings = bookingService.getAllBookings();

        // Set the bookings as an attribute to be accessed in the JSP
        request.setAttribute("bookings", bookings);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/WEB-INF/page/ViewBooking.jsp").forward(request, response);

        System.out.println("Moving to JSP...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
