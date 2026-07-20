import java.util.Scanner;
public class ComputeArea {
    public static void main(String[] args){
        // radius is a double variable initialized to 0.0
        double radius;
        double area;
        double pi = 3.14159;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a double value and hit ENTER on your keyboard");
        radius = input.nextDouble();
        area = pi * radius * radius ;
        System.out.println("The area of the circle is: " + area);
    }
}