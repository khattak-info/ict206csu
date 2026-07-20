public class Time {
    public static void main(String[] args) {
        double seconds = System.currentTimeMillis() / 1000.0;
        System.out.println("Time of (my) Existance " + seconds+ " seconds");
        double minutes = seconds / 60.0;
        System.out.println("Time of (my) Existance " + minutes+ " minutes");
        double hours = minutes / 60.0;
        System.out.println("Time of (my) Existance " + hours+ " hours");
        double days = hours / 24.0;
        System.out.println("Time of (my) Existance " + days+ " days");
        double years = days / 365.0;
        System.out.println("Time of (my) Existance " + years+ " years");
    }
}
