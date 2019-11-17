
/**
 * Write a description of class PoliceOfficer here.
 *
 * @author Brian
 * @version 02
 */
import java.util.*;

public class PoliceOfficer
{
    // instance variables - replace the example below with your own
    public final static double ONE_HOUR_FINE_AMOUNT = 20;
    public final static int MINUTES_IN_HOUR = 60;
    
    private String officerName;
    private String officerBadgeNumber;
    private ArrayList<ParkingTicket> ticketList;

    /**
     * Constructor for objects of class PoliceOfficer
     */
    public PoliceOfficer(){
        officerName = "unknown";
        officerBadgeNumber = "unknown";
        ticketList = new ArrayList<ParkingTicket>();
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
        ticketList = new ArrayList<ParkingTicket>();
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
    }
    /**
     * Method add ticket to ticketList
     * @para ticket to set ticket object to ticketList
     */
    public void addTicketList(ParkingTicket ticket){
        if(ticket != null){
            ticketList.add(ticket);
        }
    }
    /**
     * Method to getTicketList
     * @return ticketList
     */
    public ArrayList<ParkingTicket> getTicketList(){
        return ticketList;
    }
    /**
     * Method to sum all fines
     * @return sumOfFine
     */
    public double sumAllfines(){
        double sumOfFine = 0;
        for(ParkingTicket ticket : ticketList){
            sumOfFine += ticket.getFineAmountInCAD();          
        }
        return sumOfFine;
    }
    /**
     * Method to get Parking Tickets Count for a car
     * @para carLicensePlateNumber to set car license plate number
     * @return numberOfTickets
     */
    public int getParkingTicketsCountForACar(String carLicensePlateNumber){
        int numberOfTickets = 0;
        for(ParkingTicket ticket : ticketList){
            if(ticket.getCarLicensePlateNumber().equalsIgnoreCase(carLicensePlateNumber)){
                numberOfTickets++;
            }           
        }
        return numberOfTickets;
    }
    /**
     * Method getTicketArrayByLicenseNumber
     * @para carLicensePlateNumber
     * @return ticketsPerCar
     */
    public ParkingTicket[] getTicketArrayByLicenseNumber(String carLicensePlateNumber){
        ParkingTicket[] ticketsPerCar = new ParkingTicket[ticketList.size()];
        int count = 0;
        for(ParkingTicket ticket : ticketList){            
            if(ticket.getCarLicensePlateNumber().equalsIgnoreCase(carLicensePlateNumber)){
                ticketsPerCar[count] = ticket;
                count++;
            }
        }
        return ticketsPerCar;       
    }
    /**
     * method getSumOfFinesByCar
     * @para carLicensePlateNumber
     * @return sumOfFine
     */
    public double getSumOfFinesByCar(String carLicensePlateNumber){
        double sumOfFine = 0;
        for(ParkingTicket ticket : ticketList){
            if(ticket.getCarLicensePlateNumber().equalsIgnoreCase(carLicensePlateNumber)){
                sumOfFine += ticket.getFineAmountInCAD();
            }
        }
        return sumOfFine;
    }
    /**
     * Method displayticketsDetails
     * 
     */
    public void displayticketsDetails(){
        for(ParkingTicket ticket : ticketList){               
            if(ticket.getOfficerName().equals(officerName)){
                ticket.displayDetails();
                System.out.println();
            }
        }
    }
    /**
     * Method deleteTicketsByCarLicense
     * @return count
     */
    public int deleteTicketsByCarLicense(String carLicensePlateNumber){
        int count = 0;
        Iterator<ParkingTicket> itr = ticketList.iterator();
        while(itr.hasNext()){
            ParkingTicket ticket = itr.next();
            if(ticket.getCarLicensePlateNumber().equalsIgnoreCase(carLicensePlateNumber)){
                itr.remove(); 
                count++;
            }
        }
        return count;
    }
}
