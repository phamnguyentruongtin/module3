package quan_li_danh_sach;

import java.util.Scanner;

public class controller {
    private static IQuanLi ql = new QuanLiDS();
    static Scanner sc = new Scanner(System.in);

    private static int chonMain;
    static int chonChucNang1;
    static int chonChucNang2;
    static int chonChucNang3;
    static int chonChucNang4;
    static int chonChucNang5;
    static int chonChucNang6;


    public static void main(String[] args) {
        do {
            System.out.println("----Quan Lí Nhân Viên----");
            System.out.println("1 Thêm Nhân Viên");
            System.out.println("2 Cập Nhập Nhân Viên");
            System.out.println("3 Xóa Nhân Viên");
            System.out.println("4 Tìm Nhân Viên ");
            System.out.println("5 Hiển Thị Danh Sách");
            System.out.println("6 Tính Lương Tổng Của Tất Cả Nhân Viên Tháng Này");
            System.out.println("7 Exit !!!");
            try {
                chonMain = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("vui long nhap lai !!!");
                chonMain = Integer.parseInt(sc.nextLine());
            }
            boolean backToMenu1;
            switch (chonMain) {
                case 1:
                    do {
                        backToMenu1 = true;
                        System.out.println("1 Thêm Nhân Viên PartTime");
                        System.out.println("2 Thêm Nhân Viên FullTime");
                        System.out.println("3 Trở Về Trang Chủ");
                        chonChucNang1 = Integer.parseInt(sc.nextLine());
                        switch (chonChucNang1) {
                            case 1:
                                ql.layThongTinVaLuu();
                                break;
                            case 2:
                                ql.layThongTinVaLuu();
                                break;
                            case 3:
                                backToMenu1 = false;
                                break;
                            default:
                                System.out.println("Vui Lòng Chọn Đúng !!!");
                        }
                    } while (backToMenu1);
                    break;
                case 2:
                    backToMenu1 = true;
                    do {
                        System.out.println("1 Cập Nhập Thông Tin Nhân viên FullTime");
                        System.out.println("2 Cập Nhập Thông Tin Nhân viên PartTime");
                        System.out.println("3 Trở Về Trang Chủ");
                        chonChucNang2 = Integer.parseInt(sc.nextLine());
                        switch (chonChucNang2) {
                            case 1:
                                try {
                                    ql.hienThiDanhSachNhanVienFullTime();
                                    ql.layThongTinVaCapNhap();

                                    break;
                                } catch (Exception e) {

                                }
                            case 2:
                                try {
                                    ql.tongLuongPartTime();
                                    ql.layThongTinVaCapNhap();

                                    break;
                                } catch (Exception e) {

                                }
                            case 3:
                                backToMenu1 = false;
                                break;
                            default:
                                System.out.println("Vui Lòng Chọn Đúng !!!");
                        }
                    } while (backToMenu1);
                    break;
                case 3:
                    backToMenu1 = true;
                    do {
                        System.out.println("1 Xóa Nhân Viên PartTime");
                        System.out.println("2 Xóa Nhân Vien FullTime");
                        System.out.println("3 Trở Về Trang Chủ");
                        chonChucNang3 = Integer.parseInt(sc.nextLine());
                        switch (chonChucNang3) {
                            case 1:
                                ql.hienThiDanhSachNhanVienPartTime();
                                ql.layThongTinVaXoa();
                                break;
                            case 2:
                                ql.hienThiDanhSachNhanVienFullTime();
                                ql.layThongTinVaXoa();
                                break;
                            case 3:
                                backToMenu1 = false;
                                break;
                            default:
                                System.out.println("Vui Lòng Chọn Đúng !!!");
                        }
                    } while (backToMenu1);
                    break;
                case 4:
                    backToMenu1 = true;
                    do {
                        System.out.println("1 Tìm Nhân Viên PartTime \n" +
                                "2 Tìm Nhân Vien FullTime \n" +
                                "3 Trở Về Trang Chủ \n");
                        chonChucNang4 = Integer.parseInt(sc.nextLine());
                        switch (chonChucNang4) {
                            case 1:
                                ql.hienThiDanhSachNhanVienPartTime();
                                ql.timThongTinBangTenPar();
                                break;
                            case 2:
                                ql.hienThiDanhSachNhanVienFullTime();
                                ql.timThongTinBangTenFul();
                                break;
                            case 3:
                                backToMenu1 = false;
                                break;
                            default:
                                System.out.println("Vui Lòng Chọn Đúng !!!");
                        }
                    } while (backToMenu1);
                    break;
                case 5:
                    boolean backTomenu6 = true;
                    do {
                        System.out.println("1 Hiển Thị Danh Sách Tổng \n" +
                                "2 Hiển thị Danh Sách PartTime \n" +
                                "3 Hiển thị Danh Sách FullTime \n" +
                                "4 Trở Về Trang Chủ");
                        chonChucNang6 = Integer.parseInt(sc.nextLine());
                        switch (chonChucNang6) {
                            case 1:
                                ql.hienThiDsTong();
                                break;
                            case 2:
                                ql.hienThiDanhSachNhanVienPartTime();
                                break;
                            case 3:
                                ql.hienThiDanhSachNhanVienFullTime();
                                break;
                            case 4:
                                backTomenu6 = false;
                                break;
                            default:
                                System.out.println("Vui Lòng Chọn Đúng !!!");
                        }
                    } while (backTomenu6);
                    break;
                case 6:
                    backToMenu1 = true;
                    do {
                        System.out.println("1 Tổng Lương Tất Cả Nhân Viên \n" +
                                "2 Tổng Lương Nhân Viên FullTine \n" +
                                "3 Tổng Lương Nhân Viên PartTine \n" +
                                "4 Trở Về Trang Chủ \n");
                        chonChucNang5 = Integer.parseInt(sc.nextLine());
                        switch (chonChucNang5) {
                            case 1:
                                ql.tongLuongNhanVien();
                                break;
                            case 2:
                                ql.tongLuongFullTime();
                                break;
                            case 3:
                                ql.tongLuongPartTime();
                                break;
                            case 4:
                                backToMenu1 = false;
                                break;
                            default:
                                System.out.println("Vui Lòng Chọn Đúng !!!");
                        }
                    } while (backToMenu1);
                    break;
                case 7:
                    System.out.println("Thank For Use <3");
                    System.exit(chonMain);
                default:
                    System.out.println("Vui Lòng Chọn Đúng Chức Năng !!!");
            }
        } while (true);
    }
}