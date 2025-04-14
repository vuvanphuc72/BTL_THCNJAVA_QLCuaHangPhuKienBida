
package Form;

import Model.Connector;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        btThemNV = new javax.swing.JButton();
        btSuaNV = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btXoaNV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btTimKiemNV = new javax.swing.JButton();
        tfHoTenNV = new javax.swing.JTextField();
        cbTimKiemNhanVien = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfTimKiemNhanVien = new javax.swing.JTextField();
        tfSDTNV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEmailNV = new javax.swing.JTextField();
        spdNgayTuyenDung = new javax.swing.JSpinner();

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

        jLabel6.setText("Ngày tuyển dụng");

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

        btSuaNV.setText("Sửa");

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setText("QUẢN LÝ NHÂN VIÊN");

        btXoaNV.setText("Xoá");

        jLabel8.setText("Họ tên");

        btTimKiemNV.setText("Tìm kiêm theo");

        cbTimKiemNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại" }));

        jLabel9.setText("Số điện thoại");

        jLabel10.setText("Email");

        spdNgayTuyenDung.setModel(new javax.swing.SpinnerDateModel());
        spdNgayTuyenDung.setEditor(new javax.swing.JSpinner.DateEditor(spdNgayTuyenDung, "yyyy-MM-dd"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfSDTNV)
                            .addComponent(tfEmailNV)
                            .addComponent(tfHoTenNV)
                            .addComponent(spdNgayTuyenDung))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btTimKiemNV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTimKiemNhanVien)
                                    .addComponent(cbTimKiemNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemNV)
                    .addComponent(btSuaNV)
                    .addComponent(btXoaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiemNV)
                    .addComponent(cbTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(tfTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(spdNgayTuyenDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    public void clearTF(){
        tfHoTenNV.setText("");
        tfSDTNV.setText("");
        tfEmailNV.setText("");
    }
    
    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        int i = tbNhanVien.getSelectedRow();
        if (i == -1) return;
        if(tbNhanVien.getValueAt(i,0) != null && !tbNhanVien.getValueAt(i,0).toString().equals("")){
            tfHoTenNV.setText(tbNhanVien.getValueAt(i, 1).toString());
            tfSDTNV.setText(tbNhanVien.getValueAt(i, 2).toString());
            tfEmailNV.setText(tbNhanVien.getValueAt(i, 3).toString());
            Object ngayDat = tbNhanVien.getValueAt(i, 4);
           if(ngayDat instanceof String){
//               try {
//                    String ngayStr = ((String) ngayDat).trim();
//                    String[] parts = ngayStr.split("-");
//                    if (parts.length == 3) {
//                        String year = parts[0];
//                        String month = (parts[1].length() == 1) ? "0" + parts[1] : parts[1];
//                        String day = (parts[2].length() == 1) ? "0" + parts[2] : parts[2];
//                        ngayStr = year + "-" + month + "-" + day;
//                    }
////
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    ngayDat = sdf.parse(ngayStr);
//                } catch (ParseException ex) {
//                    ex.printStackTrace();
//                return;
            }
            spdNgayTuyenDung.setValue(ngayDat);
        }else{
            clearTF();
        }
    }//GEN-LAST:event_tbNhanVienMouseClicked

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
