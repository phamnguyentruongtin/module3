package entity;

import java.io.Serializable;

public class NhanVienFullTime extends NhanVien implements Serializable {
   private static final long serialVersionUID = 4l;
    private int tienThuongThang13;

    public NhanVienFullTime(String maNV, String tenNV, int soCaLam, double luong, int tienThuongThang13) {
        super(maNV, tenNV, soCaLam, luong);
        this.tienThuongThang13 = tienThuongThang13;
    }

    public int getTienThuong() {
        return tienThuongThang13;
    }

    public void setTienThuong(int tienThuong) {
        this.tienThuongThang13 = tienThuong;
    }

    public NhanVienFullTime() {
    }

    @Override
    public double tinhLuong() {
        if(this.getSoCaLam()>10){
          double tienLuong = this.getSoCaLam() * this.getLuong()+this.tienThuongThang13;
            return tienLuong;
        }else {
          double tienLuong = this.getSoCaLam() * this.getLuong();
            return tienLuong;
        }

    }

    @Override
    public String toString() {
        return "NhanVienFullTime{" +
                "tienThuong=" + tienThuongThang13 +
                "} " + super.toString()
                +"Tổng lương là " + tinhLuong();

    }


}
