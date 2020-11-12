public class Rectangle implements Shape{
    private Point bottomLeftPoint;
    private Point bottomRightPoint;
    private Point topLeftPoint;
    private Point topRightPoint;

    public Rectangle( Point x, double width, double length)
    {
        bottomLeftPoint = x;
        bottomRightPoint = new Point(x.getX() + length, x.getY());
        topLeftPoint = new Point(x.getX(), x.getY() + length);
        topRightPoint = new Point(x.getX() + length, x.getY() + width);
    }

    @Override
    public double getArea() {
        double width = Math.abs(bottomLeftPoint.getY() - topLeftPoint.getY());
        double length = Math.abs(bottomLeftPoint.getX() - bottomRightPoint.getX());
        return width * length;
    }

    @Override
    public double getPerimeter() {
        double width = Math.abs(bottomLeftPoint.getY() - topLeftPoint.getY());
        double length = Math.abs(bottomLeftPoint.getX() - bottomRightPoint.getX());
        return (width + length) * 2;
    }
}
