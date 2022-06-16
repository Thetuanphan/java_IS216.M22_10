/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author votha
 */
public class KhachHang {
    public ResultSet getListKH() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MAKH, TENKH, SDT FROM KHACHHANG";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
