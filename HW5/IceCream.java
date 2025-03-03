/**
 * A subclass of the abstract Dessert class that defines IceCream objects.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;

    /**
     * A constructor that takes in 4 parameters to create an IceCream instance.
     * @param flavor String defining flavor of the IceCream.
     * @param sweetness double defining the level of sweetness.
     * @param scoops int defining the number of scoops.
     * @param cone boolean indicating if there is a cone.
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * A constructor that takes in 2 parameters to create an IceCream.
     * flavor is defaulted to "vanilla".
     * sweetness is defaulted to 45.0.
     * @param scoops int defining the number of scoops.
     * @param cone boolean indicating if there is a cone.
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }

    /**
     * A default constructor that takes in no parameters to instantiate an IceCream.
     * flavor is defaulted to "vanilla".
     * sweetness is defaulted to 45.0.
     * scoops is defaulted to 1.
     * cone is defaulted to false.
     */
    public IceCream() {
        this("vanilla", 45.0, 1, false);
    }

    @Override
    public String toString() {
        String s1 = String.format("This is a %s ice cream with %d scoops and " + (this.cone ? "has" : "does not have")
            + " a cone.", getFlavor(), this.scoops);
        return s1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof IceCream) {
            IceCream c1 = (IceCream) o;
            return super.equals(c1) && this.scoops == c1.scoops && this.cone == c1.cone;
        }
        return false;
    }
}