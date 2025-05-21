package model;

public class GroundModel {
    private int groundId;
    private String groundName;
    private String location;
    private int capacity;
    private String description;
    private double pricePerHour;
    private int futsalId;
    private String groundImage; 

    // Getters and Setters
    public int getGroundId() { return groundId; }
    public void setGroundId(int groundId) { this.groundId = groundId; }

    public String getGroundName() { return groundName; }
    public void setGroundName(String groundName) { this.groundName = groundName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(double pricePerHour) { this.pricePerHour = pricePerHour; }

    public int getFutsalId() { return futsalId; }
    public void setFutsalId(int futsalId) { this.futsalId = futsalId; }

    public String getGroundImage() { return groundImage; }
    public void setGroundImage(String groundImage) { this.groundImage = groundImage; }
}
