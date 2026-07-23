package section02;
import java.util.Scanner;

public class ComputeArea {
    public static void main(String[] args) {
        // add scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius of the circle");
        double radius = input.nextDouble();

        // calculate area
        double area = Math.PI * Math.pow(radius, 2);

        // print area
        System.out.println("Value of PI " + Math.PI);
        System.out.println("The Area is :" + area);

        // close scanner
        input.close();
    }
}
