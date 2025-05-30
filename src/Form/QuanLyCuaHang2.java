
package Form;

import Model.Connector;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class QuanLyCuaHang2 extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    
    public QuanLyCuaHang2(String sdt){
        setTitle("QUẢN LÝ CỬA HÀNG PHỤ KIỆN BIDA 378");
        setSize(1050, 630);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/libraries/icon/8.png"));
        setIconImage(icon.getImage());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Cấm resize
        
        JTabbedPane tabbedPane = new JTabbedPane();

//        
//        JPanel panelChinh = new JPanel();
//        JLabel chaoMung = new JLabel("🌟 Chào mừng bạn đến với hệ thống quản lý cửa hàng!");
//        chaoMung.setFont(new Font("Arial", Font.BOLD, 18));
//        chaoMung.setForeground(new Color(0,205,102));
//        panelChinh.setLayout(new BoxLayout(panelChinh, BoxLayout.Y_AXIS));
//        panelChinh.setBorder(new EmptyBorder(20, 20, 20, 20));
//
//        JLabel title = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG PHỤ KIỆN BILLARD 378");
//        title.setFont(new Font("Arial", Font.BOLD, 22));
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        title.setForeground(new Color(34, 139, 34));
//
//        JLabel welcome = new JLabel("Chào mừng bạn đến với hệ thống!");
//        welcome.setFont(new Font("Arial", Font.PLAIN, 16));
//        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        panelChinh.add(title);
//        panelChinh.add(Box.createVerticalStrut(10));
//        panelChinh.add(welcome);
//        tabbedPane.addTab("Trang chính", panelChinh);
//        
//        JLabel lblTenNhanVien = new JLabel();
////        JLabel lblChucVu = new JLabel();
////        JLabel lblSDT = new JLabel();
//        JLabel Email = new JLabel();
//        
//        JPanel panelThongTinNV = new JPanel();
//        panelThongTinNV.setLayout(new BoxLayout(panelThongTinNV, BoxLayout.Y_AXIS));
//        panelThongTinNV.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));
//
//        JLabel lblTen = new JLabel("Tên nhân viên: Nguyễn Văn A");
//        lblTen.setFont(new Font("Arial", Font.BOLD, 16));
//        lblTen.setForeground(new Color(0, 102, 204));
//
//        JLabel lblChucVu = new JLabel("Chức vụ: Nhân viên bán hàng");
//        lblChucVu.setFont(new Font("Arial", Font.PLAIN, 15));
//
//        JLabel lblSDT = new JLabel("SĐT: 0123456789");
//        lblSDT.setFont(new Font("Arial", Font.PLAIN, 15));
//        
//        
//        Email.setFont(new Font("Arial", Font.PLAIN, 15));
//
//        panelChinh.add(lblTenNhanVien);
//        panelChinh.add(lblSDT);
//        panelChinh.add(Email);
//        panelChinh.add(lblChucVu);
//        
//        try {
//            Connector pt = new Connector();
//            ResultSet rs = pt.getDataBySQL("select * from nhanvien where SoDienThoai = '" + sdt +"'");
//            String ten = "";
//            String email = "";
//            while(rs.next()){
//                ten = rs.getString("HoTen").toString();
//                email = rs.getString("Email").toString();
//            }
//            lblTen.setText("Xin chào, "+ ten);
//            lblSDT.setText("SDT: "+ sdt);
//            Email.setText("Email: "+ email);
//            lblChucVu.setText("Chức vụ: Nhân viên");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(QuanLyCuaHang2.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyCuaHang2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        JPanel panelChinh = new JPanel(new BorderLayout());
        panelChinh.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelChinh.setBackground(new Color(240,255,240));
        


        // ===== Phần GIỚI THIỆU ở giữa =====
        JPanel panelGioiThieu = new JPanel();
        panelGioiThieu.setLayout(new BoxLayout(panelGioiThieu, BoxLayout.Y_AXIS));
        panelGioiThieu.setBackground(new Color(240,255,240));

        JLabel title = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG PHỤ KIỆN BILLARD 378");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(34, 139, 34));

        JLabel welcome = new JLabel("Chào mừng bạn đến với hệ thống quản lý!");
        welcome.setFont(new Font("Arial", Font.BOLD, 18));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setForeground(new Color(0, 205, 102));

        panelGioiThieu.add(title);
        panelGioiThieu.add(Box.createVerticalStrut(10));
        panelGioiThieu.add(welcome);
        
        // ===== ẢNH bên trái =====
        
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/libraries/icon/cuahang.jpg"));
        
        Image img = icon2.getImage().getScaledInstance(700, 400, Image.SCALE_SMOOTH); // resize nếu cần
        JLabel lblAnh = new JLabel(new ImageIcon(img));
        lblAnh.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelGioiThieu.add(title);
        panelGioiThieu.add(Box.createVerticalStrut(10));
        panelGioiThieu.add(welcome);
        panelGioiThieu.add(Box.createVerticalStrut(20));
        panelGioiThieu.add(lblAnh);

        // ===== Panel giới thiệu cho vào CENTER =====
        panelChinh.add(panelGioiThieu, BorderLayout.CENTER);

        // ===== Panel THÔNG TIN NHÂN VIÊN bên phải =====
        JPanel panelThongTinNV = new JPanel();
        panelThongTinNV.setBackground(new Color(240,255,240));
        panelThongTinNV.setLayout(new BoxLayout(panelThongTinNV, BoxLayout.Y_AXIS));
        panelThongTinNV.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên đang thực hiện"));
        panelThongTinNV.setPreferredSize(new Dimension(300, 0)); // Cố định chiều rộng bên phải

        // Các label thông tin
        JLabel lblTen = new JLabel("Tên nhân viên: ...");
        lblTen.setFont(new Font("Arial", Font.BOLD, 16));
        lblTen.setForeground(new Color(0, 102, 204));

        JLabel lblChucVu = new JLabel("Chức vụ: ...");
        lblChucVu.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblSDT = new JLabel("SĐT: ...");
        lblSDT.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblEmail = new JLabel("Email: ...");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));

        // Thêm label vào panel
        panelThongTinNV.add(lblTen);
        panelThongTinNV.add(Box.createVerticalStrut(10));
        panelThongTinNV.add(lblChucVu);
        panelThongTinNV.add(Box.createVerticalStrut(10));
        panelThongTinNV.add(lblSDT);
        panelThongTinNV.add(Box.createVerticalStrut(10));
        panelThongTinNV.add(lblEmail);
