/**
 * A subclass of the Pet class that defines a Hippo object.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Hippo extends Pet {
    private int buff;

    /**
     * A constructor that initializes a Hippo instance.
     * @param health an int representing the health value of a Hippo.
     * @param attack an int representing the magnitude of a Hippo's attack.
     * @param buff an int representing the scalar by which the Hippo can increment its health and attack.
     */
    public Hippo(int health, int attack, int buff) {
        super(health, attack);
        this.buff = buff;
    }

    /**
     * A constructor that initializes a Hippo with no parameters.
     * health is defaulted to 7.
     * attack is defaulted to 4.
     * buff is defaulted to 2.
     */
    public Hippo() {
        this(7, 4, 2);
    }

    /**
     * A method that allows the Hippo to become buff.
     * Increments the health and attack values by buff.
     */
    public void getBuffed() {
        setHealth(getHealth() + buff);
        setAttack(getAttack() + buff);
    }

    @Override
    public void attackPet(Pet injured) {
        injured.getAttacked(this.getAttack());
        if (injured.hasFainted()) {
            this.getBuffed();
        }
    }

    @Override
    public String toString() {
        String s1 = String.format("Hippo:" + super.toString() + "/%d", this.buff);
        return s1;
    }
}