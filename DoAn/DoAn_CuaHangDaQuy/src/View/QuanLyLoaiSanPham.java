/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Process.LoaiSanPham;
import java.lang.System.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author votha
 */
public class QuanLyLoaiSanPham extends javax.swing.JFrame {

    DefaultTableModel DSLoaiSP = new DefaultTableModel();
    int maLSP = -1;

    /**
     * Creates new form QuanLyLoaiSanPham
     */
    public QuanLyLoaiSanPham() throws SQLException, ClassNotFoundException {
        initComponents();
        setListLoaiSP();

    }

    private void setListLoaiSP() throws SQLException, ClassNotFoundException {
        try {
            LoaiSanPham lsp = new LoaiSanPham();
            ResultSet rs = lsp.getListLoaiSP();
            DSLoaiSP = (DefaultTableModel) bang.getModel();
            DSLoaiSP.setRowCount(0);
            String row[] = new String[2];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                DSLoaiSP.addRow(row);
            }
            bang.setModel(DSLoaiSP);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        bang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tenLoaiSanPham = new javax.swing.JFormattedTextField();
        bThem = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        bSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bang.setBackground(new java.awt.Color(255, 255, 255));
        bang.setForeground(new java.awt.Color(0, 0, 0));
        bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Loại Sản Phẩm"
            }
        ));
        bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bang);
        if (bang.getColumnModel().getColumnCount() > 0) {
            bang.getColumnModel().getColumn(0).setMinWidth(40);
            bang.getColumnModel().getColumn(0).setPreferredWidth(40);
            bang.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel2.setText("Loại sản phẩm");

        tenLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tenLoaiSanPhamMouseClicked(evt);
            }
        });
        tenLoaiSanPham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tenLoaiSanPhamPropertyChange(evt);
            }
        });

        bThem.setBackground(new java.awt.Color(51, 51, 255));
        bThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bThem.setForeground(new java.awt.Color(255, 255, 255));
        bThem.setText("Thêm");
        bThem.setEnabled(false);
        bThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemActionPerformed(evt);
            }
        });

        bXoa.setBackground(new java.awt.Color(255, 51, 51));
        bXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bXoa.setForeground(new java.awt.Color(255, 255, 255));
        bXoa.setText("Xóa");
        bXoa.setEnabled(false);
        bXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaActionPerformed(evt);
            }
        });

        bSua.setBackground(new java.awt.Color(51, 255, 51));
        bSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bSua.setForeground(new java.awt.Color(255, 255, 255));
        bSua.setText("Sửa");
        bSua.setEnabled(false);
        bSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSuaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Danh Sách Loại Sản Phẩm");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Quản Lý Loại Sản Phẩm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(bThem)
                        .addGap(44, 44, 44)
                        .addComponent(bXoa)
                        .addGap(50, 50, 50)
                        .addComponent(bSua)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(tenLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel3)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bThem)
                    .addComponent(bXoa)
                    .addComponent(bSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangMouseClicked
        // TODO add your handling code here:
        bThem.setEnabled(false);
        bXoa.setEnabled(true);
        bSua.setEnabled(true);
        int Index = bang.getSelectedRow();
        if (Index < DSLoaiSP.getRowCount() && Index >= 0) {
            tenLoaiSanPham.setText(DSLoaiSP.getValueAt(Index, 1).toString());
            maLSP = Integer.valueOf(DSLoaiSP.getValueAt(Index, 0).toString());
            System.out.println(maLSP);
        }
    }//GEN-LAST:event_bangMouseClicked

    private void bThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemActionPerformed
        // TODO add your handling code here:
        String tenLSP = tenLoaiSanPham.getText();
        if (tenLSP.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống !!!");
            return;
        }
        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Thêm", "Thêm", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }
        try {
            LoaiSanPham lsp = new LoaiSanPham();
            int check = lsp.checkLoaiSP(tenLSP);
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Loại sản phẩm đã tồn tại !!!");
                return;
            }
            int rs = lsp.addLSP(tenLSP);
            setListLoaiSP();
            JOptionPane.showMessageDialog(this, "Thêm thành công !!!");
            tenLoaiSanPham.setText("");
            bThem.setEnabled(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !!!");
        }
    }//GEN-LAST:event_bThemActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
        int Index = bang.getSelectedRow();
        if (!(Index < DSLoaiSP.getRowCount() && Index >= 0)) {
            JOptionPane.showMessageDialog(this, "Chọn loại sản phẩm cần xóa !!!");
            return;
        }

        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }

        try {
            System.out.println(maLSP);
            LoaiSanPham lsp = new LoaiSanPham();
            int rs = lsp.remoteLSP(maLSP);
            setListLoaiSP();
            JOptionPane.showMessageDialog(this, "Xóa thành công !!!");
            tenLoaiSanPham.setText("");
            bXoa.setEnabled(false);
            bSua.setEnabled(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại !!!");
        }
    }//GEN-LAST:event_bXoaActionPerformed

    private void bSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSuaActionPerformed
        // TODO add your handling code here:
        int Index = bang.getSelectedRow();
        if (!(Index < DSLoaiSP.getRowCount() && Index >= 0)) {
            JOptionPane.showMessageDialog(this, "Chọn loại sản phẩm cần sửa !!!");
            return;
        }

        String tenLSP = tenLoaiSanPham.getText();
        if (tenLSP.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống !!!");
            return;
        }

        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Sửa", "Sửa", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }

        try {
            System.out.println(maLSP);
            LoaiSanPham lsp = new LoaiSanPham();
            int check = lsp.checkLoaiSP(tenLSP);
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Loại sản phẩm đã tồn tại !!!");
                return;
            }
            int rs = lsp.updateLSP(maLSP, tenLSP);
            setListLoaiSP();
            JOptionPane.showMessageDialog(this, "Sửa thành công !!!");
            tenLoaiSanPham.setText("");
            bSua.setEnabled(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Sửa thất bại !!!");
        }
    }//GEN-LAST:event_bSuaActionPerformed

    private void tenLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tenLoaiSanPhamMouseClicked
        // TODO add your handling code here:
        bThem.setEnabled(true);
    }//GEN-LAST:event_tenLoaiSanPhamMouseClicked

    private void tenLoaiSanPhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tenLoaiSanPhamPropertyChange
        // TODO add your handling code here:
        bXoa.setEnabled(false);
    }//GEN-LAST:event_tenLoaiSanPhamPropertyChange

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
            java.util.logging.Logger.getLogger(QuanLyLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuanLyLoaiSanPham().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(QuanLyLoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(QuanLyLoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSua;
    private javax.swing.JButton bThem;
    private javax.swing.JButton bXoa;
    private javax.swing.JTable bang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField tenLoaiSanPham;
    // End of variables declaration//GEN-END:variables
}
