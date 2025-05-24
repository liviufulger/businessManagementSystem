
import java.util.Scanner;

// Vendor class extends Manufacturer
public class Vendor extends Manufacturer {
    // Properties specific to Vendor
    private String companyName;
    private int companyId;
    private String phone;
    private String email;
    private String address;

    // Default constructor
    public Vendor() {
    }

    // Constructor with parameters
    public Vendor(String name, String location, String companyName, int companyId, String phone,
            String email, String address) {
        super(name, location);
        this.companyName = companyName;
        this.companyId = companyId;
        this.phone = phone;
        this.email = email;
        this.address = address;

    }

    // getters and setters methods
    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Scanner getInput() {
        return input;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    // Methods

    // Method to calculate commission based on sales amount and location
    public double calculateCommission(double salesAmount) {
        double commissionRate;

        switch (super.getLocation()) {
            case "USA":
                commissionRate = 0.03; // 3% for USA
                break;
            case "Europe":
                commissionRate = 0.02; // 2% for Europe
                break;
            case "Asia":
            case "Middle East":
                commissionRate = 0.015; // 1.5% for Asia and Middle East
                break;
            default:
                commissionRate = 0; // No commission for other locations or undefined
                break;
        }

        return salesAmount * commissionRate;
    }

    Scanner input = new Scanner(System.in);

    // Method to display company information
    public void viewCompany() {

        System.out.print("\nManufacturer: " + super.getName() + "  |  ");
        System.out.print("Location: " + super.getLocation() + "  |  ");
        System.out.print("Company Id: " + this.companyId + "  |  ");
        System.out.print("Company Name: " + this.companyName + "  |  ");
        System.out.print("Contact Contact: " + this.phone + "  |  ");
        System.out.print("Company Email: " + this.email + "  |  ");
        System.out.print("Company Address: " + this.address);

    }

    // Method to add company details via user input
    public void addCompanyInput() {
        System.out.print("\nYou are going to add a new company detail....");
        System.out.print("\n---------------------------------------------");
        System.out.print("\nEnter the channel name (e.g., USA, Europe, Asia, Middle East): ");
        String cn = input.nextLine();
        super.setName("Timespa Oils and Essences");
        super.setLocation(cn);
        System.out.print("\nEnter Company Id: ");
        this.companyId = input.nextInt();
        input.nextLine();
        System.out.print("\nEnter Company Name: ");
        this.companyName = input.nextLine();
        System.out.print("\nEnter Contact Contact: ");
        this.phone = input.nextLine();
        System.out.print("\nEnter Company Email: ");
        this.email = input.nextLine();
        System.out.print("\nEnter Company Address: ");
        this.address = input.nextLine();
        System.out.print("\n  ");
        // input.close();
    }

    // Override toString method
    public String toString() {
        return "Retailer {" +
                "companyName='" + companyName + '\'' +
                ", companyId=" + companyId +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
