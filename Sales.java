
public class Sales {
    // Fields of the Sales class
    private int sales_id; // Unique identifier for the sales record
    private Vendor company_id; // Vendor object representing the company involved in the sale
    private Product product_id; // Product object representing the product being sold
    private int quantity; // Quantity of the product sold quantity;

    // Parameterized constructor to initialize a Sales object with specific values
    public Sales(int sales_id, Vendor company_id, Product product_id, int quantity) {
        this.sales_id = sales_id; // Set the sales ID
        this.company_id = company_id; // Set the company ID
        this.product_id = product_id; // Set the product ID
        this.quantity = quantity; // Set the quantity of the product
    }
    // Default constructor for creating a Sales object without initial values

    public Sales() {
    }

    // Getter method for sales_id
    public int getSales_id() {
        return sales_id;
    }

    // Setter method for sales_id
    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    // Getter method for company_id
    public Vendor getCompany_id() {
        return company_id;
    }

    // Setter method for company_id
    public void setCompany_id(Vendor company_id) {
        this.company_id = company_id;
    }

    // Getter method for product_id
    public Product getProduct_id() {
        return product_id;
    }

    // Setter method for product_id
    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    // Getter method for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter method for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Overridden toString method for Sales class
    @Override
    public String toString() {
        return "Sales [sales_id=" + sales_id + ", company_id=" + company_id + ", product_id=" + product_id
                + ", quantity=" + quantity + "]";
    }

}
