public class TestingArea {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.length = 5;
        rectangle.width = 10;
        rectangle.message();
        System.out.println(rectangle.area());
    }
    
}
