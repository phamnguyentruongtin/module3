package quan_li_danh_sach;

import data.DuLieuFullTime;
import data.DuLieuPartTime;
import data.IDuLieuFullTime;
import data.IDuLieuPartTime;
import entity.NhanVien;

import java.util.List;

public interface IQuanLi {
    IDuLieuPartTime dlpt = new DuLieuPartTime();
    IDuLieuFullTime dlft = new DuLieuFullTime();
    List<NhanVien> layDulieu();

    void hienThiDsTong();

    void hienThiDanhSachNhanVienPartTime();

    void hienThiDanhSachNhanVienFullTime();

    void layThongTinVaLuu();

    void layThongTinVaXoa();

    void timThongTinBangTenFul();
    void timThongTinBangTenPar();

    void tongLuongPartTime();

    void tongLuongFullTime();
    void layThongTinVaCapNhap();

    void tongLuongNhanVien();


}
