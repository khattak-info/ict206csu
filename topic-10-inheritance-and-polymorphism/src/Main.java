public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Car c1 = new ElectricCar();
        Car c2 = new PetrolCar();
        Car c3 = new DieselCar();

        c1.carDetails();
        c1.airBagDetails();
        System.out.println("Electric Car Mileage: " + c1.getMileage(5));
        // Example fuel input
        c2.carDetails();
        c2.airBagDetails();
        System.out.println("Petrol Car Mileage: " + c2.getMileage(5));

        c3.carDetails();
        c3.airBagDetails();
        System.out.println("Diesel Car Mileage: " + c3.getMileage(5));
        }
}