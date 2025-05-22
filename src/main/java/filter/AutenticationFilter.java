package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.Cookieutil;
import util.SessionUtil;
import java.io.IOException;

@WebFilter("/*")
public class AutenticationFilter extends HttpFilter implements Filter {
    private static final long serialVersionUID = 1L;

    // Public
    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";

    // Admin only
    private static final String ADMINDASHBOARD = "/AdmindashboardController";
    private static final String MANAGEUSER = "/Manageuser";
    private static final String ADDUSER = "/AddUser";
    private static final String ADDGROUND = "/Addground";
    private static final String PAYMENTCHART = "/PaymentChart";
    private static final String VIEWBOOKING = "/ViewBooking";

    // Common logout
    private static final String LOGOUT = "/Logout";

    // User only
    private static final String[] USER_PAGES = {
        "/AdminBooking", "/Contactus", "/Footer", "/Fustal",
        "/Header", "/History", "/Innerdetail", "/Userprofile",
        "/Search", "/Payment","/update","/aboutus","/HistoryController","/TermController","/searchGround","/showGrounds"
    };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = session != null && SessionUtil.getAttribute(req, "username") != null;
        String userRole = Cookieutil.getCookie(req, "role") != null
                ? Cookieutil.getCookie(req, "role").getValue()
                : null;

        // Allow static resources
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".jpg")) {
            chain.doFilter(request, response);
            return;
        }

        // Allow public pages
        if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
            chain.doFilter(request, response);
            return;
        }

        // If not logged in, redirect to login for everything else
        if (!isLoggedIn) {
            res.sendRedirect(req.getContextPath() + LOGIN);
            return;
        }

        // Allow logout for any logged-in user
        if (uri.endsWith(LOGOUT)) {
            chain.doFilter(request, response);
            return;
        }

        // Admin role access
        if ("admin".equals(userRole)) {
            if (uri.endsWith(ADMINDASHBOARD) ||uri.endsWith(VIEWBOOKING) ||uri.endsWith(PAYMENTCHART) ||uri.endsWith(ADDGROUND) || uri.endsWith(MANAGEUSER) || uri.endsWith(ADDUSER)) {
                chain.doFilter(request, response);
                return;
            } else {
                // Prevent admin from accessing user-only pages
                res.sendRedirect(req.getContextPath() + ADMINDASHBOARD);
                return;
            }
        }

        // User role access
        if ("customer".equals(userRole)) {
            for (String path : USER_PAGES) {
                if (uri.endsWith(path)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            // Redirect user if trying to access admin page
            res.sendRedirect(req.getContextPath() + "/Fustal");
            return;
        }

        // Default fallback
        res.sendRedirect(req.getContextPath() + LOGIN);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}