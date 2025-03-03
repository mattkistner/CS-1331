/**
 * A class representing discounted paper products that extends from the PaperProduct class.
 * @author Matthew Kistner.
 * GTID 903677868.
 * @version 1.
 */
public class DiscountedPaper extends PaperProduct {
    private double discount;
    private GoldenTicket ticket;

    /**
     * A constructor taking in 5 parameters: a String name, an int numberOfSheets,
     *  a double weightOfUnitSheet, a double discount, and a GoldenTicket ticket.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * @param numberOfSheets is an int representative of the number of sheets of paper.
     * @param weightOfUnitSheet is a double representative of the weight of a unit sheet.
     * @param discount is a double representative of the percent discount on the paper.
     * @param ticket is a GoldenTicket object representative of the Golden Ticket on the paper.
     */
    public DiscountedPaper(String name, int numberOfSheets, double weightOfUnitSheet,
        double discount, GoldenTicket ticket) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (discount <= 0 || discount > 50) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
        this.ticket = ticket;
    }

    /**
     * A constructor taking in 5 parameters: a String name, an int numberOfSheets, a double weightOfUnitSheet,
     *  a double discount, and a GoldenTicket ticket.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * @param numberOfSheets is an int representative of the number of sheets of paper.
     * weightOfUnitSheet is defaulted to 0.25.
     * discount is defaulted to 15.
     * ticket is defaulted to null.
     */
    public DiscountedPaper(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25, 15, null);
    }

    /**
     * A constructor taking in 5 parameters: a String name, an int numberOfSheets, a double weightOfUnitSheet,
     *  a double discount, and a GoldenTicket ticket.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * numberOfSheets is defaulted to 500.
     * weightOfUnitSheet is defaulted to 0.25.
     * discount is defaulted to 15.
     * ticket is defaulted to null.
     */
    public DiscountedPaper(String name) {
        this(name, 500, 0.25, 15, null);
    }

    /**
     * A constructor that creates a deep copy of a DiscountedPaper object.
     * @param discountedPaper a DiscountedProduct object that is copied.
     */
    public DiscountedPaper(DiscountedPaper discountedPaper) {
        this(new String(discountedPaper.getName()), discountedPaper.getNumberOfSheets(),
            discountedPaper.getWeightOfUnitSheet(), discountedPaper.discount, discountedPaper.ticket == null ? null
            : new GoldenTicket(discountedPaper.ticket.getCatchphrase(), discountedPaper.ticket.getDiscount()));
    }

    /**
     * A method that takes in no parameters.
     * @return a double representing the final cost after discounts from both the golden ticket and this discount.
     */
    public double discountedCost() {
        double preticket = totalCost() * ((100 - discount) * 0.01);
        return ticket == null ? preticket : preticket * ((100 - ticket.getDiscount()) * 0.01);
    }

    /**
     * A method that takes in 1 parameter of a String, the name of a company.
     * returned String dependent on value of int totalProductsToShip.
     * @param company a String representing the company products are shipped to.
     * @return a String representing the shippping information or saying there is nothing to ship.
     */
    public String shipDiscounted(String company) {
        if (getTotalProductsToShip() != 0) {
            decrementProduct();
            String sd = String.format("Shipped %.2fg of %s for $%.2f to %s. The total cost"
                + "after the discount is %.2f.",
                totalWeight(), getName(), totalCost(), company, discountedCost());
            return sd;
        } else {
            String sd = String.format("Cannot ship any items, Warehouse is empty! "
                + "The total cost after the discount is %.2f.",
                discountedCost());
            return sd;
        }
    }

    /**
     * A method that takes in no parameters.
     * @return a String representing all monetary information on the discounted paper.
     */
    public String botherAccounting() {
        return ticket == null
            ? String.format("Discounted Paper Product:%nOriginal Cost: %.2f%nFinal Cost: %.2f%nOriginal Discount:"
                + "%.2f%%%nGolden Ticket Discount: 0.00%%",
                totalCost(), discountedCost(), discount)
                : String.format("Discounted Paper Product:%nOriginal Cost: %.2f%nFinal Cost:"
                + " %.2f%nOriginal Discount: %.2f%%%nGolden Ticket Discount: %.2f%%",
                totalCost(), discountedCost(), discount, ticket.getDiscount());
    }

    /**
     * A getter that returns the value of the double discount.
     * @return the double discount.
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * A getter that returns the value of the GoldenTicket ticket.
     * @return the GoldenTicket ticket.
     */
    public GoldenTicket getTicket() {
        return this.ticket;
    }

    /**
     * A setter that asigns the value of the GoldenTicket ticket.
     * @param ticket a GoldenTicket set to the ticket variable.
     */
    public void setTicket(GoldenTicket ticket) {
        this.ticket = ticket;
    }

    /**
     * A setter that asigns the value of the double discount.
     * @param discount a double to be set to the value of discount.
     * accounts for invalid values by invoking the discountCheck method.
     */
    public void setDiscount(double discount) {
        if (discount <= 0 || discount > 50) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }
}