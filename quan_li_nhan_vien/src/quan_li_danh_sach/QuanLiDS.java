package quan_li_danh_sach;

import data.*;
import entity.NhanVien;
import entity.NhanVienFullTime;
import entity.NhanVienPartTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLiDS implements IQuanLi {
    DocFile docFile = new DocFile();
    String pathFUll = "F:\\CODEGYM\\JSP_Servlet\\quan_li_nhan_vien\\src\\data\\luongFul.dat";
    String pathPart = "F:\\CODEGYM\\JSP_Servlet\\quan_li_nhan_vien\\src\\data\\luongPart.dat";
    String pathTotal = "F:\\CODEGYM\\JSP_Servlet\\quan_li_nhan_vien\\src\\data\\luong.csv";
     List<Double> luongListFull = docFile.readFileLuong(pathFUll);
     List<Double> luongListPart = docFile.readFileLuong(pathPart);
     List<Double> luongListTotal = docFile.readFileLuong(pathTotal);
    IDuLieuPartTime dlpt = new DuLieuPartTime();
    IDuLieuFullTime dlft = new DuLieuFullTime();
    Scanner sc = new Scanner(System.in);
    controller c = new controller();


    @Override
    public List<NhanVien> layDulieu() {
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        danhSachNhanVien.addAll(dlpt.findAll());
        danhSachNhanVien.addAll(dlft.findAll());
        return danhSachNhanVien;
    }

    @Override
    public void hienThiDsTong() {
        List<NhanVien> listTongNV = layDulieu();
        if (listTongNV.size() < 1) {
            System.out.println("Danh Sach Rong!!!");
        } else {
            for (NhanVien nv : listTongNV) {
                System.out.println(nv);
            }
        }
    }


    @Override
    public void hienThiDanhSachNhanVienPartTime() {
        List<NhanVienPartTime> nhanVienPartTimeList = dlpt.findAll();
        int size = nhanVienPartTimeList.size();
        if (size < 1) {
            System.out.println("Danh Sach Rong !!!!");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(nhanVienPartTimeList.get(i));
            }
        }
    }

    @Override
    public void hienThiDanhSachNhanVienFullTime() {
        List<NhanVienFullTime> nhanVienFullTimeList = dlft.findAll();
        if (dlft.findAll().size() < 1) {
            System.out.println("Danh Sach Rong !!!!");
        } else {
            for (int i = 0; i < dlft.findAll().size(); i++) {
                System.out.println(dlft.findAll().get(i));
            }
        }
    }

    @Override
    public void layThongTinVaLuu() {
        System.out.println("Nh???p M?? Nh??n Vi??n, T??n Nh??n Vi??n , S??? Ca l??m ");
        try {
            String maNv = sc.nextLine();
            String tenNv = sc.nextLine();
            int soCaLam = Integer.parseInt(sc.nextLine());
            if (c.chonChucNang1 == 1) {
                System.out.println("Chon loai ca " +
                        "1 S??ng " +
                        "2 Tr??a " +
                        "3 T???i ");
                String loaiCa = "";
                int selectCa = Integer.parseInt(sc.nextLine());
                switch (selectCa) {
                    case 1:
                        loaiCa = "S??ng";
                        break;
                    case 2:
                        loaiCa = "Tr??a";
                        break;
                    case 3:
                        loaiCa = "T???i";
                        break;
                    default:
                        loaiCa = "T???i";
                }
                double luong;
                if (loaiCa.equalsIgnoreCase("S??ng")) {
                    luong = 17000;
                } else if (loaiCa.equalsIgnoreCase("Tr??a")) {
                    luong = 15000;
                } else {
                    luong = 20000;
                }
                NhanVienPartTime nvpt = new NhanVienPartTime(maNv, tenNv, soCaLam, luong, loaiCa);
                dlpt.luuDuLieuPart(nvpt, false);
                luongListPart.add(nvpt.tinhLuong());
                luongListTotal.add(nvpt.tinhLuong());
                docFile.writeFileLuong(luongListPart,pathPart);
                docFile.writeFileLuong(luongListTotal,pathTotal);
            } else if (c.chonChucNang1 == 2) {
                int tienLuongThang13 = 2000000;
                double luong = 150000;
                NhanVienFullTime nvft = new NhanVienFullTime(maNv, tenNv, soCaLam, luong, tienLuongThang13);
                dlft.luuDuLieuFull(nvft, false);
                luongListFull.add(nvft.tinhLuong());
                luongListTotal.add(nvft.tinhLuong());
                docFile.writeFileLuong(luongListFull,pathFUll);
                docFile.writeFileLuong(luongListTotal,pathTotal);

            }


        } catch (Exception e) {
            System.err.println("nh???p sai ?????nh D???ng");
            ;
        }
    }

    @Override
    public void layThongTinVaXoa() {
        List<NhanVien> listTongNhanVien = layDulieu();
        try {
            System.out.println("Nh???p M?? Nh??n Vi??n C???a Nh??n Vi??n b???n Mu???n x??a");
            String maNvRemove = sc.nextLine();
            if (c.chonChucNang3 == 1) {
                NhanVienPartTime nvpt = dlpt.findByMaNVPart(maNvRemove);
                if (maNvRemove.equalsIgnoreCase(nvpt.getMaNV())) {
                    dlpt.xoaDuLieuPart(nvpt);
                    luongListPart.remove(nvpt.tinhLuong());
                    listTongNhanVien.remove(nvpt);
                    System.out.println("x??a Th??nh C??ng");
                    luongListTotal.remove(nvpt.tinhLuong());
                    docFile.writeFileLuong(luongListPart,pathPart);
                    docFile.writeFileLuong(luongListTotal,pathTotal);
                }
            } else {
                NhanVienFullTime nvft = dlft.findByMaNVFull(maNvRemove);
                if (maNvRemove.equalsIgnoreCase(nvft.getMaNV())) {
                    dlft.xoaDuLieuFull(nvft);
                    luongListFull.remove(nvft.tinhLuong());
                    listTongNhanVien.remove(nvft);
                    luongListTotal.remove(nvft.tinhLuong());
                    System.out.println("x??a Th??nh C??ng");
                    docFile.writeFileLuong(luongListFull,pathFUll);
                    docFile.writeFileLuong(luongListTotal,pathTotal);
                }
            }
        } catch (Exception e) {
            System.err.println("kh??ng t??m nh??n vi??n c???n t??m");
        }
    }

    @Override
    public void timThongTinBangTenFul() {
        System.out.println("Nh???p MaNv B???n Mu???n T??m : ");
        String name = sc.nextLine();
        NhanVienFullTime nvft = dlft.findByMaNVFull(name);
        System.out.println(nvft);
    }


    @Override
    public void timThongTinBangTenPar() {
        System.out.println("Nh???p MaNv B???n Mu???n T??m : ");
        String name = sc.nextLine();
        NhanVienPartTime nvpt = dlpt.findByMaNVPart(name);
        System.out.println(nvpt);

    }

    @Override
    public void tongLuongPartTime() {
        double luongTongPart = 0;
        System.out.println(luongListPart);
        for (int i = 0; i < luongListPart.size(); i++) {
            luongTongPart += luongListPart.get(i);
        }
        System.out.println("T???ng L????ng Th??ng NV PartTime Th??ng N??y " + luongTongPart);
    }

    @Override
    public void tongLuongFullTime() {
        double luongTongFul = 0;
        System.out.println(luongListFull);
        for (int i = 0; i < luongListFull.size() ; i++) {
            luongTongFul += luongListFull.get(i);
        }
        System.out.println("T???ng L????ng Th??ng NV FullTime Th??ng N??y " + luongTongFul);
    }


    @Override
    public void layThongTinVaCapNhap() {
        try {
            List<NhanVien> listTongNhanVien = layDulieu();
            String manvEdit;
            if (c.chonChucNang2 == 1) {
                System.out.println("Nh???p M?? Nh??n Vi??n C???a Nh??n Vi??n B???n Mu???n S???a ");
                manvEdit = sc.nextLine();
                NhanVienFullTime nvft = dlft.findByMaNVFull(manvEdit);
                if (manvEdit.equalsIgnoreCase(nvft.getMaNV())) {
                    System.out.println("Nh???p M?? Nh??n Vi??n, T??n Nh??n Vi??n , S??? Ca l??m ");
                    String maNv = sc.nextLine();
                    String tenNv = sc.nextLine();
                    int soCaLam = Integer.parseInt(sc.nextLine());
                    int tienLuongThang13 = 2000000;
                    double luong = 150000;
                    NhanVienFullTime nvft1 = new NhanVienFullTime(maNv, tenNv, soCaLam, luong, tienLuongThang13);
                    dlft.luuDuLieuFull(nvft1, true);
                    listTongNhanVien.set(listTongNhanVien.indexOf(manvEdit), nvft1);
                    System.out.println("C???p Nh???p Th??nh C??ng");
                }
            } else {
                System.out.println("Nh???p M?? Nh??n Vi??n C???a Nh??n Vi??n B???n Mu???n S???a ");
                manvEdit = sc.nextLine();
                NhanVienPartTime nvpt = dlpt.findByMaNVPart(manvEdit);
                if (manvEdit.equalsIgnoreCase(nvpt.getMaNV())) {
                    System.out.println("Nh???p M?? Nh??n Vi??n, T??n Nh??n Vi??n , S??? Ca l??m ");
                    String maNv = sc.nextLine();
                    String tenNv = sc.nextLine();
                    int soCaLam = Integer.parseInt(sc.nextLine());
                    if (c.chonChucNang2 == 2) {
                        System.out.println("Chon loai ca " +
                                "1 S??ng " +
                                "2 Tr??a " +
                                "3 T???i ");
                        String loaiCa = "";
                        int selectCa = Integer.parseInt(sc.nextLine());
                        switch (selectCa) {
                            case 1:
                                loaiCa = "S??ng";
                                break;
                            case 2:
                                loaiCa = "Tr??a";
                                break;
                            case 3:
                                loaiCa = "T???i";
                                break;
                            default:
                                loaiCa = "T???i";
                        }
                        double luong;
                        if (loaiCa.equalsIgnoreCase("S??ng")) {
                            luong = 17000;
                        } else if (loaiCa.equalsIgnoreCase("Tr??a")) {
                            luong = 15000;
                        } else {
                            luong = 20000;
                        }
                        NhanVienPartTime nvpt1 = new NhanVienPartTime(maNv, tenNv, soCaLam, luong, loaiCa);
                        dlpt.luuDuLieuPart(nvpt1, true);
                        listTongNhanVien.set(listTongNhanVien.indexOf(manvEdit), nvpt1);
                        System.out.println("C???p Nh???p Th??nh C??ng");
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Nh???p Sai!!!");
        }

    }

    @Override
    public void tongLuongNhanVien() {
        List<Double> luongListTong = luongListTotal;
        double luongTongNhanVien = 0;
        System.out.println(luongListTong);
        for (int i = 0; i < luongListTong.size(); i++) {
            luongTongNhanVien += luongListTong.get(i);
        }
        System.out.println("T???ng L????ng Ph???i Tr??? Cho To??n B??? Nh??n Vi??n Th??ng N??y L?? " + luongTongNhanVien);
    }
}