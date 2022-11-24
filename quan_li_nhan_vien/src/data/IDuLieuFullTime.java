package data;

import entity.NhanVien;
import entity.NhanVienFullTime;

import java.util.ArrayList;
import java.util.List;

public interface IDuLieuFullTime {
   List<NhanVienFullTime> findAll();

    void luuDuLieuFull(NhanVienFullTime nv,boolean isEdit);

    void xoaDuLieuFull(NhanVienFullTime nv);

    NhanVienFullTime findByMaNVFull(String maNV);


}
