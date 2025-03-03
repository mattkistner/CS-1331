public class GarageOwner {
    private String name;
    private int age;
    private int carsOwned;

    public GarageOwner(String name, int age) {
        this.name = name;
        this.age = age;
        this.carsOwned = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(int carsOwned) {
        this.carsOwned = carsOwned;
    }
}