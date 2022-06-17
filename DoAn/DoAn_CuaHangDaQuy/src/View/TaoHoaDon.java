/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Process.GuiMail;
import Process.HoaDon;
import Process.KhachHang;
import Process.KhuyenMai;
import Process.SanPham;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author votha
 */
public class TaoHoaDon extends javax.swing.JFrame {

    DefaultTableModel DSSP = new DefaultTableModel();
    int maSP = -1, maLSP = -1;
    ArrayList<String> listMaLSP = null;
    DefaultTableModel DSKM = new DefaultTableModel();

    DefaultTableModel DSKH = new DefaultTableModel();
    DefaultTableModel DSSPC = new DefaultTableModel();
    String email = "";
    String SPDC[] = new String[7];
    float TongTien = 0;
    int phanTramKM = 0;
    int tienKM = 0;

    int maKM = -1;
    int maKH = -1;
    int maHD = -1;

    /**
     * Creates new form TaoHoaDon
     */
    public TaoHoaDon() {
        initComponents();
        setListSP();
        setListKM();
        setListKH();
        setMaHD();
    }

    private void setMaHD() {
        try {
            HoaDon hd = new HoaDon();
            ResultSet rs = hd.getMaHD();
            if (rs.next()) {
                maHoaDon.setText(rs.getString(1));
                maHD = Integer.valueOf(rs.getString(1));

            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Xay ra loi");
        }
    }

    private void setListSP() {
        try {
            SanPham sp = new SanPham();
            ResultSet rs = sp.getListSP();
            DSSP = (DefaultTableModel) bang2.getModel();
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
            bang2.setModel(DSSP);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Xay ra loi");
        }
    }

    private void setListKM() {
        try {
            KhuyenMai km = new KhuyenMai();
            ResultSet rs = km.getListKM();
            DSKM = (DefaultTableModel) bang3.getModel();
            DSKM.setRowCount(0);
            String row[] = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                DSKM.addRow(row);
            }
            bang3.setModel(DSKM);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Xay ra loi");
        }
    }

    private void setListKH() {
        try {
            KhachHang kh = new KhachHang();
            ResultSet rs = kh.getListKH();
            DSKH = (DefaultTableModel) bang1.getModel();
            DSKH.setRowCount(0);
            String row[] = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                DSKH.addRow(row);
            }
            bang1.setModel(DSKH);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Xay ra loi");
        }
    }

    private void tinhTienKM() {
        if (phanTramKM > 100) {
            phanTramKM = 100;
        }
        float khuyenMai = tienKM + (TongTien * (phanTramKM / (float) 100));
        float TT = TongTien - khuyenMai;
        if (TT < 0) {
            TT = 0;
        }
        tongKhuyenMai.setText(String.valueOf(khuyenMai));
        thanhTien.setText(String.valueOf(TT));
    }

    private void addCTHD() {
        // add CTHD
        int countResult = 0;
        for (int i = 0; i < DSSPC.getRowCount(); i++) {
            try {
                int MSP = Integer.valueOf(DSSPC.getValueAt(i, 0).toString());
                int SL = Integer.valueOf(DSSPC.getValueAt(i, 3).toString());
                System.out.println("\n" + maHD + "    " + MSP + "   " + SL);
                HoaDon hd = new HoaDon();
                int check = hd.addCTHD(maHD, MSP, SL);
                countResult++;
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Xảy ra lỗi!");

            } catch (ClassNotFoundException cx) {

            }
        }
        System.out.println(countResult);
    }
