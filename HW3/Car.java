/**
 * A child class of the abstract Vehicle class that represents a Car.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;

    /**
     * A constructor that takes in 6 parameters.
     * @param id String representing the specific car.
     * @param numMiles int representing the number of miles travelled.
     * @param passengers Array of String listing each passenger in the car.
     * @param rate double representing the amount charged per mile.
     * @param fees double representing the fee to use a car once.
     * @param maxNumMiles int representing the max miles a car can travel.
     */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /**
     * A constructor that takes in 6 parameters.
     * @param id String representing the specific car.
     * @param numMiles int representing the number of miles travelled.
     * passengers is defaulted to an Array of String with length 4.
     * rate is defaulted to 10 dollars charged per mile.
     * fees is defaulted to 15 dollars for one ride.
     * @param maxNumMiles int representing the max miles a car can travel.
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10, 15, maxNumMiles);
    }

    /**
     * A constructor that takes in 6 parameters.
     * @param id String representing the specific car.
     * numMiles is defaulted to 0 miles.
     * passengers is defaulted to an Array of String with length 4.
     * rate is defaulted to 10 dollars charged per mile.
     * fees is defaulted to 15 dollars for one ride.
     * maxNumMiles is defaulted to 200 miles.
     */
    public Car(String id) {
        this(id, 0, new String[4], 10, 15, 200);
    }

    /**
     * A method that returns a boolean indicative of if the car can drive a desired distance.
     * @param distance int representative of the desired distance for the car to travel.
     * @return a boolean indicating if the car can drive the distance.
     */
    @Override
    public boolean canDrive(int distance) {
        if (distance < 0) {
            return false;
        }
        return maxNumMiles > (distance + numMiles);
    }

    /**
     * A method that calculates the cost of a ride.
     * @param distance int representative of the distance of the ride.
     * @return a double representing the cost of the ride with all fees taken into account.
     * if the car cannot travel the distance then -1 will be returned.
     */
    @Override
    public double calculateCost(int distance) {
        if (!canDrive(distance)) {
            return -1;
        }
        return (rate * distance) + fees;
    }

    /**
     * A method that adds a passenger to the Array of String variable passengers.
     * @param distance int representative of the distance of the ride.
     * @param arr Array of String that lists the passengers to be added.
     * @return a boolean indicative of if the passengers can be added to the car.
     */
    @Override
    public boolean addPassenger(int distance, String[] arr) {
        int nullCount = 0;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null || passengers[i].equals("")) {
                ++nullCount;
            }
        }
        if (!canDrive(distance) || arr.length > passengers.length || arr.length > nullCount) {
            return false;
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < passengers.length; j++) {
                    if (passengers[j] == null || passengers[j].equals("")) {
                        passengers[j] = arr[i];
                    }
                }
            }
            chargeRide(distance);
            return true;
        }
    }

    /**
     * An override of the equals method found in the Vehicle class.
     * @param o the Object to be evaluated.
     * @return a boolean indicating wheter the parameter is equivalent to the Car.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Car) {
            Car c1 = (Car) o;
            return super.equals(o) && this.rate == c1.rate && this.fees == c1.fees
                && this.maxNumMiles == c1.maxNumMiles;
        }
        return false;
    }

    /**
     * An override of the toString method found in the Vehicle class.
     * @return a String listing certain qualities about the Car object.
     */
    @Override
    public String toString() {
        String s1 = String.format("Car " + super.toString() + " It can only drive %d miles. It costs"
            + "%.2f dollars per mile and there is a one-time fee of %.2f dollars.", this.maxNumMiles,
            this.rate, this.fees);
        return s1;
    }

    /**
     * A getter for the double rate.
     * @return the double rate.
     */
    public double getRate() {
        return this.rate;
    }

    /**
     * A getter for the double fees.
     * @return the double fees.
     */
    public double getFees() {
        return this.fees;
    }

    /**
     * A getter for the int maxNumMiles.
     * @return the int maxNumMiles.
     */
    public int getMaxNumMiles() {
        return this.maxNumMiles;
    }

    /**
     * A setter for the double rate.
     * @param rate a double representing the rate for each mile travelled in the car.
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * A setter for the double fees.
     * @param fees a double representing all fees for 1 ride in the Car.
     */
    public void setFees(double fees) {
        this.fees = fees;
    }

    /**
     * A setter for the int maxNumMiles.
     * @param maxNumMiles an int representing the maximum number of miles the car can travel.
     */
    public void setMaxNumMiles(int maxNumMiles) {
        this.maxNumMiles = maxNumMiles;
    }
}