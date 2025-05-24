
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

public class OrderManagement {
    private List<Order> orders; // list to store orders
    private List<Vendor> companies; // list to store vendor information
    private Scanner scanner; // the scanner for input

    // Constructor to initialize the OrderManagement system with existing companies
    // and orders
    public OrderManagement(List<Vendor> companies, List<Order> orders) {
        this.orders = orders;
        this.companies = companies;

        scanner = new Scanner(System.in); // Initialize scanner for user input
    }

    // Main method to manage orders, displaying a menu and processing user choices
    public void manageOrders() {
        int choice = 0;

        do {
            try {
                // display the order management menu
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("\nOrder Management Menu:");
                System.out.println("1. Add an Order");
                System.out.println("2. View All Orders");
                System.out.println("3. Update an Order");
                System.out.println("4. Delete an Order");
                System.out.println("5. View the total amount payable for every order");
                System.out.println("6. View comissions for each order");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt(); // reat the user choice
                scanner.nextLine(); // Consume newline left-over

                // switch case to handle different menu options
                switch (choice) {
                    case 1:
                        addOrder();
                        break;
                    case 2:
                        viewAllOrders();
                        break;
                    case 3:
                        updateOrder();
                        break;
                    case 4:
                        deleteOrder();
                        break;
                    case 5:
                        viewAbstractOrders();
                        break;
                    case 6:
                        viewComission();
                        break;
                    case 7:
                        System.out.println("Exiting Order Management...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (choice != 7); // Continue until the user chooses to exit
    }

    // Method to view total amount payable for each order
    public void viewAbstractOrders() {
        for (Order order : orders) {
            SpecificOrder abstractOrder = new SpecificOrder(order, companies, order.getItemCost());
            System.out.println(abstractOrder);
        }
    }

    // Method to view commission for each order
    public void viewComission() {
        for (Order order : orders) {
            System.out.println();
            System.out.print("\nCompany ID: "
                    + (order.getCompanyId() != null ? order.getCompanyId().getCompanyId() : "N/A") + ", ");
            System.out.print("Order Number: " + order.getOrderNumber() + ", ");
            System.out.print("Total Cost: $" + order.calculateTotalCost() + ", ");
            System.out.print("Commission: $" + order.calculateCommission());

        }
    }

    // Method to view all orders
    public void viewAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders to display.");
            return;
        }

        System.out.println("All Orders:");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------");

        for (Order order : orders) {
            // Assuming Retailer class has a getName() method
            System.out.print("\nCompany ID: "
                    + (order.getCompanyId() != null ? order.getCompanyId().getCompanyId() : "N/A") + "  |  ");
            System.out.print("Order ID: " + order.getOrderNumber() + "  |  ");
            System.out.print("Product Name: " + order.getProductName() + "  |  ");
            System.out.print("Product Size: " + order.getProductSize() + "  |  ");
            System.out.print("Number of Items: " + order.getNumberOfItems() + "  |  ");
            System.out.print("Item Cost: $" + order.getItemCost());
        }
    }

    // method to add order
    private void addOrder() {
        // Prompt user for order details and add to orders list
        System.out.print("Enter order number: ");
        int orderNumber = scanner.nextInt();

        Vendor companyId = selectRetailer(companies, scanner);
        if (companyId == null) {
            System.out.println("Order creation cancelled.");
            return;
        }

        System.out.print(
                "Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product size (e.g., 100ml, 400ml, 1000ml): ");
        String productSize = scanner.nextLine();
        System.out.print("Enter number of items: ");
        int numberOfItems = scanner.nextInt();
        System.out.print("Enter item cost: ");
        double itemCost = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Order order = new Order(companyId, orderNumber, productName, productSize, numberOfItems, itemCost);
        orders.add(order);
        System.out.println("Order added successfully!");
    }

    // Helper method to select a retailer from the list
    private Vendor selectRetailer(List<Vendor> companies, Scanner scanner) {
        // Allow user to select a retailer from the list
        if (companies.isEmpty()) {
            System.out.println("No retailers available.");
            return null;
        }

        while (true) {
            System.out.println("Select a retailer:");
            for (int i = 0; i < companies.size(); i++) {
                Vendor retailer = companies.get(i);
                System.out
                        .println((i + 1) + ". " + retailer.getCompanyName() + " (ID: " + retailer.getCompanyId() + ")");
            }

            System.out.print("Enter your choice (1-" + companies.size() + "), or 0 to cancel: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (choice == 0) {
                    return null; // User chose to cancel
                }

                if (choice >= 1 && choice <= companies.size()) {
                    return companies.get(choice - 1);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    // private void viewAllOrders() {
    // if (orders.isEmpty()) {
    // System.out.println("No orders available.");
    // return;
    // }
    // for (Order order : orders) {
    // System.out.println(order);
    // }
    // }

    // Method to update an existing order
    private void updateOrder() {
        // Prompt user for order number and update order details
        System.out.print("Enter order number to update: ");
        int orderNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                System.out.print("Enter new product type: ");
                String productName = scanner.nextLine();
                System.out.print("Enter new product size: ");
                String productSize = scanner.nextLine();
                System.out.print("Enter new number of items: ");
                int numberOfItems = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Enter new item cost: ");
                double itemCost = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                order.setProductName(productName);
                order.setProductSize(productSize);
                order.setNumberOfItems(numberOfItems);
                order.setItemCost(itemCost);

                System.out.println("Order updated successfully!");
                return;
            }
        }
        System.out.println("Order not found.");
    }

    // Method to delete an existing order
    private void deleteOrder() {
        // Prompt user for order number and delete the order
        System.out.print("Enter order number to delete: ");
        int orderNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Order orderToDelete = null;
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orderToDelete = order;
                break;
            }
        }
        if (orderToDelete != null) {
            orders.remove(orderToDelete);
            System.out.println("Order deleted successfully!");
        } else {
            System.out.println("Order not found.");
        }
    }

}
