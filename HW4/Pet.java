/**
 * An abstract class that serves as a blueprint for every subclass of a Pet.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public abstract class Pet implements Comparable<Pet> {
    private int health;
    private int attack;

    /**
     * A constructor for a Pet object.
     * @param health an int representing the health value of a Pet.
     * @param attack an int representing the power of a Pet's attack.
     */
    public Pet(int health, int attack) {
        if (health <= 0) {
            this.health = 1;
        } else {
            this.health = health;
        }
        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }

    /**
     * A method to test if a Pet has fainted.
     * @return a boolean indicating if the Pet has fainted: the health value is less than or equal to 0.
     */
    public boolean hasFainted() {
        return health <= 0;
    }

    /**
     * A method that is invoked when a Pet takes damage.
     * @param damage an int representing the amount of damage taken.
     * The health value of this Pet is decremented by the damage value.
     */
    public void getAttacked(int damage) {
        this.health -= damage;
    }

    /**
     * A method that is invoked when this Pet attacks another Pet.
     * @param injured the Pet being attacked and losing health.
     */
    public void attackPet(Pet injured) {
        injured.getAttacked(this.attack);
    }

    @Override
    public String toString() {
        String s1 = String.format("%d/%d", this.attack, this.health);
        return s1;
    }

    @Override
    public int compareTo(Pet pet) {
        if (pet == null) {
            return (this.attack + this.health);
        }
        return (this.health + this.attack) - (pet.health + pet.attack);
    }

    /**
     * A getter for the int health.
     * @return an int representing the health value of the Pet.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * A getter for the int attack.
     * @return an int representing the magnitude of an attack by a Pet.
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * A setter for the int health.
     * @param health an int representing the health value of a Pet.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * A setter for the int attack.
     * @param attack an int representing the magnitude of an attack by a Pet.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
}