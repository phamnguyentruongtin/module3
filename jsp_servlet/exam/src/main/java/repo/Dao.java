package repo;

import model.BenhAn;
import model.LyDo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao implements IDao {
    private String pass = "Tin@12tq";
    private String username = "root";
    private String url = "jdbc:mysql://localhost:3306/exam";

    private static final String GET_ALL = "select * from benh_an b,ly_do_nhap_vien l where b.id_ly_do = l.id_ly_do";

    private static final String GET_ALL_LY_DO = "   select * from ly_do_nhap_vien";

    private static final String FIND_BENH_AN = "select * from benh_an b,ly_do_nhap_vien l where b.id_ly_do = l.id_ly_do and ma_benh_an = ?";

    private static final String DELETE = "delete from benh_an where ma_benh_an = ?";

    private static final String UPDATE = "update benh_an set ten_benh_nhan = ?,ngay_nhap_vien = ?,ngay_ra_vien= ?,id_ly_do=? where ma_benh_an= ?";
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
    public List<BenhAn> getALL() throws SQLException {
        List<BenhAn> danhSachBenhAn = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(GET_ALL);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            int STT =result.getInt("stt");
            String maBenhAn = result.getString("ma_benh_an");
            String maBenhNhan = result.getString("ma_benh_nhan");
            String tenBenhNhan = result.getString("ten_benh_nhan");
            String ngayVaoVien = String.valueOf(result.getDate("ngay_nhap_vien"));
            String ngayRaVien = String.valueOf(result.getDate("ngay_ra_vien"));
            LyDo lyDo = new LyDo(result.getInt("id_ly_do"), result.getString("ly_do"));
            BenhAn benhAn = new BenhAn(STT,maBenhAn, maBenhNhan, tenBenhNhan, ngayVaoVien, ngayRaVien, lyDo);
            danhSachBenhAn.add(benhAn);
        }
        result.close();
        getConnection().close();
        return danhSachBenhAn;
    }

    @Override
    public BenhAn findBenhAn(String maBenhAn) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BENH_AN);
        preparedStatement.setString(1, maBenhAn);
        ResultSet result = preparedStatement.executeQuery();
        BenhAn benhAn = new BenhAn();
        while (result.next()) {
            benhAn.setSTT(result.getInt("stt"));
            benhAn.setMaBenhAn(result.getString("ma_benh_an"));
            benhAn.setMaBenhNhan(result.getString("ma_benh_nhan"));
            benhAn.setTenBenhNhan(result.getString("ten_benh_nhan"));
            benhAn.setNgayVaoVien(String.valueOf(result.getDate("ngay_nhap_vien")));
            benhAn.setNgayRaVien(String.valueOf(result.getDate("ngay_ra_vien")));
            LyDo lyDo = new LyDo(result.getInt("id_ly_do"), result.getString("ly_do"));
            benhAn.setLyDo(lyDo);
        }
        result.close();
        getConnection().close();
        return benhAn;
    }

    @Override
    public void edit(BenhAn benhAn) throws SQLException {
    PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE);
    preparedStatement.setString(1,benhAn.getTenBenhNhan());
    preparedStatement.setString(2,benhAn.getNgayVaoVien());
    preparedStatement.setString(3,benhAn.getNgayVaoVien());
    preparedStatement.setInt(4,benhAn.getLyDo().getIdLyDo());
    preparedStatement.setString(5,benhAn.getMaBenhAn());
    preparedStatement.executeUpdate();
    getConnection().close();
    }

    @Override
    public void delete(String maBenhAn) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE);
        preparedStatement.setString(1, maBenhAn);
        preparedStatement.executeUpdate();
        getConnection().close();
    }

    @Override
    public List<LyDo> getLyDo() throws SQLException {
        List<LyDo> danhSachLyDo = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(GET_ALL_LY_DO);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            LyDo lyDo = new LyDo(result.getInt("id_ly_do"), result.getString("ly_do"));
            danhSachLyDo.add(lyDo);
        }
        getConnection().close();
        result.close();
        return danhSachLyDo;
    }
}
