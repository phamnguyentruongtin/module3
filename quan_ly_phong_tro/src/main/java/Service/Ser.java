package Service;

import Model.ChuTro;
import Model.KieuThue;
import Model.PhongTro;
import Repo.IRepo;
import Repo.Repo;

import java.sql.SQLException;
import java.util.List;

public class Ser implements ISer {
    IRepo repo = new Repo();

    @Override
    public List<PhongTro> layDS() throws SQLException {
        List<PhongTro> dsPhongTro = repo.layDS();
        return dsPhongTro;
    }

    @Override
    public void them(PhongTro pt) throws SQLException {
        repo.them(pt);
    }

    @Override
    public PhongTro timKiem(String tenNguoiThue) throws SQLException {
        PhongTro pt = repo.timKiem(tenNguoiThue);
        return pt;
    }

    @Override
    public List<KieuThue> layDsKieuThue() throws SQLException {
        List<KieuThue> kieuThues = repo.layDsKieuThue();
        return kieuThues;
    }

    @Override
    public void xoa(int id) throws SQLException {
        repo.xoa(id);
    }

    @Override
    public Boolean getLogin(ChuTro chuTro) throws SQLException {
        boolean flag = false;
        List<ChuTro> chuTroList = repo.getLogin();
        for (ChuTro chuTro1 : chuTroList) {
            if (chuTro1.getUserName().equals(chuTro.getUserName()) && chuTro1.getPassword().equals(chuTro.getPassword())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void ThemChuTro(ChuTro chuTro) throws SQLException {
        repo.addChutro(chuTro);
    }
}
