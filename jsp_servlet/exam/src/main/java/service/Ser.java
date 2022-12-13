package service;

import model.BenhAn;
import model.LyDo;
import repo.Dao;
import repo.IDao;

import java.sql.SQLException;
import java.util.List;

public class Ser implements ISer{
    IDao dao = new Dao();
    @Override
    public List<BenhAn> getALL() throws SQLException {
        List <BenhAn> dsBenhAn = dao.getALL();
        return dsBenhAn;
    }

    @Override
    public void edit(BenhAn benhAn) throws SQLException {
        dao.edit(benhAn);
    }

    @Override
    public void delete(String maBenhAn) throws SQLException {
        dao.delete(maBenhAn);
    }

    @Override
    public BenhAn findBenhAn(String maBenhAn) throws SQLException {
        BenhAn benhAn = dao.findBenhAn(maBenhAn);
        return benhAn;
    }

    @Override
    public List<LyDo> getLyDo() throws SQLException {
        List<LyDo> lyDo = dao.getLyDo();
        return lyDo;
    }
}
