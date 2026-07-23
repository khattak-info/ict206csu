import java.util.Scanner;

public class FindMinutes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter total Seconds: ");
        int totalSeconds = input.nextInt();
        double minutesD = totalSeconds / 60.0;
        int minutesI = totalSeconds / 60;

        System.out.println("Total Minutes (double): " + minutesD);
        System.out.println("Total Minutes (int): " + minutesI);
    }
}
