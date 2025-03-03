/**
 * A class representing photo paper products that extends from the PaperProduct class.
 * @author Matthew Kistner.
 * GTID 903677868.
 * @version 1.
 */
public class PhotoPaper extends PaperProduct {
    private double glossiness;

    /**
     * A constructor taking in 4 parameters: a String name, an int numberOfSheets,
     *  a double weightOfUnitSheet, and a double glossiness.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * @param numberOfSheets is an int representative of the number of sheets of paper.
     * @param weightOfUnitSheet is a double representative of the weight of a unit sheet.
     * @param glossiness is a double representative of the percent gloss on the paper.
     */
    public PhotoPaper(String name, int numberOfSheets, double weightOfUnitSheet, double glossiness) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (glossiness < 0 || glossiness > 100) {
            this.glossiness = 70;
        } else {
            this.glossiness = glossiness;
        }
    }

    /**
     * A constructor taking in 2 parameters: a String name and an int numberOfSheets.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * @param numberOfSheets is an int representative of the number of sheets of paper.
     * weightOfUnitSheet is defaulted to 0.25.
     * glossiness is defaulted to 70.
     */
    public PhotoPaper(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25, 70);
    }

    /**
     * A constructor taking in 1 parameter: a String name.
     * The constructor accounts for invalid values to create defaults.
     * @param name is a String representative of the name of paper.
     * numberOfSheets is defaulted to 500.
     * weightOfUnitSheet is defaulted to 0.25.
     * glossiness is defaulted to 70.
     */
    public PhotoPaper(String name) {
        this(name, 500, 0.25, 70);
    }

    /**
     * A constructor that creates a deep copy of a photo paper object.
     * @param photoPaper a PhotoProduct object that is copied.
     */
    public PhotoPaper(PhotoPaper photoPaper) {
        this(new String(photoPaper.getName()), photoPaper.getNumberOfSheets(),
            photoPaper.getWeightOfUnitSheet(), photoPaper.glossiness);
    }

    /**
     * A method that takes in no parameters and returns a detailed string on the photo paper.
     * @return a String representative of the variables in photo string.
     */
    public String photoString() {
        String ps = String.format("%.2f%% glossy and %.2fg of %s for $%.2f", glossiness,
            totalWeight(), getName(), totalCost());
        return ps;
    }

    /**
     * A method that takes in 1 parameter of a String, representing a company.
     * return values dependent upon value of the int totalProductsToShip.
     * @param company a String representative of a company.
     * @return a String about the paper being sent or a String indicating there is no paper in the warehouse to be sent.
     */
    public String shipPhoto(String company) {
        if (getTotalProductsToShip() != 0) {
            decrementProduct();
            String sp = String.format("Paper is %.2f%% glossy. Shipped %.2fg of %s for $%.2f to %s.",
                glossiness, totalWeight(), getName(), totalCost(), company);
            return sp;
        } else {
            String sp = String.format("Paper is %.2f%% glossy. Cannot ship any items, Warehouse is empty!",
                glossiness);
            return sp;
        }
    }

    /**
     * A setter that asigns the value of the double glossiness.
     * @param glossiness a double to be set to the value of glossiness.
     */
    public void setGlossiness(double glossiness) {
        if (glossiness < 0 || glossiness > 100) {
            this.glossiness = 70;
        } else {
            this.glossiness = glossiness;
        }
    }

    /**
     * A getter that returns the value of the double glossiness.
     * @return the double glossiness.
     */
    public double getGlossiness() {
        return this.glossiness;
    }

}