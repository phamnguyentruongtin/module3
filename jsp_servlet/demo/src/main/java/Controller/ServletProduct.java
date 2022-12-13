package Controller;

import Dao.Dao;
import Ser.ISer;
import Ser.Ser;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletProduct", value = "/ServletProduct")
public class ServletProduct extends HttpServlet {
    ISer ser = new Ser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            try {
                showList(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        switch (action) {
            case "home":
                try {
                    showList(request, response);
                } catch (SQLException e) {
                }
                break;
            case "edit":
                try {
                    showEdit(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create":
                try {
                    showCreate(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remove":
                try {
                    doRemve(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showList(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }

    }

    private void doRemve(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idR = Integer.parseInt(request.getParameter("id"));
        ser.remove(idR);
        response.sendRedirect("ServletProduct?action=home");
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        request.setAttribute("listCa", ser.findCategory());
        request.getRequestDispatcher("Create.jsp").forward(request, response);

    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = ser.findById(id);
        request.setAttribute("p", product);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productList = ser.getAll();
        request.setAttribute("list",productList);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            try {
                showList(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        switch (action) {
            case "create":
                try {
                    doCreate(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                try {
                    doSearch(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }


    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int idS = Integer.parseInt(request.getParameter("idSearch"));
        Product product = ser.findById(idS);
        request.setAttribute("p", product);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nameCr = request.getParameter("nameCR");
        double priceCR = Double.parseDouble(request.getParameter("priceCR"));
        int quantityCR = Integer.parseInt(request.getParameter("quantityCR"));
        String colorCR = request.getParameter("colorCR");
        Category category = new Category(Integer.parseInt(request.getParameter("categoryCR")));
        Product product = new Product(nameCr, priceCR, quantityCR, colorCR, category);
        ser.add(product);
        response.sendRedirect("/ServletProduct");
    }


}
