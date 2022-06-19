/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author votha
 */
public class PhieuNhap {

    public int addCTNSP(int maPN, int maSP, int maDT, int soLN, int donGN, float thanhT) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into CTHD values (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maPN);
        ps.setInt(2, maSP);
        ps.setInt(3, maDT);
        ps.setInt(4, soLN);
        ps.setInt(5, donGN);
        ps.setFloat(6, thanhT);
        i = ps.executeUpdate();
        String SQL1 = "UPDATE SANPHAM SET SLTON = (SLTON + ?) WHERE MASP = ?";
        PreparedStatement ps1 = conn.prepareStatement(SQL1);
        ps1.setInt(2, maSP);
        ps1.setInt(1, soLN);
        i = ps1.executeUpdate();
        return i;
    }

    public int updateHD(int maHD, int tongTien) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "UPDATE PHIEUNHAP SET TONGSLSP = ? WHERE MAPN = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, tongTien);
        ps.setInt(2, maHD);
        i = ps.executeUpdate();
        return i;
    }
}
