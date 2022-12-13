package Ser;

import Model.Seafood;
import Repo.Dao;
import Repo.IDao;

import java.sql.SQLException;
import java.util.List;

public interface IServices {
    IDao dao = new Dao();
    void save(Seafood seafood);
    void delete(int id);
    List<Seafood> allALL();
    Seafood searchById(int id) throws SQLException;

    void update(Seafood seafood) throws SQLException;
}
