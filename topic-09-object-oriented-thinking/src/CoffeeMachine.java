public class CoffeeMachine{
    private int machineNumber;
    private int yearManufactured;
    private int coffeesMade;

    CoffeeMachine(){
        coffeesMade = 0;

    }

    public void makeCoffee(){
        coffeesMade++;
    }

    public int getCoffeesMade() {
        return coffeesMade;
    }

    public void setCoffeesMade(int coffeesMade) {
        this.coffeesMade = coffeesMade;
    }

    public int getMachineNumber() {
        return machineNumber;
    }

    public int getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(int yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public void setMachineNumber(int machineNumber) {
        this.machineNumber = machineNumber;
    }
}
