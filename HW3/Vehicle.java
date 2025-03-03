/**
 * An abstract class representing a structure for all vehicles in a rideshare company's database.
 * @author Matthew Kistner.
 * GTID 903677868.
 * @version 1.
 */
public abstract class Vehicle {
    private final String id;
    private double earnings;
    protected int numMiles;
    protected String[] passengers;

    /**
     * Constructor taking in an id, number of miles, and passengers in/on each vehicle.
     * @param id a String specific to each vehicle that serves as an identifier.
     * @param numMiles an int measurement of the miles travelled by the vehicle.
     * @param passengers an Array of String documenting the passengers on the vehicle.
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.earnings = 0;
        this.numMiles = numMiles;
        this.passengers = passengers;
    }

    /**
     * Constructor taking in an id, and passengers in/on the vehicle.
     * @param id a String specific to each vehicle that serves as an identifier.
     * numMiles is defaulted to 0 miles.
     * @param passengers an Array of String documenting the passengers on the vehicle.
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /**
     * An abstract method set to evaluate if the vehicle can drive the distance.
     * @param distance an int representative of the desired travel length.
     * @return a boolean determining if the vehicle can make the trip.
     */
    public abstract boolean canDrive(int distance);

    /**
     * An abstract method set to calculate the cost of the trip based on the distance.
     * @param distance an int representative of the desired travel length.
     * @return a double representative of the cost of the desired trip.
     */
    public abstract double calculateCost(int distance);

    /**
     * An abstract method set to evaluate if another passenger can be added to the vehicle.
     * @param distance an int representative of the desired travel length.
     * @param arr an Array of String showcasing the people in/on the vehicle.
     * @return a boolean indicative of if another passenger can be added.
     * If true, the passenger is added to the Array of String passengers.
     */
    public abstract boolean addPassenger(int distance, String[] arr);

    /**
     * A method that applies the necessary additions once a ride is completed.
     * @param distance an int representative of the distance traveled.
     * numMiles is incremented by the distance value.
     * earnings is incremented by the calculated cost method value.
     */
    public void chargeRide(int distance) {
        numMiles += distance;
        earnings += calculateCost(distance);
    }

    /**
     * An override method of the equals method.
     * @param other a basic object to be evaluated as an equivalent to a Vehicle.
     * @return a boolean indicative of if the values of the id and numMiles are equivalent.
     *  between the Vehicle and other.
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Vehicle) {
            Vehicle v1 = (Vehicle) other;
            return this.id.equals(v1.id) && this.numMiles == v1.numMiles;
        }
        return false;
    }

    /**
     * An override method of the toString method.
     * @return a String consisting of specific information on each vehicle.
     */
    public String toString() {
        String s1 = String.format("%s has driven %d miles and has earned %.2f dollars.",
            this.id, this.numMiles, this.earnings);
        return s1;
    }

    /**
     * A getter for the double earnings.
     * @return the value of earnings.
     */
    public double getEarnings() {
        return this.earnings;
    }

    /**
     * A getter for the int numMiles.
     * @return the value of numMiles.
     */
    public int getNumMiles() {
        return this.numMiles;
    }

    /**
     * A setter for the int numMiles.
     * @param numMiles an int representative of miles travelled by the Vehicle.
     */
    public void setNumMiles(int numMiles) {
        this.numMiles = numMiles;
    }

    /**
     * A setter for the double earnings.
     * @param earnings a double representative of the amount of money gained.
     */
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }
}