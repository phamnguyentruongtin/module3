package Model;

public class PhongTro {
    private int maThue;
    private String tenNguoiThue;
    private int sdt;
    private String ngayBatDau;
    private KieuThue kieuThue;
    private String ghiChu;

    public PhongTro(int maThue, String tenNguoiThue, int sdt, String ngayBatDau, KieuThue kieuThue, String ghiChu) {
        this.maThue = maThue;
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayBatDau = ngayBatDau;
        this.kieuThue = kieuThue;
        this.ghiChu = ghiChu;
    }

    public PhongTro(String tenNguoiThue, int sdt, String ngayBatDau, KieuThue kieuThue, String ghiChu) {
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayBatDau = ngayBatDau;
        this.kieuThue = kieuThue;
        this.ghiChu = ghiChu;
    }

    public PhongTro() {
    }

    public int getMaThue() {
        return maThue;
    }

    public void setMaThue(int maThue) {
        this.maThue = maThue;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public KieuThue getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(KieuThue kieuThue) {
        this.kieuThue = kieuThue;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
