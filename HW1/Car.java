public class Car {
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;

    public void outputCondition() {
        if (conditionCategory < 40) {
            conditionCategory = 80;
        }
        if (conditionCategory >= 90 && conditionCategory <= 100) {
            System.out.println("Perfect");
        } else if (conditionCategory >= 80 && conditionCategory < 90) {
            System.out.println("Excellent");
        } else if (conditionCategory >= 70 && conditionCategory < 80) {
            System.out.println("Fine");
        } else if (conditionCategory >= 60 && conditionCategory < 70) {
            System.out.println("Very Good");
        } else if (conditionCategory >= 50 && conditionCategory < 60) {
            System.out.println("Good");
        } else if (conditionCategory >= 40 && conditionCategory < 50) {
            System.out.println("Driver");
        }
    }

    public Car(int year, String make, String model, String color, int conditionCategory) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.conditionCategory = conditionCategory;
        outputCondition();
        isRestored = this.conditionCategory >= 90;
    }

    public Car(int year, String make, String model) {
        this(year, make, model, "blue", 80);
    }

    public Car() {
        this(1960, "Jaguar", "E-Type", "silver", 89);
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getConditionCategory() {
        return conditionCategory;
    }
}