//                anh

//        ImageIcon icon3 = new ImageIcon(getClass().getResource("/libraries/icon/avt.png"));
//        Image img2 = icon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // resize nếu cần
//        JLabel lblAnh2 = new JLabel(new ImageIcon(img2));
//        lblAnh2.setAlignmentX(Component.CENTER_ALIGNMENT);
//        panelThongTinNV.add(lblAnh2);

        // Đặt panel nhân viên vào bên phải
        panelChinh.add(panelThongTinNV, BorderLayout.EAST);

        // ===== Thêm tab Trang chính =====
        tabbedPane.addTab("Giới thiệu", panelChinh);

        // ======= Lấy dữ liệu nhân viên sau khi đăng nhập =======
        try {
            Connector pt = new Connector();
            ResultSet rs = pt.getDataBySQL("SELECT * FROM nhanvien WHERE SoDienThoai = '" + sdt + "'");
            if (rs.next()) {
                String ten = rs.getString("HoTen");
                String email = rs.getString("Email");

                lblTen.setText("Tên nhân viên: " + ten);
                lblSDT.setText("SĐT: " + sdt);
                lblEmail.setText("Email: " + email);
                lblChucVu.setText("Chức vụ: Nhân viên"); // Nếu bạn có cột ChucVu thì lấy từ rs
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
 
       ///
        
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
    
    public QuanLyCuaHang2() {
        setTitle("QUẢN LÝ CỬA HÀNG PHỤ KIỆN BIDA 378");
        setSize(1050, 630);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/libraries/icon/8.png"));
        setIconImage(icon.getImage());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Cấm resize
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel panelChinh = new JPanel();
//        panelChinh.add(new JLabel("🌟 Trang chính - Quản lý cửa hàng"));
        JLabel chaoMung = new JLabel("🌟 Chào mừng bạn đến với hệ thống quản lý cửa hàng!");
        chaoMung.setFont(new Font("Arial", Font.BOLD, 18));
        chaoMung.setForeground(new Color(0,205,102));
        panelChinh.setLayout(new BoxLayout(panelChinh, BoxLayout.Y_AXIS));
        panelChinh.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG PHỤ KIỆN BILLARD 378");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(34, 139, 34));

        JLabel welcome = new JLabel("Chào mừng bạn đến với hệ thống!");
        welcome.setFont(new Font("Arial", Font.PLAIN, 16));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelChinh.add(title);
        panelChinh.add(Box.createVerticalStrut(10));
        panelChinh.add(welcome);
        tabbedPane.addTab("Trang chính", panelChinh);
        
        
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
