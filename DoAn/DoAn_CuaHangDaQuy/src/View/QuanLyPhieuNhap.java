/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ConnectDB.ConnectionUtils;
import File.ReadWriteFile;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class QuanLyPhieuNhap extends javax.swing.JFrame {

    int maPN = -1;
    int maNV = -1;
    DefaultTableModel tableQLNH = new DefaultTableModel();
    DefaultTableModel tableCTNSP = new DefaultTableModel();

    /**
     * Creates new form QuanLyNhapHang1
     */
    public QuanLyPhieuNhap() throws IOException {
        initComponents();
        setListPN();
        setMaNV();
        setVisible(true);
    }

    public void setMaNV() throws IOException {
        ReadWriteFile rw = new ReadWriteFile();
        maNV = Integer.valueOf(rw.readMaNV());
    }

    public void setListPN() {

        tableQLNH = (DefaultTableModel) bang1.getModel();
        tableQLNH.setRowCount(0);
        try {
            Connection conn = null;
            conn = ConnectionUtils.getMyConnection();
            String SQL = "SELECT * FROM PHIEUNHAP ORDER BY MaPN DESC";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            String row[] = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                Date ngayT = rs.getDate(3);
                row[2] = String.format("%td-%<tm-%<tY", ngayT);
                row[3] = rs.getString(4);
                tableQLNH.addRow(row);
            }
            bang1.setModel(tableQLNH);
        } catch (SQLException ex) {
            System.out.println("Xay ra loi");
        } catch (ClassNotFoundException cx) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang1 = new javax.swing.JTable();
        quayLai = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bang2 = new javax.swing.JTable();
        xuat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AddReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Phiếu Nhập");

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        xoa.setBackground(new java.awt.Color(255, 0, 51));
        xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        xoa.setForeground(new java.awt.Color(255, 255, 255));
        xoa.setText("Xóa");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        bang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã NV", "Ngày Tạo", "Số Lượng SP"
            }
        ));
        bang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bang1);

        quayLai.setBackground(new java.awt.Color(102, 102, 102));
        quayLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quayLai.setForeground(new java.awt.Color(255, 255, 255));
        quayLai.setText("Quay Lại");
        quayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quayLaiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Quản Lý Phiếu Nhập");

        bang2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã DT", "SL Nhập", "Đơn Giá Nhập", "Thành Tiền"
            }
        ));
        jScrollPane4.setViewportView(bang2);

        xuat.setBackground(new java.awt.Color(51, 255, 51));
        xuat.setForeground(new java.awt.Color(255, 255, 255));
        xuat.setText("Xuất Phiếu Nhâp");
        xuat.setEnabled(false);
        xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã phiếu");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh Sách Phiếu Nhập");

        MP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Chi Tiết Phiếu Nhập");

        AddReport.setBackground(new java.awt.Color(0, 0, 255));
        AddReport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddReport.setForeground(new java.awt.Color(255, 255, 255));
        AddReport.setText("Tạo phiếu nhập");
        AddReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(quayLai)
                        .addGap(269, 269, 269)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(257, 257, 257)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(203, 203, 203)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(MP, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(AddReport)
                            .addGap(52, 52, 52)
                            .addComponent(xuat)
                            .addGap(58, 58, 58)
                            .addComponent(xoa))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGap(441, 441, 441))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(475, 475, 475))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(quayLai))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddReport)
                    .addComponent(xoa)
                    .addComponent(xuat))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddReportActionPerformed
        Connection conn = null;
        try {
            System.out.println("Ma nv: " + maNV);
            conn = ConnectionUtils.getMyConnection();
            String SQL = "INSERT INTO PHIEUNHAP(MANV, NGAYTAOPN, TONGSLSP) VALUES(?, TO_DATE(CURRENT_DATE, 'DD-MM-YYYY HH24:MI:SS'),0)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, maNV);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm thành công !!!");
            this.dispose();
            TaoPhieuNhap.main(null);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra !!!");
        } catch (ClassNotFoundException cx) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_AddReportActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        xuat.setEnabled(false);
        xoa.setEnabled(false);
        Connection conn = null;
        try {

            conn = ConnectionUtils.getMyConnection();
            String SQL1 = "DELETE FROM CTNSP "
                    + "WHERE MAPN = ? ";
            PreparedStatement ps1 = conn.prepareStatement(SQL1);
            ps1.setString(1, bang1.getValueAt(bang1.getSelectedRow(), 0).toString());
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(this, "Xóa thành công !!!");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Xảy ra lỗi!");
        } catch (ClassNotFoundException cx) {

        }
        try {

            conn = ConnectionUtils.getMyConnection();
            String SQL = "DELETE FROM PHIEUNHAP "
                    + "WHERE MAPN = ? ";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, bang1.getValueAt(bang1.getSelectedRow(), 0).toString());
            ps.executeUpdate();
            setListPN();

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Xảy ra lỗi!");
        } catch (ClassNotFoundException cx) {

        }
    }//GEN-LAST:event_xoaActionPerformed

    private void bang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang1MouseClicked
        // TODO add your handling code here:
        xuat.setEnabled(true);
        xoa.setEnabled(true);
        int indexTB = bang1.getSelectedRow();
        if (indexTB < tableQLNH.getRowCount() && indexTB >= 0) {
            maPN = Integer.valueOf(tableQLNH.getValueAt(bang1.getSelectedRow(), 0).toString());

            try {
                tableCTNSP = (DefaultTableModel) bang2.getModel();
                tableCTNSP.setRowCount(0);
                Connection conn = null;
                conn = ConnectionUtils.getMyConnection();
                String SQL = "SELECT * FROM CTNSP WHERE MAPN = ? ORDER BY MaSP";
                System.out.print(maPN);
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setInt(1, maPN);
                ResultSet rs = ps.executeQuery();
                String row[] = new String[5];
                while (rs.next()) {
                    row[0] = rs.getString(2);
                    row[1] = rs.getString(3);
                    row[2] = rs.getString(4);
                    row[3] = rs.getString(5);
                    row[4] = rs.getString(6);
                    tableCTNSP.addRow(row);
                }
                bang2.setModel(tableCTNSP);
            } catch (SQLException ex) {
                System.out.println("Xay ra loi");
            } catch (ClassNotFoundException cx) {

            }
            MP.setText(bang1.getValueAt(bang1.getSelectedRow(), 0).toString());

        }

    }//GEN-LAST:event_bang1MouseClicked

    private void MPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MPActionPerformed

    private void quayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quayLaiActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Menu.main(null);
    }//GEN-LAST:event_quayLaiActionPerformed

    private void xuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatActionPerformed
        // TODO add your handling code here:
        ReadWriteFile rw = new ReadWriteFile();
        try {
            rw.saveMaHD(MP.getText());
        } catch (IOException ex) {
            Logger.getLogger(QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        XuatPhieuNhap.main(null);
    }//GEN-LAST:event_xuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuanLyPhieuNhap().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(QuanLyPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddReport;
    private javax.swing.JTextField MP;
    private javax.swing.JTable bang1;
    private javax.swing.JTable bang2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton quayLai;
    private javax.swing.JButton xoa;
    private javax.swing.JButton xuat;
    // End of variables declaration//GEN-END:variables
}
