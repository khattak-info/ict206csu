package finalExamPractice;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        OpalTicket ticket = new OpalTicket("John Doe", 150.0);
        TransportPass transportPass = new TransportPass("Jane Smith", 150.0, 5.0);
        StudentPass studentPass = new StudentPass("Alice Johnson", 250.0, 3.0, 0.1);

        ArrayList<OpalTicket> passes = new ArrayList<>();
        passes.add(transportPass);
        passes.add(studentPass);
        passes.add(ticket);

        OpalTicket ticket2 = new OpalTicket("Hasan", 50.0);
        passes.add(ticket2);


        StudentPass studentPass2 = new StudentPass("Ivan", 20.0, 4.0, 0.15);
        passes.add(studentPass2);
 
        getDetails(passes);
        giveBonus(passes);
        getDetails(passes);
    }

    public static void giveBonus(ArrayList<OpalTicket> passes) {
        for (OpalTicket pass : passes) {
            if (pass.getBalance() < 25.0) {
                System.out.println("Warning: Low balance!" + pass.getHolder() + " has only " + pass.getBalance() + " left.");
                System.out.println("NSW government is giving you 10 dollars for free. Please check your balance.");
                pass.addBalance(10.0);
                System.out.println("New Balance: " + pass.getBalance());
            }
        }
    }

    public static void getDetails(ArrayList<OpalTicket> passes) {
        for (OpalTicket pass : passes) {
            System.out.print("Holder: " + pass.getHolder());
            System.out.println(" has Balance: " + pass.getBalance());
        }
    }
}