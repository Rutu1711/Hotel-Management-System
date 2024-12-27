package hotel.management.system;
import java.sql.*;

public class DBConnection {
    Connection c; //connection interface
    Statement s; // statement interface -> to execute sql queries
    
    DBConnection() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagementSystem", "root", "rutuparna");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
    }
    
}
