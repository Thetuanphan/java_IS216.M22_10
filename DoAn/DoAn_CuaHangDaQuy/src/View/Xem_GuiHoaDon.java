/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import File.ReadWriteFile;
import Process.GuiMail;
import Process.GuiMailHTML;
import Process.HoaDon;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author votha
 */
public class Xem_GuiHoaDon extends javax.swing.JFrame {

    DefaultTableModel DSCTHD = new DefaultTableModel();
    int maHD = -1;

    /**
     * Creates new form GuiHoaDon
     */
    public Xem_GuiHoaDon() throws IOException, SQLException, ClassNotFoundException {
        initComponents();
        setMaHD();
        setTT();

    }

    public void setMaHD() throws IOException {
        ReadWriteFile rw = new ReadWriteFile();
        String temp = rw.readMaHD();
        maHD = Integer.valueOf(temp);
    }

    public void setTT() throws SQLException, ClassNotFoundException {
        maHoaDon.setText(String.valueOf(maHD));
        HoaDon hd = new HoaDon();
        ResultSet rs = hd.getHD(maHD);
        if (rs.next()) {
            maThuNgan.setText(rs.getString(1));
            tenKhachHang.setText(rs.getString(2));
            mailKhachHang.setText(rs.getString(3));
            khuyenMai.setText(rs.getString(4));
            ngayHoaDon.setText(rs.getString(5));
            ghiChu.setText(rs.getString(6));
            tongTien.setText(rs.getString(7));
            giamGia.setText(rs.getString(8));
            thanhTien.setText(rs.getString(9));
        }
        try {
            DefaultTableModel DSCTHD = new DefaultTableModel();
            HoaDon hd1 = new HoaDon();
            ResultSet rs1 = hd1.getListCTHD(maHD);
            DSCTHD = (DefaultTableModel) bang2.getModel();
            DSCTHD.setRowCount(0);
            String row[] = new String[7];
            while (rs1.next()) {
                row[0] = rs1.getString(1);
                row[1] = rs1.getString(2);
                row[2] = rs1.getString(3);
                row[3] = rs1.getString(4);
                row[4] = rs1.getString(5);
                row[5] = rs1.getString(6);
                float temp = Integer.valueOf(row[3]) * Integer.valueOf(row[5]);
                row[6] = String.valueOf(temp);
                DSCTHD.addRow(row);
            }
            bang2.setModel(DSCTHD);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Xay ra loi");
        }
    }

private void guiHoaDonHTML(){
            String body = "<div  style='text-align:center;'> <img style='width:75%;height:50%;' src='https://www.marry.vn/wp-content/uploads/2016/04/29/hinh-dang-kim-cuong.jpg' alt='Italian Trulli'> <h1 style='color:red;'>Hóa Đơn Mua Hàng</h1> <p>Xin chào khách hàng: <b>" 
                    + tenKhachHang.getText() 
                    + "</b> </p> <p>Bạn đã mua hàng tại Cửa hàng Đá quý ABC lúc: "
                    + java.time.LocalDate.now() + " " +java.time.LocalTime.now() 
                    + "</p> <h2>Mã hóa đơn: <b style='color:blue;'>" 
                    + maHoaDon.getText() 
                    + "</b></h2> <table style='  font-family: arial, sans-serif; border-collapse: collapse; width: 100%;'> <tbody> <tr style='background-color: #D6EEEE;'> <td><b>Tên sản phẩm</b></td> <td><b>Số lượng</b></td> <td><b>Đơn vị</b></td> <td><b>Đơn giá</b></td> </tr> ";
        boolean check = true;
        for (int i = 0; i < DSCTHD.getRowCount(); i++) {
                if(check){
                body += "<tr> <td>" 
                        + DSCTHD.getValueAt(i, 1).toString() 
                        + "</td> <td>"
                        + DSCTHD.getValueAt(i, 3).toString() 
                        + "</td> <td>"
                        + DSCTHD.getValueAt(i, 4).toString() 
                        + "</td> <td>"
                        + DSCTHD.getValueAt(i, 6).toString() 
                        + "</td> </tr>";
                check = false;
                }
                else{
                body += "<tr style='background-color: #D6EEEE;'> <td>" 
                        + DSCTHD.getValueAt(i, 1).toString() 
                        + "</td> <td>"
                        + DSCTHD.getValueAt(i, 3).toString() 
                        + "</td> <td>"
                        + DSCTHD.getValueAt(i, 4).toString() 
                        + "</td> <td>"
                        + DSCTHD.getValueAt(i, 6).toString() 
                        + "</td> </tr>";
                check = true;
                }

        }
         body += "</tbody> </table> <h2>Tổng tiền: "
                 + tongTien.getText()
                 + " VND </h2> <h2>Tổng tiền giảm giá: "
                 + giamGia.getText()
                 +" VND</h2> <h2 style='color:red;'>Thành tiền: "
                 + thanhTien.getText()
                 +" VND</h2> <a href='https://www.cuahangdaquy.com/'>Cửa Hàng Đá Quý ABC</a> <a href='mailto:cuahangdaquy@abc.com'>cuahangdaquy@abc.com</a> </div>";
        GuiMailHTML  gm = new GuiMailHTML();
        String email = mailKhachHang.getText();
        try {
            gm.GuiHoaDon(email, body);
            JOptionPane.showMessageDialog(this, "Gửi thành công !!!");
        } catch (MessagingException ex) {
            Logger.getLogger(TaoHoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tenKhachHang = new javax.swing.JFormattedTextField();
        maThuNgan = new javax.swing.JFormattedTextField();
        ghiChu = new javax.swing.JFormattedTextField();
        khuyenMai = new javax.swing.JFormattedTextField();
        ngayHoaDon = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tongTien = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        giamGia = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        thanhTien = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        gui = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        mailKhachHang = new javax.swing.JFormattedTextField();
        huy = new javax.swing.JButton();
        maHoaDon = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        bang2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Chi Tiết Hóa Đơn");

        jLabel2.setText("Mã hóa đơn");

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Mã thu ngân");

        jLabel5.setText("Khuyến mãi");

        jLabel6.setText("Ngày hóa đơn");

        jLabel7.setText("Ghi chú");

        tenKhachHang.setEditable(false);

        maThuNgan.setEditable(false);

        ghiChu.setEditable(false);

        khuyenMai.setEditable(false);

        ngayHoaDon.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Danh sách sản phẩm");

        jLabel9.setText("Tổng tiền");

        tongTien.setEditable(false);

        jLabel10.setText("Giảm giá");

        giamGia.setEditable(false);

        jLabel11.setText("Thành tiền");

        thanhTien.setEditable(false);

        jButton1.setBackground(new java.awt.Color(0, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xuất hóa đơn");

        gui.setBackground(new java.awt.Color(0, 0, 255));
        gui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gui.setForeground(new java.awt.Color(255, 255, 255));
        gui.setText("Gửi");
        gui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiActionPerformed(evt);
            }
        });

        jLabel12.setText("Mail khách hàng");

        mailKhachHang.setEditable(false);

        huy.setBackground(new java.awt.Color(255, 0, 0));
        huy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        huy.setForeground(new java.awt.Color(255, 255, 255));
        huy.setText("Hủy");
        huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyActionPerformed(evt);
            }
        });

        maHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        maHoaDon.setText("0");

        bang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Loại Sản Phẩm", "Số Lượng", "Đơn Vị", "Đơn Giá", "Thành Tiền"
            }
        ));
        bang2.setEnabled(false);
        jScrollPane5.setViewportView(bang2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(maHoaDon))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel12)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(maThuNgan, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mailKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(khuyenMai)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ngayHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(ghiChu)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tongTien, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(giamGia, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(thanhTien, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(huy, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(436, 436, 436))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maHoaDon))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(mailKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(maThuNgan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ngayHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(gui)
                        .addGap(18, 18, 18)
                        .addComponent(huy))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiActionPerformed
        // TODO add your handling code here:\
        String mail = mailKhachHang.getText();
        if(mail.equals("")){
            JOptionPane.showMessageDialog(this, "Khách hàng chưa có mail. Nhập mail khách hàng !!!");
            mailKhachHang.setEditable(true);
            return;
        }
        guiHoaDonHTML();
    }//GEN-LAST:event_guiActionPerformed

    private void huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyActionPerformed
        // TODO add your handling code here:
        this.dispose();
        QuanLyHoaDon.main(null);
    }//GEN-LAST:event_huyActionPerformed

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
            java.util.logging.Logger.getLogger(Xem_GuiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xem_GuiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xem_GuiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xem_GuiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Xem_GuiHoaDon().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Xem_GuiHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Xem_GuiHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Xem_GuiHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bang2;
    private javax.swing.JFormattedTextField ghiChu;
    private javax.swing.JFormattedTextField giamGia;
    private javax.swing.JButton gui;
    private javax.swing.JButton huy;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JFormattedTextField khuyenMai;
    private javax.swing.JLabel maHoaDon;
    private javax.swing.JFormattedTextField maThuNgan;
    private javax.swing.JFormattedTextField mailKhachHang;
    private javax.swing.JFormattedTextField ngayHoaDon;
    private javax.swing.JFormattedTextField tenKhachHang;
    private javax.swing.JFormattedTextField thanhTien;
    private javax.swing.JFormattedTextField tongTien;
    // End of variables declaration//GEN-END:variables
}
