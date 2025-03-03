/**
 * A child class of the abstract Vehicle class that represents a Bus.
 * @author Matthew Kistner
 * GT ID 903677868.
 * @version 1.
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * A constructor that creates a Bus with 4 parameters.
     * @param id String representative of the exact instance of this Bus.
     * @param numMiles int representing the miles travelled by the Bus.
     * passengers is defaulted to an Array of String with length 20.
     * @param location String represents the area of the Bus route.
     * @param stopsPerMile int representing the number of stops in a mile.
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * A constructor that creates a Bus with 2 parameters.
     * @param id String representative of the exact instance of this Bus.
     * numMiles is defaulted to 0.
     * passengers is defaulted to an Array of String with length 20.
     * @param location String represents the area of the Bus route.
     * stopsPerMile is defaulted to 2.
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }

    /**
     * A method that returns a boolean indicative of if the bus can drive a desired distance.
     * @param distance int representative of the desired distance for the bus to travel.
     * @return a boolean indicating if the bus can drive the distance.
     */
    @Override
    public boolean canDrive(int distance) {
        if (distance < 0) {
            return false;
        }
        return true;
    }

    /**
     * A method that calculates the cost of a ride.
     * @param distance int representative of the distance of the ride.
     * @return a double representing the cost of the ride with all fees taken into account.
     * if the bus cannot travel the distance then -1 will be returned.
     */
    @Override
    public double calculateCost(int distance) {
        if (!canDrive(distance)) {
            return -1;
        }
        return (distance * 3) / stopsPerMile;
    }

    /**
     * A method that adds a passenger to the Array of String variable passengers.
     * @param distance int representative of the distance of the ride.
     * @param arr Array of String that lists the passengers to be added.
     * @return a boolean indicative of if the passengers can be added to the bus.
     */
    @Override
    public boolean addPassenger(int distance, String[] arr) {
        if (!canDrive(distance)) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < passengers.length; j++) {
                if (passengers[j] != null) {
                    continue;
                } else {
                    passengers[j] = arr[i];
                    setEarnings(getEarnings() + calculateCost(distance));
                }
            }
        }
        this.numMiles += distance;
        return true;
    }

    /**
     * An override of the equals method found in the Vehicle class.
     * @param o the Object to be evaluated.
     * @return a boolean indicating wheter the parameter is equivalent to the Bus.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Bus) {
            Bus b1 = (Bus) o;
            return super.equals(o) && this.location.equals(b1.location) && this.stopsPerMile == b1.stopsPerMile;
        }
        return false;
    }

    /**
     * An override of the toString method found in the Vehicle class.
     * @return a String listing certain qualities about the Bus object.
     */
    @Override
    public String toString() {
        String s1 = String.format("Bus " + super.toString() + " This bus drives around %s and"
            + "makes %d stops per mile.", this.location, this.stopsPerMile);
        return s1;
    }

    /**
     * A getter for the String location.
     * @return the String location.
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * A getter for the int stopsPerMile.
     * @return the int stopsPerMile.
     */
    public int getStopsPerMile() {
        return this.stopsPerMile;
    }

    /**
     * A setter for the String location.
     * @param location a String representing the general location of the Bus route.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * A setter for the int stopsPerMile.
     * @param stopsPerMile an int representing the stops a Bus makes per mile.
     */
    public void setStopsPerMile(int stopsPerMile) {
        this.stopsPerMile = stopsPerMile;
    }
}