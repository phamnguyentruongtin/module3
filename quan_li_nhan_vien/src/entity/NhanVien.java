package entity;

import java.util.Objects;

public abstract class NhanVien implements INhanVien {
    private String maNV;
    private String tenNV;
    private int soCaLam;
    private double luong;


    public NhanVien(String maNV, String tenNV, int soCaLam, double luong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soCaLam = soCaLam;
        this.luong = luong;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getSoCaLam() {
        return soCaLam;
    }

    public void setSoCaLam(int soCaLam) {
        this.soCaLam = soCaLam;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhanVien)) return false;
        NhanVien nhanVien = (NhanVien) o;
        return Objects.equals(getMaNV(), nhanVien.getMaNV());
    }


    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", soCaLam=" + soCaLam +
                ", luong=" + luong +
                '}';
    }

}
