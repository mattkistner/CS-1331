/**
 * A subclass of the Pet class that defines a Skunk object.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Skunk extends Pet {
    private int numSpray;

    /**
     * A constructor that initializes a Skunk object with 3 parameters.
     * @param health an int representing the health value of the Skunk.
     * @param attack an int representing the magnitude of the Skunk's attack.
     * @param numSpray an int representing how many times a skunk can spray.
     */
    public Skunk(int health, int attack, int numSpray) {
        super(health, attack);
        if (numSpray < 0) {
            this.numSpray = 0;
        } else {
            this.numSpray = numSpray;
        }
    }

    /**
     * A constructor that takes in no parameters to initialize a Skunk object.
     * health is defaulted to 5.
     * attack is defaulted to 3.
     * numSpray is defaulted to 1.
     */
    public Skunk() {
        this(5, 3, 1);
    }

    /**
     * A method that makes a Skunk spray another Pet.
     * @param sprayed a Pet that is being sprayed.
     * the sprayed Pet has their health and attack values reduced by a third.
     */
    public void sprayPet(Pet sprayed) {
        sprayed.setHealth((sprayed.getHealth() / 3) * 2);
        sprayed.setAttack((sprayed.getAttack() / 3) * 2);
        this.numSpray -= 1;
    }

    @Override
    public void attackPet(Pet injured) {
        if (this.numSpray > 0) {
            sprayPet(injured);
        }
        injured.getAttacked(this.getAttack());
    }

    @Override
    public String toString() {
        String s1 = String.format("Skunk:" + super.toString() + "/%d", this.numSpray);
        return s1;
    }
}