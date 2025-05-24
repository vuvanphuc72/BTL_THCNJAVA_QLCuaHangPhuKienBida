
package Form;

import Model.Connector;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
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

public class fQLSanPham extends javax.swing.JFrame {

    private JFrame fQL;
    
    public fQLSanPham() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false); // Cấm resize
        loadSanPham();
        loadLoaiSP();
        setColor();
        setCoLorForTB();
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
        
        cbLoaiSanPham.setRenderer(new DefaultListCellRenderer() {
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
        
        JTableHeader header = tbSanPham.getTableHeader();
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
        cbLoaiSanPham.setBackground(new Color(0, 139, 139)); // màu nền dropdown
        cbLoaiSanPham.setForeground(Color.black); // màu chữ dropdown

    }
    
    public void setColor(){
        tfTenSanPham.setBackground(new Color(245,255,245));
        tfGia.setBackground(new Color(245,255,245));
        tfTimKiem.setBackground(new Color(245,255,245));
        
        btThem.setBackground(new Color(102,205,170));
        btThem.setForeground(Color.black);
        btXoa.setBackground(new Color(102,205,170));
        btXoa.setForeground(Color.black);
        btSua.setBackground(new Color(102,205,170));
        btSua.setForeground(Color.black);
        btTimKiem.setBackground(new Color(102,205,170));
        btTimKiem.setForeground(Color.black);
        btThemLSP.setBackground(new Color(102,205,170));
        btThemLSP.setForeground(Color.black);
        btXoaLSP.setBackground(new Color(102,205,170));
        btXoaLSP.setForeground(Color.black);
        btThoat.setBackground(new Color(102,205,170));
        btThoat.setForeground(Color.black);
        cbTimKiem.setBackground(new Color(176,224,230));
        cbTimKiem.setForeground(Color.black);
        
        jPanel1.setBackground(new Color(240,255,240));
        jPanel1.setForeground(Color.BLACK);
        
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);
        
        tbSanPham.setBackground(new Color(240,255,240));
        tbSanPham.setForeground(Color.BLACK);
        
        tbSanPham.getTableHeader().setBackground(new Color(0,139,139)); // Xanh dương
        tbSanPham.getTableHeader().setForeground(Color.white); // Chữ trắng
        
        tbSanPham.setRowHeight(25);
    }
    
    public void loadLoaiSP(){
        try {
            Connector pt = new Connector();
            cbLoaiSanPham.removeAllItems();
            ResultSet rs = pt.getData("loaisanpham");
            while(rs.next()){
                cbLoaiSanPham.addItem(rs.getString("TenLoaiSanPham"));
            }
            if(pt != null) pt.Close();
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
            if(pt != null) pt.Close();
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        btSua = new javax.swing.JButton();
        btTimKiem = new javax.swing.JButton();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btThemLSP = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btThoat = new javax.swing.JButton();
        tfTenSanPham = new javax.swing.JTextField();
        btXoaLSP = new javax.swing.JButton();
        tfGia = new javax.swing.JTextField();
        cbLoaiSanPham = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 133, 81));
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btThem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btXoa.setText("Xoá");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        tbSanPham.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        btSua.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btTimKiem.setText("Tìm kiếm theo");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        cbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên sản phẩm", "Loại sản phẩm" }));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Tên sản phẩm");

        tfTimKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Giá");

        btThemLSP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btThemLSP.setText("Thêm loại SP");
        btThemLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemLSPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Loại sản phẩm");

        btThoat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        tfTenSanPham.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btXoaLSP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btXoaLSP.setText("Xoá loại SP");
        btXoaLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaLSPActionPerformed(evt);
            }
        });

        tfGia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cbLoaiSanPham.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfTenSanPham)
                                    .addComponent(tfGia)
                                    .addComponent(cbLoaiSanPham, 0, 472, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btThemLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btXoaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btThem)
                    .addComponent(btSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btXoa)
                    .addComponent(btThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemLSP)
                    .addComponent(btXoaLSP))
                .addGap(18, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btTimKiem)
                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            if(pt != null) pt.Close();
            
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
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        String TenSP = tfTenSanPham.getText();
        if(TenSP.isEmpty() || TenSP.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn/nhập sản phẩm cần xoá!");
            return;
        }
        int c = JOptionPane.showConfirmDialog(null, "Xoá sản phẩm '" +TenSP+ "' sẽ xoá hết các hoá đơn liên quan!\nBạn vẫn muốn thực hiện?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(c != JOptionPane.YES_OPTION)
            return;
        try {
            Connector pt = new Connector();
            String sql = "Select * from sanpham where TenSanPham = '"+TenSP+"'";
            ResultSet rs = pt.getDataBySQL(sql);
            String ma = "";
            while(rs.next()){
                ma = rs.getString("MaSanPham");
            }
            
            if(ma.isEmpty() || ma.equals("")){
                JOptionPane.showMessageDialog(null, "'"+TenSP+"' không tồn tại!");
                return;
            }
            
            String sqlXoa = "DELETE FROM `sanpham` WHERE TenSanPham = '"+TenSP+"'";
            pt.updateQuery(sqlXoa);
            loadSanPham();
            JOptionPane.showMessageDialog(null, "Đã xoá sản phẩm '"+TenSP+"'");
            
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btXoaActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        int kq = JOptionPane.showConfirmDialog(null, "Thoát ứng dụng", "Thông báo", JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
        if(kq == JOptionPane.YES_OPTION){
            System.exit(0);
        }
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
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btThemLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemLSPActionPerformed
        
        ThemLoaiSP fql = new ThemLoaiSP();
        fql.setVisible(true);
        // Thêm sự kiện khi đóng cửa sổ
        fql.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                loadLoaiSP();
            }
        });
    }//GEN-LAST:event_btThemLSPActionPerformed

    private void btXoaLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaLSPActionPerformed
        String loai = cbLoaiSanPham.getSelectedItem().toString();
        if(loai.isEmpty() || loai.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại sản phẩm cần xoá!");
            return;
        }
        int c = JOptionPane.showConfirmDialog(null, "Xoá loại sản phẩm '" +loai+ "' sẽ xoá hết các sản phẩm và hoá đơn liên quan!\nBạn vẫn muốn thực hiện?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(c != JOptionPane.YES_OPTION)
            return;
        
        try {
            Connector pt = new Connector();
            String sql = "Select * from loaisanpham where TenLoaiSanPham = '"+loai+"'";
            ResultSet rs = pt.getDataBySQL(sql);
            String ma = "";
            while(rs.next()){
                ma = rs.getString("MaLoaiSanPham");
            }
            
            if(ma.isEmpty() || ma.equals("")){
                JOptionPane.showMessageDialog(null, "'"+loai+"' không tồn tại!");
                return;
            }
            
            String sqlXoa = "DELETE FROM `loaisanpham` WHERE TenLoaiSanPham = '"+loai+"'";
            pt.updateQuery(sqlXoa);
            loadLoaiSP();
            loadSanPham();
            JOptionPane.showMessageDialog(null, "Đã xoá loại sản phẩm '"+loai+"'");
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fQLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btXoaLSPActionPerformed

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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfTenSanPham;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
