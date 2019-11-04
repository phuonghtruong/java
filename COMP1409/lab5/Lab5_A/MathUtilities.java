
/**
 * Write a description of class MathUtilities here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class MathUtilities
{
    // instance variables - replace the example below with your own
    private int base;
    private int exponent;

    /**
     * Constructor for objects of class MathUtilities
     */
    public MathUtilities()
    {
        // initialise instance variables
        base = 0;
        exponent = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static int power(int base, int exponent)
    {
        // put your code here
        int result = 1;
        while(exponent > 0){
            result = result * base;
            exponent--;
        }
        return result;
    }
}
