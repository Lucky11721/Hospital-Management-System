package Executive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // JDBC URL for SQL Server using port 1434
        String url = "jdbc:sqlserver://LUCKYSLAPYY:1434;databaseName=HospitalDB;encrypt=true;trustServerCertificate=true";
        String username = "Lucky"; // Change this if needed
        String password = "Hospital@123"; // Change this if needed

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connected to SQL Server successfully on port 1434!");

            // Close connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
