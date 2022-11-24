package data;

import entity.NhanVienPartTime;

import java.util.List;

public class DuLieuPartTime implements IDuLieuPartTime{
    String path = "F:\\CODEGYM\\JSP_Servlet\\quan_li_nhan_vien\\src\\data\\NhanVienPart.dat";
    public List<NhanVienPartTime> nhanVienPartTimeList= DocFile.readFileNvPt(path);
    @Override
    public void luuDuLieuPart(NhanVienPartTime nv, boolean isEdit) {
        if (isEdit) {
            int index = nhanVienPartTimeList.indexOf(nv);
            nhanVienPartTimeList.set(index, nv);
            DocFile.writeFileNvPt(nhanVienPartTimeList,path);
        } else {
            nhanVienPartTimeList.add(nv);
            DocFile.writeFileNvPt(nhanVienPartTimeList,path);
        }
    }

    public List<NhanVienPartTime> findAll(){
        return nhanVienPartTimeList;
    }

    @Override
    public void xoaDuLieuPart(NhanVienPartTime nv) {
        nhanVienPartTimeList.remove(nv);
        DocFile.writeFileNvPt(nhanVienPartTimeList,path);
    }

    @Override
    public NhanVienPartTime findByMaNVPart(String maNV) {
        return nhanVienPartTimeList.stream().filter(e-> e.getMaNV().equalsIgnoreCase(maNV)).findFirst().get();
    }

}
