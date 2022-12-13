package model;

public class BenhAn {
    private int STT;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayVaoVien;
    private String ngayRaVien;
    private LyDo lyDo;

    public BenhAn(String tenBenhNhan, String ngayVaoVien, String ngayRaVien) {
        this.tenBenhNhan = tenBenhNhan;
        this.ngayVaoVien = ngayVaoVien;
        this.ngayRaVien = ngayRaVien;
    }

    public BenhAn(String tenBenhNhan, String ngayVaoVien, String ngayRaVien, LyDo lyDo) {
        this.tenBenhNhan = tenBenhNhan;
        this.ngayVaoVien = ngayVaoVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
    }

    public BenhAn(int STT, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayVaoVien, String ngayRaVien, LyDo lyDo) {
        this.STT = STT;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayVaoVien = ngayVaoVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
    }

    public BenhAn(int STT, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayVaoVien, String ngayRaVien) {
        this.STT = STT;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayVaoVien = ngayVaoVien;
        this.ngayRaVien = ngayRaVien;
    }

    public BenhAn(String maBenhAn, String tenBenhNhan, String ngayVaoVien, String ngayRaVien, LyDo lyDo) {
        this.maBenhAn = maBenhAn;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayVaoVien = ngayVaoVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public BenhAn() {
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayVaoVien() {
        return ngayVaoVien;
    }

    public void setNgayVaoVien(String ngayVaoVien) {
        this.ngayVaoVien = ngayVaoVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public LyDo getLyDo() {
        return lyDo;
    }

    public void setLyDo(LyDo lyDo) {
        this.lyDo = lyDo;
    }
}
