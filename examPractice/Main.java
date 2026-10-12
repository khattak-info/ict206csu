package examPractice;
public class Main{
    public static void main(String[] args) {
        OpalTicket ticket = new OpalTicket("John Doe", 50.0);
        System.out.println("Holder: " + ticket.getHolder());
        System.out.println("Balance: " + ticket.getBalance());

        ticket.addBalance(20.0);
        System.out.println("New Balance: " + ticket.getBalance());


        TransportPass transportPass = new TransportPass("Jane Smith", 30.0, 5.0);
        System.out.println("Holder: " + transportPass.getHolder());
        System.out.println("Balance: " + transportPass.getBalance());
        System.out.println("Fare: " + transportPass.calculateFare());
    }
}