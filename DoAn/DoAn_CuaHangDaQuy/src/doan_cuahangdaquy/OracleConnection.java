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
 * @author DELL
 */
class OracleConnection {
    public static Connection getMsSqlConnect() throws ClassNotFoundException,SQLException{
        String hostname = "localhost";
        String db = "SQL";
        String port = "1433";
        String username = "sa";
        String password = "123456789";
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
//        String connectURL = "jdbc:sqlserver://" + hostname + ":" + port + ";databaseName=" + db + ";" + "integratedSecurity=true"+ ";";
        String connectURL = "jdbc:sqlserver://" +hostname + ":"+port+";DatabaseName=" + db + ";encrypt=true;trustServerCertificate=true;";

        Connection conn = DriverManager.getConnection(connectURL, username, password);
        
        return conn;
}
}
