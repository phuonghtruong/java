
/**
 * Write a description of class Driver here.
 *
 * @author Brian
 * @version 01
 */
public class Driver
{
    public static void main(String[] args){
        ParkedCar car1 = new ParkedCar("Brian", "Honda", 2018, "THP123", 150);
        ParkedCar car2 = new ParkedCar("Daphne", "Jeep", 2019, "PVA789", 140);
       
        ParkingMeter meter1 = new ParkingMeter("Park Royal", true, 21.5 , 90);
        
        PoliceOfficer officer1 = new PoliceOfficer("Bob", "RMCP135");
        PoliceOfficer officer2 = new PoliceOfficer("Emily", "RMCP246");
        PoliceOfficer officer3 = new PoliceOfficer("Michael", "RMCP789");
        
        officer1.issueParkingTicket(car1, meter1);
        officer2.issueParkingTicket(car2, meter1);
        
        PoliceDepartment department1 = new PoliceDepartment("Marine Dr");
        department1.addPoliceOfficer(officer1);
        department1.addPoliceOfficer(officer2);
        department1.addPoliceOfficer(officer3);
        
        System.out.println(ParkingTicket.counter);
        
        department1.displayTicketsByOfficer(officer2.getOfficerName());
        int numDelete = officer2.deleteTicketsByCarLicense("PVA789");
        department1.displayTicketsByOfficer(officer2.getOfficerName());
    }
}
