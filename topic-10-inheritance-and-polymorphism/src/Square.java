public class Square extends Shape {
    public Square() {
        System.out.println("Square constructor");
        super();
    }
    
    @Override
    public int area() {
        System.out.println("Area of Square");
        return length * length;
    }
    
}
