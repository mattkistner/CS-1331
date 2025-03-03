/**
 * A subclass, extending the Exception class, triggered if an item is not in a Vending Machine.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class ItemNotContainedException extends Exception {
    /**
     * A constructor that produces an Exception message.
     * @param item String defining an item found or not found in a Vending Machine.
     */
    public ItemNotContainedException(String item) {
        super(item + " not sold in this vending machine.");
    }
}