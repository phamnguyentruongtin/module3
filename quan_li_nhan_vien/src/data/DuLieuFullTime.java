package data;

import entity.NhanVienFullTime;

import java.util.List;

public class DuLieuFullTime implements IDuLieuFullTime {

    String path = "F:\\CODEGYM\\JSP_Servlet\\quan_li_nhan_vien\\src\\data\\NhanVienFull.dat";
    public  List<NhanVienFullTime> nhanVienFullTimeList = DocFile.readFileNvFt(path);
    @Override
    public List<NhanVienFullTime> findAll() {
        return nhanVienFullTimeList;
    }

    @Override
    public void luuDuLieuFull(NhanVienFullTime nv,boolean isEdit) {
        if (isEdit) {
            int index = nhanVienFullTimeList.indexOf(nv);
           nhanVienFullTimeList.set(index, nv);
           DocFile.writeFileNvFt(nhanVienFullTimeList,path);
        } else {
            nhanVienFullTimeList.add(nv);
            DocFile.writeFileNvFt(nhanVienFullTimeList,path);
        }
    }

    @Override
    public void xoaDuLieuFull(NhanVienFullTime nv) {
        nhanVienFullTimeList.remove(nv);
        DocFile.writeFileNvFt(nhanVienFullTimeList,path);
    }

    @Override
    public NhanVienFullTime findByMaNVFull(String maNV) {
        return nhanVienFullTimeList.stream().filter(e-> e.getMaNV().equalsIgnoreCase(maNV)).findFirst().get();
    }


    }
