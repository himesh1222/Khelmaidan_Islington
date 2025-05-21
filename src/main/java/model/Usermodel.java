package model;


public class Usermodel {
    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String password;
    private String dob;
    private String phone;
    private String imagePath;
    public Usermodel() {
        // Empty constructor
    }
    
    private int id; // add this at the top

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    // Constructor
    public Usermodel(String email, String title, String firstName, String lastName, String password, String dob, String phone, String imagePath) {
        this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
