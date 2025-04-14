
package Form;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FQuanLy extends javax.swing.JFrame {

    private JFrame fLogin;

    public FQuanLy(){
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public FQuanLy(JFrame fLogin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.fLogin = fLogin;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                fLogin.setVisible(true);
        }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btQLKH = new javax.swing.JButton();
        btQLDH = new javax.swing.JButton();
        btQLSP = new javax.swing.JButton();
        btQLNV = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng phụ kiện Bida Vip Pro");

        btQLKH.setText("Quản lý khách hàng");
        btQLKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLKHActionPerformed(evt);
            }
        });

        btQLDH.setText("Quản lý đơn hàng");
        btQLDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLDHActionPerformed(evt);
            }
        });

        btQLSP.setText("Quản lý sản phẩm");
        btQLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLSPActionPerformed(evt);
            }
        });

        btQLNV.setText("Quản lý nhân viên");
        btQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLNVActionPerformed(evt);
            }
        });

        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btQLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btQLDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(470, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btQLKH)
                .addGap(18, 18, 18)
                .addComponent(btQLDH)
                .addGap(18, 18, 18)
                .addComponent(btQLSP)
                .addGap(18, 18, 18)
                .addComponent(btQLNV)
                .addGap(18, 18, 18)
                .addComponent(btThoat)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        int kq = JOptionPane.showConfirmDialog(null, "Thoát ứng dụng", "Thông báo", JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
        if(kq == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btThoatActionPerformed

    private void btQLDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLDHActionPerformed
        this.setVisible(false);
        fQLDonHang fql = new fQLDonHang(this);
        fql.setVisible(true);
    }//GEN-LAST:event_btQLDHActionPerformed

    private void btQLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLSPActionPerformed
        this.setVisible(false);
        fQLSanPham fql = new fQLSanPham(this);
        fql.setVisible(true);
    }//GEN-LAST:event_btQLSPActionPerformed

    private void btQLKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLKHActionPerformed
        this.setVisible(false);
        fQLKhachHang fql = new fQLKhachHang(this);
        fql.setVisible(true);
    }//GEN-LAST:event_btQLKHActionPerformed

    private void btQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLNVActionPerformed
        this.setVisible(false);
        QLNhanVien fql = new QLNhanVien(this);
        fql.setVisible(true);
    }//GEN-LAST:event_btQLNVActionPerformed


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
            java.util.logging.Logger.getLogger(FQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FQuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btQLDH;
    private javax.swing.JButton btQLKH;
    private javax.swing.JButton btQLNV;
    private javax.swing.JButton btQLSP;
    private javax.swing.JButton btThoat;
    // End of variables declaration//GEN-END:variables
}
