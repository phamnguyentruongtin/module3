package model;


public class Product {
    private int idProduct;
    private String productName;
    private double price;
    private int quantity;
    private String color;
    private Category category;

    public Product(int idProduct, String productName, double price, int quantity, String color, Category category) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(int idProduct, String productName, double price, int quantity, String color) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Product(String productName, double price, int quantity, String color, Category category) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
