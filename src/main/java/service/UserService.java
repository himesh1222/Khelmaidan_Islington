package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Usermodel;
import DB.Dbconfig;

public class UserService {

    // Method to get all users from the database
    public List<Usermodel> getAllUsers() throws SQLException, ClassNotFoundException {
        List<Usermodel> users = new ArrayList<>();
        String sql = "SELECT * FROM newuser"; // Assuming table name is 'users'

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usermodel user = new Usermodel();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setDob(rs.getString("dob"));
                user.setImagePath(rs.getString("image_path"));
                // Set any additional fields if present in the database
                users.add(user);
            }
        }
        return users;
    
}
    public Usermodel getUserById(int userId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM newuser WHERE id = ?";
        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usermodel user = new Usermodel();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone"));
                    user.setDob(rs.getString("dob"));
                    user.setImagePath(rs.getString("image_path"));
                    return user;
                }
            }
        }
        return null;
    }
    public boolean deleteUserById(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM newuser WHERE id = ?";
        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}