/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doan_cuahangdaquy;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author thetu
 */
public class DoAn_CuaHangDaQuy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        // TODO code application logic here
        System.out.println("Get connection ...");
        
        Connection conn= getMyConnection();
        
        System.out.println("get connection" + conn);
        System.out.println("Done!");
        
        
    }

//    static Connection getMyConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return OracleConnection.getMsSqlConnect();
    }
 
    
}
