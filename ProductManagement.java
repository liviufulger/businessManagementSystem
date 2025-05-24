
import java.util.Scanner;
import java.util.List;

public class ProductManagement {
    private List<Product> products; // list to store product objects
    private Scanner scanner; // scaner for user input

    // Constructor to initialize ProductManagement with a list of products
    public ProductManagement(List<Product> products) {
        this.products = products;
        scanner = new Scanner(System.in);
    }

    // Method to display the menu and handle user choices
    public void manageProducts() {
        int choice = 0;

        do {
            try {
                // Displaying the menu options
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("\nProduct Management Menu:");
                System.out.println("1. Add a Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update a Product");
                System.out.println("4. Delete a Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                // Switch case to handle different menu options
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        viewAllProducts();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        deleteProduct();
                        break;
                    case 5:
                        System.out.println("Exiting Product Management...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (choice != 5);
    }

    // Method to add a new product
    private void addProduct() {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product type: ");
        String productType = scanner.nextLine();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter product size: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Product product = new Product(productId, productName, price, productType, size);
        products.add(product);
        System.out.println("Product added successfully!");
    }

    // Method to view all products with toString

    public static void viewAllProdu(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("There are no products to display.");
            return;
        }

        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Method to view all products with viewProduct method
    private void viewAllProducts() {
        System.out.print("\nAll product details are as follows\n");
        System.out.print("----------------------------------------------\n");
        for (Product product : products) {
            product.viewProduct();
        }
        System.out.print("\n----------------------------------------------\n");
    }

    // Method to update an existing product
    private void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Product product : products) {
            if (product.getProductId() == productId) {
                System.out.print("Enter new product name: ");
                String productName = scanner.nextLine();
                System.out.print("Enter new product price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Enter new product type: ");
                String productType = scanner.nextLine();
                System.out.print("Enter new product size: ");
                int size = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                product.setProductName(productName);
                product.setPrice(price);
                product.setProductType(productType);
                product.setSize(size);

                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // Method to delete a product
    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Product productToDelete = null;
        for (Product product : products) {
            if (product.getProductId() == productId) {
                productToDelete = product;
                break;
            }
        }
        if (productToDelete != null) {
            products.remove(productToDelete);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }
}
