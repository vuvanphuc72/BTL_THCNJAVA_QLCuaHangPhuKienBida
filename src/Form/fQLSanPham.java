
package Form;

import Model.Connector;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fQLSanPham extends javax.swing.JFrame {

    private JFrame fQL;
    
    public fQLSanPham() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadSanPham();
        loadLoaiSP();
    }
    
    public fQLSanPham(JFrame fQL) {
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
        loadSanPham();
        loadLoaiSP();
    }
    
    public void loadLoaiSP(){
        try {
            Connector pt = new Connector();
            cbLoaiSanPham.removeAllItems();
            ResultSet rs = pt.getData("loaisanpham");
            while(rs.next()){
                cbLoaiSanPham.addItem(rs.getString("TenLoaiSanPham"));
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void loadSanPham(){
        DefaultTableModel model = (DefaultTableModel) tbSanPham.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        try {
            Connector pt = new Connector();
            String sql = "SELECT sanpham.MaSanPham, sanpham.TenSanPham, sanpham.GiaDonVi, loaisanpham.TenLoaiSanPham FROM sanpham JOIN loaisanpham ON sanpham.MaLoaiSanPham = loaisanpham.MaLoaiSanPham;";
//            ResultSet rs = pt.getData("sanpham");
            ResultSet rs = pt.getDataBySQL(sql);
            int dem = 0;
            while(rs.next()){
                tbSanPham.setValueAt(rs.getString("MaSanPham"), dem, 0);
                tbSanPham.setValueAt(rs.getString("TenSanPham"), dem, 1);
                tbSanPham.setValueAt(rs.getString("GiaDonVi"), dem, 2);
                tbSanPham.setValueAt(rs.getString("TenLoaiSanPham"), dem, 3);
                dem++;
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void clearTF(){
        tfTenSanPham.setText("");
        tfGia.setText("");
        cbLoaiSanPham.setSelectedIndex(0);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTenSanPham = new javax.swing.JTextField();
        tfGia = new javax.swing.JTextField();
        cbLoaiSanPham = new javax.swing.JComboBox<>();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btTimKiem = new javax.swing.JButton();
        cbTimKiem = new javax.swing.JComboBox<>();
        tfTimKiem = new javax.swing.JTextField();
        btThemLSP = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        btXoaLSP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Loại sản phẩm"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setText("Quản lý sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Giá");

        jLabel5.setText("Loại sản phẩm");

        cbLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setText("Xoá");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btTimKiem.setText("Tìm kiếm theo");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên sản phẩm", "Loại sản phẩm" }));

        btThemLSP.setText("Thêm loại SP");

        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        btXoaLSP.setText("Xoá loại SP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTimKiem))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btThemLSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btXoaLSP))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(btThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btThem)
                    .addComponent(btSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btXoa)
                    .addComponent(btThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemLSP)
                    .addComponent(btXoaLSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btTimKiem)
                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int i = tbSanPham.getSelectedRow();
        if(tbSanPham.getValueAt(i,0) != null && !tbSanPham.getValueAt(i,0).toString().equals("")){
            tfTenSanPham.setText(tbSanPham.getValueAt(i, 1).toString());
            tfGia.setText(tbSanPham.getValueAt(i, 2).toString());
            cbLoaiSanPham.setSelectedItem(tbSanPham.getValueAt(i, 3).toString());
        }else{
            clearTF();
        }
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        String ten = tfTenSanPham.getText();
        String gia = tfGia.getText();
        String loai = cbLoaiSanPham.getSelectedItem().toString();
        try {
            
            Connector pt = new Connector();
            int maLoai = -1;
            String sqlLoaiSP = "SELECT MaLoaiSanPham FROM loaisanpham WHERE TenLoaiSanPham = '"+loai+"';";
            ResultSet rs = pt.getDataBySQL(sqlLoaiSP);
            while(rs.next()){
                maLoai = Integer.parseInt(rs.getString("MaLoaiSanPham"));
            }
            if(maLoai == -1) return;
            String sql = "INSERT INTO `sanpham`(`TenSanPham`, `GiaDonVi`, `SoLuongTon`, `MaLoaiSanPham`) VALUES ('"+ten+"', "+gia+", 999, "+maLoai+")";
            pt.updateQuery(sql);
            loadSanPham();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        String ten = tfTenSanPham.getText();
        String gia = tfGia.getText();
        String loai = cbLoaiSanPham.getSelectedItem().toString();
        String ma = "";
        try {
            Connector pt = new Connector();
            int maLoai = -1;
            String sqlLoaiSP = "SELECT MaLoaiSanPham FROM loaisanpham WHERE TenLoaiSanPham = '"+loai+"';";
            ResultSet rs = pt.getDataBySQL(sqlLoaiSP);
            while(rs.next()){
                maLoai = Integer.parseInt(rs.getString("MaLoaiSanPham"));
            }
            if(maLoai == -1) return;
            int i = tbSanPham.getSelectedRow();
            
            if(i == -1) return;
            if(tbSanPham.getValueAt(i,0) != null && !tbSanPham.getValueAt(i,0).toString().equals("") && i >= 0){
                ma = tbSanPham.getValueAt(i, 0).toString();
//                JOptionPane.showMessageDialog(null, ma);
            }else{
                JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa!");
                return;
            }
            String sql = "UPDATE `sanpham` SET `TenSanPham`='"+ten+"',`GiaDonVi`= "+gia+",`MaLoaiSanPham`= "+maLoai+" WHERE `MaSanPham`= "+ma+"";
            pt.updateQuery(sql);
            loadSanPham();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btXoaActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        
    }//GEN-LAST:event_btThoatActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbSanPham.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        String ma = "1";
        if (cbTimKiem.getSelectedIndex() == 0){
            ma = "sanpham.TenSanPham LIKE '%" + tfTimKiem.getText() + "%'"; 
        }
        else if(cbTimKiem.getSelectedIndex() == 1){
            ma = "loaisanpham.TenLoaiSanPham LIKE '%" + tfTimKiem.getText() + "%'"; 
        }
        
        try {
            Connector pt = new Connector();
            ResultSet rs = null;
            String sql = "SELECT sanpham.MaSanPham, sanpham.TenSanPham, sanpham.GiaDonVi, loaisanpham.TenLoaiSanPham FROM sanpham JOIN loaisanpham ON sanpham.MaLoaiSanPham = loaisanpham.MaLoaiSanPham ";
            if(tfTimKiem.getText().equals("")){
                rs = pt.getDataBySQL(sql);                
            }
            else{
                rs = pt.getDataBySQL(sql + " where " + ma);
            }
            int dem = 0;
            while(rs.next()){
                tbSanPham.setValueAt(rs.getString("MaSanPham"), dem, 0);
                tbSanPham.setValueAt(rs.getString("TenSanPham"), dem, 1);
                tbSanPham.setValueAt(rs.getString("GiaDonVi"), dem, 2);
                tbSanPham.setValueAt(rs.getString("TenLoaiSanPham"), dem, 3);
                dem++;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fQLSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThemLSP;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXoaLSP;
    private javax.swing.JComboBox<String> cbLoaiSanPham;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfTenSanPham;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
