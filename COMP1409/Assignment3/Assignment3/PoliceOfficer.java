
/**
 * Write a description of class PoliceOfficer here.
 *
 * @author Brian
 * @version 02
 */
public class PoliceOfficer
{
    // instance variables - replace the example below with your own
    public final static double ONE_HOUR_FINE_AMOUNT = 20;
    public final static int MINUTES_IN_HOUR = 60;
    
    public static int numberOfTicket = 0;
    
    private String officerName;
    private String officerBadgeNumber;
    private ParkingTicket[] ticketList;

    /**
     * Constructor for objects of class PoliceOfficer
     */
    public PoliceOfficer(){
        officerName = "unknown";
        officerBadgeNumber = "unknown";
        ticketList = new ParkingTicket[999];
    }
    /**
     * Constructor for objects of class PoliceOfficer
     * @para officerName to set officer name
     * @para officerBadgeNumber to set officer badge number
     */
    public PoliceOfficer(String officerName, String officerBadgeNumber)
    {
        // initialise instance variables
        setOfficerName(officerName);
        setOfficerBadgeNumber(officerBadgeNumber);
        ticketList = new ParkingTicket[999];
    }
    /**
     * Mutator method to set officer name
     * @para officerName
     */
    public void setOfficerName(String officerName){
        if(officerName == null){
            throw new IllegalArgumentException("officer name must not be null");
        }
        else if(officerName.length() == 0){
            throw new IllegalArgumentException("officer name must not be an empty String");
        }
        else{
            this.officerName = officerName;
        }
    }
    /**
     * Mutator method to set officer badge number
     * @para officerBadgeNumber
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
     * Accessor method to get officer name
     * @return officerName
     */
    public String getOfficerName(){
        return officerName;
    }
    /**
     * Accessor method to get officer badge number
     * @return officerBadgeNumber
     */
    public String getOfficerBadgeNumber(){
        return officerBadgeNumber;
    }
    /**
     * Method to check if parking time is expired
     * @para car , object of ParkedCar
     * @para meter, object of ParkingMeter
     * @return boolean
     */
    private boolean isParkingTimeExpired(ParkedCar car, ParkingMeter meter){
        if(car.getNumberOfMinutesParked() > meter.getNumberOfPurchasedMinutes()){
            return true;
        }
        else{
            return false;
        }
        
    }
    /**
     * Method to calculateFine
     * @para car , object of ParkedCar
     * @para meter, object of ParkingMeter
     * @return totalFine
     */
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
    /**
     * Method to issue parking ticket
     * @para car , object of ParkedCar
     * @para meter, object of ParkingMeter
     * @return object
     */
    public void issueParkingTicket(ParkedCar car, ParkingMeter meter){
        boolean isExpired = isParkingTimeExpired(car,meter);
        double fine = calculateFine(car,meter);
        
        if(isExpired){
            ParkingTicket ticket = new ParkingTicket(officerName, officerBadgeNumber, car.getLicensePlateNumber(), fine);
            ticket.displayDetails();
            addTicketList(ticket);
        }
        else{
            
        }
        numberOfTicket++;
            //return null;
    }
    
    public void addTicketList(ParkingTicket ticket){
        //int index = (ParkingTicket.counter - 1000) - 1;
        ticketList[numberOfTicket] = ticket;
        System.out.println("DEBUG");
    }
    
    public ParkingTicket[] getTicketList(){
        return ticketList;
    }
    
    public double sumAllfines(){
        double sumOfFine = 0;
        for(int index = 0; index <ticketList.length; ++index){
            if(ticketList[index] != null){
                sumOfFine += ticketList[index].getFineAmountInCAD();
            }
            else{
                break;
            }
        }
        return sumOfFine;
    }
    
    public int getParkingTicketsCountForACar(String carLicensePlateNumber){
        int numberOfTickets = 0;
        for(int index = 0; index <ticketList.length; ++index){
            if(ticketList[index] != null){
                if(ticketList[index].getCarLicensePlateNumber().equals(carLicensePlateNumber.toUpperCase())){
                    numberOfTickets++;
                }
            }
            else{
                break;
            }
        }
        return numberOfTickets;
    }
    
    public ParkingTicket[] getTicketArrayByLicenseNumber(String carLicensePlateNumber){
        ParkingTicket [] ticketsPerCar = new ParkingTicket[1000];
        int count = 0;
        for(int index = 0; index <ticketList.length; ++index){
            if(ticketList[index] != null){
                if(ticketList[index].getCarLicensePlateNumber().equals(carLicensePlateNumber.toUpperCase())){
                    ticketsPerCar[count] = ticketList[index];
                    count++;
                }
            }
            else{
                break;
            }
        }
        return ticketsPerCar;       
    }
    
    public double getSumOfFinesByCar(String carLicensePlateNumber){
        ParkingTicket[] ticketsPerOneCar =  getTicketArrayByLicenseNumber(carLicensePlateNumber);
        //ticketsPerOneCar = getAllTicketOfOneCar(carLicensePlateNumber);
        double sumOfFine = 0;
        for(int index = 0; index < ticketsPerOneCar.length; ++index){
            sumOfFine += ticketsPerOneCar[index].getFineAmountInCAD();
        }
        return sumOfFine;
    }
    
    public void displayticketsDetails(){
        for(int index = 0; index <ticketList.length; ++index){
            System.out.println("Officer index: " + index);   // Debug
            System.out.println("Officer display ticket : " + ticketList[index].getOfficerName());  // Debug
            
            if(ticketList[index].getOfficerName().equals(officerName)){
                System.out.println("=============**==============");
                ticketList[index].displayDetails();
                System.out.println();
            }
        }
    }
    
    public int deleteTicketsByCarLicense(String carLicensePlateNumber){
        ParkingTicket[] ticketsPerOneCar = getTicketArrayByLicenseNumber(carLicensePlateNumber);;
        //ticketsPerOneCar = getAllTicketOfOneCar(carLicensePlateNumber);
        int count = 0;
        for(int index = 0; index <ticketsPerOneCar.length; ++index){
            if(ticketsPerOneCar[index] != null){
                ticketsPerOneCar[index] = null; 
                count++;
            }
        }
        return count;
    }
}
