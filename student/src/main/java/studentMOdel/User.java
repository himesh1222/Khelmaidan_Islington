package studentMOdel;

public class User {
    private String fname;
    private String lname;
    private String dob;
    private String email;
    private String password;
    private String image;
    private String phone;

    public User() {
        // Empty constructor
    }

    public User(String fname, String lname, String dob, String email, String password, String image, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.image = image;
        this.phone = phone;
    }

    // Getters and Setters
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
