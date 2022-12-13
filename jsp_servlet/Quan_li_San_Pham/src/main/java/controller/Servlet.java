package controller;

import Model.Seafood;
import Repo.Dao;
import Ser.IServices;
import Ser.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "Servlet", value = "/Product")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IServices services;

    @Override
    public void init() throws ServletException {
        super.init();
        services = new Services();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            showList(req, resp);
        }
        switch (action) {
            case "list":
                showList(req, resp);
                break;
            case "creat":
                showCreate(req, resp);
                break;
            case "edit" :
                try {
                    doEdit(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remove" :
                doRemove(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            showList(req, resp);
        }
        switch (action) {
            case "create":
                doCreate(req, resp);
                break;
            case "search":
                try {
                    doSearch(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit2" :
                try {
                    doEdit2(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
               showList(req, resp);
        }
    }

    private void doRemove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        services.delete(id);
        resp.sendRedirect("/Product");
    }

    private void doEdit2(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int idx = Integer.parseInt(req.getParameter("idED"));
        String namex = req.getParameter("nameED");
        int amount = Integer.parseInt(req.getParameter("amountED"));
        double pricex = Double.parseDouble(req.getParameter("priceED"));
        Seafood s = new Seafood(idx,namex,amount,pricex);
        services.update(s);
        resp.sendRedirect("/Product");


    }

    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Seafood s = services.searchById(id);
        req.setAttribute("s",s);
        req.getRequestDispatcher("Update.jsp").forward(req, resp);
    }

    private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idSearch"));
        Seafood s;
        s = services.searchById(id);
        req.setAttribute("s",s);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("idCR"));
        String name = req.getParameter("nameCR");
        int amount = Integer.parseInt(req.getParameter("amountCR"));
        double price = Double.parseDouble(req.getParameter("priceCR"));
        Seafood seafood = new Seafood(id, name, amount, price);
        services.save(seafood);
        resp.sendRedirect("/Product?action=list");
    }


    private void showCreate(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect("Create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Seafood> seafo = services.allALL();
        req.setAttribute("list", seafo);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }

}

