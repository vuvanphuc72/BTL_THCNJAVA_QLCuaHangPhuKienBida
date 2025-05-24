
package Form;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class QuanLyCuaHang2 extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    
    public QuanLyCuaHang2() {
        setTitle("Quản lý cửa hàng phụ kiện bida");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Cấm resize
        
        JPanel pnlKhachHang = new JPanel();
        fQLKhachHang khForm = new fQLKhachHang();
        pnlKhachHang.add(khForm.getContentPane());


        JPanel pnlNhanVien = new JPanel();
        QLNhanVien nvForm = new QLNhanVien();
        pnlNhanVien.add(nvForm.getContentPane());

        JPanel pnlHoaDon = new JPanel();
        fQLDonHang hdForm = new fQLDonHang();
        pnlHoaDon.add(hdForm.getContentPane());
        
        JPanel pnlSanPham = new JPanel();
        fQLSanPham spForm = new fQLSanPham();
        pnlSanPham.add(spForm.getContentPane());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Quản lý hóa đơn", pnlHoaDon);
        tabbedPane.addTab("Quản lý sản phẩm", pnlSanPham);
        tabbedPane.addTab("Quản lý khách hàng", pnlKhachHang);
        tabbedPane.addTab("Quản lý nhân viên", pnlNhanVien);
        
        pnlSanPham.setBackground(new Color(240,255,240));
        pnlHoaDon.setBackground(new Color(240,255,240));
        pnlNhanVien.setBackground(new Color(240,255,240));
        pnlKhachHang.setBackground(new Color(240,255,240));
        
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            JLabel label = new JLabel(tabbedPane.getTitleAt(i));
            label.setForeground(new Color(20,119,67)); // Màu chữ
             label.setFont(new Font("Segoe UI", Font.BOLD, 14)); // 👉 chữ to và đậm
            tabbedPane.setTabComponentAt(i, label);
        }

        add(tabbedPane);
        setColor();
    }

    public void setColor(){
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuanLyCuaHang2().setVisible(true));
    }
}
