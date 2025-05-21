package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.PaymentModel;
import DB.Dbconfig;

public class PaymentDAO {

    // Save payment details in the database
    public int savePayment(PaymentModel payment) throws SQLException {
        int generatedId = -1;
        String sql = "INSERT INTO Payment (payment_date, amount, payment_status, payment_method) VALUES (?, ?, ?, ?)";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setTimestamp(1, new Timestamp(payment.getPaymentDate().getTime()));
            ps.setDouble(2, payment.getAmount());
            ps.setString(3, payment.getPaymentStatus());
            ps.setString(4, payment.getPaymentMethod());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return generatedId;
    }

    // Save booking and payment association
    public void saveBookingPayment(int bookingId, int paymentId) throws SQLException {
        String sql = "INSERT INTO Booking_Payment (booking_id, payment_id) VALUES (?, ?)";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            ps.setInt(2, paymentId);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Fetch all payments from the database
    public List<PaymentModel> getAllPayments() throws SQLException {
        List<PaymentModel> payments = new ArrayList<>();
        String sql = "SELECT payment_date, amount FROM Payment ORDER BY payment_date";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PaymentModel payment = new PaymentModel();
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setAmount(rs.getDouble("amount"));
                payments.add(payment);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return payments;
    }}
    