private void guiHoaDon(){
            String body = "Xin chào khách hàng: " + tenKhachHang.getText() + "\n"
                + "Quý khách có 1 hóa đơn ở Cửa hàng đá quý ABC\n"
                + "Mã hóa đơn: " + maHoaDon.getText() + "\n"
                + "Tổng tiền:  " + tongTien.getText() + " VND\n"
                + "Giảm giá: " + tongKhuyenMai.getText() + " VND\n"
                + "Thành tiền: " + thanhTien.getText() +" VND\n"
                + "Chi tiết:\n===================================================\n";
        int countResult = 0;
        for (int i = 0; i < DSSPC.getRowCount(); i++) {
                body += "Tên sản phẩm: " + DSSPC.getValueAt(i, 1).toString() + ""
                        + " - " + DSSPC.getValueAt(i, 3).toString() + ""
                        + " (" + DSSPC.getValueAt(i, 4).toString() + "), "
                        + "Thành tiền: " + DSSPC.getValueAt(i, 6).toString() + " VND\n"
                        + "===================================================\n";
                countResult++;
        }
        GuiMail  gm = new GuiMail();
        try {
            gm.GuiHoaDon(email, body);
            JOptionPane.showMessageDialog(this, "Gửi thành công !!!");
        } catch (MessagingException ex) {
            Logger.getLogger(TaoHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        bang1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        bang2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bang3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tenKhachHang = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        tenKhuyenMai = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        ghiChu = new javax.swing.JFormattedTextField();
        abc = new javax.swing.JLabel();
        thanhToan = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        bang4 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tenSPC = new javax.swing.JFormattedTextField();
        maSPC = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        soLC = new javax.swing.JFormattedTextField();
        themVaoHoaDon = new javax.swing.JButton();
        chonLai = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tongTien = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tongKhuyenMai = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        thanhTien = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        huyHoaDon = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        maHoaDon = new javax.swing.JLabel();
        boKM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Mail"
            }
        ));
        bang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bang1);
        if (bang1.getColumnModel().getColumnCount() > 0) {
            bang1.getColumnModel().getColumn(2).setResizable(false);
        }

        bang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Loại Sản Phẩm", "Số Lượng", "Đơn Vị", "Đơn Giá"
            }
        ));
        bang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bang2);
        if (bang2.getColumnModel().getColumnCount() > 0) {
            bang2.getColumnModel().getColumn(0).setMinWidth(60);
            bang2.getColumnModel().getColumn(0).setPreferredWidth(60);
            bang2.getColumnModel().getColumn(0).setMaxWidth(60);
            bang2.getColumnModel().getColumn(1).setResizable(false);
            bang2.getColumnModel().getColumn(2).setMinWidth(200);
            bang2.getColumnModel().getColumn(2).setPreferredWidth(200);
            bang2.getColumnModel().getColumn(2).setMaxWidth(200);
            bang2.getColumnModel().getColumn(3).setMinWidth(60);
            bang2.getColumnModel().getColumn(3).setPreferredWidth(60);
            bang2.getColumnModel().getColumn(3).setMaxWidth(60);
            bang2.getColumnModel().getColumn(4).setMinWidth(60);
            bang2.getColumnModel().getColumn(4).setPreferredWidth(60);
            bang2.getColumnModel().getColumn(4).setMaxWidth(60);
            bang2.getColumnModel().getColumn(5).setMinWidth(120);
            bang2.getColumnModel().getColumn(5).setPreferredWidth(120);
            bang2.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        jLabel1.setText("Danh Sách Sản Phẩm");

        jLabel2.setText("Sản Phẩm Đã Chọn");

        bang3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Tỉ lệ Giảm", "Tiền Giảm"
            }
        ));
        bang3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(bang3);

        jLabel3.setText("Danh Sách Khách Hàng");

        jLabel4.setText("Danh Sách Khuyến Mãi");

        jLabel5.setText("Tên khách hàng");

        tenKhachHang.setEnabled(false);

        jLabel6.setText("Khuyến mãi");

        tenKhuyenMai.setEnabled(false);

        jLabel7.setText("Ghi chú");

        ghiChu.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        abc.setText("Tạo Hóa Đơn");

        thanhToan.setText("Thanh Toán");
        thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhToanActionPerformed(evt);
            }
        });

        bang4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Loại Sản Phẩm", "Số Lượng", "Đơn Vị", "Đơn Giá", "Thành Tiền"
            }
        ));
        bang4.setEnabled(false);
        jScrollPane5.setViewportView(bang4);
        if (bang4.getColumnModel().getColumnCount() > 0) {
            bang4.getColumnModel().getColumn(0).setMinWidth(60);
            bang4.getColumnModel().getColumn(0).setPreferredWidth(60);
            bang4.getColumnModel().getColumn(0).setMaxWidth(60);
            bang4.getColumnModel().getColumn(1).setResizable(false);
            bang4.getColumnModel().getColumn(2).setMinWidth(200);
            bang4.getColumnModel().getColumn(2).setPreferredWidth(200);
            bang4.getColumnModel().getColumn(2).setMaxWidth(200);
            bang4.getColumnModel().getColumn(3).setMinWidth(60);
            bang4.getColumnModel().getColumn(3).setPreferredWidth(60);
            bang4.getColumnModel().getColumn(3).setMaxWidth(60);
            bang4.getColumnModel().getColumn(4).setMinWidth(60);
            bang4.getColumnModel().getColumn(4).setPreferredWidth(60);
            bang4.getColumnModel().getColumn(4).setMaxWidth(60);
            bang4.getColumnModel().getColumn(5).setMinWidth(120);
            bang4.getColumnModel().getColumn(5).setPreferredWidth(120);
            bang4.getColumnModel().getColumn(5).setMaxWidth(120);
            bang4.getColumnModel().getColumn(6).setMinWidth(120);
            bang4.getColumnModel().getColumn(6).setPreferredWidth(120);
            bang4.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        jLabel9.setText("Sản phẩm đang chọn");

        tenSPC.setEditable(false);

        maSPC.setEditable(false);

        jLabel10.setText("Số lượng");

        soLC.setText("1");
        soLC.setEnabled(false);

        themVaoHoaDon.setText("Thêm Vào Hóa Đơn");
        themVaoHoaDon.setEnabled(false);
        themVaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themVaoHoaDonActionPerformed(evt);
            }
        });

        chonLai.setText("Chọn Lại");
        chonLai.setEnabled(false);
        chonLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonLaiActionPerformed(evt);
            }
        });

        jLabel11.setText("Tổng Tiền");

        tongTien.setEditable(false);
        tongTien.setText("0");

        jLabel12.setText("VND");

        jLabel13.setText("Khuyến Mãi");

        tongKhuyenMai.setEditable(false);
        tongKhuyenMai.setText("0");

        jLabel14.setText("Thành Tiền");

        thanhTien.setEditable(false);
        thanhTien.setText("0");

        jLabel15.setText("VND");

        jLabel16.setText("VND");

        huyHoaDon.setText("Hủy Hóa Đơn");
        huyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyHoaDonActionPerformed(evt);
            }
        });

        jLabel17.setText("Mã hóa đơn");

        maHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maHoaDon.setForeground(new java.awt.Color(255, 51, 51));
        maHoaDon.setText("0");

        boKM.setText("Bỏ KM");
        boKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(639, 639, 639)
                .addComponent(abc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(69, 69, 69)
                .addComponent(chonLai)
                .addGap(560, 560, 560))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ghiChu)
                                            .addComponent(tenKhuyenMai)
                                            .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boKM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(32, 32, 32)
                                                        .addComponent(thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(thanhToan)
                                                            .addComponent(huyHoaDon)))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel13))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tongKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(110, 110, 110))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maHoaDon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(352, 352, 352)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(themVaoHoaDon)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(soLC, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(maSPC))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tenSPC, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(45, 45, 45)
                                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel3)
                        .addGap(403, 403, 403)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(118, 118, 118)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(abc)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(maHoaDon))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(tenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boKM))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(ghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chonLai, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(tongKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))
                                        .addGap(53, 53, 53)
                                        .addComponent(thanhToan)
                                        .addGap(18, 18, 18)
                                        .addComponent(huyHoaDon))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tenSPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maSPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soLC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(themVaoHoaDon)
                .addGap(153, 153, 153))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang1MouseClicked
        // TODO add your handling code here:
        int Index = bang1.getSelectedRow();
        if (Index < DSKH.getRowCount() && Index >= 0) {
            maKH = Integer.valueOf(DSKH.getValueAt(Index, 0).toString());
            tenKhachHang.setText(DSKH.getValueAt(Index, 1).toString());
            email = DSKH.getValueAt(Index, 2).toString();
            System.out.println(maKH);
        }
    }//GEN-LAST:event_bang1MouseClicked

    private void bang3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang3MouseClicked
        // TODO add your handling code here:
        int Index = bang3.getSelectedRow();
        if (Index < DSKM.getRowCount() && Index >= 0) {
            maKM = Integer.valueOf(DSKM.getValueAt(Index, 0).toString());
            tenKhuyenMai.setText(DSKM.getValueAt(Index, 1).toString());
            phanTramKM = Integer.valueOf(DSKM.getValueAt(Index, 2).toString());
            tienKM = Integer.valueOf(DSKM.getValueAt(Index, 3).toString());
            tinhTienKM();
        }
    }//GEN-LAST:event_bang3MouseClicked

    private void bang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang2MouseClicked
        // TODO add your handling code here:
        soLC.setEnabled(true);
        themVaoHoaDon.setEnabled(true);
        int indexTB = bang2.getSelectedRow();
        if (indexTB < DSSP.getRowCount() && indexTB >= 0) {
            String row[] = new String[2];
            row[0] = DSSP.getValueAt(indexTB, 0).toString();;
            row[1] = DSSP.getValueAt(indexTB, 1).toString();
            maSPC.setValue(row[0]);
            tenSPC.setValue(row[1]);
            SPDC[0] = DSSP.getValueAt(bang2.getSelectedRow(), 0).toString();
            SPDC[1] = DSSP.getValueAt(bang2.getSelectedRow(), 1).toString();
            SPDC[2] = DSSP.getValueAt(bang2.getSelectedRow(), 2).toString();
            SPDC[3] = DSSP.getValueAt(bang2.getSelectedRow(), 3).toString();
            SPDC[4] = DSSP.getValueAt(bang2.getSelectedRow(), 4).toString();
            SPDC[5] = DSSP.getValueAt(bang2.getSelectedRow(), 5).toString();
//        int temp = Integer.parseInt(soL) * Integer.parseInt(donG);
//        SPDC[6] = String.valueOf(temp);
        }
