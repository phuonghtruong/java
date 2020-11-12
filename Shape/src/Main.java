public class Main {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
        FactoryShape factory = new FactoryShape();
        Shape s1 = factory.createShape(EnumShape.RECTANGLE, point, 3, 4);
        System.out.println("Area of Rectangle: "  + s1.getArea());
        System.out.println("Perimeter of Rectangle: "  + s1.getPerimeter());
    }
}
