
/**
 * Write a description of class StockPurchase here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class StockPurchase
{
    // instance variables - replace the example below with your own
    private Stock stock;
    private int numberOfShares;

    /**
     * Constructor for objects of class StockPurchase
     */
    public StockPurchase()
    {
        // initialise instance variables
        numberOfShares = 0;
        stock = new Stock();
    }
    /**
     * Constructor
     * @para stock to set object stock
     * @para numberOfShares to set number of shares
     */
    public StockPurchase(Stock stock, int numberOfShares){
        setStock(stock);
        setNumberOfShares(numberOfShares);
    }
    /**
     * Mutator method set stock
     * @para stock to set stock object
     */
    public void setStock(Stock stock){
        if(stock == null){
            throw new IllegalArgumentException("stock cannot be null");
        }else{
            this.stock = stock;
        }
    }
    
    /**
     * Mutator method to set number of shares
     * @para numberOfShares to set number of shares
     */
    public void setNumberOfShares(int numberOfShares){
        if(numberOfShares < 0){
            throw new IllegalArgumentException("number of shares cannot be negative");
        }
        else{
            this.numberOfShares = numberOfShares;
        }
    }
    
    /**
     * Accessor method getStock
     * @return stock object
     */
    public Stock getStock(){
        return stock;
    }
    
    /**
     * Accessor method getNumberOfShares
     * @return numberOfShares
     */
    public int getNumberOfShares(){
        return numberOfShares;
    }
    
    /**
     * Method to getTotalCost
     * @return totalCost
     */
    public double getTotalCost(){
        double totalCost = stock.getSharePrice() * getNumberOfShares();
        return totalCost;
    }
    
    /**
     * Method display info
     */
    public void displayInfo(){
        stock.displayInfo();
        System.out.println("Number of Shares: " + getNumberOfShares());
        System.out.println("Total Cost: " + getTotalCost());
    }
}
