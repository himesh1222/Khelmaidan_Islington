package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.Dbconfig;
import model.HistoryModel;

public class HistoryService {

    public List<HistoryModel> getBookingHistoryByUserId(int userId) {
        List<HistoryModel> historyList = new ArrayList<>();

        String sql = "SELECT b.booking_id, g.Ground_Name, b.booking_date, b.slot_time, b.duration_hours, " +
                     "p.amount, p.payment_method, p.payment_status " +
                     "FROM booking b " +
                     "JOIN booking_ground bg ON b.booking_id = bg.booking_id " +
                     "JOIN grounds g ON bg.futsal_id = g.Ground_ID " +
                     "JOIN booking_payment bp ON b.booking_id = bp.booking_id " +
                     "JOIN payment p ON bp.payment_id = p.payment_id " +
                     "WHERE b.user_id = ?";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HistoryModel model = new HistoryModel();
                    model.setBookingId(rs.getInt("booking_id"));
                    model.setGroundName(rs.getString("Ground_Name"));
                    model.setBookingDate(rs.getString("booking_date"));
                    model.setSlotTime(rs.getString("slot_time"));
                    model.setDurationHours(rs.getInt("duration_hours"));
                    model.setAmount(rs.getDouble("amount"));
                    model.setPaymentMethod(rs.getString("payment_method"));
                    model.setPaymentStatus(rs.getString("payment_status"));
                    historyList.add(model);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return historyList;
    }
}
