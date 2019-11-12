
/**
 * Write a description of class PoliceDepartment here.
 *
 * @author Brian
 * @version 01
 */
public class PoliceDepartment
{
    // instance variables - replace the example below with your own
    private String address;
    private PoliceOfficer[] officerList;

    private final static int NUMBER_OF_OFFICER = 50;
    public static int officerIndex = 0;
    /**
     * Constructor for objects of class PoliceDepartment
     */
    public PoliceDepartment()
    {
        // initialise instance variables
        address = "unknown";
        officerList = new PoliceOfficer[NUMBER_OF_OFFICER];
    }

    public PoliceDepartment(String address){
        setAddress(address);
        officerList = new PoliceOfficer[NUMBER_OF_OFFICER];
    }
    
    public void setAddress(String address){
        if(address != null && address.length() > 0){
            this.address = address;
        }
        else if(address == null){
            throw new IllegalArgumentException("address cannot be null");
        }
        else{
            throw new IllegalArgumentException("address cannot be empty String");
        }
    }
    
    public String getAddress(){
        return address;
    }
    
    public PoliceOfficer[] getOfficerList(){
        return officerList;
    }
    
    public void addPoliceOfficer(PoliceOfficer officer){
        if(officer != null){
            officerList[officerIndex] = officer;
            officerIndex++;
        }
        else{
            
        }
            
    }
    
    public void displayTicketsByOfficer(String officerName){
        boolean isFound = false;
        if(officerName != null && officerName.length() > 0){
            
            for(int index=0; index <officerList.length; ++index){
                System.out.println(index);   // Debug
                System.out.println("Department display: " + officerList[index].getOfficerName());  // Debug
                
                if(officerList[index].getOfficerName().equals(officerName)){
                    
                    officerList[index].displayticketsDetails();
                    isFound = true;
                    break;
                }
            }
            if(isFound == false){
                // ParkingTicket[] tickets
                System.out.println("Officer name is not found");
                // ticketList[index].displayDetails();
                // System.out.println();
             }   
        }
        else if(officerName == null){
            throw new IllegalArgumentException("officer name cannot be null");
        }
        else{
            throw new IllegalArgumentException("officer name cannot be empty String");
        }
    }
    
    public double calculateSumOfAllTicketsOfAllOfficers(){
        double sumOfAllTickets = 0;
        for(int index=0; index < officerList.length; ++index){
            sumOfAllTickets += officerList[index].sumAllfines();
        }
        return sumOfAllTickets;
    }

    public int totalParkingTicketCountOfACar(String licensePlateNumber){
        int totalNumberOfParkingTickets = 0;
        for(int index=0; index < officerList.length; ++index){
            totalNumberOfParkingTickets += officerList[index].getParkingTicketsCountForACar(licensePlateNumber);
        }
        return totalNumberOfParkingTickets;
    }
}
