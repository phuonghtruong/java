
/**
 * Write a description of class PoliceDepartment here.
 *
 * @author Brian
 * @version 01
 */

import java.util.*;

public class PoliceDepartment
{
    // instance variables - replace the example below with your own
    private String address;
    private ArrayList<PoliceOfficer> officerList;

    /**
     * Constructor for objects of class PoliceDepartment
     */
    public PoliceDepartment()
    {
        // initialise instance variables
        address = "unknown";
        officerList = new ArrayList<PoliceOfficer>();
    }
    /**
     * Constructor for objects of class PoliceDepartment
     * @para address to set address of department
     */
    public PoliceDepartment(String address){
        setAddress(address);
        officerList = new ArrayList<PoliceOfficer>();
    }
    /**
     * Method setAddress
     * @para address to set address
     */
    public void setAddress(String address){
        if(address != null && address.length() > 0){
            this.address = address;
        }
        else if(address == null){
            throw new IllegalArgumentException("address cannot be null");
        }
        else{
            throw new IllegalArgumentException("address cannot be an empty String");
        }
    }
    /**
     * Accessor method getAddress
     * @return address
     */
    public String getAddress(){
        return address;
    }
    /**
     * Method getOfficerList
     * @return officerList
     */
    public ArrayList<PoliceOfficer> getOfficerList(){
        return officerList;
    }
    
    /**
     * Method addPoliceOfficer
     * @para officer to set officer object
     */
    
    public void addPoliceOfficer(PoliceOfficer officer){
        if(officer != null){
            officerList.add(officer);
        }
    }
    /**
     * Method displayTicketsByOfficer
     * @para officerName
     */
    public void displayTicketsByOfficer(String officerName){
        boolean isFound = false;
        if(officerName != null && officerName.length() > 0){            
            for(PoliceOfficer officer: officerList){               
                if(officer.getOfficerName().equalsIgnoreCase(officerName)){                    
                    officer.displayticketsDetails();
                    isFound = true;
                }
            }
            if(isFound == false){
                System.out.println("Officer name is not found");
             }   
        }
        else if(officerName == null){
            throw new IllegalArgumentException("officer name cannot be null");
        }
        else{
            throw new IllegalArgumentException("officer name cannot be empty String");
        }
    }
    /**
     * Method calculateSumOfAllTicketsOfAllOfficers
     * @return sumOfAllTickets
     */
    public double calculateSumOfAllTicketsOfAllOfficers(){
        double sumOfAllTickets = 0;
        for(PoliceOfficer officer: officerList){
            sumOfAllTickets += officer.sumAllfines();
        }
        return sumOfAllTickets;
    }
    /**
     * Method totalParkingTicketCountOfACar
     * @para licensePlateNumber
     * @return totalNumberOfParkingTickets
     */
    public int totalParkingTicketCountOfACar(String licensePlateNumber){
        int totalNumberOfParkingTickets = 0;
        for(PoliceOfficer officer: officerList){
            totalNumberOfParkingTickets += officer.getParkingTicketsCountForACar(licensePlateNumber);
        }
        return totalNumberOfParkingTickets;
    }
}
