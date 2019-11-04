
/**
 * Write a description of class Driver here.
 *
 * @author Brian
 * @version 01
 */
public class Driver
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        ParkedCar car1 = new ParkedCar("Brian", "Honda", 2018, "THP012", 125);
        car1.displayDetails();
        ParkingMeter meter1 = new ParkingMeter("Queen Park", true, 18.5, 60);
        meter1.displayDetails();
        PoliceOfficer officer1 = new PoliceOfficer("Daphne", "RCMP2305");
        officer1.issueParkingTicket(car1, meter1);
        
        ParkedCar car2 = new ParkedCar("Holy", "Toyota", 2009, "THU5Z8", 200);
        car2.displayDetails();
        ParkingMeter meter2 = new ParkingMeter("Burrad Street", true, 19.5, 60);
        meter2.displayDetails();        
        officer1.issueParkingTicket(car2, meter2);
        
    }
}
