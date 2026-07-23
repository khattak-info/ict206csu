package section02;
import java.util.Scanner;

public class Variables {
    public static void main(String[] args) {
        double salary = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        salary = scanner.nextDouble();
        int newtaxRate = 2;
    
        

        double taxAmount = salary * newtaxRate;
        double netSalary = salary - taxAmount;

        if(netSalary > 800) {
            System.out.println("You are high earner: " + netSalary);
        } else {
            System.out.println("you are not a high earner: " + netSalary);
        }
        scanner.close();
    }
}
