
package Model;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private double gia;
    private int soLuong;

    public SanPham(){
    }
    
    public SanPham(String maSanPham, String tenSanPham, double gia, int soLuong) {
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }
}
