public class Garage {
    private GarageOwner theOwner;
    private Car[] carCatalogue;

    public Garage(GarageOwner theOwner, Car[] carCatalogue) {
        this.theOwner = theOwner;
        this.carCatalogue = carCatalogue;
    }

    public Garage() {
        this(new GarageOwner("Enzo Ferrari", 35), new Car[4]);
    }

    public Car addCar(int i, Car car) {
        if (i < 0 || i > carCatalogue.length - 1 || car == null) {
            System.out.println("Cannot add a car to this spot");
            return null;
        } else if (carCatalogue[i] != null) {
            Car oldCar = carCatalogue[i];
            System.out.printf("There was a %s %d %s %s here before.%n", carCatalogue[i].getColor(),
                carCatalogue[i].getYear(), carCatalogue[i].getMake(), carCatalogue[i].getModel());
            carCatalogue[i] = car;
            return oldCar;
        } else if (this.carCatalogue[i] == null) {
            carCatalogue[i] = car;
            System.out.printf("A %s %d %s %s was just parked here.%n", car.getColor(),
                car.getYear(), car.getMake(), car.getModel());
            return null;
        }
        return null;
    }

    public Car sellCar(int i) {
        if (i < 0 || i > carCatalogue.length - 1 || carCatalogue[i] == null) {
            System.out.println("There was no car to sell!");
            return null;
        } else if (carCatalogue[i] != null) {
            System.out.printf("%s just sold a %s %d %s %s.%n", theOwner.getName(), carCatalogue[i].getColor(),
                carCatalogue[i].getYear(), carCatalogue[i].getMake(), carCatalogue[i].getModel());
            theOwner.setCarsOwned(carCatalogue.length - 1);
            return carCatalogue[i];
        }
        return null;
    }

    public void showCertainCars(int cc) {
        for (Car car: carCatalogue) {
            if (car.getConditionCategory() > cc) {
                System.out.printf("A %s %d %s %s with a condition category of %d.%n", car.getColor(),
                    car.getYear(), car.getMake(), car.getModel(), car.getConditionCategory());
            }
        }
    }

}