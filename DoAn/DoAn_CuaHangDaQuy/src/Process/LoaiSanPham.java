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
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author votha
 */
public class LoaiSanPham {

    public ResultSet getListLoaiSP() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM LOAISANPHAM order by TENLSP asc";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public int checkLoaiSP(String tenLSP) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM LOAISANPHAM where TENLSP = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenLSP);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 0;
        } else {
            return 1;
        }
    }

    public int addLSP(String tenLSP) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into LOAISANPHAM (TENLSP) values (?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenLSP);
        i = ps.executeUpdate();
        return i;
    }

    public int remoteLSP(int maLSP) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "delete LOAISANPHAM where MALSP = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maLSP);
        i = ps.executeUpdate();
        return i;
    }

    public int updateLSP(int maLSP, String tenLSP) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update LOAISANPHAM set TENLSP = ? where MALSP = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenLSP);
        ps.setInt(2, maLSP);
        i = ps.executeUpdate();
        return i;
    }
}
