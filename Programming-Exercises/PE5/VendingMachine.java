import java.util.ArrayList;
/**
 * A class that defines a Vending Machine.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class VendingMachine {
    ArrayList<String> itemsContained;
    int cost;

    /**
     * A constructor that takes in 2 parameters to create a VendingMachine object.
     * @param itemsContained ArrayList of String that defines the items in the VendingMachine.
     * @param cost int defining the cost of an item.
     */
    public VendingMachine(ArrayList<String> itemsContained, int cost) {
        this.itemsContained = itemsContained;
        this.cost = cost;
    }
    
    /**
     * A method that checks if an item is in a VendingMachine.
     * @param itemsBought ArrayList of String defining the items to be bought.
     * @throws ItemNotContainedException if the item is not in the machine.
     */
    public void checkIfItemsSold(ArrayList<String> itemsBought) throws ItemNotContainedException {
        for (String item : itemsBought) {
            if (!itemsContained.contains(item)) {
                throw new ItemNotContainedException(item);
            }
        }
    }

    /**
     * A method that buys an item from a Vending Machine.
     * @param item String representing the item to be bought.
     * @param money int representing the money put in the machine.
     * @throws ItemNotContainedException if the item is not in the machine.
     */
    public void buyItem(String item, int money) throws ItemNotContainedException {
        checkIfItemsSold(new ArrayList<String>(java.util.Arrays.asList(item)));
        if (cost > money) {
            throw new NotEnoughMoneyException();
        } else {
            itemsContained.remove(item);
        }
    }

    /**
     * A method that removes items that are not in a Vending Machine.
     * @param items ArrayList of String that consists of items to be removed. 
     * @return ArrayList of String consisting of the removed items.
     */
    public ArrayList<String> removeAbsentItems(ArrayList<String> items) {
        ArrayList<String> removedAbsent = new ArrayList<String>();
        for (String item : items) {
            if (itemsContained.contains(item)) {
                removedAbsent.add(item);
            }
        }
        return removedAbsent;
    }
    
    /**
     * main method consisting of test code.
     * @param args standard parameter. 
     */
    public static void main(String[] args) {
        ArrayList<String> vendingItems = new ArrayList<String>(java.util.Arrays.asList("Gummies", "Skit"
            + "tles", "Lays", "Cheetos", "Twix"));
        VendingMachine hopkins = new VendingMachine(vendingItems, 2);
        try {
            hopkins.checkIfItemsSold(vendingItems);
            hopkins.removeAbsentItems(vendingItems);
        } catch (ItemNotContainedException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Took stock of the vending machine!");
        }
    }
}