// this example was written by Hasan
// July 17, 2026
// Lecture of week 1

public class App{
    public static void main(String[] args){
        System.out.println("Hello, Thursday class");
        System.out.println("Today is 17 july 2026");
        System.out.println("I am learning Java in ITC206");
        liveAlone(23);
        sum(5, 10);
        deduct(10, 5);
    }
    // this method is the solution for question 1 in assignement 1
    static void sum(int num1, int num2){
        int sum = num1 + num2;
        System.out.println("The sum is: " + sum);
    }
    static void deduct(int num1, int num2){
        int deduct = num1 - num2;
        System.out.println("The deduct is: " + deduct);
    }

    static void liveAlone(int age){
        if(age>=18){
            System.out.println("You can live alone, get married and have a house");
        }
    }
}