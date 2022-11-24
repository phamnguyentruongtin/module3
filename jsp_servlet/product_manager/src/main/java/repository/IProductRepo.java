package repository;

import init.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepo {
   static List<Product> productList = new ArrayList<>();

   void save(Product product);
    List<Product> addAll();

    void addProduct(Product product);
    void updateProductById(int id,Product product);
    void deleteProductById(Product product);
    List<Product> searchProductByName(String name);

    Product findById(int id);

}
