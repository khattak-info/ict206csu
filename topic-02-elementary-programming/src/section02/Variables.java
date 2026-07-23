package section02;
import java.util.Scanner;

public class Variables {
    public static void main(String[] args) {
        // salary variable
        double salary = 0;
        
        //scanner object to read input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        salary = scanner.nextDouble();

        // tax rate variable
        int newtaxRate = 2;

        // calculate tax amount and net salary
        double taxAmount = salary * newtaxRate;
        double netSalary = salary - taxAmount;

        // display the results
        System.out.println("Your salary is: " + salary);
        System.out.println("Your tax amount is: " + taxAmount);
        System.out.println("Your net salary is: " + netSalary);
        if(netSalary > 800) {
            System.out.println("You are high earner: ");
        } else {
            System.out.println("you are not a high earner: ");
        }
        scanner.close();
    }
}
