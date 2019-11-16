
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
    
    public static int numberOfTicket = 0;
    
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
        else{
            
        }
        numberOfTicket++;
            //return null;
    }
    
    public void addTicketList(ParkingTicket ticket){
        //int index = (ParkingTicket.counter - 1000) - 1;
        ticketList.add(ticket);
        System.out.println("DEBUG");
    }
    
    public ArrayList<ParkingTicket> getTicketList(){
        return ticketList;
    }
    
    public double sumAllfines(){
        double sumOfFine = 0;
        for(int index = 0; index <ticketList.size(); ++index){
            if(ticketList.get(index) != null){
                sumOfFine += ticketList.get(index).getFineAmountInCAD();
            }
            else{
                break;
            }
        }
        return sumOfFine;
    }
    
    public int getParkingTicketsCountForACar(String carLicensePlateNumber){
        int numberOfTickets = 0;
        for(int index = 0; index <ticketList.size(); ++index){
            if(ticketList.get(index) != null){
                if(ticketList.get(index).getCarLicensePlateNumber().equals(carLicensePlateNumber.toUpperCase())){
                    numberOfTickets++;
                }
            }
            else{
                break;
            }
        }
        return numberOfTickets;
    }
    
    public ArrayList<ParkingTicket> getTicketArrayByLicenseNumber(String carLicensePlateNumber){
        ArrayList<ParkingTicket> ticketsPerCar = new ArrayList<ParkingTicket>();
        //int count = 0;
        for(int index = 0; index <ticketList.size(); ++index){
            if(ticketList.get(index) != null){
                if(ticketList.get(index).getCarLicensePlateNumber().equals(carLicensePlateNumber.toUpperCase())){
                    ticketsPerCar.add(ticketList.get(index));
                    //count++;
                }
            }
            else{
                break;
            }
        }
        return ticketsPerCar;       
    }
    
    public double getSumOfFinesByCar(String carLicensePlateNumber){
        ArrayList<ParkingTicket> ticketsPerOneCar =  getTicketArrayByLicenseNumber(carLicensePlateNumber);
        //ticketsPerOneCar = getAllTicketOfOneCar(carLicensePlateNumber);
        double sumOfFine = 0;
        for(int index = 0; index < ticketsPerOneCar.size(); ++index){
            sumOfFine += ticketsPerOneCar.get(index).getFineAmountInCAD();
        }
        return sumOfFine;
    }
    
    public void displayticketsDetails(){
        for(int index = 0; index <ticketList.size(); ++index){
            //System.out.println("Officer index: " + index);   // Debug
            //System.out.println("Officer display ticket : " + ticketList.get(index).getOfficerName());  // Debug
            
            if(ticketList.get(index).getOfficerName().equals(officerName)){
                //System.out.println("=============**==============");
                //System.out.println();
                ticketList.get(index).displayDetails();
                System.out.println();
            }
        }
    }
    
    public int deleteTicketsByCarLicense(String carLicensePlateNumber){
        ArrayList<ParkingTicket> ticketsPerOneCar = getTicketArrayByLicenseNumber(carLicensePlateNumber);;
        //ticketsPerOneCar = getAllTicketOfOneCar(carLicensePlateNumber);
        int count = 0;
        for(int index = 0; index <ticketsPerOneCar.size(); ++index){
            if(ticketsPerOneCar.get(index) != null){
                ticketsPerOneCar.add(null); 
                count++;
            }
        }
        return count;
    }
}