//        DefaultTableModel tableModelChuyen, tableModelNhan = new DefaultTableModel();
//        tableModelChuyen = (DefaultTableModel) bang2.getModel();
//        String maSP = tableModelChuyen.getValueAt(bang2.getSelectedRow(), 0).toString();
//        String tenSP = tableModelChuyen.getValueAt(bang2.getSelectedRow(), 1).toString();
//        String loaiSP = tableModelChuyen.getValueAt(bang2.getSelectedRow(), 2).toString();
//        String soL = "1";
//        String donV = tableModelChuyen.getValueAt(bang2.getSelectedRow(), 4).toString();
//        String donG = tableModelChuyen.getValueAt(bang2.getSelectedRow(), 5).toString();
//        int temp = Integer.parseInt(soL) * Integer.parseInt(donG);
//        String thanhT = String.valueOf(temp);
//
//        tableModelNhan = (DefaultTableModel) bang4.getModel();
//        tableModelNhan.addRow(new Object[]{maSP, tenSP, loaiSP, soL, donV, donG, thanhT});
//        int indexTB = bang2.getSelectedRow();
//        if (indexTB < DSSP.getRowCount() && indexTB >= 0) {
//            DSSP.removeRow(indexTB);
//        }

    }//GEN-LAST:event_bang2MouseClicked

    private void themVaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themVaoHoaDonActionPerformed
        // TODO add your handling code here:
        if (soLC.getText().equals("") || soLC.getText().equals(" ") || soLC.getText().equals("  ")) {
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống !!!");
            return;
        }
        String tempSS = soLC.getText();
        int a = Integer.parseInt(SPDC[3]), b = Integer.parseInt(tempSS);
        if (b > a) {
            JOptionPane.showMessageDialog(this, "Không đủ hàng để bán !!!");
            return;
        }
        SPDC[3] = soLC.getText();
        int temp = Integer.parseInt(SPDC[3]) * Integer.parseInt(SPDC[5]);
        TongTien += temp;
        tongTien.setText(String.valueOf(TongTien));
        SPDC[6] = String.valueOf(temp);
        DSSPC = (DefaultTableModel) bang4.getModel();
        DSSPC.addRow(new Object[]{SPDC[0], SPDC[1], SPDC[2], SPDC[3], SPDC[4], SPDC[5], SPDC[6]});
        int indexTB = bang2.getSelectedRow();
        themVaoHoaDon.setEnabled(false);
        if (indexTB < DSSP.getRowCount() && indexTB >= 0) {
            DSSP.removeRow(indexTB);
        }
        tinhTienKM();
        soLC.setText("1");
        chonLai.setEnabled(true);
    }//GEN-LAST:event_themVaoHoaDonActionPerformed

    private void chonLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonLaiActionPerformed
        // TODO add your handling code here:
        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn chọn lại", "Chọn lại", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }
        DSSPC.setRowCount(0);
        DSSP.setRowCount(0);
        setListSP();
        tongTien.setText("0");
        tongKhuyenMai.setText("0");
        thanhTien.setText("0");
    }//GEN-LAST:event_chonLaiActionPerformed

    private void thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhToanActionPerformed
        // TODO add your handling code here:
        //update hoa don
        System.out.print(maKM);
        String tongT = tongTien.getText();
        String tongKM = tongKhuyenMai.getText();
        String thanhT = thanhTien.getText();
        String ghiC = ghiChu.getText();
        String tenKH = tenKhachHang.getText();
        if (tenKH.equals("")) {
            JOptionPane.showMessageDialog(this, "Chọn khách hàng !!!");
            return;
        }
        int ret = 0;
        ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Thanh Toán ?", "Thanh Toán", JOptionPane.YES_NO_OPTION);
        if (!(ret == JOptionPane.YES_OPTION)) {
            return;
        }
        try {
            HoaDon hd = new HoaDon();
            int check = hd.updateHD(maHD, maKH, maKM, tongT, tongKM, thanhT, ghiC);
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Thanh toán thành thất bại !!!");
                return;
            }
            JOptionPane.showMessageDialog(this, "Thanh toán thành công !!!");
            addCTHD();
            guiHoaDon();
            this.dispose();
            QuanLyHoaDon.main(null);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành thất bại  !!!");
        }


    }//GEN-LAST:event_thanhToanActionPerformed

    private void boKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boKMActionPerformed
        // TODO add your handling code here:
        maKM = -1;
        tenKhuyenMai.setText("");
        phanTramKM = 0;
        tienKM = 0;
        tinhTienKM();
    }//GEN-LAST:event_boKMActionPerformed

    private void huyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyHoaDonActionPerformed
        // TODO add your handling code here:
        try {

            HoaDon hd = new HoaDon();
            int rs = hd.remoteHD(maHD);
            setListKM();
            JOptionPane.showMessageDialog(this, "Xóa thành công !!!");
            this.dispose();
            QuanLyHoaDon.main(null);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại !!!");
        }
    }//GEN-LAST:event_huyHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(TaoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abc;
    private javax.swing.JTable bang1;
    private javax.swing.JTable bang2;
    private javax.swing.JTable bang3;
    private javax.swing.JTable bang4;
    private javax.swing.JButton boKM;
    private javax.swing.JButton chonLai;
    private javax.swing.JFormattedTextField ghiChu;
    private javax.swing.JButton huyHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel maHoaDon;
    private javax.swing.JFormattedTextField maSPC;
    private javax.swing.JFormattedTextField soLC;
    private javax.swing.JFormattedTextField tenKhachHang;
    private javax.swing.JFormattedTextField tenKhuyenMai;
    private javax.swing.JFormattedTextField tenSPC;
    private javax.swing.JFormattedTextField thanhTien;
    private javax.swing.JButton thanhToan;
    private javax.swing.JButton themVaoHoaDon;
    private javax.swing.JFormattedTextField tongKhuyenMai;
    private javax.swing.JFormattedTextField tongTien;
    // End of variables declaration//GEN-END:variables
}
