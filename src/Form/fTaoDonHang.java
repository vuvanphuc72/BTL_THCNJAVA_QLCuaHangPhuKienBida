
package Form;

import Model.Connector;
import Model.DonHangConnect;
import Model.SanPham;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
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

public class fTaoDonHang extends javax.swing.JFrame {

    private JFrame fQLDH;
    
    public fTaoDonHang() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false); // Cấm resize
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadSanPham("sanpham");
        setColor();
        setCoLorForTB();
    }
    
    public fTaoDonHang(JFrame fQLDH) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.fQLDH = fQLDH;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                fQLDH.setVisible(true);
        }
        });
        loadSanPham("sanpham");
    }
    
    public void setCoLorForTB(){
        
        JTableHeader header = tbSanPhamDaThem.getTableHeader();
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
        
        JTableHeader header2 = tbSanPham.getTableHeader();
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

    }
    
    public void setColor(){
        tfMaKhachHang.setBackground(new Color(245,255,245));
        tfMaNhanVien.setBackground(new Color(245,255,245));
        tfTongTien.setBackground(new Color(245,255,245));
        tfTenSanPhamTK.setBackground(new Color(245,255,245));
        tfTenSanPham.setBackground(new Color(245,255,245));
        tfGiaSanPham.setBackground(new Color(245,255,245));
        
        btTaoDon.setBackground(new Color(102,205,170));
        btTaoDon.setForeground(Color.black);
        btThem.setBackground(new Color(102,205,170));
        btThem.setForeground(Color.black);
        btXoa.setBackground(new Color(102,205,170));
        btXoa.setForeground(Color.black);
        btTimKiemSanPham.setBackground(new Color(102,205,170));
        btTimKiemSanPham.setForeground(Color.black);
        
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);
        
        tbSanPhamDaThem.setBackground(new Color(240,255,240));
        tbSanPhamDaThem.setForeground(Color.BLACK);
        tbSanPham.setBackground(new Color(240,255,240));
        tbSanPham.setForeground(Color.BLACK);
        
        tbSanPham.getTableHeader().setBackground(new Color(0,139,139)); // Xanh dương
        tbSanPham.getTableHeader().setForeground(Color.white); // Chữ trắng
        
        tbSanPhamDaThem.getTableHeader().setBackground(new Color(0,139,139)); // Xanh dương
        tbSanPhamDaThem.getTableHeader().setForeground(Color.white); // Chữ trắng
    }

    public void loadSanPham(String tenBang){
        DefaultTableModel model = (DefaultTableModel) tbSanPham.getModel();
        model.setRowCount(0);
        model.setRowCount(50);
        try {
            DonHangConnect pt = new DonHangConnect();
            ResultSet rs = pt.getData(tenBang);
            int dem = 0;
            while(rs.next()){
                tbSanPham.setValueAt(rs.getString("MaSanPham"), dem, 0);
                tbSanPham.setValueAt(rs.getString("TenSanPham"), dem, 1);
                tbSanPham.setValueAt(rs.getString("GiaDonVi"), dem, 2);
                tbSanPham.setValueAt(rs.getString("SoLuongTon"), dem, 3);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfTenSanPham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTongTien = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btTimKiemSanPham = new javax.swing.JButton();
        tfTenSanPhamTK = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSanPhamDaThem = new javax.swing.JTable();
        btXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfMaNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfGiaSanPham = new javax.swing.JTextField();
        spSoLuong = new javax.swing.JSpinner();
        btTaoDon = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfMaKhachHang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng tồn kho"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        jLabel1.setText("Tên sản phẩm");

        jLabel2.setText("Nhập số lượng");

        jLabel3.setText("TỔNG TIỀN");

        tfTongTien.setEditable(false);

        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btTimKiemSanPham.setText("Tìm kiếm theo tên");
        btTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemSanPhamActionPerformed(evt);
            }
        });

        tbSanPhamDaThem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá"
            }
        ));
        jScrollPane2.setViewportView(tbSanPhamDaThem);

        btXoa.setText("Xoá");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã nhân viên");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 133, 81));
        jLabel5.setText("TẠO HOÁ ĐƠN");

        jLabel6.setText("Giá");

        tfGiaSanPham.setEditable(false);

        spSoLuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ThayDoiSoLuong(evt);
            }
        });

        btTaoDon.setBackground(new java.awt.Color(153, 153, 0));
        btTaoDon.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btTaoDon.setForeground(new java.awt.Color(0, 0, 153));
        btTaoDon.setText("TẠO ĐƠN");
        btTaoDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaoDonActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã khách hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfTenSanPhamTK, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfGiaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(tfTenSanPham)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(spSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(52, 52, 52))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(311, 311, 311)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btTaoDon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTaoDon)
                    .addComponent(jLabel7)
                    .addComponent(tfMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btTimKiemSanPham)
                            .addComponent(tfTenSanPhamTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(spSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfGiaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btThem)
                            .addComponent(btXoa)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int i = tbSanPham.getSelectedRow();
        double gia = 0;
        if(i == -1) return;
        if(tbSanPham.getValueAt(i,0) != null && !tbSanPham.getValueAt(i,0).toString().equals("")){
           tfTenSanPham.setText(tbSanPham.getValueAt(i, 1).toString());
           int sl = (int) spSoLuong.getValue();
           gia += Double.parseDouble(tbSanPham.getValueAt(i, 2).toString()) * sl;
           tfGiaSanPham.setText(String.format("%.2f", gia));
        }
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void ThayDoiSoLuong(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ThayDoiSoLuong
        int sl = (int) spSoLuong.getValue();
        double gia = Double.parseDouble(tbSanPham.getValueAt(tbSanPham.getSelectedRow(), 2).toString()) * sl;
        tfGiaSanPham.setText(String.format("%.2f", gia));
    }//GEN-LAST:event_ThayDoiSoLuong
    
    
    ArrayList<SanPham> ds = new ArrayList<>();
    
    public void loadSanPhamThem(){
        DefaultTableModel model = (DefaultTableModel) tbSanPhamDaThem.getModel();
        model.setRowCount(0);
        double tongTien = 0;
        for(SanPham sp : ds){
            Object[] row = new Object[]{sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuong(), String.format("%.2f", sp.getGia())};
            model.addRow(row);
            tongTien += sp.getGia();
        }
        tfTongTien.setText(String.format("%.1f", tongTien));
    }
    
    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        SanPham sp = new SanPham();
        sp.setMaSanPham(tbSanPham.getValueAt(tbSanPham.getSelectedRow(), 0).toString());
        sp.setTenSanPham(tbSanPham.getValueAt(tbSanPham.getSelectedRow(), 1).toString());
        sp.setSoLuong((int) spSoLuong.getValue());
        sp.setGia(Double.parseDouble(tfGiaSanPham.getText()));
        ds.add(sp);
        loadSanPhamThem();
    }//GEN-LAST:event_btThemActionPerformed

    private void btTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemSanPhamActionPerformed
        String tenSP = tfTenSanPhamTK.getText();
        if(tenSP.equals("")){
            loadSanPham("sanpham");            
        }else{
            loadSanPham("sanpham where TenSanPham like '%" + tenSP + "%'");            
        }
    }//GEN-LAST:event_btTimKiemSanPhamActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        int index = tbSanPhamDaThem.getSelectedRow();
        String ma = tbSanPhamDaThem.getValueAt(index, 0).toString();
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaSanPham().equals(ma)){
                ds.remove(i);
                break;
            }
        }
        loadSanPhamThem();
    }//GEN-LAST:event_btXoaActionPerformed

    private void btTaoDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaoDonActionPerformed
        String maNV = tfMaNhanVien.getText();
        String maKH = tfMaKhachHang.getText();
        String tongTien = tfTongTien.getText();
        
        if(maNV.isEmpty()|| maNV.equals("") || maKH.isEmpty() || maKH.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        
        boolean c = false;
        
        try {
            Connector check = new Connector();
            ResultSet rs = check.getDataBySQL("select * from khachhang where MaKhachHang = '"+maKH+"'");
            ResultSet rs2 = check.getDataBySQL("select * from nhanvien where MaNhanVien = '"+maNV+"'");
            if(!rs.next() || !rs2.next()){
                JOptionPane.showMessageDialog(null, "Mã nhân viên hoặc khách hàng không tồn tại!");
                c = true;
            }
            if(check != null) check.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fTaoDonHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fTaoDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(c) return;
        
        if(ds == null){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm!");
            return;
        }
        
        if(tongTien.isEmpty()|| tongTien.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm!");
            return;
        }
        
        try {
            DonHangConnect pt = new DonHangConnect();
            int maDonHangMoi = pt.themDonHang(maNV, maKH, tongTien);
//            System.out.println("Mã đơn hàng vừa tạo là: " + maDonHangMoi);
            
            String ctdh = "INSERT INTO `chitiethoadon`(`MaHoaDon`, `MaSanPham`, `SoLuong`, `GiaTaiThoiDiem`) VALUES ";
            boolean first = true;
            for(SanPham sp : ds){
                if(!first) ctdh += ", ";
                ctdh += "("+maDonHangMoi+","+sp.getMaSanPham()+", "+sp.getSoLuong()+","+sp.getGia()+")";
                first = false;
            }
            pt.themCTDH(ctdh);
//            System.out.println(ctdh);
            JOptionPane.showMessageDialog(null, "Thêm hoá đơn thành công!");
            if(pt != null) pt.Close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fTaoDonHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fTaoDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btTaoDonActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fTaoDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fTaoDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fTaoDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fTaoDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fTaoDonHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTaoDon;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimKiemSanPham;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spSoLuong;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tbSanPhamDaThem;
    private javax.swing.JTextField tfGiaSanPham;
    private javax.swing.JTextField tfMaKhachHang;
    private javax.swing.JTextField tfMaNhanVien;
    private javax.swing.JTextField tfTenSanPham;
    private javax.swing.JTextField tfTenSanPhamTK;
    private javax.swing.JTextField tfTongTien;
    // End of variables declaration//GEN-END:variables
}
