
/**
 * The JointVenture class represents a joint venture partnership.
 * It includes details about the partner involved in the joint venture
 * and the percentage of profits that are shared.
 */
public class JointVenture {
    // Fields
    private String partnerName; // Name of the joint venture partner
    private double profitPercentage; // Percentage of profits shared in the joint venture

    /**
     * Constructor to initialize a JointVenture object.
     *
     * @param partnerName      The name of the partner in the joint venture.
     * @param profitPercentage The percentage of profit to be shared with the
     *                         partner.
     */
    public JointVenture(String partnerName, double profitPercentage) {
        this.partnerName = partnerName;
        this.profitPercentage = profitPercentage;
    }

    // Getter and Setter methods

    /**
     * Gets the name of the joint venture partner.
     *
     * @return The name of the partner.
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * Sets the name of the joint venture partner.
     *
     * @param partnerName The name to set for the partner.
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    /**
     * Gets the profit percentage shared in the joint venture.
     *
     * @return The profit percentage.
     */
    public double getProfitPercentage() {
        return profitPercentage;
    }

    /**
     * Sets the profit percentage to be shared in the joint venture.
     *
     * @param profitPercentage The profit percentage to set.
     */
    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    /**
     * Returns a string representation of the JointVenture object.
     *
     * @return A string that contains the partner's name and the profit percentage.
     */
    @Override
    public String toString() {
        return "JointVenture [partnerName = " + partnerName + ", profitPercentage = " + profitPercentage + "]";
    }
}
