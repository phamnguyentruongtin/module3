package service;

import model.BenhAn;
import model.LyDo;

import java.sql.SQLException;
import java.util.List;

public interface ISer {
    List<BenhAn> getALL() throws SQLException;
    void edit(BenhAn benhAn) throws SQLException;
    void delete (String maBenhAn) throws SQLException;
    BenhAn findBenhAn(String maBenhAn) throws SQLException;
    List<LyDo> getLyDo() throws SQLException;


}
