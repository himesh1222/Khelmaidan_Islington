package DB;

import java.sql.Connection;

public class dbtest {
    public static void main(String[] args) {
        try {
            Connection conn = Dbconfig.getDbConnection();
            if (conn != null) {
                System.out.println("✅ Database connected successfully!");
                conn.close();
            } else {
                System.out.println("❌ Failed to connect to the database.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
