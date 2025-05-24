
import java.util.Scanner;

/**
 * The Manufacturer class represents a manufacturer with a name and location.
 * It also provides a static method for displaying the main menu of the
 * application.
 */
public class Manufacturer {

    private String name; // Name of the manufacturer
    private String location; // Location of the manufacturer or the channel name

    public Manufacturer() { // default constructor
    }

    public Manufacturer(String name, String location) { // constructor iwth parameters
        this.name = name;
        this.location = location;
    }

    // Getters and setters methods for name and location
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Static Scanner object for input
    static Scanner input = new Scanner(System.in);

    /**
     * Displays the main menu and handles user input for menu selection.
     * Ensures that the user inputs a valid integer within the specified range.
     *
     * @return The user's menu choice as an integer.
     */

    public static int mainMenu() {

        while (true) {
            try {
                System.out.println(" STU123013 ");
                System.out.println("  ");
                System.out.println("  ");
                System.out.print("\n     Timespa Oils and Essences       ");
                System.out.print("\n--------------------------------------");
                System.out.print("\n1. Company Management");
                System.out.print("\n2. Products Management");
                System.out.print("\n3. Order Management");
                System.out.print("\n4. Sales Analysis");
                System.out.print("\n5. Exit");
                System.out.print("\nplease enter your choice (1-5): ");

                // Reading the user's choice
                int choice1 = input.nextInt();
                // Validating the user's choice
                if (choice1 < 0 || choice1 > 5) {
                    System.out.print("\n1. Your input is out of range..Please try again");
                    continue;
                } else
                    return choice1;
            } catch (Exception ex) {
                // Handling invalid input (non-integer)
                System.out.print("\nYou entered a character or wrong input");
                System.out.print("\nPlease retry");
                input.next(); // clearing the scanner buffer
            }
        }
    }

}