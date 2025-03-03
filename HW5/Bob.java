/**
 * A class to represent Bob and his behaviors.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Bob {

    /**
     * A method comparing two stores.
     * @param s1 1st store to be compared.
     * @param s2 2nd store to be compared to store 1.
     * @return boolean representing if the two stores have the same desserts.
     */
    public static boolean compareStores(Store s1, Store s2) {
        for (int i = 0; i < s1.getDesserts().size() - 1; i++) {
            if (s2.findDessert(s1.getDesserts().get(i)) == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * A method seeing if the dessert Bob desires is at a store.
     * @param s Store to be investigated.
     * @param d Dessert that Bob desires.
     * @return boolean indicating if the store has the dessert.
     */
    public static boolean shop(Store s, Dessert d) {
        s.sortStore();
        return s.findDessert(d) == null;
    }
}