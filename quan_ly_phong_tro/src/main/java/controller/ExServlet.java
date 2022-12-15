package controller;

import Model.ChuTro;
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            showLogin(request, response);
        }
        switch (action) {
            case "createChutro":
                showCreatChuTro(request,response);
                break;
            case "login":
                showLogin(request,response);
                break;
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
                    response.sendRedirect("/ExServlet?action=home");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
        }
    }

    private void showCreatChuTro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("CreateChutro.jsp");
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("Login.jsp");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            showLogin(request, response);
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
            case "doLogin":
                try {
                    doLogin(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "doCreateCT":
                try {
                    doCreateCt(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:
        }
    }

    private void doCreateCt(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String user = request.getParameter("name");
        String pass = request.getParameter("pass");
        ChuTro chuTro = new ChuTro(user,pass);
        ser.ThemChuTro(chuTro);
        response.sendRedirect("Login.jsp");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        ChuTro chuTro = new ChuTro(username,password);
        if (ser.getLogin(chuTro)){
            response.sendRedirect("/ExServlet?action=home");
        }else {
            String mess = "Sai Thông Tin";
            request.setAttribute("mess",mess);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    private void doTimKiem(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String ten =request.getParameter("nameS");
        PhongTro phongTro = ser.timKiem(ten);
        if (phongTro.getTenNguoiThue()==ten) {
            request.setAttribute("pt",phongTro);
            request.getRequestDispatcher("Search.jsp").forward(request,response);
        }else {
            String mess = "Khong Tim Thay";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("/ExServlet?action=home").forward(request, response);
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
        response.sendRedirect("/ExServlet?action=home");


    }

}
