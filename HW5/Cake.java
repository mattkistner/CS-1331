/**
 * A subclass of the abstract class Dessert that defines Cake objects.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Cake extends Dessert {
    private String frosting;

    /**
     * A constructor that takes in 3 parameters to form a Cake object.
     * @param flavor String defining flavor of the Cake.
     * @param sweetness double defining the level of sweetness.
     * @param frosting String defining frosting type.
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }

    /**
     * A constructor that takes in 1 parameter to form a Cake object.
     * @param flavor String defining flavor of the Cake.
     * sweetness is defaulted to 45.0.
     * frosting is defaulted to "vanilla".
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }

    @Override
    public String toString() {
        String s1 = String.format("This is a %s cake with a %s frosting and"
            + "has a sweetness of %.2f", getFlavor(), this.frosting, getSweetness());
        return s1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Cake) {
            Cake c1 = (Cake) o;
            return super.equals(c1) && this.frosting.equals(c1.frosting);
        }
        return false;
    }
}