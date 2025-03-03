public class BatteryCalculator{
    public static void main(String[] args){
        int tikTokHours = 2;
        int spotifyHours = 3;
        double messagingHours = 1.5;
        double instagramHours = 0.5;
        int phoneBattery = 100;
        phoneBattery -= (tikTokHours * 17) + (spotifyHours * 5) + (messagingHours * 8) + (instagramHours * 12);
        System.out.printf("The battery of my phone at the end of the day is %d%%. \n", phoneBattery);
    }
}