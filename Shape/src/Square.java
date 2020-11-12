public class Square implements Shape{
    private Point bottomLeftPoint;
    private Point bottomRightPoint;
    private Point topLeftPoint;
    private Point topRightPoint;

    public Square(Point point, double width)
    {
        bottomLeftPoint = point;
        bottomRightPoint = new Point(point.getX() + width, point.getY());
        topLeftPoint = new Point(point.getX(), point.getY() + width);
        topRightPoint = new Point(point.getX() + width, point.getY() + width);
    }

    @Override
    public double getArea() {
        double width = Math.abs(bottomLeftPoint.getX() - bottomRightPoint.getX());
        return width * width;
    }

    @Override
    public double getPerimeter() {
        double width = Math.abs(bottomLeftPoint.getX() - bottomRightPoint.getX());
        return width * 2;
    }
}
