
import java.time.LocalDate;
import java.util.List;

/**
 * The Order class represents an order with details such as vendor, product, and
 * cost.
 */
public class Order {

    private Vendor companyId; // Vendor associated with the order
    private int orderNumber; // Unique order number
    private String productName; // Name of the product ordered
    private String productSize; // Size of the product ordered
    private int numberOfItems; // Number of items in the order
    private double itemCost; // Cost per item
    private LocalDate date; // Date of the order

    // Constructor with LocalDate.now() that Sets the date of the order to the
    // current date.
    public Order(Vendor companyId, int orderNumber, String productName, String productSize, int numberOfItems,
            double itemCost) {
        this.companyId = companyId;
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.productSize = productSize;
        this.numberOfItems = numberOfItems;
        this.itemCost = itemCost;
        this.date = LocalDate.now(); // Set the date to the current date
    }

    // Getters and Setters for all fields including date

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Other getters and setters...
    public Vendor getCompanyId() {
        return companyId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setCompanyId(Vendor companyId) {
        this.companyId = companyId;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    // Methods

    // Method to calculate the total cost of the order
    public double calculateTotalCost() {
        return numberOfItems * itemCost;
    }

    /**
     * Calculates the commission based on the location of the company.
     *
     * @return The calculated commission as a double.
     */
    public double calculateCommission() {
        // Commission calculation logic
        double commissionRate;
        String location = companyId.getLocation();

        switch (location) {
            case "USA":
                System.out.print("Channel Name: " + location + ", ");
                commissionRate = 0.03; // 3% for USA
                break;
            case "Europe":
                System.out.print("Channel Name: " + location + ", ");
                commissionRate = 0.02; // 2% for Europe
                break;
            case "Asia":
            case "Middle East":
                System.out.print("Channel Name: " + location + ", ");
                commissionRate = 0.015; // 1.5% for Asia and Middle East

                break;
            default:
                commissionRate = 0; // No commission for other locations or undefined
                break;
        }

        return calculateTotalCost() * commissionRate;
    }

    /**
     * Static method to view all orders in a given list.
     *
     * @param orders The list of orders to be displayed.
     */
    public static void viewAllOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("There are no orders to display.");
            return;
        }

        System.out.println("All Orders:");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------");

        for (Order order : orders) {
            // Assuming Retailer class has a getName() method
            System.out.print("Company ID: "
                    + (order.getCompanyId() != null ? order.getCompanyId().getCompanyId() : "N/A") + "  |  ");
            System.out.print("Order ID: " + order.getOrderNumber() + "  |  ");
            System.out.print("Product Type: " + order.getProductName() + "  |  ");
            System.out.print("Product Size: " + order.getProductSize() + "  |  ");
            System.out.print("Number of Items: " + order.getNumberOfItems() + "  |  ");
            System.out.print("Item Cost: $" + order.getItemCost());
        }
    }

    @Override
    public String toString() {
        return "Order [companyId=" + companyId + ", orderNumber=" + orderNumber + ", productName=" + productName
                + ", productSize=" + productSize + ", numberOfItems=" + numberOfItems + ", itemCost=" + itemCost
                + ", date=" + date + "]";
    }

    /**
     * Abstract inner class representing a generic order.
     */
    public static abstract class AbstractOrder {
        protected Order orders;
        protected Vendor company;
        protected double unitPrice;

        // Constructor for AbstractOrder.
        public AbstractOrder(Order orders, List<Vendor> companies, double unitPrice) {
            this.orders = orders;
            this.unitPrice = unitPrice;
            this.company = findVendorbyId(companies, orders.getCompanyId());
        }

        /**
         * Finds a vendor by its ID.
         *
         * @param companies The list of vendors.
         * @param companyId The ID of the vendor to find.
         * @return The found vendor or null if not found.
         */

        private Vendor findVendorbyId(List<Vendor> companies, Vendor companyId) {
            for (Vendor company : companies) {
                if (company.equals(companyId)) {
                    return company;
                }
            }
            return null;
        }

        /**
         * Abstract method to calculate the total amount of the order.
         * Must be implemented by subclasses.
         *
         * @return The total amount as a double.
         */
        public abstract double calculateTotalAmount();

        @Override
        public String toString() {
            String companyName = company != null ? company.getCompanyName() : "Unknown";
            String companyAddress = company != null ? company.getAddress() : "Unknown Address";

            return

            companyName + ", " + companyAddress + ", " + orders.getProductName() + ", Qty "
                    + orders.getNumberOfItems()
                    + ", $" + String.format("%.2f", calculateTotalAmount());
        }
    }

}
