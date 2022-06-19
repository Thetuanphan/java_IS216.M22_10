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
        String SQL = "SELECT MAKH, TENKH, EMAIL FROM KHACHHANG";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet getListKHCT() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM KHACHHANG ORDER BY TENKH";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public int addKH(String tenKH, String gioiT, String mail, String sdt, String di, String lo, String namS) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "INSERT INTO KHACHHANG(MAKH, TenKH,GioiTinh,Email,SDT,Diem,Loai,NgaySinh) VALUES(makh_seq.nextval, ?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenKH);
        ps.setString(2, gioiT);
        ps.setString(3, mail);
        ps.setString(4, sdt);
        ps.setString(5, di);
        ps.setString(6, sdt);
        ps.setString(7, namS);
        i = ps.executeUpdate();
        return i;
    }

    public int checkMail(String mail) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM KHACHHANG where EMAIL = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, mail);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 0;
        } else {
            return 1;
        }
    }
    
        public int remoteKH(int maKH) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "delete KHACHHANG where MAKH = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maKH);
        i = ps.executeUpdate();
        return i;
    }
        
    public int updateKH(int maKH, String tenKH, String gioiT, String mail, String sdt, String di, String lo, String namS) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update KHACHHANG set TenKH = ?, GioiTinh = ?, Email = ?, SDT = ?, Diem = ?, Loai = ?, NgaySinh = ? where MAKH = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenKH);
        ps.setString(2, gioiT);
        ps.setString(3, mail);
        ps.setString(4, sdt);
        ps.setString(5, di);
        ps.setString(6, sdt);
        ps.setString(7, namS);
        ps.setInt(8, maKH);
        i = ps.executeUpdate();
        return i;
    }
}
