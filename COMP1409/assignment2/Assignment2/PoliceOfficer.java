
/**
 * Write a description of class PoliceOfficer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PoliceOfficer
{
    // instance variables - replace the example below with your own
    public final static double ONE_HOUR_FINE_AMOUNT = 20;
    public final static int MINUTES_IN_HOUR = 60;
    private String officerName;
    private String officerBadgeNumber;

    /**
     * Constructor for objects of class PoliceOfficer
     */
    public PoliceOfficer(){
        officerName = "unknown";
        officerBadgeNumber = "unknown";
    }
    
    public PoliceOfficer(String officerName, String officerBadgeNumber)
    {
        // initialise instance variables
        setOfficerName(officerName);
        setOfficerBadgeNumber(officerBadgeNumber);
    }
    
    public void setOfficerName(String officerName){
        if(officerName == null)
            throw new IllegalArgumentException("officer name must not be null");
        else if(officerName.length() == 0)
            throw new IllegalArgumentException("officer name must not be an empty String");
        else
            this.officerName = officerName;
    }
    
    public void setOfficerBadgeNumber(String officerBadgeNumber){
        if(officerBadgeNumber == null)
            throw new IllegalArgumentException("badge number must not be null");
        else if(officerBadgeNumber.length() == 0)
            throw new IllegalArgumentException("badge number must not be empty String");
        else
            this.officerBadgeNumber = officerBadgeNumber;
        
    }
    
    public String getOfficerName(){
        return officerName;
    }
    
    public String getOfficerBadgeNumber(){
        return officerBadgeNumber;
    }
    
    private boolean isParkingTimeExpired(ParkedCar car, ParkingMeter meter){
        if( car.getNumberOfMinutesParked() > meter.getNumberOfPurchasedMinutes()){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    private double calculateFine(ParkedCar car, ParkingMeter meter){
        boolean isExpired = isParkingTimeExpired(car,meter);
        double totalFine = 0.0;
        if(isExpired){
            int numberOfUnpaidMinutes = car.getNumberOfMinutesParked() - meter.getNumberOfPurchasedMinutes();
            if(numberOfUnpaidMinutes % MINUTES_IN_HOUR != 0){
                totalFine = ((numberOfUnpaidMinutes/MINUTES_IN_HOUR) + 1) * ONE_HOUR_FINE_AMOUNT;
            }
            else{
                totalFine = (numberOfUnpaidMinutes/MINUTES_IN_HOUR) * ONE_HOUR_FINE_AMOUNT;
            }
        }
        return totalFine;
    }
    
    public ParkingTicket issueParkingTicket(ParkedCar car, ParkingMeter meter){
        boolean isExpired = isParkingTimeExpired(car,meter);
        double fine = calculateFine(car,meter);
        if(isExpired){
            ParkingTicket ticket = new ParkingTicket(officerName, officerBadgeNumber, car.getLicensePlateNumber(), fine);
            ticket.displayDetails();
            return ticket;
        }
        else
            return null;
    }
}
