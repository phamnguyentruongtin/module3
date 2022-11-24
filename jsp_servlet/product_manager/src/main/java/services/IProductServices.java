package services;

import init.Product;

import java.util.List;

public interface IProductServices {
    void save(Product product);
    void addProductService(Product product);
    void deleteProductService(Product product);
    void updateProductService(int id,Product product);

    Product findById(int id);
    List <Product> displayAll();
}
