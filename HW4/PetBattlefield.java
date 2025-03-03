/**
 * A class where teams of Pet objects battle.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class PetBattlefield {
    private Pet[] firstTeam;
    private Pet[] secondTeam;

     /**
     * A constructor that takes in two pet teams.
     * @param firstTeam an Array of Pet objects defined as team 1.
     * @param secondTeam an Array of Pet objects defined as team 2.
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        if (firstTeam.length > 5 || secondTeam.length > 5) {
            this.firstTeam = new Pet[5];
            this.secondTeam = new Pet[5];
        } else {
            this.firstTeam = firstTeam;
            this.secondTeam = secondTeam;
        }
    }

    /**
     * A method that initializes and helps to create a String for the toString method.
     * @param pets an Array of Pet objects.
     * @return a String detailing a team of Pet objects.
     */
    public String creator(Pet[] pets) {
        String s1 = "";
        int i = 0;
        for (Pet pet : pets) {
            s1 += (pet == null) ? " Empty" : " " + pet.toString();
            if (i < (pets.length - 1)) {
                s1 += ",";
            }
            i++;
        }
        return s1;
    }
    @Override
    public String toString() {
        return "First Team:" + creator(firstTeam) + " vs Second Team:" + creator(secondTeam);
    }

    /**
     * A method that compares the 2 Array of Pet teams.
     * Prints out a prediction of which team will win.
     */
    public void compareTeams() {
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i] == null && secondTeam[i] != null) {
                t2 += 1;
            } else if (firstTeam[i] != null && firstTeam[i].compareTo(secondTeam[i]) > 0) {
                t1 += 1;
            } else if (firstTeam[i] != null && firstTeam[i].compareTo(secondTeam[i]) < 0) {
                t2 += 1;
            }
        }
        if (t1 == t2) {
            System.out.println("It is an even match.");
        } else {
            System.out.println("The " + (t1 > t2 ? "first " : "second ") + "team will probably win.");
        }
    }

    /**
     * A method that makes the two Array of Pet teams battle.
     * Prints out a winner.
     */
    public void battle() {
        int i1 = 0;
        int i2 = 0;
        int first = firstTeam.length;
        int second = secondTeam.length;
        while ((i1 < firstTeam.length && firstTeam[i1] != null)
            && (i2 < secondTeam.length && secondTeam[i2] != null)) {
            firstTeam[i1].attackPet(secondTeam[i2]);
            secondTeam[i2].attackPet(firstTeam[i1]);
            if (firstTeam[i1].hasFainted()) {
                firstTeam[i1] = null;
                i1++;
                first--;
            }
            if (secondTeam[i2].hasFainted()) {
                secondTeam[i2] = null;
                i2++;
                second--;
            }
        }
        if (first == second) {
            System.out.println("Both teams fainted.");
        } else {
            System.out.println("The " + (first > second ? "first " : "second ") + "team won!");
        }
    }

    /**
     * A main method to test the code.
     * @param args default parameter.
     */
    public static void main(String[] args) {
        Pet[] team1 = {new Skunk(5, 7, 2), null, new Skunk(), new Hippo(4, 2, 1), new Turtle(6, 6, true)};
        Pet[] team2 = {new Hippo(8, 8, 2), new Turtle(), new Hippo(), new Skunk(6, 3, 4), null};
        Pet[] team3 = {new Hippo(10, 12, 1), new Hippo(), null, null, new Skunk(4, 7, 8)};
        Pet[] team4 = {null, new Skunk(), new Turtle(5, 8, true), null, new Turtle()};
        PetBattlefield rosebowl = new PetBattlefield(team1, team4);
        PetBattlefield orangebowl = new PetBattlefield(team2, team3);
        System.out.println(orangebowl.toString());
        System.out.println(rosebowl.toString());
        orangebowl.compareTeams();
        rosebowl.compareTeams();
        orangebowl.battle();
        System.out.println(orangebowl.toString());
        rosebowl.battle();
        System.out.println(rosebowl.toString());
    }
}