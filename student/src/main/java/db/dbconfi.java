package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconfi {
	 public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "");
	    }
}