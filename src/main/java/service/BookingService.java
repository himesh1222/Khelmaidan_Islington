package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.Dbconfig;
import model.BookingModel;

public class BookingService {

    public boolean saveBooking(BookingModel booking) {
        try (Connection conn = Dbconfig.getDbConnection()) {
            String sql = "INSERT INTO booking (User_Id, Booking_Date, Slot_Time, Duration_Hours, Booking_Status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, booking.getUserId());
            ps.setString(2, booking.getBookingDate());
            ps.setString(3, booking.getSlotTime());
            ps.setInt(4, booking.getDurationHours());
            ps.setString(5, booking.getBookingStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        booking.setBookingId(rs.getInt(1));
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveBookingGround(BookingModel booking) {
        try (Connection conn = Dbconfig.getDbConnection()) {
            String sql = "INSERT INTO booking_ground (Booking_id, Futsal_Id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, booking.getBookingId());
            ps.setInt(2, booking.getFutsalId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<BookingModel> getAllBookings() {
        List<BookingModel> bookings = new ArrayList<>();

        String sql = "SELECT * FROM booking"; // Query to fetch all data from the booking table

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BookingModel booking = new BookingModel();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setBookingDate(rs.getString("booking_date"));
                booking.setSlotTime(rs.getString("slot_time"));
                booking.setDurationHours(rs.getInt("duration_hours"));
                booking.setBookingStatus(rs.getString("booking_status"));
                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookings;
    }

}
