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

class HybridCar extends Car implements CarInterface {
    @Override
    public double getMileage(double fuel) {
        return fuel * 30; // Example mileage calculation for hybrid cars
    }

    public void airBagDetails() {
        System.out.println("Hybrid Car has 7 airbags.");
    }

    @Override
    public double tyrePressure() {
        return 32.0; // Example tyre pressure for hybrid cars
    }

    @Override
    public double brakeEfficiency() {
        return 0.85; // Example brake efficiency for hybrid cars
    }

    @Override
    public double fuelEfficiency() {
        return 50.0; // Example fuel efficiency for hybrid cars
    }

    @Override
    public double enginePower() {
        return 150.0; // Example engine power for hybrid cars
    }
}