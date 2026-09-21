public class CoffeeMaker {
    
    private int strength;
    public CoffeeMaker(int strength) {
        this.strength = strength;
    }
    public void brewCoffee() {
        System.out.println("Brewing coffee with strength: " + strength);
    }
}