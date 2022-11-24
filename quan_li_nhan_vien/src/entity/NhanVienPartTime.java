package entity;


import java.io.Serializable;

public class NhanVienPartTime extends NhanVien implements Serializable {
    private static final long serialVersionUID = 5l;
    private String loaiCa;

    public NhanVienPartTime() {
    }

    public NhanVienPartTime(String maNV, String tenNV, int soCaLam, double luong, String loaiCa) {
        super(maNV, tenNV, soCaLam, luong);
        this.loaiCa = loaiCa;
    }

    public String getLoaiCa() {
        return loaiCa;
    }

    public void setLoaiCa(String loaiCa) {
        this.loaiCa = loaiCa;
    }

    @Override
    public double tinhLuong() {

        if (this.loaiCa.equalsIgnoreCase("Sáng")) {
            double tienLuong = this.getSoCaLam() * 17000;
            return tienLuong;
        } else if (this.loaiCa.equalsIgnoreCase("Trưa")) {
            double tienLuong = this.getSoCaLam() * 15000;
            return tienLuong;
        } else if (this.loaiCa.equalsIgnoreCase("Tối")) {
            double tienLuong = this.getSoCaLam() * 20000;
            return tienLuong;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "NhanVienPartTime{" +
                "loaiCa='" + loaiCa + '\'' +
                "} " + super.toString()
                +"Tổng lương là " + tinhLuong();

    }


}
