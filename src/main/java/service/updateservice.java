package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DB.Dbconfig;
import model.Usermodel;

public class updateservice {
    public boolean updateUser(Usermodel user) {
        boolean success = false;
        try {
            Connection conn = Dbconfig.getDbConnection();
            String sql = "UPDATE newuser SET first_name=?, last_name=?, phone=?, image_path=? ,password=? WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getImagePath());
            ps.setString(5, user.getPassword());
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
