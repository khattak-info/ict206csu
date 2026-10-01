public abstract class Car{
    public double getMileage(double fuel) {
        return 0.0;
    }
    abstract public void airBagDetails();
    public void carDetails() {
        System.out.println("Four doors.");
        System.out.println("Four wheels.");
        System.out.println("One engine.");
    }
}

class ElectricCar extends Car {
    @Override
    public double getMileage(double fuel) {
        return fuel * 100; // Example mileage calculation for electric cars
    }
    public void airBagDetails() {
        System.out.println("Electric Car has 6 airbags.");
    }
}

class PetrolCar extends Car {
    @Override
    public double getMileage(double fuel) {
        return fuel * 15; // Example mileage calculation for petrol cars
    }
    public void airBagDetails() {
        System.out.println("Petrol Car has 4 airbags.");
    }
}

class DieselCar extends Car {
    @Override
    public double getMileage(double fuel) {
        return fuel * 20; // Example mileage calculation for diesel cars
    }

    public void airBagDetails() {
        System.out.println("Diesel Car has 5 airbags.");
    }
}