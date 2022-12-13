package Ser;

import Model.Seafood;
import Repo.Dao;
import Repo.IDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Services implements IServices {
    IDao dao = new Dao();

    @Override
    public void save(Seafood seafood) {
        try {
            dao.save(seafood);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<Seafood> allALL() {
        List<Seafood> seafoodList = new ArrayList<>();
        try {
            seafoodList = dao.addAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seafoodList;

    }

    @Override
    public Seafood searchById(int id) throws SQLException {
        Seafood s ;
        return s = dao.searchByID(id);
    }

    @Override
    public void update( Seafood seafood) throws SQLException {
        dao.update(seafood);
    }
}
