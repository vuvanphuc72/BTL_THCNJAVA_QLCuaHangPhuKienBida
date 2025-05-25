
package Form;

import java.util.Date;
import Model.Connector;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class QLNhanVien extends javax.swing.JFrame {

    
    
    private JFrame fQL;

    public QLNhanVien() {
        initComponents();
        setColor();
        setCoLorForTB();
        setResizable(false); // Cấm resize
        loadNhanVien();
    }
    
    public void setCoLorForTB(){
        cbTimKiemNhanVien.setRenderer(new DefaultListCellRenderer() {
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
        
        JTableHeader header = tbNhanVien.getTableHeader();
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
        
        cbTimKiemNhanVien.setBackground(new Color(0, 139, 139)); // màu nền dropdown
        cbTimKiemNhanVien.setForeground(Color.black); // màu chữ dropdown

    }
    
    public void setColor(){
        tfHoTenNV.setBackground(new Color(245,255,245));
        tfSDTNV.setBackground(new Color(245,255,245));
        tfEmailNV.setBackground(new Color(245,255,245));
        tfMatKhau.setBackground(new Color(245,255,245));
        tfTimKiemNhanVien.setBackground(new Color(245,255,245));
        spdNgayTuyenDung.getEditor().setBackground(new Color(245,255,245));
        
        btThemNV.setBackground(new Color(102,205,170));
        btThemNV.setForeground(Color.black);
        btXoaNV.setBackground(new Color(102,205,170));
        btXoaNV.setForeground(Color.black);
        btSuaNV.setBackground(new Color(102,205,170));
        btSuaNV.setForeground(Color.black);
        btTimKiemNV.setBackground(new Color(102,205,170));
        btTimKiemNV.setForeground(Color.black);
        cbTimKiemNhanVien.setBackground(new Color(176,224,230));
        cbTimKiemNhanVien.setForeground(Color.black);
        
        jPanel1.setBackground(new Color(240,255,240));
        jPanel1.setForeground(Color.BLACK);
        
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);
        
        tbNhanVien.setBackground(new Color(240,255,240));
        tbNhanVien.setForeground(Color.BLACK);
        
        tbNhanVien.getTableHeader().setBackground(new Color(0,139,139)); // Xanh dương
        tbNhanVien.getTableHeader().setForeground(Color.white); // Chữ trắng
        
        tbNhanVien.setRowHeight(25);
    }
    
    public QLNhanVien(JFrame fQL) {
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
        loadNhanVien();
        
    }
    
    public void loadNhanVien(){
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        try {
            Connector pt = new Connector();
            ResultSet rs = pt.getData("nhanvien");
            int dem = 0;
            while(rs.next()){
                tbNhanVien.setValueAt(rs.getString("MaNhanVien"), dem, 0);
                tbNhanVien.setValueAt(rs.getString("HoTen"), dem, 1);
                tbNhanVien.setValueAt(rs.getString("SoDienThoai"), dem, 2);
                tbNhanVien.setValueAt(rs.getString("Email"), dem, 3);
                tbNhanVien.setValueAt(rs.getString("NgayTuyenDung"), dem, 4);
                tbNhanVien.setValueAt(rs.getString("matkhau"), dem, 5);
                dem++;
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btTimKiem = new javax.swing.JButton();
        tfHoTen = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfTimKiem = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tfHoTenNV = new javax.swing.JTextField();
        cbTimKiemNhanVien = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        tfTimKiemNhanVien = new javax.swing.JTextField();
        tfSDTNV = new javax.swing.JTextField();
        btThemNV = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btSuaNV = new javax.swing.JButton();
        tfEmailNV = new javax.swing.JTextField();
        spdNgayTuyenDung = new javax.swing.JSpinner();
        btXoaNV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btTimKiemNV = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tfMatKhau = new javax.swing.JTextField();

        jLabel5.setText("Địa chỉ");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Số điện thoại", "Email", "Địa chỉ"
            }
        ));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        btThem.setText("Thêm");

        btSua.setText("Sửa");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        btXoa.setText("Xoá");

        jLabel2.setText("Họ tên");

        btTimKiem.setText("Tìm kiêm theo");

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại" }));

        jLabel3.setText("Số điện thoại");

        jLabel4.setText("Email");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(40, 133, 81));
        jLabel7.setText("QUẢN LÝ NHÂN VIÊN");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfHoTenNV.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfHoTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 18, 480, -1));

        cbTimKiemNhanVien.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbTimKiemNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên NV", "SDT", "Email" }));
        jPanel1.add(cbTimKiemNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 65, 172, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Ngày tuyển dụng");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 124, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Số điện thoại (TK)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tbNhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Số điện thoại", "Email", "Ngày tuyển dụng", "Mật khẩu"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNhanVien);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 179, 998, 290));

        tfTimKiemNhanVien.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfTimKiemNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 172, 30));

        tfSDTNV.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfSDTNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 60, 480, -1));

        btThemNV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/importt.png"))); // NOI18N
        btThemNV.setText("Thêm");
        btThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNVActionPerformed(evt);
            }
        });
        jPanel1.add(btThemNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 12, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Email");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 124, -1));

        btSuaNV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/edit.png"))); // NOI18N
        btSuaNV.setText("Sửa");
        btSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaNVActionPerformed(evt);
            }
        });
        jPanel1.add(btSuaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 12, 102, -1));

        tfEmailNV.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfEmailNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 100, 480, -1));

        spdNgayTuyenDung.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spdNgayTuyenDung.setModel(new javax.swing.SpinnerDateModel());
        spdNgayTuyenDung.setEditor(new javax.swing.JSpinner.DateEditor(spdNgayTuyenDung, "yyyy-MM-dd"));
        jPanel1.add(spdNgayTuyenDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 163, -1));

        btXoaNV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/delete.png"))); // NOI18N
        btXoaNV.setText("Xoá");
        btXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaNVActionPerformed(evt);
            }
        });
        jPanel1.add(btXoaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 12, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Họ tên");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 20, 124, -1));

        btTimKiemNV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btTimKiemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/search.png"))); // NOI18N
        btTimKiemNV.setText("Tìm kiếm theo");
        btTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemNVActionPerformed(evt);
            }
        });
        jPanel1.add(btTimKiemNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 64, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Mật khẩu");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 71, -1));

        tfMatKhau.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        int i = tbKhachHang.getSelectedRow();
        if (i == -1) return;
        if(tbKhachHang.getValueAt(i,0) != null && !tbKhachHang.getValueAt(i,0).toString().equals("")){
            tfHoTenNV.setText(tbKhachHang.getValueAt(i, 1).toString());
            tfSDTNV.setText(tbKhachHang.getValueAt(i, 2).toString());
            tfEmailNV.setText(tbKhachHang.getValueAt(i, 3).toString());
        }else{
            clearTF();
        }
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemNVActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        String ma = "1";
        if (cbTimKiemNhanVien.getSelectedIndex() == 0){
            ma = "HoTen LIKE '%" + tfTimKiemNhanVien.getText() + "%'";
        }
        else if(cbTimKiemNhanVien.getSelectedIndex() == 1){
            ma = "SoDienThoai LIKE '%" + tfTimKiemNhanVien.getText() + "%'";
        }
        else{
            ma = "Email LIKE '%" + tfTimKiemNhanVien.getText() + "%'";
        }

        try {
            Connector pt = new Connector();
            ResultSet rs = null;
            if(tfTimKiemNhanVien.getText().equals("")){
                rs = pt.getData("nhanvien");
            }
            else{
                //                JOptionPane.showMessageDialog(null, ma);
                rs = pt.getDataBySQL("select * from nhanvien where " + ma);
            }
            int dem = 0;
            while(rs.next()){
                tbNhanVien.setValueAt(rs.getString("MaNhanVien"), dem, 0);
                tbNhanVien.setValueAt(rs.getString("HoTen"), dem, 1);
                tbNhanVien.setValueAt(rs.getString("SoDienThoai"), dem, 2);
                tbNhanVien.setValueAt(rs.getString("Email"), dem, 3);
                tbNhanVien.setValueAt(rs.getString("NgayTuyenDung"), dem, 4);
                tbNhanVien.setValueAt(rs.getString("matkhau"), dem, 5);
                dem++;
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTimKiemNVActionPerformed

    private void btSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaNVActionPerformed
        String hoTen = tfHoTenNV.getText();
        String sdt = tfSDTNV.getText();
        String email = tfEmailNV.getText();
        String mk = tfMatKhau.getText();

        if(hoTen.isEmpty()|| hoTen.equals("") || sdt.isEmpty() || sdt.equals("") ||
                email.isEmpty()|| email.equals("") || mk.isEmpty() || mk.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        
        Object value = spdNgayTuyenDung.getValue();
        java.util.Date utilDate = (Date) value;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String ngayDat = sqlDate.toString();

        try {
            Connector pt = new Connector();
            int i = tbNhanVien.getSelectedRow();
            if(tbNhanVien.getValueAt(i,0) != null && !tbNhanVien.getValueAt(i,0).toString().equals("")){
                String sdtTruoc = tbNhanVien.getValueAt(i, 2).toString();
                int maNV = -1;
                String sqlNV = "SELECT MaNhanVien FROM nhanvien WHERE SoDienThoai = '"+sdtTruoc+"';";
                ResultSet rs = pt.getDataBySQL(sqlNV);
                while(rs.next()){
                    maNV = Integer.parseInt(rs.getString("MaNhanVien"));
                }
                if(maNV != -1){
                    String sql = "UPDATE `nhanvien` SET `HoTen`='"+hoTen+"',`SoDienThoai`='"+sdt+"',`Email`='"+email+"',`NgayTuyenDung`='"+ngayDat+"', `matkhau`='"+mk+"' WHERE `MaNhanVien`= "+maNV+"";
                    pt.updateQuery(sql);
                    JOptionPane.showMessageDialog(null, "Sửa nhân viên thành công!");
                    loadNhanVien();
                }else{
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa thông tin!");
                }
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSuaNVActionPerformed

    private void btThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNVActionPerformed
        String hoTen = tfHoTenNV.getText();
        String sdt = tfSDTNV.getText();
        String email = tfHoTenNV.getText();
        String mk = tfMatKhau.getText();

        if(hoTen.isEmpty()|| hoTen.equals("") || sdt.isEmpty() || sdt.equals("") ||
                email.isEmpty()|| email.equals("") || mk.isEmpty() || mk.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        
        Object value = spdNgayTuyenDung.getValue();
        java.util.Date utilDate = (Date) value;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String ngayDat = sqlDate.toString();

        try {
            Connector pt = new Connector();
            int maNV = -1;
            String sqlNV = "SELECT MaNhanVien FROM NhanVien WHERE SoDienThoai = '"+sdt+"';";
            ResultSet rs = pt.getDataBySQL(sqlNV);
            while(rs.next()){
                maNV = Integer.parseInt(rs.getString("MaNhanVien"));
            }
            if(maNV != -1){
                JOptionPane.showMessageDialog(null, "Nhân viên với sdt này đã tồn tại!");
                return;
            }
            String sql = "INSERT INTO `nhanvien`(`HoTen`, `SoDienThoai`, `Email`, `NgayTuyenDung`, `matkhau`) VALUES ('"+hoTen+"','"+sdt+"','"+email+"','"+ngayDat+"','"+mk+"')";
            pt.updateQuery(sql);
            JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
            loadNhanVien();
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btThemNVActionPerformed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        int i = tbNhanVien.getSelectedRow();
        if (i == -1) return;
        if(tbNhanVien.getValueAt(i,0) != null && !tbNhanVien.getValueAt(i,0).toString().equals("")){
            tfHoTenNV.setText(tbNhanVien.getValueAt(i, 1).toString());
            tfSDTNV.setText(tbNhanVien.getValueAt(i, 2).toString());
            tfEmailNV.setText(tbNhanVien.getValueAt(i, 3).toString());
            tfMatKhau.setText(tbNhanVien.getValueAt(i, 5).toString());
            String ngayDat = tbNhanVien.getValueAt(i, 4).toString();

            SpinnerDateModel model = new SpinnerDateModel();
            spdNgayTuyenDung.setModel(model);
            JSpinner.DateEditor edit = new JSpinner.DateEditor(spdNgayTuyenDung, "yyyy-MM-dd");
            spdNgayTuyenDung.setEditor(edit);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate;
            try {
                utilDate = sdf.parse(ngayDat);
                spdNgayTuyenDung.setValue(utilDate);
            } catch (ParseException ex) {
                Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            clearTF();
        }
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaNVActionPerformed
        String SDT = tfSDTNV.getText();
        if(SDT.isEmpty() || SDT.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn/nhập nhân viên cần xoá!");
            return;
        }
        
        try {
            Connector pt = new Connector();
            String sql = "Select * from nhanvien where SoDienThoai = '"+SDT+"'";
            ResultSet rs = pt.getDataBySQL(sql);
            String ten = "";
            while(rs.next()){
                ten = rs.getString("HoTen");
            }
            
            if(ten.isEmpty() || ten.equals("")){
                JOptionPane.showMessageDialog(null, "Nhân viên với SDT '"+SDT+"' không tồn tại!");
                return;
            }
            
            int c = JOptionPane.showConfirmDialog(null, "Xoá nhân viên '" +ten+ "' sẽ xoá hết các hoá đơn liên quan!\nBạn vẫn muốn thực hiện?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(c != JOptionPane.YES_OPTION)
                return;
            
            String sqlXoa = "DELETE FROM `nhanvien` WHERE SoDienThoai = '"+SDT+"'";
            pt.updateQuery(sqlXoa);
            loadNhanVien();
            JOptionPane.showMessageDialog(null, "Đã xoá nhân viên '"+ten+"'");
            if(pt != null)pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btXoaNVActionPerformed

    public void clearTF(){
        tfHoTenNV.setText("");
        tfSDTNV.setText("");
        tfEmailNV.setText("");
        tfMatKhau.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btSuaNV;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThemNV;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btTimKiemNV;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXoaNV;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JComboBox<String> cbTimKiemNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spdNgayTuyenDung;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmailNV;
    private javax.swing.JTextField tfHoTen;
    private javax.swing.JTextField tfHoTenNV;
    private javax.swing.JTextField tfMatKhau;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfSDTNV;
    private javax.swing.JTextField tfTimKiem;
    private javax.swing.JTextField tfTimKiemNhanVien;
    // End of variables declaration//GEN-END:variables
}
