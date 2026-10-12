public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Car c1 = new ElectricCar();
        c1.carDetails();
        c1.airBagDetails();
        System.out.println("Electric Car Mileage: " + c1.getMileage(5));
        }
}