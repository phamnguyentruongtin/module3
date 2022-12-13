package Ser;

import Dao.Dao;
import Dao.IDao;
import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ser implements ISer{
    IDao dao = new Dao();
    @Override
    public void add(Product product) throws SQLException {
        dao.add(product);
    }

    @Override
    public void edit(Product product) throws SQLException {
        dao.edit(product);
    }

    @Override
    public void remove(int id) throws SQLException {
        dao.remove(id);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> list;
         list = dao.getAll();
         return list;
    }

    @Override
    public Product findById(int id) throws SQLException {
        Product product = dao.findProduct(id);
        return product;
    }
    public List<Category> findCategory() throws SQLException {
        List<Category> category = dao.findCategory();
        return category;
    }
}
