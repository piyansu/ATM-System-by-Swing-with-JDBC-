package BankSystemManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
    
    Connection c;
    Statement s;

    public connection() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Replace the placeholders with your actual database credentials
            String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12674062";
            String username = "sql12674062";
            String password = "7qRXINwZlw";

            // Establish the connection
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
