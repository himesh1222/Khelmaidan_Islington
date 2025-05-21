package finasd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PaymentDAO;
import service.DashboardFetch;
import model.PaymentModel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdmindashboardController")
public class AdmindashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdmindashboardController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Payment chart logic
        PaymentDAO dao = new PaymentDAO();
        List<String> dates = new ArrayList<>();
        List<Double> amounts = new ArrayList<>();

        try {
            List<PaymentModel> payments = dao.getAllPayments();
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
            for (PaymentModel p : payments) {
                dates.add(sdf.format(p.getPaymentDate()));
                amounts.add(p.getAmount());
            }

            // Set data for chart
            request.setAttribute("dates", dates);
            request.setAttribute("amounts", amounts);

            // ✅ Total user count logic
            DashboardFetch dashboardFetch = new DashboardFetch();
            int totalUsers = dashboardFetch.getTotalUsers();
            int totalBookings = dashboardFetch.getTotalBookings();
            double totalRevenue = dashboardFetch.getTotalPaymentAmount();

            request.setAttribute("totalUsers", totalUsers);
            request.setAttribute("totalBookings", totalBookings);
            request.setAttribute("totalRevenue", totalRevenue);

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/page/AdminDashboard.jsp").forward(request, response);
    }
}
