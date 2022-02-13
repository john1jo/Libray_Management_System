
package com.example.librarymanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Database_Connectionclass
{
    private static final String url = "jdbc:mysql://localhost:3306/library_management";
    private static final String user = "root";
    private static final String password = "";
    private static final String driver = "com.mysql.jdbc.Driver";
    //String con;

    public Connection connMethod() throws ClassNotFoundException {
        Class.forName(driver);
        Connection conn = null ;

        try {
            conn = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "connected");

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error: " + ex);
        }
        return conn;
    }
    
}