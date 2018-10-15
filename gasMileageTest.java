import java.util.*;

public class gasMileageTest{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many trips: ");
        int num_trips = input.nextInt();
        System.out.println("==================");
        double total_usage = 0;
        for(int i=1; i<= num_trips;i++){
            System.out.printf("Trip %d :%n", i);
            System.out.print("How long for the trip: ");
            int miles = input.nextInt();
            System.out.print("How much gallons for the trip: ");
            int gallons = input.nextInt();
            gasMileage trip = new gasMileage(miles, gallons);
            System.out.printf("Trip %d usage is: %.2f%n", i, trip.Cal_OneTripUsage());
            System.out.println();
            total_usage += trip.Cal_OneTripUsage();
        }
        System.out.println("==================");
        System.out.printf("Total usage of trips: %.2f%n", total_usage);
    }
}
