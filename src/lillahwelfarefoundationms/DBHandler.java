/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;
import java.sql.*;
/**
 *
 * @author Rufah
 */
public class DBHandler {
      static String url = "jdbc:mysql://localhost:3306/LillahWelfareFoundation";
      static String user = "root";
      static String password = "rufah"; 

         public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection conn) {
           try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
}}
