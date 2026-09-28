public class Rectangle extends Shape {
    int width;
    public Rectangle() {
        System.out.println("Rectangle constructor");
        super();
    }
    
    @Override
    public int area() {
        System.out.println("Area of Rectangle");
        return length * width;
    }
    
    public int area(int length, int width) {
        System.out.println("Area of Rectangle");
        return length * width;
    }
}
