/**
 * A class aiding as a test class for all paper classes.
 * @author Matthew Kistner.
 * GTID 903677868.
 * @version 1.
 */
public class Warehouse {
    /**
     * Main method.
     * @param args input to the main method.
     */
    public static void main(String[] args) {
        GoldenTicket ticket = new GoldenTicket("WOO!", 40.0);
        PaperProduct p1 = new PaperProduct("Standard", 750, 0.4);
        PaperProduct p2 = new PaperProduct("Cardstock");
        DiscountedPaper d1 = new DiscountedPaper("Posterboard", 300, 0.5, 10.0, ticket);
        DiscountedPaper d2 = new DiscountedPaper("Stiff A40");
        PhotoPaper ph1 = new PhotoPaper("Printer", 230, 0.2, 60);
        PhotoPaper ph2 = new PhotoPaper("Dunder");
        PaperProduct p3 = new PaperProduct(p2);
        p3.setNumberOfSheets(210);
        System.out.println(p2.paperString());
        System.out.println(p3.paperString());
        System.out.println(p1.ship("Matthew's House"));
        System.out.println(p2.ship("Hopkins Hall"));
        System.out.println(d1.shipDiscounted("Bobby Dodd"));
        System.out.println(d2.shipDiscounted("CULC"));
        System.out.println(ph1.shipPhoto("Willage"));
        System.out.println(ph2.shipPhoto("NAV"));
        System.out.println(d1.botherAccounting());
        System.out.println(d2.botherAccounting());

    }
}