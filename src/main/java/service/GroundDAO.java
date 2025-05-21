package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.GroundModel;
import DB.Dbconfig;

public class GroundDAO {

    public List<GroundModel> getAllGrounds() throws Exception {
        List<GroundModel> grounds = new ArrayList<>();
        String sql = "SELECT * FROM grounds";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                GroundModel ground = new GroundModel();
                ground.setGroundId(rs.getInt("Ground_ID"));

                ground.setGroundName(rs.getString("Ground_Name"));
                ground.setLocation(rs.getString("Location"));
                ground.setCapacity(rs.getInt("Capacity"));
                ground.setDescription(rs.getString("Description"));
                ground.setPricePerHour(rs.getDouble("PricePerHour"));
                ground.setGroundImage(rs.getString("Ground_Image"));

                grounds.add(ground);

            }
        }
        return grounds;
    }
    // ✅ Add a new ground
    public boolean addGround(GroundModel ground) throws Exception {
        String sql = "INSERT INTO grounds (Ground_Name, Location, Capacity, Description, PricePerHour, ground_image) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ground.getGroundName());
            ps.setString(2, ground.getLocation());
            ps.setInt(3, ground.getCapacity());
            ps.setString(4, ground.getDescription());
            ps.setDouble(5, ground.getPricePerHour());
            ps.setString(6, ground.getGroundImage());

            return ps.executeUpdate() > 0;
        }
        
    }

 
    public List<GroundModel> searchGrounds(String keyword) throws Exception {
        List<GroundModel> grounds = new ArrayList<>();
        String sql = "SELECT * FROM grounds WHERE Ground_Name LIKE ? OR Location LIKE ?";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String likeQuery = "%" + keyword + "%";
            ps.setString(1, likeQuery);
            ps.setString(2, likeQuery);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GroundModel ground = new GroundModel();
                ground.setGroundId(rs.getInt("Ground_ID"));
                ground.setGroundName(rs.getString("Ground_Name"));
                ground.setLocation(rs.getString("Location"));
                ground.setCapacity(rs.getInt("Capacity"));
                ground.setDescription(rs.getString("Description"));
                ground.setPricePerHour(rs.getDouble("PricePerHour"));
                ground.setGroundImage(rs.getString("Ground_Image"));
                grounds.add(ground);
            }
        }
        return grounds;
    }

   

    public GroundModel getGroundById(int futsalId) throws Exception {
        GroundModel ground = null;
        String sql = "SELECT * FROM grounds WHERE Ground_ID= ?";

        try (Connection conn = Dbconfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, futsalId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ground = new GroundModel();
                ground.setGroundId(rs.getInt("Ground_ID"));

                ground.setGroundName(rs.getString("Ground_Name"));
                ground.setLocation(rs.getString("Location"));
                ground.setCapacity(rs.getInt("Capacity"));
                ground.setDescription(rs.getString("Description"));
                ground.setPricePerHour(rs.getDouble("PricePerHour"));
                ground.setGroundImage(rs.getString("Ground_Image"));
            }
        }
        return ground;
    }
    }


