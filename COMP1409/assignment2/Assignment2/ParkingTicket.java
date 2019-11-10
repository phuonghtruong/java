
/**
 * Write a description of class ParkingTicket here.
 *
 * @author Brian
 * @version 01
 */
public class ParkingTicket
{
    public static final String TICKET_PREFIX = "VAN";
    public static int counter = 1000;
    // instance variables - replace the example below with your own
    private String ticketNumber;
    private String officerName;
    private String officerBadgeNumber;
    private String carLicensePlateNumber;
    private double fineAmountInCAD;

    /**
     * Constructor for objects of class ParkingTicket
     */
    public ParkingTicket(){
        ticketNumber = "unknown";
        officerName = "unknown";
        officerBadgeNumber = "unknown";
        carLicensePlateNumber = "unknown";
        fineAmountInCAD = 0.0;
    }
    /**
     * Constructor for objects of class ParkingTicket
     * @para inputOfficerName to set officerName
     * @para inputOfficerBadgeNumber to set officerBadgeNumber
     * @para carLicensePlateNumber to set license plate number
     * @para fine to set fine amount
     */
    public ParkingTicket(String inputOfficerName, String inputOfficerBadgeNumber, 
                            String carLicensePlateNumber, double fine)
    {
        // initialise instance variables
        setOfficerName(inputOfficerName);
        setOfficerBadgeNumber(inputOfficerBadgeNumber);
        setCarLicensePlateNumber(carLicensePlateNumber);
        setFineAmountInCAD(fine);
        setTicketNumber();
    }
    /**
     * Mutator method setOfficerName
     * @para officeName to set officerName
     */    
    public void setOfficerName(String officerName){
        if(officerName == null)
            throw new IllegalArgumentException("officer name must not be null");
        else if(officerName.length() == 0)
            throw new IllegalArgumentException("officer name must not be an empty String");
        else
            this.officerName = officerName;
    }
    /**
     * Mutator method setOfficerName
     * @para officeName to set officerBadgeNumber
     */ 
    public void setOfficerBadgeNumber(String officerBadgeNumber){
        if(officerBadgeNumber == null)
            throw new IllegalArgumentException("badge number must not be null");
        else if(officerBadgeNumber.length() == 0)
            throw new IllegalArgumentException("badge number must not be empty String");
        else
            this.officerBadgeNumber = officerBadgeNumber;
        
    }
    /**
     * Mutator method to setCarLicensePlateNumber
     * @para carLicensePlateNumber to set car license plate number
     */
    public void setCarLicensePlateNumber(String carLicensePlateNumber){
        if(carLicensePlateNumber == null)
            throw new IllegalArgumentException("car license plate number must not be null");
        else if(carLicensePlateNumber.length() == 0)
            throw new IllegalArgumentException("car license plate number must not be empty String");
        else
            this.carLicensePlateNumber = carLicensePlateNumber;
    }
    /**
     * method to set ticket number
     */
    public void setTicketNumber(){
        counter++;
        this.ticketNumber = TICKET_PREFIX + counter;
    }
    /**
     * method to set fine amount
     * @para fineAmountInCAD
     */
    public void setFineAmountInCAD(double fineAmountInCAD){
        if(fineAmountInCAD < 0){
            throw new IllegalArgumentException("fine amount must not be negative");
        }
        else if(fineAmountInCAD == 0){
            throw new IllegalArgumentException("fine amount must not be 0");
        }
        else{
            this.fineAmountInCAD = fineAmountInCAD;
        }
    }
    /**
     * Accessor method to getOfficerName
     * @return officerName
     */
    public String getOfficerName(){
        return officerName;
    }
    /**
     * Accessor method to getOfficerBadgeNumber
     * @return officerBadgeNumber
     */
    public String getOfficerBadgeNumber(){
        return officerBadgeNumber;
    }
    /**
     * Accessor method to getCarLicensePlateNumber
     * @return carLicensePlateNumber
     */
    public String getCarLicensePlateNumber(){
        return carLicensePlateNumber;
    }
    /**
     * Accessor method to getTicketNumber
     * @return ticketNumber
     */
    public String getTicketNumber(){
        return ticketNumber;
    }
    /**
     * Accessor method to getFineAmountInCAD
     * @return fineAmountInCAD
     */
    public double getFineAmountInCAD(){
        return fineAmountInCAD;
    }
    /**
     * Method display details
     */
    public void displayDetails(){
        System.out.println("Ticket Number: " + getTicketNumber());
        System.out.println("Officer Name: " + getOfficerName());
        System.out.println("Officer Badge number: " + getOfficerBadgeNumber());        
        System.out.println("Car License Plate Number: " + getCarLicensePlateNumber());
        System.out.println("Fine amount: " + getFineAmountInCAD());
    }
    /**
     * Method to resetCounter
     */
    public static void resetCounter(){
        counter = 1000;
    }
}
