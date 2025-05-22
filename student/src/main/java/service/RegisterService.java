package service;

import java.sql.*;
import db.dbconfi;
import studentMOdel.User;

public class RegisterService {

    public boolean registerUser(User user) {
        try (Connection conn = dbconfi.getDbConnection()) {
            String sql = "INSERT INTO us (first_name, last_name, dob, email, password, image_path, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getDob());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getImage());
            ps.setString(7, user.getPhone());  // Initially null for registration

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
