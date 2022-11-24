package services;

import init.Product;
import repository.IProductRepo;
import repository.rimpl.ProductRepo;

import java.util.List;

public class ProductService implements IProductServices{
    IProductRepo productRepo = new ProductRepo();

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void addProductService(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public void deleteProductService(Product product) {
        productRepo.deleteProductById(product);
    }

    @Override
    public void updateProductService(int id, Product product) {
        productRepo.updateProductById(id,product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> displayAll() {
        return productRepo.addAll();
    }
}
