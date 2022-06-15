/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Process.LoaiSanPham;
import Process.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author votha
 */
public class QuanLySanPham extends javax.swing.JFrame {

    DefaultTableModel DSSP = new DefaultTableModel();
    int maSP = -1, maLSP = -1;
    ArrayList<String> listMaLSP = null;

    /**
     * Creates new form QuanLySanPham
     */
    public QuanLySanPham() {
        initComponents();
        setListSP();
        setListLSP();
    }

    private void setListLSP() {
        try {
            LoaiSanPham lsp = new LoaiSanPham();
            ResultSet rs = lsp.getListLoaiSP();
            HashMap<String, String> listLSP = new HashMap<>();
            while (rs.next()) {
                listLSP.put(rs.getString(1), rs.getString(2));
            }
            listMaLSP = new ArrayList<String>();
            listMaLSP.addAll(listLSP.keySet());
            ArrayList<String> listTenLSP = new ArrayList<String>();
            listTenLSP.addAll(listLSP.values());
            loaiSanPham.setModel(new DefaultComboBoxModel(listTenLSP.toArray()));
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Xay ra loi");
        }
    }

    private void setListSP() {
        try {
            SanPham sp = new SanPham();
            ResultSet rs = sp.getListSP();
            DSSP = (DefaultTableModel) bang.getModel();
            DSSP.setRowCount(0);
            String row[] = new String[6];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                DSSP.addRow(row);
            }
            bang.setModel(DSSP);

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tenSanPham = new javax.swing.JFormattedTextField();
        soLuong = new javax.swing.JFormattedTextField();
        donGia = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang = new javax.swing.JTable();
        bThem = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        bSua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        donVi = new javax.swing.JFormattedTextField();
        loaiSanPham = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên sản phẩm:");

        jLabel2.setText("Số lượng:");

        jLabel3.setText("Đơn giá");

        jLabel4.setText("Loại sản phẩm");

        tenSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Loại sản phẩm", "Số Lượng", "Đơn vị", "Đơn giá"
            }
        ));
        bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bang);
        if (bang.getColumnModel().getColumnCount() > 0) {
            bang.getColumnModel().getColumn(0).setMinWidth(60);
            bang.getColumnModel().getColumn(0).setPreferredWidth(60);
            bang.getColumnModel().getColumn(0).setMaxWidth(60);
            bang.getColumnModel().getColumn(1).setResizable(false);
            bang.getColumnModel().getColumn(2).setMinWidth(200);
            bang.getColumnModel().getColumn(2).setPreferredWidth(200);
            bang.getColumnModel().getColumn(2).setMaxWidth(200);
            bang.getColumnModel().getColumn(3).setMinWidth(80);
            bang.getColumnModel().getColumn(3).setPreferredWidth(80);
            bang.getColumnModel().getColumn(3).setMaxWidth(80);
            bang.getColumnModel().getColumn(4).setMinWidth(80);
            bang.getColumnModel().getColumn(4).setPreferredWidth(80);
            bang.getColumnModel().getColumn(4).setMaxWidth(80);
            bang.getColumnModel().getColumn(5).setMinWidth(120);
            bang.getColumnModel().getColumn(5).setPreferredWidth(120);
            bang.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        bThem.setText("Thêm");
        bThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemActionPerformed(evt);
            }
        });

        bXoa.setText("Xóa");
        bXoa.setEnabled(false);
        bXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaActionPerformed(evt);
            }
        });

        bSua.setText("Sửa");
        bSua.setEnabled(false);
        bSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSuaActionPerformed(evt);
            }
        });

        jLabel5.setText("Quản Lý Sản Phẩm");

        jLabel6.setText("Danh Sách Sản Phẩm Hiện Có");

        jLabel7.setText("Đơn vị");

        loaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(soLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                            .addComponent(tenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                            .addComponent(donGia)
                            .addComponent(donVi)
                            .addComponent(loaiSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bSua, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bThem, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(bXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(donVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(donGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bThem)
                        .addGap(29, 29, 29)
                        .addComponent(bXoa)
                        .addGap(36, 36, 36)
                        .addComponent(bSua)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(loaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemActionPerformed
        // TODO add your handling code here:
        String tenSP = tenSanPham.getText();
        String SL = soLuong.getText();
        String DV = donVi.getText();
        String DG = donGia.getText();
        if (tenSP.equals("") || SL.equals("") || DV.equals("") || DG.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống !!!");
            return;
        }
        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Thêm", "Thêm", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }
        try {
            SanPham sp = new SanPham();
            int check = sp.checkSP(tenSP);
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại !!!");
                return;
            }

            int maLSP = Integer.valueOf(listMaLSP.get(loaiSanPham.getSelectedIndex()));
            int intSL = Integer.valueOf(SL);
            int intDG = Integer.valueOf(DG);
            int rs = sp.addSP(maLSP, tenSP, intSL, DV, intDG);
            setListSP();
            JOptionPane.showMessageDialog(this, "Thêm thành công !!!");
            tenSanPham.setText("");
            soLuong.setText("");
            donVi.setText("");
            donGia.setText("");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !!!");
        }
    }//GEN-LAST:event_bThemActionPerformed

    private void bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangMouseClicked
        // TODO add your handling code here:
        bThem.setEnabled(true);
        bXoa.setEnabled(true);
        bSua.setEnabled(true);
        int Index = bang.getSelectedRow();
        if (Index < DSSP.getRowCount() && Index >= 0) {
            maSP = Integer.valueOf(DSSP.getValueAt(Index, 0).toString());
            tenSanPham.setText(DSSP.getValueAt(Index, 1).toString());
            String LSP = DSSP.getValueAt(Index, 2).toString();
            loaiSanPham.setSelectedItem(LSP);
            soLuong.setText(DSSP.getValueAt(Index, 3).toString());
            donVi.setText(DSSP.getValueAt(Index, 4).toString());
            donGia.setText(DSSP.getValueAt(Index, 5).toString());
            System.out.println(maSP);
        }
    }//GEN-LAST:event_bangMouseClicked

    private void bSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSuaActionPerformed
        // TODO add your handling code here:
        int Index = bang.getSelectedRow();
        if (!(Index < DSSP.getRowCount() && Index >= 0)) {
            JOptionPane.showMessageDialog(this, "Chọn loại sản phẩm cần sửa !!!");
            return;
        }

        String tenSP = tenSanPham.getText();
        String SL = soLuong.getText();
        String DV = donVi.getText();
        String DG = donGia.getText();
        if (tenSP.equals("") || SL.equals("") || DV.equals("") || DG.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống !!!");
            return;
        }

        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Sửa", "Sửa", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }

        try {
            SanPham sp = new SanPham();
            int maLSP = Integer.valueOf(listMaLSP.get(loaiSanPham.getSelectedIndex()));
            int intSL = Integer.valueOf(SL);
            int intDG = Integer.valueOf(DG);
            int rs = sp.updateSP(maLSP, tenSP, intSL, DV, intDG, maSP);
            setListSP();
            JOptionPane.showMessageDialog(this, "Sửa thành công !!!");
            tenSanPham.setText("");
            soLuong.setText("");
            donVi.setText("");
            donGia.setText("");
            bSua.setEnabled(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Sửa thất bại !!!");
        }
    }//GEN-LAST:event_bSuaActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int Index = bang.getSelectedRow();
        if (!(Index < DSSP.getRowCount() && Index >= 0)) {
            JOptionPane.showMessageDialog(this, "Chọn loại sản phẩm cần xóa !!!");
            return;
        }

        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }

        try {
            System.out.println(maSP);
            SanPham sp = new SanPham();
            int rs = sp.remoteSP(maSP);
            setListSP();
            JOptionPane.showMessageDialog(this, "Xóa thành công !!!");
            tenSanPham.setText("");
            soLuong.setText("");
            donVi.setText("");
            donGia.setText("");
            bThem.setEnabled(true);
            bXoa.setEnabled(false);
            bSua.setEnabled(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại !!!");
        }
    }//GEN-LAST:event_bXoaActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSua;
    private javax.swing.JButton bThem;
    private javax.swing.JButton bXoa;
    private javax.swing.JTable bang;
    private javax.swing.JFormattedTextField donGia;
    private javax.swing.JFormattedTextField donVi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> loaiSanPham;
    private javax.swing.JFormattedTextField soLuong;
    private javax.swing.JFormattedTextField tenSanPham;
    // End of variables declaration//GEN-END:variables

}