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
public class HoaDon {

    public int addHD() throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "INSERT INTO HOADON (MAHD, MANV, NGAYTAOHD, TONGTIEN, TIENKM, THANHTIEN) VALUES (mahd_seq.nextval, 3, TO_DATE(CURRENT_DATE, 'DD-MM-YYYY HH24:MI:SS'), '0', '0', '0')";
        PreparedStatement ps = conn.prepareStatement(SQL);
        i = ps.executeUpdate();
        return i;
    }
    public int addCTHD(int maHD, int maSP, int soL) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into CTHD values (?, ?, ?)";
        
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maHD);
        ps.setInt(2, maSP);
        ps.setInt(3, soL);
        i = ps.executeUpdate();
        String SQL1 = "UPDATE SANPHAM SET SLTON = (SLTON - ?) WHERE MASP = ?";
        PreparedStatement ps1 = conn.prepareStatement(SQL1);
        ps1.setInt(2, maSP);
        ps1.setInt(1, soL);
        i = ps1.executeUpdate();
        return i;
    }
    public ResultSet getMaHD() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MAHD FROM HOADON ORDER BY  MAHD DESC";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public int updateHD(int maHD, int maKH, int maKM, String tongTien, String tongKM, String thanhT, String ghiC) throws ClassNotFoundException, SQLException {
        float a = Float.valueOf(tongTien), b = Float.valueOf(tongKM), c = Float.valueOf(thanhT);
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "";
        if (maKM < 0) {
            SQL = "UPDATE HOADON SET MAKH = ?, TONGTIEN = ?, TIENKM = ?, THANHTIEN = ?, GHICHU = ? WHERE MAHD = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, maKH);
            ps.setFloat(2, a);
            ps.setFloat(3, b);
            ps.setFloat(4, c);
            ps.setString(5, ghiC);
            ps.setInt(6, maHD);
            i = ps.executeUpdate();
            return i;
        } else {
            SQL = "UPDATE HOADON SET MAKH = ?, MAKM = ?, TONGTIEN = ?, TIENKM = ?, THANHTIEN = ?, GHICHU = ? WHERE MAHD = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, maKH);
            ps.setInt(2, maKM);
            ps.setFloat(3, a);
            ps.setFloat(4, b);
            ps.setFloat(5, c);
            ps.setString(6, ghiC);
            ps.setInt(7, maHD);
            i = ps.executeUpdate();
            return i;
        }

    }
}
