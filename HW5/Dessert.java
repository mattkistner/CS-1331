/**
 * An abstract class providing a blue print for all subclasses of Dessert.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;

    /**
     * A constructor taking in 2 parameters to represent a Dessert.
     * @param flavor String describing the flavor of Dessert.
     * @param sweetness double giving a sweetness level of Dessert.
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }

    /**
     * A constructor taking in no parameters to represent a Dessert.
     * defaults flavor to "vanilla".
     * defaults sweetness to 25.0.
     */
    public Dessert() {
        this("vanilla", 25.0);
    }

    @Override
    public String toString() {
        String s1 = String.format("This is a %s dessert with a sweetness of %.2f",
            this.flavor, this.sweetness);
        return s1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof Dessert) {
            Dessert d1 = (Dessert) o;
            return this.flavor.equals(d1.flavor) && this.sweetness == d1.sweetness;
        }
        return false;
    }

    /**
     * A method that compares Dessert objects.
     * @param d Dessert object to be compared.
     * @return int representing which Dessert was greater.
     */
    public int compareTo(Dessert d) {
        if (this.sweetness > d.sweetness) {
            return 1;
        } else if (d.sweetness > this.sweetness) {
            return -1;
        } else {
            if (d.flavor.length() == this.flavor.length()) {
                return 0;
            }
            return d.flavor.length() > this.flavor.length() ? -1 : 1;
        }
    }

    /**
     * A getter for the String flavor.
     * @return String representing the flavor.
     */
    public String getFlavor() {
        return this.flavor;
    }

    /**
     * A getter for the double sweetness.
     * @return double representing the sweetness.
     */
    public double getSweetness() {
        return this.sweetness;
    }
}