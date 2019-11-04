
/**
 * Write a description of class CarpetCalculator here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class CarpetCalculator
{
    // instance variables - replace the example below with your own
    private double pricePerSquareFoot;
    private Room room;

    /**
     * Constructor for objects of class CarpetCalculator
     */
    public CarpetCalculator(double price, Room iRoom)
    {
        // initialise instance variables
        setPricePerSquareFoot(price);
        setRoom(iRoom);
    }
    
    /**
     * Accessor method for getRoom
     * @return object room
     */
    public Room getRoom(){
        return room;
    }
    
    /**
     * Accessor method for getPricePerSquareFoot
     * @return pricePerSquareFoot
     */
    public double getPricePerSquareFoot(){
        return pricePerSquareFoot;
    }
    
    /**
     * Mutator method for setPricePerSquareFoot
     * @param price to set pricePerSquareFoot
     */
    public void setPricePerSquareFoot(double price){
        if(price > 0){
            pricePerSquareFoot = price;
        }else{
            throw new IllegalArgumentException("price must be positive");
        }
    }
    
    /**
     * mutator method for setRoom
     * @param iRoom to set object
     */
    public void setRoom(Room iRoom){
        if(iRoom == null){
            room = new Room();
        }else{
            room = iRoom;
        }
    }
    
    /**
     * Method calculateTotalCost
     * @return totalCost
     */
    public double calculateTotalCost()
    {
        // put your code here
        double totalCost = pricePerSquareFoot * room.calculateArea();
        return totalCost;
    }
    
    /**
     * Method displayInfo
     */
    public void displayInfo(){
        System.out.println("Length (in feet) : " + room.getLengthInFeet());
        System.out.println("Width (in feet) : " + room.getWidthInFeet());
        System.out.println("Price per square foot: $" + getPricePerSquareFoot());
        System.out.println("Total cost: $" + calculateTotalCost());
    }
}
