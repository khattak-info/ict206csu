public class CoffeeMachine {
    private int machineNumber;

    public CoffeeMachine(int machineNumber) {
        this.machineNumber = machineNumber;
    }

    public void makeCoffee(int strength, String milkType) {
        CoffeeMaker coffeeMaker = new CoffeeMaker(strength);
        coffeeMaker.brewCoffee();

        MilkDispenser milkDispenser = new MilkDispenser(milkType);
        milkDispenser.dispenseMilk();

        System.out.println("Coffee made by machine number: " + machineNumber);
        System.out.println("Coffee strength: " + strength);
        System.out.println("Milk type: " + milkType);
        System.out.println("Enjoy your coffee!");
    }

}