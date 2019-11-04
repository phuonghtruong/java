
/**
 * Write a description of class ParkingMeter here.
 *
 * @author Brian Truong 
 * @version 1.1 
 * @date    Oct 07th, 2019
 */
public class ParkingMeter
{
    // instance variables - replace the example below with your own
    public static final int MINUTES_PURCHASED_UPPER_LIMIT = 180;
    
    private String meterLocation;
    private boolean hasACamera;
    private double priceOfOneMinuteInCAD;
    private int numberOfPurchasedMinutes;

    /**
     * Constructor for objects of class ParkingMeter
     * @param location set meterLocation
     * @param hasCamera set hasACamera
     * @param pricePerMinutes set priceOfOneMinuteInCAD
     * @param purchasedTimeInMinutes set numberOfPurchasedMinutes
     */
    public ParkingMeter(String location, boolean hasCamera, 
                        double pricePerMinute, int purchasedTimeInMinutes)
    {
        // initialise instance variables
        if(location != null){
            meterLocation = location;
        }else{
            throw new IllegalArgumentException("meter location cannot be null");
        }
        
        hasACamera = hasCamera;
        
        if(pricePerMinute > 0){
            priceOfOneMinuteInCAD = pricePerMinute;
        }else{
            throw new IllegalArgumentException("price of one minute cannot be 0 or less");
        }
        
        if(purchasedTimeInMinutes > MINUTES_PURCHASED_UPPER_LIMIT){
            numberOfPurchasedMinutes = MINUTES_PURCHASED_UPPER_LIMIT;
            System.out.println("Number of purchased minutes cannot be greater than 180. The value will set to 180");
            //numberOfPurchasedMinutes = 180;
        } else if( purchasedTimeInMinutes <= 0){
            throw new IllegalArgumentException("number of purchased minutes cannot be 0 or negative");
        } else{
            numberOfPurchasedMinutes = purchasedTimeInMinutes;
        }
    }
        /**
         * Method set meter location
         * @param location set meterLocation
         */
        public void setMeterLocation(String location){
            if(location != null){
                meterLocation = location;
            }else{
                throw new IllegalArgumentException("meter location cannot be null");
            }
        }
        
        /**
         * Method get meter location
         * @return meterLocation
         */
        public String getMeterLocation(){
            return meterLocation;
        }
        
        /**
         * Method set hasACamera
         * @param hasCamera set hasACamera
         */
        public void setHasACamera(boolean hasCamera){
            hasACamera = hasCamera;
        }
        
        /**
         * Method getHasACamera
         * @return hasACamera
         */
        public boolean getHasACamera(){
            return hasACamera;
        }
        
        /**
         * Method set price of one minute in CAD
         * @param pricePerMinute set priceOfOneMinuteInCAD
         */
        public void setPriceOfOneMinuteInCAD(double pricePerMinute){
            if(pricePerMinute > 0){
                priceOfOneMinuteInCAD = pricePerMinute;
            }else{
                throw new IllegalArgumentException("price of one minute cannot be 0 or less");
            }
        }
        
        /**
         * Method get price of one minute in CAD
         * @return priceOfOneMinuteInCAD
         */
        public double getPriceOfOneMinuteInCAD(){
            return priceOfOneMinuteInCAD;
        }
        
        /**
         * Method set number of purchased minutes
         * @param purchasedTimeInMinutes set numberOfPurchaseMinutes
         */
        public void setNumberOfPurchasedMinutes(int purchasedTimeInMinutes){
            if(purchasedTimeInMinutes > MINUTES_PURCHASED_UPPER_LIMIT){
                numberOfPurchasedMinutes = MINUTES_PURCHASED_UPPER_LIMIT;
                System.out.println("Number of purchased minutes cannot be greater than 180. The value will set to 180");
            } else if( purchasedTimeInMinutes <= 0){
                throw new IllegalArgumentException("number of purchased minutes cannot be 0 or negative");
            } else{
                numberOfPurchasedMinutes = purchasedTimeInMinutes;
            }
        }
        
        /**
         * Method get number of purchase minutes
         * @return numberOfPurchaseMinutes
         */
        public int getNumberOfPurchasedMinutes(){
            return numberOfPurchasedMinutes;
        }
        
        /**
         * Method displayDetails
         */
        public void displayDetails(){
            System.out.println("metre location: " + meterLocation);
            System.out.println("meter have a camera: " + hasACamera);
            System.out.println("price of one minute in CAD: " + priceOfOneMinuteInCAD);
            System.out.println("number of purchased minutes: " + numberOfPurchasedMinutes);
        }
   

}
