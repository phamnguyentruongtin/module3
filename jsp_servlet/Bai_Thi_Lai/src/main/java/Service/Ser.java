package Service;

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
        return kieuThues ;
    }

    @Override
    public void xoa(int id) throws SQLException {
        repo.xoa(id);
    }
}
