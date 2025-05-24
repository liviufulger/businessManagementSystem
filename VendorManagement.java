
import java.util.List;
import java.util.Scanner;

public class VendorManagement {
    private List<Vendor> companies; // list to store companies
    private Scanner scanner;

    public VendorManagement(List<Vendor> companies) {
        this.companies = companies;
        scanner = new Scanner(System.in);
    }

    public void manageVendors() {
        int choice = 0;

        do {
            try {
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("  ");
                System.out.println("\nVendor Management Menu:");
                System.out.println("1. Add new Vendor");
                System.out.println("2. Delete Vendor");
                System.out.println("3. View all Vendors");
                System.out.println("4. Search Vendor");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        addCompany();
                        break;
                    case 2:
                        deleteCompany();
                        break;
                    case 3:
                        viewAllCompanies();
                        break;
                    case 4:
                        searchCompany();
                        break;
                    case 5:
                        System.out.println("Exiting Companies Management...");
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

    private void addCompany() {
        Vendor company = new Vendor();
        company.addCompanyInput();
        companies.add(company);
        System.out.println("\nNew company detail added successfully...\n");
    }

    private void deleteCompany() {
        System.out.print("Enter company ID to delete: ");
        int companyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        Vendor companyToDelete = null;
        for (Vendor company : companies) {
            if (company.getCompanyId() == companyId) {
                companyToDelete = company;
                break;
            }
        }
        if (companyToDelete != null) {
            companies.remove(companyToDelete);
            System.out.println("Company deleted successfully!");
        } else {
            System.out.println("Company not found.");
        }
    }

    private void viewAllCompanies() {
        if (companies.isEmpty()) {
            System.out.println("No companies available.");
            return;
        }
        for (Vendor company : companies) {
            company.viewCompany();
        }
    }

    public static void viewComp(List<Vendor> companies) {
        if (companies.isEmpty()) {
            System.out.println("No companies available.");
            return;
        }
        for (Vendor company : companies) {
            System.out.println(company);
        }
    }

    private void searchCompany() {
        System.out.print("\nEnter the company Id to find: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        boolean found = false;
        for (Vendor company : companies) {
            if (company.getCompanyId() == id) {
                found = true;
                company.viewCompany();
                System.out.println("\nFound and printed....");
                break;
            }
        }
        if (!found)
            System.out.println("Sorry, not found....");
    }
}
