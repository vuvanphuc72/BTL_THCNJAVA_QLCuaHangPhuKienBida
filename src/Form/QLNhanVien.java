
package Form;

import java.util.Date;
import Model.Connector;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

public class QLNhanVien extends javax.swing.JFrame {

    private JFrame fQL;

    public QLNhanVien() {
        initComponents();
        loadNhanVien();
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
                dem++;
            }
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

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setText("QUẢN LÝ NHÂN VIÊN");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbTimKiemNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên nhân viên", "Số điện thoại", "Email" }));

        jLabel6.setText("Ngày tuyển dụng");

        jLabel9.setText("Số điện thoại");

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Số điện thoại", "Email", "Ngày tuyển dụng"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNhanVien);

        btThemNV.setText("Thêm");
        btThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNVActionPerformed(evt);
            }
        });

        jLabel10.setText("Email");

        btSuaNV.setText("Sửa");
        btSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaNVActionPerformed(evt);
            }
        });

        spdNgayTuyenDung.setModel(new javax.swing.SpinnerDateModel());
        spdNgayTuyenDung.setEditor(new javax.swing.JSpinner.DateEditor(spdNgayTuyenDung, "yyyy-MM-dd"));

        btXoaNV.setText("Xoá");

        jLabel8.setText("Họ tên");

        btTimKiemNV.setText("Tìm kiêm theo");
        btTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfSDTNV)
                            .addComponent(tfEmailNV)
                            .addComponent(spdNgayTuyenDung)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btTimKiemNV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTimKiemNhanVien)
                                    .addComponent(cbTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemNV)
                    .addComponent(btSuaNV)
                    .addComponent(btXoaNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiemNV)
                    .addComponent(cbTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(tfTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(spdNgayTuyenDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jLabel7)
                .addContainerGap(359, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                dem++;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTimKiemNVActionPerformed

    private void btSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaNVActionPerformed
        String hoTen = tfHoTenNV.getText();
        String sdt = tfSDTNV.getText();
        String email = tfHoTenNV.getText();

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
                    String sql = "UPDATE `nhanvien` SET `HoTen`='"+hoTen+"',`SoDienThoai`='"+sdt+"',`Email`='"+email+"',`NgayTuyenDung`='"+ngayDat+"' WHERE `MaNhanVien`= "+maNV+"";
                    pt.updateQuery(sql);
                    JOptionPane.showMessageDialog(null, "Sửa nhân viên thành công!");
                    loadNhanVien();
                }else{
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa thông tin!");
                }
            }
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
            String sql = "INSERT INTO `nhanvien`(`HoTen`, `SoDienThoai`, `Email`, `NgayTuyenDung`) VALUES ('"+hoTen+"','"+sdt+"','"+email+"','"+ngayDat+"')";
            pt.updateQuery(sql);
            JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
            loadNhanVien();
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

    public void clearTF(){
        tfHoTenNV.setText("");
        tfSDTNV.setText("");
        tfEmailNV.setText("");
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
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfSDTNV;
    private javax.swing.JTextField tfTimKiem;
    private javax.swing.JTextField tfTimKiemNhanVien;
    // End of variables declaration//GEN-END:variables
}
