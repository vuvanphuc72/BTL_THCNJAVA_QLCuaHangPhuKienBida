
package Model;

import java.sql.*;

public class DonHangConnect {
    private Connection con;
    
    public DonHangConnect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlpkbida", "root", "");
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
        String sql = "select * from donhang";
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getDataCTDH(String maDonHang) throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        String sql = "SELECT sanpham.TenSanPham, chitietdonhang.SoLuong, chitietdonhang.GiaTaiThoiDiem "
                + "from chitietdonhang JOIN sanpham on chitietdonhang.MaSanPham = sanpham.MaSanPham "
                + "WHERE MaDonHang = " + maDonHang;
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getDataTK(String ma) throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        String sql = "select * from donhang where " + ma;
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public int themDonHang(String maNV, String maKH, String tongTien) throws SQLException{
        Statement st = con.createStatement();
        String sql = "INSERT INTO `donhang`(`MaKhachHang`, `MaNhanVien`, `NgayDatHang`, `TongTien`) VALUES ('"+maKH+"','"+maNV+"', CURDATE(), "+tongTien+")";
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
