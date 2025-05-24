
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class serves as the entry point for the application.
 * It initializes and manages various entities like vendors, products, sales,
 * and orders.
 */
public class Main {
        // Static lists to store companies, products, sales and orders
        public static List<Vendor> companies = new ArrayList<>();
        public static List<Product> products = new ArrayList<>();
        public static List<Sales> sales = new ArrayList<>();
        public static List<Order> orders = new ArrayList<>();
        static Scanner input = new Scanner(System.in);

        /**
         * Initializes the application with some dummy data.
         * Adds predefined companies, products, and orders to their respective lists.
         */
        public static void database() {

                // Adding predefined companies to the companies list
                companies.add(new Vendor("Timespa Oils and Essences", "USA", "California Aromatics Ltd", 1,
                                "0555123456",
                                "caliaroma@example.com", "Los Angeles, USA"));
                companies.add(new Vendor("Timespa Oils and Essences", "USA", "Florida Essence Corp", 2, "0555987654",
                                "floridaessence@example.com", "Miami, USA"));
                companies.add(new Vendor("Timespa Oils and Essences", "Europe", "Paris Beauty Co.", 3, "0555333444",
                                "parisbeauty@example.com", "Paris, France"));
                companies.add(new Vendor("Timespa Oils and Essences", "Europe", "Berlin Spa Solutions", 4, "0555777888",
                                "berlinspa@example.com", "Berlin, Germany"));
                companies.add(new Vendor("Timespa Oils and Essences", "Europe", "Rome Wellness Ltd", 5, "0555666777",
                                "romewellness@example.com", "Rome, Italy"));
                companies.add(new Vendor("Timespa Oils and Essences", "Asia", "Tokyo Serenity Inc", 6, "0555999111",
                                "tokyoserenity@example.com", "Tokyo, Japan"));
                companies.add(new Vendor("Timespa Oils and Essences", "Asia", "Seoul Natural Care", 7, "0555222333",
                                "seoulnatural@example.com", "Seoul, South Korea"));
                companies.add(new Vendor("Timespa Oils and Essences", "Asia", "Shanghai Herbal Lux", 8, "0555444555",
                                "shanghaiherbal@example.com", "Shanghai, China"));
                companies.add(new Vendor("Timespa Oils and Essences", "Asia", "Mumbai Ayurvedics", 9, "0555666444",
                                "mumbaiayurvedics@example.com", "Mumbai, India"));
                companies.add(new Vendor("Timespa Oils and Essences", "Asia", "Bangkok Spa Innovations", 10,
                                "0555888999",
                                "bangkokspa@example.com", "Bangkok, Thailand"));

                // Adding predefined products to the products list
                products.add(new Product(1, "Olive Oil based Shampoo", 3.49, "Shampoo", 100));
                products.add(new Product(2, "Olive Oil based Shampoo", 6.49, "Shampoo", 400));
                products.add(new Product(3, "Olive Oil based Shampoo", 9.49, "Shampoo", 1000));
                products.add(new Product(4, "Tea Tree and Lemon Shampoo for Oily hair", 2.99, "Shampoo", 100));
                products.add(new Product(5, "Tea Tree and Lemon Shampoo for Oily hair", 4.99, "Shampoo", 400));
                products.add(new Product(6, "Tea Tree and Lemon Shampoo for Oily hair", 6.99, "Shampoo", 1000));
                products.add(new Product(7, "Extra Moisturising Shampoo", 3.00, "Shampoo", 100));
                products.add(new Product(8, "Extra Moisturising Shampoo", 6.00, "Shampoo", 400));
                products.add(new Product(9, "Extra Moisturising Shampoo", 9.00, "Shampoo", 1000));
                products.add(new Product(10, "Rosemary and Lavender Shampoo for hair growth", 2.99, "Shampoo", 100));
                products.add(new Product(11, "Rosemary and Lavender Shampoo for hair growth", 4.99, "Shampoo", 400));
                products.add(new Product(12, "Rosemary and Lavender Shampoo for hair growth", 6.99, "Shampoo", 1000));
                products.add(new Product(13, "Sensitive Shampoo with Aloe", 2.99, "Shampoo", 100));
                products.add(new Product(14, "Sensitive Shampoo with Aloe", 4.99, "Shampoo", 400));
                products.add(new Product(15, "Sensitive Shampoo with Aloe", 6.99, "Shampoo", 1000));
                products.add(new Product(16, "Cleansing shampoo with Lime and Lemon", 3.20, "Shampoo", 100));
                products.add(new Product(17, "Cleansing shampoo with Lime and Lemon", 6.20, "Shampoo", 400));
                products.add(new Product(18, "Cleansing shampoo with Lime and Lemon", 6.20, "Shampoo", 1000));
                products.add(new Product(19, "Rose oil shampoo", 3.49, "Shampoo", 100));
                products.add(new Product(20, "Rose oil shampoo", 6.49, "Shampoo", 400));
                products.add(new Product(21, "Rose oil shampoo", 9.49, "Shampoo", 1000));
                products.add(new Product(22, "Fresh Natural Shampoo without SLS", 3.49, "Shampoo", 100));
                products.add(new Product(23, "Fresh Natural Shampoo without SLS", 6.49, "Shampoo", 400));
                products.add(new Product(24, "Fresh Natural Shampoo without SLS", 9.49, "Shampoo", 1000));
                products.add(new Product(25, "Dry Shampoo with Conditioner", 1.99, "Shampoo", 100));
                products.add(new Product(26, "Dry Shampoo with Conditioner", 2.99, "Shampoo", 400));
                products.add(new Product(27, "Dry Shampoo with Conditioner", 4.99, "Shampoo", 1000));

                // Adding predefined orders to the orders list
                orders.add(new Order(companies.get(0), 1, "Olive Oil based Shampoo", "100ml", 10,
                                products.get(0).getPrice()));
                orders.add(new Order(companies.get(0), 2, "Olive Oil based Shampoo", "400ml", 5,
                                products.get(1).getPrice()));
                orders.add(new Order(companies.get(1), 3, "Olive Oil based Shampoo", "1000ml", 8,
                                products.get(2).getPrice()));
                orders.add(new Order(companies.get(1), 4, "Tea Tree and Lemon Shampoo for Oily hair", "100ml", 15,
                                products.get(3).getPrice()));
                orders.add(new Order(companies.get(2), 5, "Tea Tree and Lemon Shampoo for Oily hair", "400ml", 20,
                                products.get(4).getPrice()));
                orders.add(new Order(companies.get(2), 6, "Tea Tree and Lemon Shampoo for Oily hair", "1000ml", 12,
                                products.get(5).getPrice()));
                orders.add(
                                new Order(companies.get(3), 7, "Extra Moisturising Shampoo", "100ml", 7,
                                                products.get(6).getPrice()));
                orders.add(
                                new Order(companies.get(3), 8, "Extra Moisturising Shampoo", "400ml", 10,
                                                products.get(7).getPrice()));
                orders.add(
                                new Order(companies.get(4), 9, "Extra Moisturising Shampoo", "1000ml", 5,
                                                products.get(8).getPrice()));
                orders.add(new Order(companies.get(4), 10, "Rosemary and Lavender Shampoo for hair growth", "100ml", 9,
                                products.get(9).getPrice()));

        }

