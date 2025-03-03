import java.util.Random;

public class BendingBattlefield{
    public static void main(String[] args){
        Random rand = new Random();
        int numHeroes = rand.nextInt(51) + 50;
        double boomerangBoost = rand.nextDouble() * 4 + 3;

        double averageFirePower = 0.0;
        double averageFireHealth = 0.0;
        double averageAlliancePower = 0.0;
        double averageAllianceHealth = 0.0;

        System.out.printf("Selecting %s heroes.%n", numHeroes);

        int numFire = 0;
        int numAlliance = 0;

        while (numHeroes > 0){
            BendingType heroType = BendingType.values()[rand.nextInt(5)];
            double health = Math.round((rand.nextDouble() * 100 + 50) * 100.0) / 100.0;
            double power = Math.round((rand.nextDouble() * 80 + 40) * 100.0) / 100.0;
            if (heroType == BendingType.FIRE){
                averageFireHealth += health;
                averageFirePower += power;
                ++numFire;
            }
            else if (heroType == BendingType.NON_BENDER){
                power = power * boomerangBoost;
                averageAllianceHealth += health;
                averageAlliancePower += power;
                ++numAlliance;
            }
            else {
                averageAllianceHealth += health;
                averageAlliancePower += power;
                ++numAlliance;
            }
            System.out.printf("%s hero has been summoned by his army, adding %.2f power and %.2f health to the army.%n", heroType, power, health);
            
            numHeroes -= 1;
        }

        averageFirePower /= numFire;
        averageFireHealth /= numFire;
        averageAlliancePower /= numAlliance;
        averageAllianceHealth /= numAlliance;

        System.out.printf("The Fire Nation has an average of %.2f power and %.2f health.%n", averageFirePower, averageFireHealth);
        System.out.printf("The Alliance has an average of %.2f power and %.2f health.%n", averageAlliancePower, averageAllianceHealth);

        double fireFinal = 2 * averageFirePower + 3 * averageFireHealth;
        double allianceFinal = 2 * averageAlliancePower + 3 * averageAllianceHealth;

        if (fireFinal > allianceFinal){
            System.out.print("The Fire Nation won!");
        }
        else {
            System.out.print("The Alliance won!");
        }
    }
}
