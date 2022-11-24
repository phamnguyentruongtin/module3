package repository.rimpl;

import init.Product;
import repository.IProductRepo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
   static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product("Hao Hao",1,"12-05-2020","acecook"));
        productList.add(new Product("Sting",2,"10-10-2020","Pepsi"));
        productList.add(new Product("Omo",3,"12-06-2020","OMO"));
        productList.add(new Product("Coke",4,"17-05-2021","Coca-cola"));
    }

    @Override
    public void save(Product product) {
        if(product.getId() > 0)
        {
            int index = productList.indexOf(product);
            productList.set(index, product);
        }
        else {
            productList.add(product);
        }
    }

    @Override
    public List<Product> addAll() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProductById(int id,Product product) {
        productList.set(id, product);
    }

    @Override
    public void deleteProductById(Product product) {
        productList.remove(product);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return (List<Product>) productList.get(Integer.parseInt(name));
    }

    @Override
    public Product findById(int id) {
        return productList.stream().filter(e-> e.getId() == id).findFirst().get();
    }

    }



