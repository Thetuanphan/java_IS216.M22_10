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
public class SanPham {
    public ResultSet getListSP() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MASP, TENSP, L.TENLSP, SLTON, DVT, DONGIA FROM SANPHAM S, LOAISANPHAM L WHERE S.MALSP = L.MALSP AND S.SLTON > 0 order by TENSP asc";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public int checkSP(String tenLSP) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM SANPHAM where TENSP = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenLSP);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 0;
        } else {
            return 1;
        }
    }
    public int checkLSP(String tenLSP) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM LOAISANPHAM where TENLSP = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenLSP);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int maLSP = rs.getInt(1);
        return maLSP;
    }
    public int addSP(int maLSP, String tenSP, int soLuong, String donVi, int donGia) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into SANPHAM values (masp_seq.nextval, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maLSP);
        ps.setString(2, tenSP);
        ps.setInt(3, soLuong);
        ps.setString(4, donVi);
        ps.setInt(5, donGia);
        i = ps.executeUpdate();
        return i;
    }

    public int remoteSP(int maSP) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "delete SANPHAM where MASP = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maSP);
        i = ps.executeUpdate();
        return i;
    }

    public int updateSP(int maLSP, String tenSP, int soLuong, String donVi, int donGia, int maSP) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update SANPHAM set MALSP = ?, TENSP = ?, SLTON = ?, DVT = ?, DONGIA = ? where MASP = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maLSP);
        ps.setString(2, tenSP);
        ps.setInt(3, soLuong);
        ps.setString(4, donVi);
        ps.setInt(5, donGia);
        ps.setInt(6, maSP);
        i = ps.executeUpdate();
        return i;
    }
}
