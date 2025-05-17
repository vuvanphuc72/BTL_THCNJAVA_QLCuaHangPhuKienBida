
package Model;

import java.sql.*;

public class DonHangConnect {
    private Connection con;
    
    public DonHangConnect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlphukienbidastore", "root", "");
    }
    
    public ResultSet getData(String tenBang) throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        String sql = "select * from " + tenBang;
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getData() throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        String sql = "select * from hoadon";
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getDataCTDH(String maDonHang) throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        String sql = "SELECT sanpham.TenSanPham, chitiethoadon.SoLuong, chitiethoadon.GiaTaiThoiDiem "
                + "from chitiethoadon JOIN sanpham on chitiethoadon.MaSanPham = sanpham.MaSanPham "
                + "WHERE MaHoaDon = " + maDonHang;
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getDataTK(String ma) throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        String sql = "select * from hoadon where " + ma;
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public int themDonHang(String maNV, String maKH, String tongTien) throws SQLException{
        Statement st = con.createStatement();
        String sql = "INSERT INTO `hoadon`(`MaKhachHang`, `MaNhanVien`, `NgayDatHang`, `TongTien`) VALUES ('"+maKH+"','"+maNV+"', CURDATE(), "+tongTien+")";
//        st.executeUpdate(sql);
        st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = st.getGeneratedKeys();
        int maDonHangMoi = -1;
        if (rs.next()) {
            maDonHangMoi = rs.getInt(1);
        }
        return maDonHangMoi;
    }
    
    public void themCTDH(String ctdh) throws SQLException{
        Statement st = con.createStatement();
        st.executeUpdate(ctdh);
    }
    
    public void Close(){
        if(this.con != null)
            this.con = null;
    }
}
