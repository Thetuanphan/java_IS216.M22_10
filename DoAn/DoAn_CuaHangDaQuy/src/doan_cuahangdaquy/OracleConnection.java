/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan_cuahangdaquy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thetu
 */
public class OracleConnection {
    public static Connection getOracleConnection() throws ClassNotFoundException, SQLException{
        String hostName ="localhost";
        String sid = "CHDQ";
        String userName = "demo";
        String password = "123456Az";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        if (conn != null) {
   System.out.println("Kết nối thành công");
 }
        return conn;
    }
}
