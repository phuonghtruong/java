public class Rectangle extends AbstractShape
{
    private int width;
    private int height;

    public Rectangle(final int w, final int h)
    {
        width = w;
        height = h;
        height = h * 2;
    }

    @Override
    public void draw()
    {
        System.out.printf("Yeah ok\n");
    }

}
