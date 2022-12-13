package Dao;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IDao {
    void add(Product product) throws SQLException;
    void remove(int id) throws SQLException;
    List<Product> getAll() throws SQLException;
    Product findProduct(int id) throws SQLException;
    void edit(Product product) throws SQLException;
   List<Category> findCategory() throws SQLException;

}
