public class MilkDispenser{
    private String milkType;
    public MilkDispenser(String milkType) {
        this.milkType = milkType;   
    }
    public void dispenseMilk() {
        System.out.println("Dispensing milk of type: " + milkType);
    }
}