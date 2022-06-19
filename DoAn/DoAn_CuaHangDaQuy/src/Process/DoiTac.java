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
public class DoiTac {
    public ResultSet getListDT() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT MADT, TENCTY, DIACHI, SDT FROM DOITAC";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public int checkDoiTac(String tenCT) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "SELECT * FROM DOITAC where TENCTY = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenCT);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return 0;
        } else {
            return 1;
        }
    }
    public int addDoiTac(String tenCT, String diaC, String soDT) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "insert into DOITAC values (madt_seq.nextval, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenCT);
        ps.setString(2, diaC);
        ps.setString(3, soDT);
        i = ps.executeUpdate();
        return i;
    }
    
    public int remoteDT(int maDT) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "delete DOITAC where MADT = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, maDT);
        i = ps.executeUpdate();
        return i;
    }
    public int updateKM(int maDT, String tenCT, String diaC, String soDT) throws ClassNotFoundException, SQLException {
        int i = 0;
        Connection conn = null;
        conn = ConnectionUtils.getMyConnection();
        String SQL = "update DOITAC set TENCTY = ?, DIACHI = ?, SDT = ? where MADT = ?";
        System.out.println(SQL);
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, tenCT);
        ps.setString(2, diaC);
        ps.setString(3, soDT);
        ps.setInt(4, maDT);
        i = ps.executeUpdate();
        return i;
    }
}
