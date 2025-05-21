package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.dbconfi;
import util.password;

public class loginservice {

    public boolean validateUser(String email, String inputPassword) {
        try (Connection conn = dbconfi.getDbConnection()) {
            String sql = "SELECT password FROM us WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String encryptedPassword = rs.getString("password");
                String decryptedPassword = password.decrypt(email, encryptedPassword);

                System.out.println("Encrypted Password from DB: " + encryptedPassword);
                System.out.println("Decrypted Password: " + decryptedPassword);
                System.out.println("Input Password: " + inputPassword);

                // Safely compare
                return decryptedPassword != null && decryptedPassword.equals(inputPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
