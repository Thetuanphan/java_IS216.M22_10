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
public class TaiKhoan {
    public ResultSet getListTK() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MANV, TENTK, MATKHAU from TAIKHOAN order by MATK asc";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public int checkTK(int maNV) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM TAIKHOAN where MANV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maNV);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public int addTK(int maNV, String tenTK, String MK) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into TAIKHOAN(maNV, tenTK, MatKhau) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maNV);
        ps.setString(2, tenTK);
        ps.setString(3, MK);
        i = ps.executeUpdate();
        return i;
    }

    public int remoteTK(int maNV) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "delete TAIKHOAN where MANV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maNV);
        i = ps.executeUpdate();
        return i;
    }

    public int updateTK(int maNV, String tenTK, String MK) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update TAIKHOAN set TENTK = ?, MATKHAU = ? where MANV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maNV);
        ps.setString(2, tenTK);
        ps.setString(3, MK);
        i = ps.executeUpdate();
        return i;
    }
}
