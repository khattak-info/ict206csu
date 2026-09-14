import java.util.Scanner;

public class exceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();
        try 
        {
            int result = divide(a, b);
            System.out.println("Result: " + result);
            
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }

    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }
}
