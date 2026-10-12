package examPractice;

class StudentPass extends TransportPass implements DiscountableInterface {
    final private double discount;

    public StudentPass(String holder, double balance, double fare, double discount) {
        super(holder, balance, fare);
        this.discount = discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}