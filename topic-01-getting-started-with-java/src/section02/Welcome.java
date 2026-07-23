public class Welcome {
    public static void main(String[] args) {
        System.out.println("I have two numbers and this was there sum " + sum1(5, 10));

        int Num1 = 5;
        int num1 =10;
    }   

    static int sum1(int a, int b) {   
       return a + b;
    }

    static void sum2(int a, int b) {   
       System.out.println("This was there sum " + (a + b));
    }
}
