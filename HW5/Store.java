import java.util.ArrayList;
/**
 * A class representing a Store full of Desserts.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Store {
    private String name;
    private ArrayList<Dessert> desserts;

    /**
     * A constructor taking in 1 parameter to instantiate a Store.
     * @param name String naming the Store.
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<>();
    }

    /**
     * Method that adds a Dessert to the Store.
     * @param d Dessert to be added.
     */
    public void addDessert(Dessert d) {
        desserts.add(d);
    }

    /**
     * Method that removes a Dessert from the Store using Linear Search.
     * @param d Dessert to be removed.
     * @return Dessert removed.
     */
    public Dessert removeDessert(Dessert d) {
        for (Dessert de : desserts) {
            if (d.equals(de)) {
                desserts.remove(d);
                return d;
            }
        }
        return null;
    }

    /**
     * Method that finds a Dessert in the Store using Binary Search.
     * @param d Dessert to be found.
     * @return Dessert if found, null if not found.
     */
    public Dessert findDessert(Dessert d) {
        int b = 0;
        int l = desserts.size() - 1;
        int mid = 0;
        while (b <= l) {
            mid = (b + l) / 2;
            if (desserts.get(mid).compareTo(d) < 0) {
                b = mid + 1;
            } else if (desserts.get(mid).compareTo(d) > 0) {
                l = mid - 1;
            } else {
                Dessert d1 = desserts.get(mid);
                return d1;
            }
        }
        return null;
    }

    /**
     * Method that sorts the Store using Bubble sort.
     */
    public void sortStore() {
        int t = desserts.size();
        for (int i = 0; i < t; i++) {
            int l = i;
            for (int j = i + 1; j < t; j++) {
                if (desserts.get(j).compareTo(desserts.get(i)) < 0) {
                    l = j;
                }
            }
            Dessert temp = desserts.get(l);
            desserts.remove(l);
            desserts.add(i, temp);
        }
    }

    /**
     * Method that checks to see how many desserts in the store are greater than a certain dessert.
     * @param d Dessert to be evaluated.
     * @return int representing number of desserts greater than parameter.
     */
    public int checkStore(Dessert d) {
        int c = 0;
        for (int i = 0; i <= desserts.size(); i++) {
            if (d.compareTo(desserts.get(i)) <= 0) {
                ++c;
            }
        }
        return c;
    }

    /**
     * A getter for the ArrayList desserts.
     * @return ArrayList of Dessert.
     */
    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}