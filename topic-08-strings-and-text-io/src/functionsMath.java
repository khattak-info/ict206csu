import java.util.Scanner;

public class functionsMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();


        System.out.println("The square of the number you entered is: " + Math.sqrt(number));
        System.out.println("The cube of the number you entered is: " + Math.cbrt(number));
        System.out.println("The absolute value of the number you entered is: " + Math.abs(number));
        System.out.println("The sine of the number you entered is: " + Math.sin(number));
        System.out.println("The cosine of the number you entered is: " + Math.cos(number));
        System.out.println("The tangent of the number you entered is: " + Math.tan(number));
    }
    
}
