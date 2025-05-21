package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.http.HttpSession;

import DB.Dbconfig;
import util.PasswordUtil;

public class LoginService {

    public boolean validateUser(String email, String inputPassword, HttpSession session) {
        try (Connection conn = Dbconfig.getDbConnection()) {
            // SQL to fetch password and user ID based on the email
            String sql = "SELECT id, password FROM newUser WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String encryptedPassword = rs.getString("password");
                String decryptedPassword = PasswordUtil.decrypt(email, encryptedPassword);

                System.out.println("Encrypted Password from DB: " + encryptedPassword);
                System.out.println("Decrypted Password: " + decryptedPassword);
                System.out.println("Input Password: " + inputPassword);

                // Safely compare passwords
                if (decryptedPassword != null && decryptedPassword.equals(inputPassword)) {
                    // If password is correct, get the user ID and set it in the session
                    int userId = rs.getInt("id");
                    session.setAttribute("userId", userId); // Store user ID in session

                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
