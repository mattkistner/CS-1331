public class CurrencyConversion{
    public static void main(String[] args){
        double aedPerUsd = 3.67;
        double aedPerEur = 4.19;
        int notes = 250;
        String name = "Matthew";
        double euros = notes / aedPerEur;
        double dollars = notes / aedPerUsd;
        System.out.printf(name + " is carrying %.2f Euros and %.2f Dollars!", euros, dollars);
    }
}