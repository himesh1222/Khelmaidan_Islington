package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Dbconfig;

public class DashboardFetch {

    // Get total number of users from newuser table
    public int getTotalUsers() {
        int totalUsers = 0;
        String sql = "SELECT COUNT(*) FROM newuser";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                totalUsers = rs.getInt(1);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalUsers;
    }

    // ✅ Get total payment amount from Payment table
    public double getTotalPaymentAmount() {
        double totalAmount = 0.0;
        String sql = "SELECT SUM(amount) FROM Payment";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                totalAmount = rs.getDouble(1);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalAmount;
    }

    // ✅ Get total number of bookings from Booking table
    public int getTotalBookings() {
        int totalBookings = 0;
        String sql = "SELECT COUNT(*) FROM Booking";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                totalBookings = rs.getInt(1);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalBookings;
    }
}
