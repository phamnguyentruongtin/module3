package Dao;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao implements IDao {

    private String url = "jdbc:mysql://localhost:3306/product";
    private String pass = "Tin@12tq";
    private String username = "root";

    private final String INSERT_PRODUCT = "insert into product(product_name,price_product,quantity_product,color_product,id_category) values (?,?,?,?,?)";
    private final String DELETE = "delete from product where id_product = ? ";
    private final String FIND_PRODUCT = "select * from product p,product.category c where p.id_category = c.id_category and id_product= ?";
    private final String UPDATE_PRODUCT = "update product set  product_name = ?, price_product = ?,quantity_product = ?,color_product = ?,id_category = ? where id_product = ?";
    private final String GET_ALL_PRODUCT = "select p.id_product,p.product_name,p.price_product,p.quantity_product,p.color_product,p.id_category,c.id_category,c.category_name from product.product p,product.category c where p.id_category = c.id_category ";
    private Connection connection;

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, pass);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Product product) throws SQLException {
        PreparedStatement preparedStatement =  getConnection().prepareStatement(INSERT_PRODUCT);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setInt(5, product.getCategory().getIdCategory());
        preparedStatement.executeUpdate();
        getConnection().close();
    }

    @Override
    public void remove(int id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        getConnection().close();
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> list = new ArrayList();
        PreparedStatement preparedStatement = getConnection().prepareStatement(GET_ALL_PRODUCT);
        ResultSet resultSet = preparedStatement.executeQuery();
        Category category;
        while (resultSet.next()) {
            Product product = new Product();
            product.setIdProduct(resultSet.getInt("id_product"));
            product.setProductName(resultSet.getString("product_name"));
            product.setPrice(resultSet.getDouble("price_product"));
            product.setQuantity(resultSet.getInt("quantity_product"));
            product.setColor(resultSet.getString("color_product"));
            product.setCategory(new Category(resultSet.getInt("id_category"), resultSet.getString("category_name")));
            list.add(product);
        }
        getConnection().close();
        resultSet.close();
        return list;
    }



    @Override
    public Product findProduct(int id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_PRODUCT);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Product product = new Product();
        Category c;
        while (rs.next()) {
            product.setIdProduct(rs.getInt(1));
            product.setProductName(rs.getString(2));
            product.setPrice(rs.getDouble(3));
            product.setQuantity(rs.getInt(4));
            product.setColor(rs.getString(5));
            product.setCategory(new Category(rs.getInt(7),rs.getString(8)));
        }
        getConnection().close();
        rs.close();
        return product;
    }

    @Override
    public void edit(Product product) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_PRODUCT);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setInt(5, product.getCategory().getIdCategory());
        preparedStatement.setInt(6, product.getIdProduct());
        preparedStatement.executeUpdate();

    }

    @Override
    public List <Category>findCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement("select id_category , category_name from category;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            Category ca = new Category(resultSet.getInt("id_category"),resultSet.getString("category_name"));
            categories.add(ca);
        }
        return categories;
    }
}
