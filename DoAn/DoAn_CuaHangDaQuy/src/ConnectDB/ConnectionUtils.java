/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author votha
 */
public class ConnectionUtils {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return OracleConnection.getOracleConnection();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        System.out.println("Get connection...");
        Connection conn = getMyConnection();
        System.out.println("Get connection" + conn);
        System.out.println("Done!");
    }
        
}
