
/**
 * Write a description of class ParkedCar here.
 *
 * @author Brian Truong
 * @version 1.0
 * @date    Sep 21st, 2019
 */

import java.util.Calendar;

public class ParkedCar
{
    // instance variables - replace the example below with your own
    private String ownerName;
    private String carMake;
    private int modelYear;
    private String licensePlateNumber;
    private int numberOfMinutesParked;

    public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    public static final int CAR_MODEL_YEAR_LOWER_LIMIT = 1900;
    /**
     * Constructor for objects of class ParkedCar
     * @param name set ownerName
     * @param make set carMake
     * @param modelInYear set modelYear
     * @param licenseNumber set licensePlateNumber
     * @param minutesParked set numberOfMinutesParked
     */
    public ParkedCar(String name, String make, int modelInYear,String licenseNumber, int minutesParked)
    {
        // initialise instance variables
        if(name != null){
            ownerName = name;
        }else{
            throw new IllegalArgumentException("owner name cannot be null");
        }
        
        if(make != null){
            carMake = make;
        }else{
            throw new IllegalArgumentException("car make cannot be null");
        }
        
        if(modelInYear < CAR_MODEL_YEAR_LOWER_LIMIT){
            throw new IllegalArgumentException("model year must not be earlier than " + CAR_MODEL_YEAR_LOWER_LIMIT);
        }else if(modelInYear > CURRENT_YEAR){
            throw new IllegalArgumentException("model year cannot be later than " + CURRENT_YEAR);
        }else{
            modelYear = modelInYear;        
        }
        
        if(licenseNumber != null){
            licensePlateNumber = licenseNumber;
        }else{
            throw new IllegalArgumentException("car license number cannot be null");
        }
        
        if(minutesParked > 0){
            numberOfMinutesParked = minutesParked;
        }else{
            throw new IllegalArgumentException("minutes parked should be greater than 0");
        }
    }
    /**
     * Method set owner name
     * @param name set ownerName
     */
    public void setOwnerName(String name){
       if(name != null){
            ownerName = name;
        }else{
            throw new IllegalArgumentException("owner name cannot be null");
        } 
    }
    /**
     * Method get owner name
     * @return ownerName
     */
    public String getOwnerName(){
        return ownerName;
    }
    
    /**
     * Method set car make
     * @param make set carMake
     */
    public void setCarMake(String make){
        if(carMake != null){
            carMake = make;
        }else{
            throw new IllegalArgumentException("car make cannot be null");
        }
    }
    
    /**
     * Method get car make
     * @return carMake
     */
    public String getCarMake(){
        return carMake;
    }
    
    /**
     * Method set model in year
     * @param modelInYear set modelYear
     */
    public void setModelYear(int modelInYear){
        if(modelInYear < CAR_MODEL_YEAR_LOWER_LIMIT){
            throw new IllegalArgumentException("model year must not be earlier than " + CAR_MODEL_YEAR_LOWER_LIMIT);
        }else if(modelInYear > CURRENT_YEAR){
            throw new IllegalArgumentException("model year cannot be later than " + CURRENT_YEAR);
        }else{
            modelYear = modelInYear;        
        }
    }
    
    /**
     * Method get model in year
     * @return modelYear
     */
    public int getModelYear(){
        return modelYear;
    }
    
    /**
     * Method set license plate number
     * @param licenseNumber set licensePlateNumber
     */
    public void setLicensePlateNumber(String licenseNumber){
        if(licenseNumber != null){
            licensePlateNumber = licenseNumber;
        }else{
            throw new IllegalArgumentException("car license number cannot be null");
        }
    }
    
    /**
     * Method get license plate number
     * @return licensePlateNumber
     */
    public String getLicensePlateNumber(){
        return licensePlateNumber;
    }
    
    /**
     * Method set number of minutes parked
     * @param minutesParked set numberOfMinutesParked
     */
    public void setNumberOfMinutesParked(int minutesParked){
        if(minutesParked > 0){
            numberOfMinutesParked = minutesParked;
        }else{
            throw new IllegalArgumentException("minutes parked should be greater than 0");
        }
    }
    
    /**
     * Method get number of minutes parked
     * @return numberOfMinutesParked
     */
    public int getNumberOfMinutesParked(){
        return numberOfMinutesParked;
    }
    
    /**
     * Method display details
     */
    public void displayDetails(){
        System.out.println("Owner name: " + ownerName);
        System.out.println("Car make: " + carMake);
        System.out.println("Car model year: " + modelYear);
        System.out.println("Car license Plate number: " + licensePlateNumber);
        System.out.println("Number of minutes parked: " + numberOfMinutesParked);
    }

}

