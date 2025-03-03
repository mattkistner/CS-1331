/**
 * A subclass of the Pet class that defines a Turtle object.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Turtle extends Pet {
    private boolean melonArmor;

    /**
     * A constructor that initializes a Turtle instance.
     * @param health an int representing the health value.
     * @param attack an int representing the power of attack.
     * @param melonArmor a boolean indicating if the Turtle possesses armor/some shielding from attack.
     */
    public Turtle(int health, int attack, boolean melonArmor) {
        super(health, attack);
        this.melonArmor = melonArmor;
    }

    /**
     * A constructor that takes in no parameters.
     * health is defaulted to 4.
     * attack is defaulted to 2.
     * melonArmor is defaulted to true.
     */
    public Turtle() {
        this(4, 2, true);
    }


    @Override
    public void getAttacked(int damage) {
        if (this.melonArmor) {
            if (damage > 20) {
                this.setHealth(this.getHealth() - (damage - 20));
                this.melonArmor = false;
            } else {
                this.melonArmor = false;
            }
        } else {
            this.setHealth(this.getHealth() - damage);
        }
    }

    @Override
    public String toString() {
        String s1 = String.format("Turtle:" + super.toString() + "/%b", this.melonArmor);
        return s1;
    }
}