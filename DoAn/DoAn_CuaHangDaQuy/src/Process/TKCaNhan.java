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
public class TKCaNhan {
    
    public ResultSet getListTKCN() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MANV, TENNV, CHUCVU, GIOITINH, NGAYSINH, DIACHi, SDT, NGAYVAOLAM from TAIKHOAN where MANV = 1";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public int updateTK(int maNV, String tenNV, String gioiTinh, String diaChi, String sdt, String MK) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update NHANVIEN set TENNV = ?, GIOITINH = ?, DIACHI = ?, SDT = ? where MANV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenNV);
        ps.setString(2, gioiTinh);
        ps.setString(3, diaChi);
        ps.setString(4, sdt);
        ps.setInt(5, maNV);
        
        SQL = "update TAIKHOAN set MATKHAU = ? where MANV = ?";
        PreparedStatement ps1 = conn.prepareStatement(SQL);
        ps1.setString(1, MK);
        ps1.setInt(2, maNV);
        

        i = ps.executeUpdate();
        return i;
    }
}
