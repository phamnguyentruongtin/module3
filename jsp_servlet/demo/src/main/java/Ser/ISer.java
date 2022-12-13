package Ser;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ISer {
    void add(Product product) throws SQLException;
    void edit(Product product) throws SQLException;
    void remove(int id) throws SQLException;
    List<Product> getAll () throws SQLException;
    Product findById(int id) throws SQLException;
    List<Category> findCategory() throws SQLException;

}
