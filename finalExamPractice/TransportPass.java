package finalExamPractice;
class TransportPass extends OpalTicket {
    private double fare;

    public TransportPass(String holder, double balance, double fare) {
        super(holder, balance);
        this.fare = fare;
    }

    public double calculateFare() {
        return fare;
    }
}