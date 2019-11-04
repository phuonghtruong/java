
/**
 * Write a description of class BookClub here.
 *
 * @author Brian
 * @version 1.0
 * @date Sep 28, 2019
 */
public class BookClub
{
    public static final int MINIMUM_QUANTITY_FOR_FOURTH_LEVEL = 11;
    public static final int MINIMUM_QUANTITY_FOR_THIRD_LEVEL = 8;
    public static final int MINIMUM_QUANTITY_FOR_SECOND_LEVEL = 4;
    public static final int MINIMUM_QUANTITY_FOR_FIRST_LEVEL = 1;
    
    public static final int EARNED_POINTS_FIRST_LEVEL = 5;
    public static final int EARNED_POINTS_SECOND_LEVEL = 15;
    public static final int EARNED_POINTS_THIRD_LEVEL = 30;
    public static final int EARNED_POINTS_FOURTH_LEVEL = 60;
    // instance variables - replace the example below with your own
    private String clientName;
    private int numberOfPurchasedBooksPerMonth;
    
    public static int totalNumberOfSoldBooks;

    /**
     * Constructor for objects of class BookClub
     */
    public BookClub(String cName, int numberOfPurchasedBooks)
    {
        // initialise instance variables
        if(cName != null){
            clientName = cName;
        }else{
            throw new IllegalArgumentException("client name cannot be null");
        }
        
        if(numberOfPurchasedBooks > 0){
            numberOfPurchasedBooksPerMonth = numberOfPurchasedBooks;
            totalNumberOfSoldBooks = numberOfPurchasedBooksPerMonth;
        }else{
            throw new IllegalArgumentException("number of purchased books must be greater than 0");
        }
    }
    
    /**
     * Accessor method for client name
     * @return clientName
     */
    public String getClientName(){
        return clientName;
    }
    
    /**
     * Accessor method for number of purchased books per month
     * @return numberOfPurchasedBooksPerMonth
     */
    public int getNumberOfPurchasedBooksPerMonth(){
        return numberOfPurchasedBooksPerMonth;
    }
    
    /**
     * Mutator method for set client name
     * @param cName to set client name
     */
    public void setClientName(String cName){
        if(cName != null){
            clientName = cName;
        }else{
            throw new IllegalArgumentException("client name cannot be null");
        }
    }
    
    /**
     * Mutator method for set number of purchased books per month
     * @param numberOfPurchasedBooks
     */
    public void setNumberOfPurchasedBooksPerMonth(int numberOfPurchasedBooks){
        if(numberOfPurchasedBooks > 0){
            numberOfPurchasedBooksPerMonth = numberOfPurchasedBooks;
            totalNumberOfSoldBooks = numberOfPurchasedBooksPerMonth;
        }else{
            throw new IllegalArgumentException("number of purchased books must be greater than 0");
        }
    }
    
    /**
     * static method
     * @return totalNumberOfSoldBooks
     */
    public static int getTotalNumberOfSoldBooks(){
        return totalNumberOfSoldBooks;
    }
    
    
    /**
     * Method calculate book points
     *
     * @return    numberOfPoints
     */
    public int calculateBookPoints()
    {
        // put your code here
        int numberOfPoints = 0;
        
        if(numberOfPurchasedBooksPerMonth >= MINIMUM_QUANTITY_FOR_FOURTH_LEVEL){
            numberOfPoints += EARNED_POINTS_FOURTH_LEVEL;
        }else if(numberOfPurchasedBooksPerMonth >= MINIMUM_QUANTITY_FOR_THIRD_LEVEL){
            numberOfPoints += EARNED_POINTS_THIRD_LEVEL;
        }else if(numberOfPurchasedBooksPerMonth >= MINIMUM_QUANTITY_FOR_SECOND_LEVEL){
            numberOfPoints += EARNED_POINTS_SECOND_LEVEL;
        }else{
            numberOfPoints += EARNED_POINTS_FIRST_LEVEL;
        }
        return numberOfPoints;
    }
}
