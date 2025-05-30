
package Form;

import Model.Connector;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
//import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class fQLKhachHang extends javax.swing.JFrame {

    private JFrame fQL;
    
    public fQLKhachHang() {
        initComponents();
        setResizable(false); // Cấm resize
        this.setLocationRelativeTo(null);
        loadKhachHang();
        setColor();
        setCoLorForTB();
    }
    
    public fQLKhachHang(JFrame fQL) {
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
        loadKhachHang();
        
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
        
        JTableHeader header = tbKhachHang.getTableHeader();
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
        
        cbTimKiem.setBackground(new Color(0, 139, 139)); // màu nền dropdown
        cbTimKiem.setForeground(Color.black); // màu chữ dropdown

    }
    
    public void setColor(){
        tfHoTen.setBackground(new Color(245,255,245));
        tfSDT.setBackground(new Color(245,255,245));
        tfEmail.setBackground(new Color(245,255,245));
        tfTimKiem.setBackground(new Color(245,255,245));
        tfDiaChi.setBackground(new Color(245,255,245));
        
        btThem.setBackground(new Color(102,205,170));
        btThem.setForeground(Color.black);
        btXoa.setBackground(new Color(102,205,170));
        btXoa.setForeground(Color.black);
        btSua.setBackground(new Color(102,205,170));
        btSua.setForeground(Color.black);
        btTimKiem.setBackground(new Color(102,205,170));
        btTimKiem.setForeground(Color.black);
        cbTimKiem.setBackground(new Color(176,224,230));
        cbTimKiem.setForeground(Color.black);
        
        jPanel1.setBackground(new Color(240,255,240));
        jPanel1.setForeground(Color.BLACK);
        
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);
        
        tbKhachHang.setBackground(new Color(240,255,240));
        tbKhachHang.setForeground(Color.BLACK);
        
        tbKhachHang.getTableHeader().setBackground(new Color(0,139,139)); // Xanh dương
        tbKhachHang.getTableHeader().setForeground(Color.white); // Chữ trắng
        
        tbKhachHang.setRowHeight(25);
    }

    public void loadKhachHang(){
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        model.setRowCount(200);
        try {
            Connector pt = new Connector();
            ResultSet rs = pt.getData("khachhang");
            int dem = 0;
            while(rs.next()){
                tbKhachHang.setValueAt(rs.getString("MaKhachHang"), dem, 0);
                tbKhachHang.setValueAt(rs.getString("HoTen"), dem, 1);
                tbKhachHang.setValueAt(rs.getString("SoDienThoai"), dem, 2);
                tbKhachHang.setValueAt(rs.getString("Email"), dem, 3);
                tbKhachHang.setValueAt(rs.getString("DiaChi"), dem, 4);
                dem++;
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSDT = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        cbTimKiem = new javax.swing.JComboBox<>();
        btTimKiem = new javax.swing.JButton();
        tfTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 133, 81));
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 100, 91, -1));

        tfEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 98, 500, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 141, 91, -1));

        tfDiaChi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 139, 500, -1));

        tbKhachHang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 180, 999, 290));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Họ tên");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 20, 66, -1));

        tfHoTen.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 18, 500, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Số điện thoại");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 59, -1, -1));

        tfSDT.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 57, 500, -1));

        btThem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/importt.png"))); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });
        jPanel1.add(btThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 110, -1));

        btSua.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/edit.png"))); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 110, -1));

        btXoa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/delete.png"))); // NOI18N
        btXoa.setText("Xoá");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 110, -1));

        cbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên khách", "Số DT", "Email" }));
        jPanel1.add(cbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 190, -1));

        btTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/search.png"))); // NOI18N
        btTimKiem.setText("Tìm kiêm theo");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 170, -1));

        tfTimKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(tfTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        int i = tbKhachHang.getSelectedRow();
        if (i == -1) return;
        if(tbKhachHang.getValueAt(i,0) != null && !tbKhachHang.getValueAt(i,0).toString().equals("")){
            tfHoTen.setText(tbKhachHang.getValueAt(i, 1).toString());
            tfSDT.setText(tbKhachHang.getValueAt(i, 2).toString());
            tfEmail.setText(tbKhachHang.getValueAt(i, 3).toString());
            tfDiaChi.setText(tbKhachHang.getValueAt(i, 4).toString());
        }else{
            clearTF();
        }
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        String hoten = tfHoTen.getText();
        String sdt = tfSDT.getText();
        String email = tfEmail.getText();
        String diaChi = tfDiaChi.getText();
        
        if(hoten.isEmpty()|| hoten.equals("") || sdt.isEmpty() || sdt.equals("") ||
                email.isEmpty()|| email.equals("") || diaChi.isEmpty() || diaChi.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        
        try {
            Connector pt = new Connector();
            int maKH = -1;
            String sqlKH = "SELECT MaKhachHang FROM khachhang WHERE SoDienThoai = '"+sdt+"';";
            ResultSet rs = pt.getDataBySQL(sqlKH);
            while(rs.next()){
                maKH = Integer.parseInt(rs.getString("MaKhachHang"));
            }
            if(maKH != -1){
                JOptionPane.showMessageDialog(null, "Khách hàng với sdt này đã tồn tại!");
                return;
            } 
            String sql = "INSERT INTO `khachhang`(`HoTen`, `SoDienThoai`, `Email`, `DiaChi`) VALUES ('"+hoten+"','"+sdt+"','"+email+"','"+diaChi+"')";
            pt.updateQuery(sql);
            JOptionPane.showMessageDialog(null, "Thêm khách hàng '"+hoten+"' thành công!");
            loadKhachHang();
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        String hoten = tfHoTen.getText();
        String sdt = tfSDT.getText();
        String email = tfEmail.getText();
        String diaChi = tfDiaChi.getText();
        
        if(hoten.isEmpty()|| hoten.equals("") || sdt.isEmpty() || sdt.equals("") ||
                email.isEmpty()|| email.equals("") || diaChi.isEmpty() || diaChi.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        
        int c = JOptionPane.showConfirmDialog(null, "Bạn muốn thay đổi thông tin khách hàng thành '" +hoten+" - "+sdt+" - "+email+" - "+diaChi+ "'?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(c != JOptionPane.YES_OPTION)
                return;
        
        try {
            Connector pt = new Connector();
            int i = tbKhachHang.getSelectedRow();
            if(tbKhachHang.getValueAt(i,0) != null && !tbKhachHang.getValueAt(i,0).toString().equals("")){
                String sdtTruoc = tbKhachHang.getValueAt(i, 2).toString();
                int maKH = -1;
                String sqlKH = "SELECT MaKhachHang FROM khachhang WHERE SoDienThoai = '"+sdtTruoc+"';";
                ResultSet rs = pt.getDataBySQL(sqlKH);
                while(rs.next()){
                    maKH = Integer.parseInt(rs.getString("MaKhachHang"));
                }
                if(maKH != -1){
                    String sql = "UPDATE `khachhang` SET `HoTen`='"+hoten+"',`SoDienThoai`='"+sdt+"',`Email`='"+email+"',`DiaChi`='"+diaChi+"' WHERE `MaKhachHang`= "+maKH+"";
                    pt.updateQuery(sql);
                    JOptionPane.showMessageDialog(null, "Sửa khách hàng thành công!");
                    loadKhachHang();
                }else{
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần sửa thông tin!");
                }
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        String SDT = tfSDT.getText();
        if(SDT.isEmpty() || SDT.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn/nhập nhân viên cần xoá!");
            return;
        }
        
        try {
            Connector pt = new Connector();
            String sql = "Select * from khachhang where SoDienThoai = '"+SDT+"'";
            ResultSet rs = pt.getDataBySQL(sql);
            String ten = "";
            while(rs.next()){
                ten = rs.getString("HoTen");
            }
            
            if(ten.isEmpty() || ten.equals("")){
                JOptionPane.showMessageDialog(null, "Khách hàng với SDT '"+SDT+"' không tồn tại!");
                return;
            }
            
            int c = JOptionPane.showConfirmDialog(null, "Xoá khách hàng '" +ten+ "' sẽ xoá hết các hoá đơn liên quan!\nBạn vẫn muốn thực hiện?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(c != JOptionPane.YES_OPTION)
                return;
            
            String sqlXoa = "DELETE FROM `khachhang` WHERE SoDienThoai = '"+SDT+"'";
            pt.updateQuery(sqlXoa);
            loadKhachHang();
            JOptionPane.showMessageDialog(null, "Đã xoá khách hàng '"+ten+"'");
            if(pt != null)pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        model.setRowCount(200);
        String ma = "1";
        if (cbTimKiem.getSelectedIndex() == 0){
            ma = "HoTen LIKE '%" + tfTimKiem.getText() + "%'"; 
        }
        else if(cbTimKiem.getSelectedIndex() == 1){
            ma = "SoDienThoai LIKE '%" + tfTimKiem.getText() + "%'"; 
        }
        else{
            ma = "Email LIKE '%" + tfTimKiem.getText() + "%'";
        }
        
        try {
            Connector pt = new Connector();
            ResultSet rs = null;
            if(tfTimKiem.getText().equals("")){
                rs = pt.getData("khachhang");                
            }
            else{
//                JOptionPane.showMessageDialog(null, ma);
                rs = pt.getDataBySQL("select * from khachhang where " + ma);
            }
            int dem = 0;
            while(rs.next()){
                tbKhachHang.setValueAt(rs.getString("MaKhachHang"), dem, 0);
                tbKhachHang.setValueAt(rs.getString("HoTen"), dem, 1);
                tbKhachHang.setValueAt(rs.getString("SoDienThoai"), dem, 2);
                tbKhachHang.setValueAt(rs.getString("Email"), dem, 3);
                tbKhachHang.setValueAt(rs.getString("DiaChi"), dem, 4);
                dem++;
            }
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTimKiemActionPerformed

    public void clearTF(){
        tfHoTen.setText("");
        tfSDT.setText("");
        tfDiaChi.setText("");
        tfEmail.setText("");
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
            java.util.logging.Logger.getLogger(fQLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fQLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fQLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fQLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fQLKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfHoTen;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
