package Repo;

import Model.Seafood;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao implements IDao {
    private String url = "jdbc:mysql://localhost:3306/seafood";
    private String pass = "Tin@12tq";
    private String username = "root";
    private final String INSERT_SEAFOOD = "insert into seafood (id_seafood,name_seafood,amount_seafood,price) values(?,?,?,?)";

    private final String FIND_BY_ID = "select * from seafood where id_seafood = ?";
    private final String getALL = "select * from seafood ";

    private final String DELETE = "delete from seafood where id_seafood = ?";
    private final String UPDATE = "update seafood set name_seafood = ?, amount_seafood = ?, price = ? where id_seafood = ?";
    private Connection connection;

    public Connection getConnection() {
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
    public void save(Seafood seafood) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SEAFOOD);
        preparedStatement.setInt(1, seafood.getId());
        preparedStatement.setString(2, seafood.getName());
        preparedStatement.setInt(3, seafood.getAmount());
        preparedStatement.setDouble(4, seafood.getPrice());
        preparedStatement.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(int id) {
        try(Connection conn = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Seafood seafood) throws SQLException {
        Connection c = getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(UPDATE);
        preparedStatement.setString(1,seafood.getName());
        preparedStatement.setInt(2,seafood.getAmount());
        preparedStatement.setDouble(3,seafood.getPrice());
        preparedStatement.setInt(4,seafood.getId());
        preparedStatement.executeUpdate();
        c.close();
    }

    @Override
    public List<Seafood> addAll() throws SQLException {
        List<Seafood> listSeafoods = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(getALL);
        ResultSet resultSet = statement.executeQuery();
        Seafood seafood;
        while (resultSet.next()) {
            seafood = new Seafood();
            seafood.setId(resultSet.getInt(1));
            seafood.setName(resultSet.getString(2));
            seafood.setAmount(resultSet.getInt(3));
            seafood.setPrice(resultSet.getDouble(4));
            listSeafoods.add(seafood);
        }
        connection.close();
        resultSet.close();
        return listSeafoods;
    }

    @Override
    public Seafood searchByID(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Seafood s = null;
        while (resultSet.next()) {
             id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int amount = resultSet.getInt(3);
            double price = resultSet.getDouble(4);
            s = new Seafood(id, name, amount, price);
        }
        resultSet.close();
        return s;
    }
}
