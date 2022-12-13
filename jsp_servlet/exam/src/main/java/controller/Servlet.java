package controller;

import model.BenhAn;
import model.LyDo;
import service.ISer;
import service.Ser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    ISer ser = new Ser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            try {
                showHome(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        switch (action) {
            case "home":
                try {
                    showHome(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    showEdit(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remove":
                String maBenhAn = request.getParameter("maBenhAn");
                try {
                    ser.delete(maBenhAn);
                    response.sendRedirect("/Servlet?action=home");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    showHome(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        BenhAn benhAn = ser.findBenhAn(maBenhAn);
        List<LyDo> list = ser.getLyDo();
        request.setAttribute("benhAn", benhAn);
        request.setAttribute("lydo1", list);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<BenhAn> danhSachBenhAn = ser.getALL();
        request.setAttribute("danhSachBenhAn", danhSachBenhAn);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        LyDo lyDo = new LyDo(Integer.parseInt(request.getParameter("lydo")));
        BenhAn bA = new BenhAn(maBenhAn,tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo);
        ser.edit(bA);
        response.sendRedirect("/Servlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            try {
                showHome(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        switch (action) {
            case "edit":
                try {
                    doEdit(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }


    }
}


