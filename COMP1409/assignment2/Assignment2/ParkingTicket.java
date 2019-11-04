
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
    //private String officerName;
    //private String officerBadgeNumber;
    private PoliceOfficer officer;
    private String carLicensePlateNumber;
    private double fineAmountInCAD;

    /**
     * Constructor for objects of class ParkingTicket
     */
    public ParkingTicket(){
        ticketNumber = "unknown";
        officer = new PoliceOfficer();
        carLicensePlateNumber = "unknown";
        fineAmountInCAD = 0.0;
    }
    
    public ParkingTicket(String inputOfficerName, String inputOfficerBadgeNumber, 
                            String carLicensePlateNumber, double fine)
    {
        // initialise instance variables
        // setOfficerName(inputOfficerName);
        // setOfficerBadgeNumber(inputOfficerBadgeNumber);
        setOfficer(inputOfficerName, inputOfficerBadgeNumber);
        setCarLicensePlateNumber(carLicensePlateNumber);
        setFineAmountInCAD(fine);
        setTicketNumber();
    }

    public void setOfficer(String officerName, String officerBadgeNumber){        
       officer = new PoliceOfficer(officerName, officerBadgeNumber); 

    }
    
    public PoliceOfficer getOfficer(){
        return officer;
    }
    // public void setOfficerName(String officerName){
        // if(officerName == null)
            // throw new IllegalArgumentException("officer name must not be null");
        // else if(officerName.length() == 0)
            // throw new IllegalArgumentException("officer name must not be an empty String");
        // else
            // this.officerName = officerName;
    // }
    
    // public void setOfficerBadgeNumber(String officerBadgeNumber){
        // if(officerBadgeNumber == null)
            // throw new IllegalArgumentException("badge number must not be null");
        // else if(officerBadgeNumber.length() == 0)
            // throw new IllegalArgumentException("badge number must not be empty String");
        // else
            // this.officerBadgeNumber = officerBadgeNumber;
        
    // }
    
    public void setCarLicensePlateNumber(String carLicensePlateNumber){
        if(carLicensePlateNumber == null)
            throw new IllegalArgumentException("car license plate number must not be null");
        else if(carLicensePlateNumber.length() == 0)
            throw new IllegalArgumentException("car license plate number must not be empty String");
        else
            this.carLicensePlateNumber = carLicensePlateNumber;
    }
    
    public void setTicketNumber(){
        counter++;
        this.ticketNumber = TICKET_PREFIX + counter;
    }
    
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
    
    public String getOfficerName(){
        return officer.getOfficerName();
    }
    
    public String getOfficerBadgeNumber(){
        return officer.getOfficerBadgeNumber();
    }
    
    public String getCarLicensePlateNumber(){
        return carLicensePlateNumber;
    }
    
    public String getTicketNumber(){
        return ticketNumber;
    }
    
    public double getFineAmountInCAD(){
        return fineAmountInCAD;
    }
    
    public void displayDetails(){
        System.out.println("Ticket Number: " + getTicketNumber());
        System.out.println("Officer Name: " + officer.getOfficerName());
        System.out.println("Officer Badge number: " + officer.getOfficerBadgeNumber());        
        System.out.println("Car License Plate Number: " + getCarLicensePlateNumber());
        System.out.println("Fine amount: " + getFineAmountInCAD());
    }
    
    public static void resetCounter(){
        counter = 1000;
    }
}
