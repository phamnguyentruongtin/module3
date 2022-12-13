package Repo;

import Model.Seafood;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDao {
    void save(Seafood seafood) throws SQLException;
    void delete(int id);

    void update(Seafood seafood) throws SQLException;
    List<Seafood> addAll() throws SQLException;
    Seafood searchByID(int id) throws SQLException;

}
