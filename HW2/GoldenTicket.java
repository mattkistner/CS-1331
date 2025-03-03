/**
 * A class representing a Golden Ticket discount.
 * @author Matthew Kistner.
 * GTID 903677868.
 * @version 1.
 */
public class GoldenTicket {
    private String catchphrase;
    private double discount;

    /**
     * A constructor taking in 2 parameters: a String catchphrase and a double discount.
     * The constructor accounts for invalid values to create defaults.
     * @param catchphrase is a String representative of the catchphrase given on the ticket.
     * @param discount is a double representative of the percentage of the discount.
     */
    public GoldenTicket(String catchphrase, double discount) {
        if (catchphrase == null || catchphrase.equals("")) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
        if (discount <= 0 || discount > 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }

    /**
     * A method that takes in no parameters.
     * @return a String representing the golden ticket's information.
     */
    public String ticketString() {
        String ts = String.format("Golden Ticket with a %.2f%% discount! %s", discount, catchphrase);
        return ts;
    }

    /**
     * A getter that returns the value of the String catchphrase.
     * @return the String catchphrase.
     */
    public String getCatchphrase() {
        return this.catchphrase;
    }

    /**
     * A getter that returns the value of the double discount.
     * @return the double discount.
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * A setter that asigns the value of the String catchphrase.
     * @param catchphrase a String to be set to the catchphrase.
     */
    public void setCatchphrase(String catchphrase) {
        if (catchphrase == null || catchphrase.equals("")) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
    }

    /**
     * A setter that asigns the value of the double discount.
     * @param discount a double to be set to the discount.
     */
    public void setDiscount(double discount) {
        if (discount <= 0 || discount > 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }
}