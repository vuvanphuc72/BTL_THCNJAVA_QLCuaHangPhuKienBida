
package Form;

import Model.Connector;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThemLoaiSP extends javax.swing.JFrame {

    public ThemLoaiSP() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false); // Cấm resize
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setColor();
    }
    
    public void setColor(){
        tfThemLSP.setBackground(new Color(245,255,245));
        tfThemLSP.setBackground(new Color(245,255,245));
        
        btThemLoaiSP.setBackground(new Color(102,205,170));
        btThemLoaiSP.setForeground(Color.black);

        jLabel1.setForeground(new Color(40,133,81));
        
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfThemLSP = new javax.swing.JTextField();
        btThemLoaiSP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm loại sản phẩm");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nhập loại SP");

        tfThemLSP.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btThemLoaiSP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btThemLoaiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraries/icon/importLSP.png"))); // NOI18N
        btThemLoaiSP.setText("Thêm");
        btThemLoaiSP.setIconTextGap(12);
        btThemLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemLoaiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btThemLoaiSP, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(tfThemLSP))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfThemLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btThemLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemLoaiSPActionPerformed
        String loaiSP = tfThemLSP.getText();
        if(loaiSP.isEmpty() || loaiSP.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên loại sản phẩm cần thêm!");
            return;
        }
        try {
            Connector pt = new Connector();
            String sql = "INSERT INTO `loaisanpham`(`TenLoaiSanPham`) VALUES ('"+loaiSP+"')";
            pt.updateQuery(sql);
            JOptionPane.showMessageDialog(null, "Đã thêm loại sản phẩm: " + loaiSP);
            if(pt != null) pt.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThemLoaiSP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThemLoaiSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btThemLoaiSPActionPerformed


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
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemLoaiSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThemLoaiSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tfThemLSP;
    // End of variables declaration//GEN-END:variables
}
