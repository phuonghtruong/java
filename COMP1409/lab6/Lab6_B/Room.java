
/**
 * Write a description of class Room here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class Room
{
    // instance variables - replace the example below with your own
    private double lengthInFeet;
    private double widthInFeet;

    /**
     * Constructor for objects of class Room
     */
    public Room()
    {
        // initialise instance variables
        lengthInFeet = 0.0;
        widthInFeet = 0.0;
    }
    /**
     * Constructor for objects of class Room
     * @para length to set lengthInFeet
     * @para width to set widthInFeet
     */
    public Room(double length, double width){
        setLengthInFeet(length);
        setWidthInFeet(width);
    }
    
    /**
     * Mutator method setLengthInFeet
     * @para length to set lengthInFeet
     */
    public void setLengthInFeet(double length){
        if(length > 0){
            lengthInFeet = length;
        }else{
            throw new IllegalArgumentException("length must be positive");
        }
    }
    
    /**
     * Mutator method to setWidthInFeet
     * @para width to set widthInFeet
     */
    public void setWidthInFeet(double width){
        if(width > 0){
            widthInFeet = width;
        }else{
            throw new IllegalArgumentException("width must be positive");
        }
        
    }
    
    /**
     * Accessor getLengthInFeet
     * @return lengthInFeet
     */
    public double getLengthInFeet(){
        return lengthInFeet;
    }
    
    /**
     * Accessor getWidthInFeet
     * @return widthInFeet
     */
    public double getWidthInFeet(){
        return widthInFeet;
    }
    
    /**
     * Method to calculateArea
     * @return area
     */
       public double calculateArea()
    {
        double area = lengthInFeet * widthInFeet;
        return area;
    }
}
