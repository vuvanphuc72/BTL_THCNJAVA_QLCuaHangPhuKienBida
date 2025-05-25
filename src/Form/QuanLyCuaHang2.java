
package Form;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class QuanLyCuaHang2 extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    
    public QuanLyCuaHang2() {
        setTitle("QUẢN LÝ CỬA HÀNG PHỤ KIỆN BIDA 378");
        setSize(1050, 630);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/libraries/icon/8.png"));
        setIconImage(icon.getImage());
        
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
        
        
        // 2. Tạo nút "Thoát"
        JButton btnThoat = new JButton("Thoát");
        btnThoat.setFocusPainted(false);
        btnThoat.setBackground(new Color(220, 53, 69));
        btnThoat.setForeground(Color.black);
        btnThoat.setFont(btnThoat.getFont().deriveFont(Font.BOLD));
        btnThoat.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // 3. Cho vào layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(btnThoat, BorderLayout.SOUTH); // hoặc EAST nếu muốn

        // 4. Thêm mainPanel vào JFrame
        add(mainPanel);

        
        
    }

    public void setColor(){
        this.getContentPane().setBackground(new Color(240,255,240));
        this.setForeground(Color.BLACK);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuanLyCuaHang2().setVisible(true));
    }
}
