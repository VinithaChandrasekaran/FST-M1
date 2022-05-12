package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car i20 = new Car();
        i20.make = 2014;
        i20.color = "Black";
        i20.transmission = "Manual";

        i20.displayCharacteristics();
        i20.accelarate();
        i20.brake();
    }

}
