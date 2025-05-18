
package Form;

import Model.Connector;
import Model.DonHangConnect;
import Model.NhapSo;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class fQLDonHang extends javax.swing.JFrame {

    private JFrame fQL;
    public fQLDonHang() {
        initComponents();
        this.setLocationRelativeTo(null);
        ((AbstractDocument) tfTimKiem.getDocument()).setDocumentFilter(new NhapSo());        
        loadTable();
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

        btTaoDon.setText("Tạo đơn hàng");
        btTaoDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaoDonActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã đơn hàng");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Mã nhân viên tạo");

        jLabel4.setText("Ngày đặt hàng");

        jLabel5.setText("Tổng tiền");

        btXoaDon.setText("Xoá đơn hàng");
        btXoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaDonActionPerformed(evt);
            }
        });

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

        btTimKiem.setText("Tìm kiếm theo");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        tbDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Mã khách hàng", "Mã nhân viên tạo đơn", "Ngày đặt hàng", "Tổng tiền"
            }
        ));
        tbDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDonHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDonHang);

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã đơn hàng", "Mã nhân viên", "Mã khách hàng", " " }));

        jLabel6.setText("Danh sách sản phẩm của đơn hàng");

        jLabel7.setText("Danh sách đơn hàng");

        spdNgayDat.setModel(new javax.swing.SpinnerDateModel());
        spdNgayDat.setEditor(new javax.swing.JSpinner.DateEditor(spdNgayDat, "yyyy-MM-dd"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfMaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfMaNhanVien, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfTongTien)
                                    .addComponent(tfMaDonHang)
                                    .addComponent(spdNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(97, 97, 97))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btTaoDon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btXoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btTimKiem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btTaoDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(btXoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btTimKiem)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfMaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(spdNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setText("QUẢN LÝ HOÁ ĐƠN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
