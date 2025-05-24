
import java.util.List;

// SpecificOrder class extends AbstractOrder which is an inner abstract class of Order
class SpecificOrder extends Order.AbstractOrder {

    // Constructor for SpecificOrder
    public SpecificOrder(Order orders, List<Vendor> companies, double unitPrice) {
        // Calls the constructor of the parent abstract class (Order.AbstractOrder)
        super(orders, companies, unitPrice);
    }

    // Overridden method from the abstract class to calculate the total amount of
    // the order
    @Override
    public double calculateTotalAmount() {
        // Calculates the total amount by multiplying the number of items in the order
        // by the unit price
        return orders.getNumberOfItems() * unitPrice;
    }
}