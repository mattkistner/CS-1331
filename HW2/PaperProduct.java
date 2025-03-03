/**
 * A class representing paper products.
 * @author Matthew Kistner.
 * GTID 903677868.
 * @version 1.
 */
public class PaperProduct {
    private final String name;
    private int numberOfSheets;
    private final double weightOfUnitSheet;
    private static int totalProductsToShip = 10;
    public static final double COST_PER_GRAM = 0.025;

    /**
     * A constructor taking in 3 parameters: a String name, an int numberOfSheets, and a double weightOfUnitSheet.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * @param numberOfSheets is an int representative of the number of sheets of paper.
     * @param weightOfUnitSheet is a double representative of the weight of a unit sheet.
     */
    public PaperProduct(String name, int numberOfSheets, double weightOfUnitSheet) {
        if (name == null || name.equals("")) {
            this.name = "A4";
        } else {
            this.name = name;
        }
        if (numberOfSheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = numberOfSheets;
        }
        if (weightOfUnitSheet < 0) {
            this.weightOfUnitSheet = 0.25;
        } else {
            this.weightOfUnitSheet = weightOfUnitSheet;
        }
    }

    /**
     * A constructor taking in 2 parameters: a String name, an int numberOfSheets.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * @param numberOfSheets is an int representative of the number of sheets of paper.
     * weightOfUnitSheets defaults to 0.25.
     */
    public PaperProduct(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25);
    }

     /**
     * A constructor taking in 1 parameter: a String name.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * numberOfSheets defaults to 500.
     * weightOfUnitSheets defaults to 0.25.
     */
    public PaperProduct(String name) {
        this(name, 500, 0.25);
    }

    /**
     * A constructor that creates a deep copy of a paper product object.
     * @param paperProduct a PaperProduct object that is copied.
     */
    public PaperProduct(PaperProduct paperProduct) {
        this(new String(paperProduct.name), paperProduct.numberOfSheets, paperProduct.weightOfUnitSheet);
    }

    /**
     * A method that takes in no parameters and calculates the total weight of paper.
     * @return a double representative of the total weight.
     */
    public double totalWeight() {
        return weightOfUnitSheet * numberOfSheets;
    }

    /**
     * A method that takes in no parameters and calculates the total cost of the paper.
     * @return a double representative of the total cost.
     */
    public double totalCost() {
        return COST_PER_GRAM * totalWeight();
    }

    /**
     * A method that takes in no parameters and returns a string about the paper.
     * @return a string that details the total weight, name, and total cost.
     */
    public String paperString() {
        String ps = String.format("%.2fg of %s for $%.2f", totalWeight(), name, totalCost());
        return ps;
    }

    /**
     * A method that takes in the parameter of a String, a company's name.
     * method depends on value of the int totalProductsToShip.
     * @param company a String representing the company products are shipped to.
     * @return a String representing the sending details or a String saying there is nothing to ship.
     */
    public String ship(String company) {
        if (totalProductsToShip != 0) {
            --totalProductsToShip;
            String s = String.format("Shipped %.2fg of %s for $%.2f to %s.", totalWeight(), name, totalCost(), company);
            return s;
        } else {
            return "Cannot ship any items, Warehouse is empty!";
        }
    }

    /**
     * A getter that returns the value of the String name.
     * @return the String name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * A getter that returns the value of the int numberOfSheets.
     * @return the int numberOfSheets.
     */
    public int getNumberOfSheets() {
        return this.numberOfSheets;
    }

    /**
     * A getter that returns the value of the double weightOfUnitSheet.
     * @return the double weightOfUnitSheet.
     */
    public double getWeightOfUnitSheet() {
        return this.weightOfUnitSheet;
    }

    /**
     * A getter that returns the value of the int totalProductsToShip.
     * @return the int totalProductsToShip.
     */
    public static int getTotalProductsToShip() {
        return totalProductsToShip;
    }

    /**
     * A setter that asigns the value of the int numberOfSheets.
     * @param numberOfSheets an int to be set to the numberOfSheets.
     */
    public void setNumberOfSheets(int numberOfSheets) {
        if (numberOfSheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = numberOfSheets;
        }
    }

    /**
     * A method needed to access the private variable totalProductsToShip within other classes.
     * Decrements the variable by 1 every invocation.
     */
    public static void decrementProduct() {
        --totalProductsToShip;
    }
}
