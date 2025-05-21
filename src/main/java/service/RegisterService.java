package service;

import java.sql.*;
import DB.Dbconfig;
import model.Usermodel;

public class RegisterService {
    public boolean registerUser(Usermodel user) {
        try (Connection conn = Dbconfig.getDbConnection()) {
            String sql = "INSERT INTO newUser (first_name, last_name, dob, email, password, image_path, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set parameters in the correct order
            ps.setString(1, user.getFirstName()); // first_name
            ps.setString(2, user.getLastName());  // last_name
            ps.setString(3, user.getDob());       // dob
            ps.setString(4, user.getEmail());     // email
            ps.setString(5, user.getPassword());  // password
            ps.setString(6, user.getImagePath()); // image_path
            ps.setString(7, user.getPhone());     // phone
            
            return ps.executeUpdate() > 0;  // Returns true if insertion is successful
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Returns false if an exception occurs
        }
    }
}
