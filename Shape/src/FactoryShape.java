public class FactoryShape{

    public Shape createShape(EnumShape type, Point x, double width, double length)
    {
        Shape shape;
        switch (type)
        {
            case RECTANGLE:
                shape = new Rectangle(x ,width, length);
                break;
            case SQUARE:
                shape = new Square(x,width);
                break;
            case TRIANGLE:
            default:
                throw new IllegalArgumentException("Illegal shape!!!");
        }
        return shape;
    }
}
