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
public class PhieuDichVu {
    public ResultSet getListPDV() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT PDV.MAPDV, KH.TENKH, NGAYTAOPDV, TONGSLDV, TONGTIEN, TRATRUOC, THANHTIEN "
                + "FROM PHIEUDV PDV, KHACHHANG KH WHERE KH.MAKH = PDV.MAKH order by MAPDV DESC";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet getListCTDV(int maPDV) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT S.MADV, S.TENDV, C.SLDV, S.TIENDV"
                + "FROM CTDV C, DICHVU S WHERE C.MADV = S.MADV AND MAPDV = ? ORDER BY TENDV ASC";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maPDV);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public int addPDV(int maNV) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "INSERT INTO PHIEUDV (MANV, MAKH, NGAYTAOPDV, TONGSLDV, TONGTIEN, TRATRUOC, THANHTIEN) "
                + "VALUES (?, '1', TO_DATE(CURRENT_DATE, 'DD-MM-YYYY HH24:MI:SS'), '0', '0', '0', '0')";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maNV);
        i = ps.executeUpdate();
        return i;
    }

    public int remotePDV(int maPDV) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "DELETE PHIEUDV WHERE MAPDV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maPDV);
        i = ps.executeUpdate();
        return i;
    }

    public int remoteCTDV(int maPDV) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "DELETE CTDV WHERE MAPDV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maPDV);
        i = ps.executeUpdate();
        return i;
    }

    public int addCTDV(int maPDV, int maDV, int SL) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into CTDV values (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maPDV);
        ps.setInt(2, maDV);
        ps.setInt(3, SL);
        i = ps.executeUpdate();

        return i;
    }

    public ResultSet getMaPDV() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MAPDV FROM PHIEUDV ORDER BY  MAPDV DESC";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet getPDV(int maPDV) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT H.MANV, K.TENKH, K.EMAIL, H.NGAYTAOPDV, H.TONGSLDV, H.TONGTIEN, H.TRATRUOC, H.THANHTIEN "
                + "FROM PHIEUDV H, KHACHHANG K WHERE H.MAKH = K.MAKH AND H.MAPDV = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maPDV);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public int updatePDV(int maPDV, int maKH, int tongSLDV, String tongTien, String traTruoc, String thanhT) throws ClassNotFoundException, SQLException {
        float a = Float.valueOf(tongTien), b = Float.valueOf(traTruoc), c = Float.valueOf(thanhT);
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "";
        
            SQL = "UPDATE phieudv SET MAKH = ?,TONGSLDV = ?, TONGTIEN = ?, TRATRUOC = ?, THANHTIEN = ? WHERE MAPDV = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, maKH);
            ps.setInt(2, Integer.valueOf(tongSLDV));
            ps.setFloat(3, a);
            ps.setFloat(4, b);
            ps.setFloat(5, c);
            ps.setInt(6, maPDV);
            i = ps.executeUpdate();
            return i;
        
        

    }
}
