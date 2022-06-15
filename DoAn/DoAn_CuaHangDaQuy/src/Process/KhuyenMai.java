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
public class KhuyenMai {

    public ResultSet getListKM() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM KHUYENMAI order by LOAIKM asc";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public int checkLoaiKM(String loaiKM) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM KHUYENMAI where LOAIKM = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, loaiKM);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 0;
        } else {
            return 1;
        }
    }

    public int addKM(String loaiKM, int tiLG, int tienG) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into KHUYENMAI values (makm_seq.nextval, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, loaiKM);
        ps.setInt(2, tiLG);
        ps.setInt(3, tienG);
        i = ps.executeUpdate();
        return i;
    }

    public int remoteKM(int maKM) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "delete KHUYENMAI where MAKM = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maKM);
        i = ps.executeUpdate();
        return i;
    }

    public int updateKM(int maKM, String loaiKM, int tiLG, int tienG) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update KHUYENMAI set LOAIKM = ?, TYLEGIAM = ?, TIENGIAM = ? where MAKM = ?";
        System.out.println(SQL);
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, loaiKM);
        ps.setInt(2, tiLG);
        ps.setInt(3, tienG);
        ps.setInt(4, maKM);
        i = ps.executeUpdate();
        return i;
    }
}