        /**
         * Initializes a joint venture and displays its details.
         */
        public static void jontVenture() {
                JointVenture jointVenture = new JointVenture("Regency Hotel", 30.0);
                System.out.println("");
                System.out.println("");
                System.out.println(jointVenture);

        }

        /**
         * The main method - the program's starting point.
         * Initializes various management classes and provides a menu for user
         * interaction.
         *
         * @param args Command line arguments (not used in this application).
         */
        public static void main(String[] args) {
                VendorManagement vendorManagement = new VendorManagement(companies);
                ProductManagement productManagement = new ProductManagement(products);
                OrderManagement orderManagement = new OrderManagement(companies, orders);
                SalesManagement salesManagement = new SalesManagement(companies, products, sales);

                database(); // this is called to initilse some dummy data

                jontVenture(); // Initialize and display joint venture details

                // Main loop for the application menu
                while (true) {
                        int choice1 = Manufacturer.mainMenu();
                        switch (choice1) {
                                case 1:
                                        vendorManagement.manageVendors();
                                        break;
                                case 2:
                                        productManagement.manageProducts();
                                        break;
                                case 3:
                                        orderManagement.manageOrders();
                                        break;
                                case 4:
                                        salesManagement.manageSales();
                                        break;
                                case 5:
                                        System.out.print("You selected option 5 - EXIT");
                                        // Exiting the application
                                        return; // This will exit the while loop and end the program
                        }

                }
        }
}
