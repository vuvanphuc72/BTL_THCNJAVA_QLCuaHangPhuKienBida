
package Form;

import Model.Connector;
import Model.DonHangConnect;
import Model.NhapSo;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.text.AbstractDocument;

public class fQLDonHang extends javax.swing.JFrame {

    private JFrame fQL;
    public fQLDonHang() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        ((AbstractDocument) tfTimKiem.getDocument()).setDocumentFilter(new NhapSo());        
        loadTable();
        setColor();
        setCoLorForTB();
    }
    
    public fQLDonHang(JFrame fQL) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.fQL = fQL;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                fQL.setVisible(true);
        }
        });
        ((AbstractDocument) tfTimKiem.getDocument()).setDocumentFilter(new NhapSo());        
        loadTable();
    }
    
    private void exportTableToCSV(JTable table, File file) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
             BufferedWriter bw = new BufferedWriter(writer)) {

            // Ghi BOM để Excel nhận biết UTF-8
            bw.write('\uFEFF');

            // Ghi tên cột
            TableModel model = table.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                bw.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) bw.write(",");
            }
            bw.newLine();

            // Ghi dữ liệu
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Object value = model.getValueAt(i, j);
                    bw.write(value != null ? value.toString() : "");
                    if (j < model.getColumnCount() - 1) bw.write(",");
                }
                bw.newLine();
            }

            bw.flush();
            JOptionPane.showMessageDialog(null, "Xuất file CSV thành công!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất CSV: " + e.getMessage());
        }
    }


    
    
    public void setCoLorForTB(){
        cbTimKiem.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setBackground(new Color(240,255,240)); // màu nền
            label.setForeground(Color.black); // màu chữ
            label.setOpaque(true);
            return label;
        }
        });
        
        JTableHeader header = tbDonHang.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
            label.setBackground(new Color(0, 139, 139));
            label.setForeground(Color.WHITE);
            label.setOpaque(true);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            return label;
        }
        });
        
        JTableHeader header2 = tbChiTietDonHang.getTableHeader();
        header2.setDefaultRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
            label.setBackground(new Color(0, 139, 139));
            label.setForeground(Color.WHITE);
            label.setOpaque(true);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            return label;
        }
        });
        
        cbTimKiem.setBackground(new Color(0, 139, 139)); // màu nền dropdown
        cbTimKiem.setForeground(Color.black); // màu chữ dropdown

    }
    
    public void setColor(){
        tfMaDonHang.setBackground(new Color(245,255,245));
        tfMaKhachHang.setBackground(new Color(245,255,245));
        tfTimKiem.setBackground(new Color(245,255,245));
        tfMaNhanVien.setBackground(new Color(245,255,245));
        tfTongTien.setBackground(new Color(245,255,245));
        
        btTaoDon.setBackground(new Color(102,205,170));
        btTaoDon.setForeground(Color.black);
        btXoaDon.setBackground(new Color(102,205,170));
        btXoaDon.setForeground(Color.black);
        btTimKiem.setBackground(new Color(102,205,170));
        btTimKiem.setForeground(Color.black);
        cbTimKiem.setBackground(new Color(176,224,230));
        cbTimKiem.setForeground(Color.black);
        
        jPanel2.setBackground(new Color(240,255,240));
        jPanel2.setForeground(Color.BLACK);
        
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);
        
        tbDonHang.setBackground(new Color(240,255,240));
        tbDonHang.setForeground(Color.BLACK);
        tbChiTietDonHang.setBackground(new Color(240,255,240));
        tbChiTietDonHang.setForeground(Color.BLACK);
        
        tbDonHang.getTableHeader().setBackground(new Color(0,139,139)); // Xanh dương
        tbDonHang.getTableHeader().setForeground(Color.white); // Chữ trắng
        
        tbDonHang.setRowHeight(25);
        
        tbChiTietDonHang.getTableHeader().setBackground(new Color(0,139,139)); // Xanh dương
        tbChiTietDonHang.getTableHeader().setForeground(Color.white); // Chữ trắng
        
        jLabel8.setForeground(new Color(40,133,81));
    }
    
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) tbDonHang.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        try {
            DonHangConnect pt = new DonHangConnect();
            ResultSet rs = pt.getData();
            int dem = 0;
            while(rs.next()){
                tbDonHang.setValueAt(rs.getString("MaHoaDon"), dem, 0);
                tbDonHang.setValueAt(rs.getString("MaKhachHang"), dem, 1);
                tbDonHang.setValueAt(rs.getString("MaNhanVien"), dem, 2);
                tbDonHang.setValueAt(rs.getString("NgayDatHang"), dem, 3);
                tbDonHang.setValueAt(rs.getString("TongTien"), dem, 4);
                dem++;
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        btTaoDon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfMaDonHang = new javax.swing.JTextField();
        tfMaKhachHang = new javax.swing.JTextField();
        tfMaNhanVien = new javax.swing.JTextField();
        tfTongTien = new javax.swing.JTextField();
        btXoaDon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbChiTietDonHang = new javax.swing.JTable();
        btTimKiem = new javax.swing.JButton();
        tfTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDonHang = new javax.swing.JTable();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spdNgayDat = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        btXuatHoaDon = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btTaoDon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btTaoDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/writing.png"))); // NOI18N
        btTaoDon.setText("Tạo hoá đơn");
        btTaoDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaoDonActionPerformed(evt);
            }
        });
        jPanel2.add(btTaoDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 12, 150, 38));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Mã hoá đơn");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, 118, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 60, 112, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Mã nhân viên tạo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 101, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Ngày đặt hàng");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 101, 112, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 143, 118, -1));

        tfMaDonHang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(tfMaDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 58, 112, -1));

        tfMaKhachHang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(tfMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 58, 122, -1));

        tfMaNhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(tfMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 99, 112, -1));

        tfTongTien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(tfTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 141, 382, -1));

        btXoaDon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btXoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/trash.png"))); // NOI18N
        btXoaDon.setText("Xoá hoá đơn");
        btXoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaDonActionPerformed(evt);
            }
        });
        jPanel2.add(btXoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 12, 150, 38));

        tbChiTietDonHang.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tbChiTietDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sản phẩm", "Giá", "Số lượng"
            }
        ));
        jScrollPane3.setViewportView(tbChiTietDonHang);
        if (tbChiTietDonHang.getColumnModel().getColumnCount() > 0) {
            tbChiTietDonHang.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbChiTietDonHang.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbChiTietDonHang.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 83, 470, 122));

        btTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/search.png"))); // NOI18N
        btTimKiem.setText("Tìm kiếm theo");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, 30));

        tfTimKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(tfTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 264, 30));

        tbDonHang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tbDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hoá đơn", "Mã khách hàng", "Mã nhân viên tạo đơn", "Ngày đặt hàng", "Tổng tiền"
            }
        ));
        tbDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDonHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDonHang);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 211, 1000, 260));

        cbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hoá đơn", "Mã nhân viên", "Mã khách hàng", " " }));
        jPanel2.add(cbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 170, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Danh sách sản phẩm của hoá đơn");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Danh sách hoá đơn");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 189, -1, -1));

        spdNgayDat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spdNgayDat.setModel(new javax.swing.SpinnerDateModel());
        spdNgayDat.setEditor(new javax.swing.JSpinner.DateEditor(spdNgayDat, "yyyy-MM-dd"));
        jPanel2.add(spdNgayDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 99, 122, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setText("QUẢN LÝ HOÁ ĐƠN");

        btXuatHoaDon.setBackground(new java.awt.Color(204, 204, 0));
        btXuatHoaDon.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btXuatHoaDon.setForeground(new java.awt.Color(0, 0, 0));
        btXuatHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/xuat.png"))); // NOI18N
        btXuatHoaDon.setText("XUẤT HOÁ ĐƠN");
        btXuatHoaDon.setIconTextGap(12);
        btXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(275, 275, 275)
                .addComponent(btXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(btXuatHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void hienThiCTDH(String maDonHang){
        
        DefaultTableModel model = (DefaultTableModel) tbChiTietDonHang.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        try {
            DonHangConnect pt = new DonHangConnect();
            ResultSet rs = pt.getDataCTDH(maDonHang);
            int i = 0;
            while(rs.next()){
                tbChiTietDonHang.setValueAt(rs.getString("TenSanPham"), i, 0);
                tbChiTietDonHang.setValueAt(rs.getString("SoLuong"), i, 2);
                tbChiTietDonHang.setValueAt(rs.getString("GiaTaiThoiDiem"), i, 1);
                i++;
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tbDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDonHangMouseClicked
        int i = tbDonHang.getSelectedRow();
        if(i == -1) return;
        if(tbDonHang.getValueAt(i,0) != null && !tbDonHang.getValueAt(i,0).toString().equals("")){
           tfMaDonHang.setText(tbDonHang.getValueAt(i, 0).toString());
           tfMaKhachHang.setText(tbDonHang.getValueAt(i, 1).toString());
           tfMaNhanVien.setText(tbDonHang.getValueAt(i, 2).toString());
           Object ngayDat = tbDonHang.getValueAt(i, 3);
           if(ngayDat instanceof String){
               try {
                    String ngayStr = ((String) ngayDat).trim();
                    String[] parts = ngayStr.split("-");
                    if (parts.length == 3) {
                        String year = parts[0];
                        String month = (parts[1].length() == 1) ? "0" + parts[1] : parts[1];
                        String day = (parts[2].length() == 1) ? "0" + parts[2] : parts[2];
                        ngayStr = year + "-" + month + "-" + day;
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ngayDat = sdf.parse(ngayStr);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                return;
            }
            spdNgayDat.setValue(ngayDat);
           }
           tfTongTien.setText(tbDonHang.getValueAt(i, 4).toString());
           String maDonHang = tbDonHang.getValueAt(tbDonHang.getSelectedRow(), 0).toString();
           hienThiCTDH(maDonHang);
        }
    }//GEN-LAST:event_tbDonHangMouseClicked

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbDonHang.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        String ma = "all";
        if (cbTimKiem.getSelectedIndex() == 0){
            ma = "MaHoaDon = " + tfTimKiem.getText(); 
        }
        else if(cbTimKiem.getSelectedIndex() == 1){
            ma = "MaNhanVien = " + tfTimKiem.getText(); 
        }
        else{
            ma = "MaKhachHang = " + tfTimKiem.getText();
        }

        try {
            DonHangConnect pt = new DonHangConnect();
            ResultSet rs = null;
            if(tfTimKiem.getText().equals("")){
                rs = pt.getData();                
            }
            else{
                rs = pt.getDataTK(ma);
            }
            
            int dem = 0;
            while(rs.next()){
                tbDonHang.setValueAt(rs.getString("MaHoaDon"), dem, 0);
                tbDonHang.setValueAt(rs.getString("MaKhachHang"), dem, 1);
                tbDonHang.setValueAt(rs.getString("MaNhanVien"), dem, 2);
                tbDonHang.setValueAt(rs.getString("NgayDatHang"), dem, 3);
                tbDonHang.setValueAt(rs.getString("TongTien"), dem, 4);
                dem++;
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btTaoDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaoDonActionPerformed
//        this.setVisible(false);
        fTaoDonHang fql = new fTaoDonHang();
        fql.setVisible(true);
        // Thêm sự kiện khi đóng cửa sổ
        fql.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                loadTable();
            }
        });
    }//GEN-LAST:event_btTaoDonActionPerformed

    private void btXoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaDonActionPerformed
        String maHD = tfMaDonHang.getText();
        if(maHD.isEmpty() || maHD.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã hoá đơn cần xoá!");
            return;
        }
        try {
            Connector pt = new Connector();
            String sql1 = "DELETE FROM `chitiethoadon` WHERE MaHoaDon = " +maHD;
            String sql2 = "DELETE FROM `hoadon` WHERE MaHoaDon = " +maHD;
            int c = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá hoá đơn " + maHD, "Cảnh báo" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(c != JOptionPane.YES_OPTION)
                return;
            pt.updateQuery(sql1);
            pt.updateQuery(sql2);
            
            JOptionPane.showMessageDialog(null, "Đã xoá hoá đơn " + maHD);
            loadTable();
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btXoaDonActionPerformed

    private void btXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXuatHoaDonActionPerformed
//        File file = new File("C:/Users/LENOVO/Desktop/nhanvien.csv"); 
//        exportTableToCSV(tbDonHang, file); 

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file CSV");

        // Gợi ý phần mở rộng .csv
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Đảm bảo file có đuôi .csv
            if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".csv");
            }

            exportTableToCSV(tbDonHang, fileToSave);
        }
    }//GEN-LAST:event_btXuatHoaDonActionPerformed

    public static void main(String args[]) {

        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fQLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fQLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fQLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fQLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fQLDonHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTaoDon;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoaDon;
    private javax.swing.JButton btXuatHoaDon;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spdNgayDat;
    private javax.swing.JTable tbChiTietDonHang;
    private javax.swing.JTable tbDonHang;
    private javax.swing.JTextField tfMaDonHang;
    private javax.swing.JTextField tfMaKhachHang;
    private javax.swing.JTextField tfMaNhanVien;
    private javax.swing.JTextField tfTimKiem;
    private javax.swing.JTextField tfTongTien;
    // End of variables declaration//GEN-END:variables
}
