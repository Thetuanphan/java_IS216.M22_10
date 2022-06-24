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
 * @author thetu
 */
public class DichVu {
    public ResultSet getListDV() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MADV, TENDV, TIENDV from DICHVU order by MADV asc";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public int checkDV(String tenDV) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM DICHVU where TENDV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenDV);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public int addDV(String tenDV, int tienDV) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into DICHVU(tenDV, tienDV) values (?, ?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenDV);
        ps.setInt(2, tienDV);
        i = ps.executeUpdate();
        return i;
    }

    public int remoteDV(int maDV) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "delete DICHVU where MADV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maDV);
        i = ps.executeUpdate();
        return i;
    }

    public int updateDV(int maDV, String tenDV, int tienDV) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update DICHVU set TENDV = ?, tienDV = ? where MADV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenDV);
        ps.setInt(2, tienDV);
        ps.setInt(3, maDV);
        i = ps.executeUpdate();
        return i;
    }
}
