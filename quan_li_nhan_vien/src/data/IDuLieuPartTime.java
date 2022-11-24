package data;

import entity.NhanVien;
import entity.NhanVienPartTime;

import java.util.ArrayList;
import java.util.List;

public interface IDuLieuPartTime {
    void luuDuLieuPart(NhanVienPartTime nv, boolean isEdit);

    void xoaDuLieuPart(NhanVienPartTime nv);

    NhanVienPartTime findByMaNVPart(String maNV);

    List<NhanVienPartTime> findAll();
}
