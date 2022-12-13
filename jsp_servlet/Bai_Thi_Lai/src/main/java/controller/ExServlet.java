package controller;

import Model.KieuThue;
import Model.PhongTro;
import Service.ISer;
import Service.Ser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ExServlet", value = "/ExServlet")
public class ExServlet extends HttpServlet {
    ISer ser = new Ser();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            try {
                hienThiDS(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        switch (action) {
            case "home":
                try {
                    hienThiDS(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create":
                try {
                    hienThiDangKi(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remove":
                int id = Integer.parseInt(request.getParameter("id"));
                try {
                    ser.xoa(id);
                    response.sendRedirect("/ExServlet");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
        }
    }

    private void hienThiDangKi(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("dsKieuThue",ser.layDsKieuThue());
        request.getRequestDispatcher("Create.jsp").forward(request, response);
    }

    private void hienThiDS(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<PhongTro> dsPhongTro = ser.layDS();
        request.setAttribute("dsPhong",dsPhongTro);
        request.getRequestDispatcher("Home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {

        }
        switch (action) {
            case "home":
                try {
                    hienThiDS(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create" :
                try {
                    doCreate(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                try {
                    doTimKiem(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
        }
    }

    private void doTimKiem(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String ten =request.getParameter("nameS");
        PhongTro phongTro = ser.timKiem(ten);
        if (phongTro.getTenNguoiThue()!=null) {
            request.setAttribute("pt",phongTro);
            request.getRequestDispatcher("Search.jsp").forward(request,response);
        }else {
            String mess = "Khong Tim Thay";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        }
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String tenChuPhong = request.getParameter("name");
        int sdt = Integer.parseInt(request.getParameter("sdt"));
        String ngayThue = request.getParameter("ngay");
        KieuThue kt = new KieuThue(Integer.parseInt(request.getParameter("kieuThue")));
        String ghiChu = request.getParameter("ghiChu");
        PhongTro phongTro = new PhongTro(tenChuPhong,sdt,ngayThue,kt,ghiChu);
        ser.them(phongTro);
        response.sendRedirect("/ExServlet");


    }
}
