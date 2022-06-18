/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Process.GuiMail;
import Process.GuiMailHTML;
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
private void guiHoaDonHTML(){
            String body = "<div  style='text-align:center;'> <img style='width:75%;height:50%;' src='https://www.marry.vn/wp-content/uploads/2016/04/29/hinh-dang-kim-cuong.jpg' alt='Italian Trulli'> <h1 style='color:red;'>Hóa Đơn Mua Hàng</h1> <p>Xin chào khách hàng: <b>" 
                    + tenKhachHang.getText() 
                    + "</b> </p> <p>Bạn đã mua hàng tại Cửa hàng Đá quý ABC lúc: "
                    + java.time.LocalDate.now() + " " +java.time.LocalTime.now() 
                    + "</p> <h2>Mã hóa đơn: <b style='color:blue;'>" 
                    + maHoaDon.getText() 
                    + "</b></h2> <table style='  font-family: arial, sans-serif; border-collapse: collapse; width: 100%;'> <tbody> <tr style='background-color: #D6EEEE;'> <td><b>Tên sản phẩm</b></td> <td><b>Số lượng</b></td> <td><b>Đơn vị</b></td> <td><b>Đơn giá</b></td> </tr> ";
        boolean check = true;
        for (int i = 0; i < DSSPC.getRowCount(); i++) {
                if(check){
                body += "<tr> <td>" 
                        + DSSPC.getValueAt(i, 1).toString() 
                        + "</td> <td>"
                        + DSSPC.getValueAt(i, 3).toString() 
                        + "</td> <td>"
                        + DSSPC.getValueAt(i, 4).toString() 
                        + "</td> <td>"
                        + DSSPC.getValueAt(i, 6).toString() 
                        + "</td> </tr>";
                check = false;
                }
                else{
                body += "<tr style='background-color: #D6EEEE;'> <td>" 
                        + DSSPC.getValueAt(i, 1).toString() 
                        + "</td> <td>"
                        + DSSPC.getValueAt(i, 3).toString() 
                        + "</td> <td>"
                        + DSSPC.getValueAt(i, 4).toString() 
                        + "</td> <td>"
                        + DSSPC.getValueAt(i, 6).toString() 
                        + "</td> </tr>";
                check = true;
                }

        }
         body += "</tbody> </table> <h2>Tổng tiền: "
                 + tongTien.getText()
                 + " VND </h2> <h2>Tổng tiền giảm giá: "
                 + tongKhuyenMai.getText()
                 +" VND</h2> <h2 style='color:red;'>Thành tiền: "
                 + thanhTien.getText()
                 +" VND</h2> <a href='https://www.cuahangdaquy.com/'>Cửa Hàng Đá Quý ABC</a> <a href='mailto:cuahangdaquy@abc.com'>cuahangdaquy@abc.com</a> </div>";
        GuiMailHTML  gm = new GuiMailHTML();
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
        jSlider1 = new javax.swing.JSlider(1, 10, 1);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Danh Sách Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Danh Sách Khách Hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Danh Sách Khuyến Mãi");

        jLabel5.setText("Tên khách hàng");

        tenKhachHang.setEditable(false);

        jLabel6.setText("Khuyến mãi");

        tenKhuyenMai.setEditable(false);

        jLabel7.setText("Ghi chú");

        ghiChu.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        abc.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        abc.setForeground(new java.awt.Color(255, 0, 51));
        abc.setText("Tạo Hóa Đơn");

        thanhToan.setBackground(new java.awt.Color(51, 51, 255));
        thanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        thanhToan.setForeground(new java.awt.Color(255, 255, 255));
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

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        soLC.setText("1");
        soLC.setEnabled(false);

        themVaoHoaDon.setBackground(new java.awt.Color(0, 255, 0));
        themVaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themVaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        themVaoHoaDon.setText("Thêm Vào Hóa Đơn");
        themVaoHoaDon.setEnabled(false);
        themVaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themVaoHoaDonActionPerformed(evt);
            }
        });

        chonLai.setBackground(new java.awt.Color(255, 102, 102));
        chonLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chonLai.setForeground(new java.awt.Color(255, 255, 255));
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

        huyHoaDon.setBackground(new java.awt.Color(255, 0, 0));
        huyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        huyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
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

        boKM.setBackground(new java.awt.Color(255, 204, 204));
        boKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boKM.setForeground(new java.awt.Color(0, 0, 0));
        boKM.setText("Bỏ KM");
        boKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boKMActionPerformed(evt);
            }
        });

        jLabel8.setText("1");

        jLabel18.setText("10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maHoaDon)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ghiChu)
                                    .addComponent(tenKhuyenMai)
                                    .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boKM)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(chonLai)
                                .addGap(249, 249, 249))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(32, 32, 32)
                                        .addComponent(thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel13))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tongKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(592, 592, 592)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(thanhToan)
                                    .addGap(11, 11, 11))
                                .addComponent(huyHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(633, 633, 633)
                        .addComponent(abc)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(659, 659, 659)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(soLC)
                            .addComponent(maSPC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenSPC, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(173, 173, 173)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(860, 860, 860)
                        .addComponent(themVaoHoaDon)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(abc)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
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
                                            .addComponent(ghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addGap(34, 34, 34)
                                        .addComponent(thanhToan)
                                        .addGap(26, 26, 26)
                                        .addComponent(huyHoaDon)
                                        .addGap(66, 66, 66))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(chonLai))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(themVaoHoaDon)
                .addGap(154, 154, 154))
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
            guiHoaDonHTML();
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

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        System.out.println( jSlider1.getValue());
        soLC.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
