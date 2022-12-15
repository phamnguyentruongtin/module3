package Repo;

import Model.ChuTro;
import Model.KieuThue;
import Model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repo implements IRepo {
    private String pass = "Tin@12tq";
    private String username = "root";
    private String url = "jdbc:mysql://localhost:3306/thilai";
    private static final String GET_ALL = "select * from phong_tro p,hinh_thuc h where p.id_hinh_thuc = h.id_hinh_thuc ";
    private static final String FIND = "select * from phong_tro p,hinh_thuc h where p.id_hinh_thuc = h.id_hinh_thuc and ten_nguoi_thue = ?";
    private static final String DELETE = "delete from  phong_tro where ma_phong_tro = ? ";
    private static final String GET_KIEU = "select * from hinh_thuc";
    private static final String SAVE = "  insert into phong_tro(ten_nguoi_thue,sdt,ngay_bat_dau_thue,id_hinh_thuc,ghi_chu) values(?,?,?,?,?) ";

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
    public List<PhongTro> layDS() throws SQLException {
        List<PhongTro> dsPhongTro = new ArrayList<PhongTro>();
        PreparedStatement prepareStatement = getConnection().prepareStatement(GET_ALL);
        ResultSet result = prepareStatement.executeQuery();
        while (result.next()) {
            PhongTro phongTro = new PhongTro();
            phongTro.setMaThue(result.getInt("ma_phong_tro"));
            phongTro.setTenNguoiThue(result.getString("ten_nguoi_thue"));
            phongTro.setSdt(result.getInt("sdt"));
            phongTro.setNgayBatDau(result.getString("ngay_bat_dau_thue"));
            KieuThue kt = new KieuThue();
            kt.setId_kieuThue(result.getInt("id_hinh_thuc"));
            kt.setKieuThue(result.getString("hinh_thuc"));
            phongTro.setKieuThue(kt);
            phongTro.setGhiChu(result.getString("ghi_chu"));
            dsPhongTro.add(phongTro);
        }
        result.close();
        getConnection().close();
        return dsPhongTro;
    }

    @Override
    public void them(PhongTro pt) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(SAVE);
        preparedStatement.setString(1, pt.getTenNguoiThue());
        preparedStatement.setInt(2, pt.getSdt());
        preparedStatement.setString(3, pt.getNgayBatDau());
        preparedStatement.setInt(4, pt.getKieuThue().getId_kieuThue());
        preparedStatement.setString(5, pt.getGhiChu());
        preparedStatement.executeUpdate();
        getConnection().close();
    }

    @Override
    public PhongTro timKiem(String tenNguoiThue) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(FIND);
        preparedStatement.setString(1, tenNguoiThue);
        ResultSet result = preparedStatement.executeQuery();
        PhongTro phongTro = new PhongTro();
        while (result.next()) {
            phongTro.setMaThue(result.getInt("ma_phong_tro"));
            phongTro.setTenNguoiThue(result.getString("ten_nguoi_thue"));
            phongTro.setSdt(result.getInt("sdt"));
            phongTro.setNgayBatDau(result.getString("ngay_bat_dau_thue"));
            KieuThue kt = new KieuThue();
            kt.setId_kieuThue(result.getInt("id_hinh_thuc"));
            kt.setKieuThue(result.getString("hinh_thuc"));
            phongTro.setKieuThue(kt);
            phongTro.setGhiChu(result.getString("ghi_chu"));
        }
        result.close();
        getConnection().close();
        return phongTro;
    }

    @Override
    public List<KieuThue> layDsKieuThue() throws SQLException {
        List<KieuThue> kieuThues = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(GET_KIEU);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            KieuThue kieuThue = new KieuThue();
            kieuThue.setId_kieuThue(rs.getInt("id_hinh_thuc"));
            kieuThue.setKieuThue(rs.getString("hinh_thuc"));
            kieuThues.add(kieuThue);
        }
        rs.close();
        getConnection().close();
        return kieuThues;
    }

    @Override
    public void xoa(int id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        getConnection().close();

    }

    @Override
    public List<ChuTro> getLogin() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("select * from admin");
        ResultSet rs = preparedStatement.executeQuery();
        List<ChuTro> chuTroList = new ArrayList();
        while (rs.next()) {
            ChuTro chuTro = new ChuTro();
            chuTro.setUserName(rs.getString("user_name"));
            chuTro.setPassword(rs.getString("pass"));
            chuTroList.add(chuTro);
        }
        getConnection().close();
        return chuTroList;
    }

    @Override
    public void addChutro(ChuTro chutro) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("insert into admin (user_name,pass) values (?,?)");
        preparedStatement.setString(1, chutro.getUserName());
        preparedStatement.setString(2, chutro.getPassword());
        preparedStatement.executeUpdate();
        getConnection().close();

    }
}
