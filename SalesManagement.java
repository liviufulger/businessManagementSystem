
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SalesManagement {
    // Fields to store lists of sales, companies, and products, and a scanner for
    // input
    private List<Sales> sales;
    private List<Vendor> companies;
    private List<Product> products;
    private Scanner scanner;

    // Constructor to initialize the SalesManagement with existing lists
    public SalesManagement(List<Vendor> companies, List<Product> products, List<Sales> sales) {
        this.companies = companies;
        this.products = products;
        this.sales = sales;
        scanner = new Scanner(System.in);
    }

    // Main method to manage sales operations
    public void manageSales() {
        int choice = 0;
        do {
            try {
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("\nSales Management Menu:");
                System.out.println("1. Add a Sale");
                System.out.println("2. View All Sales");
                System.out.println("3. Update a Sale");
                System.out.println("4. Delete a Sale");
                System.out.println("5. Sales History - Total Profits per year.");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        addSale();
                        break;
                    case 2:
                        viewAllSales();
                        break;
                    case 3:
                        updateSale();
                        break;
                    case 4:
                        deleteSale();
                        break;
                    case 5:
                        viewProfitDetails();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (choice != 6);

    }

    // task
    // 4----------------------------------------------------------------------------------------

    private static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private static final Map<Integer, ArrayList<Double>> profits = new HashMap<>();

    static {
        profits.put(1, new ArrayList<>(
                List.of(140.0, 120.0, 136.0, 122.0, 142.0, 138.0, 142.0, 151.0, 144.0, 120.0, 143.0, 147.0)));
        profits.put(2, new ArrayList<>(
                List.of(130.0, 122.0, 126.0, 122.0, 140.0, 181.0, 141.0, 128.0, 168.0, 122.0, 141.0, 148.0)));
        profits.put(3, new ArrayList<>(
                List.of(127.0, 131.0, 134.0, 124.0, 142.0, 158.0, 142.0, 165.0, 142.0, 121.0, 140.0, 154.0)));
        profits.put(4, new ArrayList<>(
                List.of(140.0, 127.0, 137.0, 125.0, 141.0, 138.0, 141.0, 154.0, 180.0, 123.0, 142.0, 139.0)));
    }

    public static double yearlyProfitCalculation(int year) {
        return profits.get(year).stream().mapToDouble(Double::doubleValue).sum();
    }

    public static double averageMonthlyProfit(int year) {
        return yearlyProfitCalculation(year) / 12;
    }

    public static List<String> getMonthsAboveAverage(int year) {
        double average = averageMonthlyProfit(year);
        List<String> monthsAboveAverage = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (profits.get(year).get(i) > average) {
                monthsAboveAverage.add(MONTHS[i]);
            }
        }
        return monthsAboveAverage;
    }

    // Method to view profit details
    public void viewProfitDetails() {
        // Iterate through each year and print profit details
        for (int year : profits.keySet()) {
            System.out.println();
            System.out.println("Year " + year + ":");
            System.out.println("Profit: $" + yearlyProfitCalculation(year) + " millions");
            System.out.println("Months Above Avg.: " + getMonthsAboveAverage(year));
            System.out.println("Avg. Monthly Profit: $" + averageMonthlyProfit(year) + " millions");

        }
    }

    // task4
    // -----------------------------------------------------------------------------------

    // method to add a sale
    private void addSale() {
        System.out.print("Enter sales ID: ");
        int salesId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Vendor company = selectRetailer();
        if (company == null) {
            System.out.println("Sale creation cancelled.");
            return;
        }

        Product product = selectProduct();
        if (product == null) {
            System.out.println("Sale creation cancelled.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Sales sale = new Sales(salesId, company, product, quantity);
        sales.add(sale);
        System.out.println("Sale added successfully!");
    }

    // Method to select a vendor
    private Vendor selectRetailer() {
        if (companies.isEmpty()) {
            System.out.println("No companies available.");
            return null;
        }

        System.out.println("Select a retailer:");
        for (int i = 0; i < companies.size(); i++) {
            Vendor retailer = companies.get(i);
            System.out.println((i + 1) + ". " + retailer.getCompanyName());
        }

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (choice < 1 || choice > companies.size()) {
            System.out.println("Invalid choice.");
            return null;
        }

        return companies.get(choice - 1);
    }

    // method to select a product
    private Product selectProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return null;
        }

        System.out.println("Select a product:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getProductName());
        }

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (choice < 1 || choice > products.size()) {
            System.out.println("Invalid choice.");
            return null;
        }

        return products.get(choice - 1);
    }

    // method to view all sales
    private void viewAllSales() {
        if (sales.isEmpty()) {
            System.out.println("No sales records available.");
            return;
        }
        for (Sales sale : sales) {
            System.out.println(sale);
        }
    }

    // method to update sale
    private void updateSale() {
        System.out.print("Enter sales ID to update: ");
        int salesId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Sales sale : sales) {
            if (sale.getSales_id() == salesId) {
                Vendor company = selectRetailer();
                if (company != null) {
                    sale.setCompany_id(company);
                }

                Product product = selectProduct();
                if (product != null) {
                    sale.setProduct_id(product);
                }

                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                sale.setQuantity(quantity);

                System.out.println("Sale updated successfully!");
                return;
            }
        }
        System.out.println("Sale record not found.");
    }

    // method to delete sale
    private void deleteSale() {
        System.out.print("Enter sales ID to delete: ");
        int salesId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Sales saleToDelete = null;
        for (Sales sale : sales) {
            if (sale.getSales_id() == salesId) {
                saleToDelete = sale;
                break;
            }
        }
        if (saleToDelete != null) {
            sales.remove(saleToDelete);
            System.out.println("Sale deleted successfully!");
        } else {
            System.out.println("Sale record not found.");
        }
    }
}
