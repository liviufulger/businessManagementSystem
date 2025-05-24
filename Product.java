
import java.util.Scanner;
import java.util.List;

public class Product {
    // Attributes of the Product class
    private int productId;
    private String productName;
    private double price;
    private String productType;
    private int size;

    // Static scanner for input
    static Scanner input = new Scanner(System.in);

    // Constructor for initializing a Product with a list of products (currently
    // unused)
    public Product(List<Product> products) {

    }

    // Constructor to initialize a Product with specific details
    public Product(int productId, String productName, double price, String productType, int size) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.size = size;

    }

    // Getters and setters for each attribute
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Methods

    public void viewProduct() {

        System.out.println(" ");
        System.out.print("\nProduct Id: " + this.productId);
        System.out.print("\nProduct Name: " + this.productName);
        System.out.print("\nProduct price: " + this.price);
        System.out.print("\nProduct productType: " + this.productType);
        System.out.print("\nProduct Size: " + this.size);
    }

    public void addProductInput() {
        System.out.print("\nHere you should enter product information");
        System.out.print("\n-----------------------------------------");
        System.out.print("\nEnter Product Id: ");
        this.productId = input.nextInt();
        input.nextLine();
        System.out.print("\nEnter Product Name: ");
        this.productName = input.nextLine();
        System.out.print("\nEnter Product price: ");
        this.price = input.nextDouble();
        System.out.print("\nEnter Product productType: ");
        this.productType = input.nextLine();
        System.out.print("\nEnter Product Size: ");
        this.size = input.nextInt();
        input.nextLine();
        System.out.print("\n----------------------------------------");

    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
                + ", productType=" + productType + ", size=" + size + "]";
    }

}
