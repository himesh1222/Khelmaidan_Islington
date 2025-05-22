package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.dbconfi;
import studentMOdel.User;

public class updateservice {
    public boolean updateUser(User user) {
        boolean success = false;
        try {
            Connection conn = dbconfi.getDbConnection();
            String sql = "UPDATE us SET first_name=?, last_name=?, dob=?, phone=?, image_path=? WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getDob());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getImage());
            ps.setString(6, user.getEmail());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
