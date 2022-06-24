/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Process.DoiTac;
import Process.KhachHang;
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
public class QuanLyKhachHang extends javax.swing.JFrame {

    int maKH = -1;
    /**
     * Creates new form QuanLyNhanVien
     */
    DefaultTableModel tableQLKH = new DefaultTableModel();

    public QuanLyKhachHang() throws SQLException, ClassNotFoundException {

        initComponents();

        setListKH();

    }

    private void setListKH() throws SQLException, ClassNotFoundException {
        try {
            KhachHang kh = new KhachHang();
            ResultSet rs = kh.getListKHCT();
            tableQLKH = (DefaultTableModel) bang1.getModel();
            tableQLKH.setRowCount(0);
            String row[] = new String[8];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8).substring(0, 10);
                tableQLKH.addRow(row);
            }
            bang1.setModel(tableQLKH);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Xay ra loi");
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
        quayLai = new javax.swing.JButton();
        diem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bthem = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        bXoa = new javax.swing.JButton();
        MKH = new javax.swing.JTextField();
        loai = new javax.swing.JComboBox<>();
        TKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SDT = new javax.swing.JTextField();
        bSua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        GT = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        quayLai.setBackground(new java.awt.Color(102, 102, 102));
        quayLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quayLai.setForeground(new java.awt.Color(255, 255, 255));
        quayLai.setText("Quay Lại");
        quayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quayLaiActionPerformed(evt);
            }
        });

        diem.setText("0");

        jLabel5.setText("Điểm");

        jLabel6.setText("Giới tính");

        jLabel7.setText("Ngày sinh");

        bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Giới Tính", "Email", "SDT", "Điểm", "Loại", "Ngày Sinh"
            }
        ));
        bang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bang1);

        jLabel8.setText("SĐT");

        jLabel9.setText("Email");

        bthem.setBackground(new java.awt.Color(0, 0, 255));
        bthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bthem.setForeground(new java.awt.Color(255, 255, 255));
        bthem.setText("Thêm");
        bthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthemActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Bảng khách hàng ");

        bXoa.setBackground(new java.awt.Color(255, 0, 0));
        bXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bXoa.setForeground(new java.awt.Color(255, 255, 255));
        bXoa.setText("Xóa");
        bXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaActionPerformed(evt);
            }
        });

        MKH.setEditable(false);

        loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "Thân Thiết", "Tiềm Năng", "Thường" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Quản Lý Khách Hàng");

        jLabel1.setText("Mã khách hàng ");

        bSua.setBackground(new java.awt.Color(0, 255, 0));
        bSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bSua.setForeground(new java.awt.Color(255, 255, 255));
        bSua.setText("Sửa");
        bSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSuaActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên khách hàng ");

        GT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAM", "NỮ", "KHÁC" }));
        GT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GTActionPerformed(evt);
            }
        });

        jLabel4.setText("Loại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(472, 472, 472))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(quayLai)
                        .addGap(368, 368, 368)
                        .addComponent(jLabel2)
                        .addGap(235, 382, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(diem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(loai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MKH, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(164, 164, 164)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(14, 14, 14))
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(NS, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TKH)
                                    .addComponent(GT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bthem)
                        .addGap(151, 151, 151)
                        .addComponent(bXoa)
                        .addGap(154, 154, 154)
                        .addComponent(bSua)
                        .addGap(341, 341, 341))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(quayLai))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bthem)
                    .addComponent(bXoa)
                    .addComponent(bSua))
                .addGap(29, 29, 29)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang1MouseClicked
        int Index = bang1.getSelectedRow();
        if (Index < tableQLKH.getRowCount() && Index >= 0) {
            maKH = Integer.valueOf(tableQLKH.getValueAt(Index, 0).toString());
            MKH.setText(tableQLKH.getValueAt(Index, 0).toString());
            TKH.setText(tableQLKH.getValueAt(Index, 1).toString());
            email.setText(tableQLKH.getValueAt(Index, 3).toString());
            SDT.setText(tableQLKH.getValueAt(Index, 4).toString());
            diem.setText(tableQLKH.getValueAt(Index, 5).toString());
            NS.setText(tableQLKH.getValueAt(Index, 7).toString().substring(0, 10));
            if (tableQLKH.getValueAt(Index, 2).toString().equals("NAM")) {
                GT.setSelectedIndex(0);
            } else if (tableQLKH.getValueAt(Index, 2).toString().equals("NỮ")) {
                GT.setSelectedIndex(1);
            } else {
                GT.setSelectedIndex(2);
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_bang1MouseClicked

    private void GTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GTActionPerformed

    private void bthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthemActionPerformed
        String tenKH = TKH.getText();
        String gioiT = GT.getSelectedItem().toString();
        String mail = email.getText();
        String sdt = SDT.getText();
        String di = diem.getText();
        String lo = loai.getSelectedItem().toString();
        String namS = NS.getText();
        if (tenKH.equals("") || mail.equals("") || sdt.equals("") || di.equals("") || namS.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống !!!");
            return;
        }
        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Thêm", "Thêm", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }
        try {
            KhachHang kh = new KhachHang();
            int check = kh.checkMail(mail);
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Mail đã tồn tại !!!");
                return;
            }
            int rs = kh.addKH(tenKH, gioiT, mail, sdt, di, lo, namS);
            setListKH();
            JOptionPane.showMessageDialog(this, "Thêm thành công !!!");
            TKH.setText("");
            email.setText("");
            SDT.setText("");
            diem.setText("");
            NS.setText("");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ngày Sinh Có Dạng Ngày-Tháng-Năm");
        } catch (ClassNotFoundException cx) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_bthemActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
        int Index = bang1.getSelectedRow();
        if (!(Index < tableQLKH.getRowCount() && Index >= 0)) {
            JOptionPane.showMessageDialog(this, "Chọn loại sản phẩm cần xóa !!!");
            return;
        }

        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }

        try {
            KhachHang kh = new KhachHang();
            int rs = kh.remoteKH(maKH);
            setListKH();
            JOptionPane.showMessageDialog(this, "Xóa thành công !!!");
            TKH.setText("");
            email.setText("");
            SDT.setText("");
            diem.setText("");
            NS.setText("");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại !!!");
        }
    }//GEN-LAST:event_bXoaActionPerformed

    private void bSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSuaActionPerformed
        // TODO add your handling code here:
        int Index = bang1.getSelectedRow();
        if (!(Index < tableQLKH.getRowCount() && Index >= 0)) {
            JOptionPane.showMessageDialog(this, "Chọn loại khuyến mãi cần sửa !!!");
            return;
        }

        String tenKH = TKH.getText();
        String gioiT = GT.getSelectedItem().toString();
        String mail = email.getText();
        String sdt = SDT.getText();
        String di = diem.getText();
        String lo = loai.getSelectedItem().toString();
        String namS = NS.getText();
        if (tenKH.equals("") || mail.equals("") || sdt.equals("") || di.equals("") || namS.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống !!!");
            return;
        }
        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Sửa", "Sửa", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }

        try {
            KhachHang kh = new KhachHang();
            int check = kh.checkMail(mail);
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Mail đã tồn tại !!!");
                return;
            }

            int rs = kh.updateKH(maKH, tenKH, gioiT, mail, sdt, di, lo, namS);
            setListKH();
            JOptionPane.showMessageDialog(this, "Sửa thành công !!!");
            TKH.setText("");
            email.setText("");
            SDT.setText("");
            diem.setText("");
            NS.setText("");
            bSua.setEnabled(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Ngày Sinh Có Dạng Ngày-Tháng-Năm");
        }
    }//GEN-LAST:event_bSuaActionPerformed

    private void quayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quayLaiActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Menu.main(null);
    }//GEN-LAST:event_quayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuanLyKhachHang().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> GT;
    private javax.swing.JTextField MKH;
    private javax.swing.JTextField NS;
    private javax.swing.JTextField SDT;
    private javax.swing.JTextField TKH;
    private javax.swing.JButton bSua;
    private javax.swing.JButton bXoa;
    private javax.swing.JTable bang1;
    private javax.swing.JButton bthem;
    private javax.swing.JTextField diem;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> loai;
    private javax.swing.JButton quayLai;
    // End of variables declaration//GEN-END:variables
}
