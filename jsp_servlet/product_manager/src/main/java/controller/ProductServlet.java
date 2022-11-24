package controller;

import init.Product;
import repository.IProductRepo;
import repository.rimpl.ProductRepo;
import services.IProductServices;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/Product")
public class ProductServlet extends HttpServlet {
    IProductRepo repo = new ProductRepo();
    private IProductServices services = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            listProducts(request, response);
        }
        switch (action) {
            case "create":
                ShowdoCreate(request, response);
                break;
            case "update":
                showupdateProduct(request, response);
                break;
            case "delete1":
                showDelete(request, response);
                break;
            case "delete2":
                showDelete1(request, response);
                break;
            case "list":
                listProducts(request, response);
                break;
            case "search":
                break;
            case "update2":
                showupdate2Product(request, response);

            default:
                listProducts(request, response);
        }
    }

    private void showDelete1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("remove2.jsp");
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("remove.jsp");
    }

    private void showupdate2Product(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("remove2.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showupdateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("list", services.displayAll());
        try {
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


    private void ShowdoCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("create.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            listProducts(request, response);
        }
        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "update1":
                updateProduct(request, response);
                break;
            case "delete1":
                doDelete1(request, response);
                break;
            case "list":
                listProducts(request, response);
                break;
            case "search":
                break;
            case "update":
                doUpdate(request, response);
                break;
            case "delete2":
                doDelete2(request, response);
                break;
            default:
                listProducts(request, response);
        }
    }

    private void doDelete2(HttpServletRequest request, HttpServletResponse response) {
        int idRemove2 = Integer.parseInt(request.getParameter("idremove2"));
        Product product = services.findById(idRemove2);
        services.deleteProductService(product);
        try {
            response.sendRedirect("/Product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void doDelete1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idremove"));
        Product product = services.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("remove2.jsp").forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameedit");
        int id = Integer.parseInt(request.getParameter("id1"));
        String date = request.getParameter("dateedit");
        String producer = request.getParameter("produceredit");
        Product product = new Product(name, id, date, producer);
        services.save(product);
//        services.updateProductService(services.findById(id).getId(),product);
        try {
            response.sendRedirect("/Product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name1 = request.getParameter("name1");
        int id = Integer.parseInt(request.getParameter("id1"));
        String date = request.getParameter("date1");
        String producer = request.getParameter("producer1");
        Product product = new Product(name1, id, date, producer);
        services.save(product);
        response.sendRedirect("/Product");
//        doGet(request, response);

    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList", services.displayAll());
        request.getRequestDispatcher("List.jsp").forward(request, response);
    }


    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idedit"));
        Product product = services.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("update2.jsp").forward(request, response);
    }

}
