/**
 * A subclass, extending the RuntimeException, triggered if someone does not have enough money.
 * @author Matthew Kistner. 
 * GT ID 903677868.
 * @version 1. 
 */
public class NotEnoughMoneyException extends RuntimeException {
    /**
     * A constructor that produces a message if the exception is triggered. 
     */
    public NotEnoughMoneyException() {
        super("Item not vended. Insufficient funds.");
    }
}