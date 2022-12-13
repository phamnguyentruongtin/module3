package Service;

import Model.KieuThue;
import Model.PhongTro;

import java.sql.SQLException;
import java.util.List;

public interface ISer {
    List<PhongTro> layDS() throws SQLException;
    void them(PhongTro pt) throws SQLException;
    PhongTro timKiem(String tenNguoiThue) throws SQLException;
    List<KieuThue> layDsKieuThue() throws SQLException;
    void xoa(int id) throws SQLException;
}
