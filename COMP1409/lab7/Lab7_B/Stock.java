
/**
 * Write a description of class Stock here.
 *
 * @author Brian    
 * @version (a version number or a date)
 */
public class Stock
{
    // instance variables - replace the example below with your own
    private String stockSymbol;
    private double sharePrice;

    /**
     * Constructor for objects of class Stock
     */
    public Stock()
    {
        // initialise instance variables
        stockSymbol = new String("unknown");
        sharePrice = 0.0;
    }
    /**
     * Constructor
     * @para stockSymbol to set stock symbol
     * @para sharePrice to set share price
     */
    public Stock(String stockSymbol, double sharePrice){
        setStockSymbol(stockSymbol);
        setSharePrice(sharePrice);
    }

    /**
     * Mutator method to setStockSymbol
     * @para stockSymbol to set stock symbol
     */
    public void setStockSymbol(String stockSymbol){
        if(stockSymbol.equals(null)){
            throw new IllegalArgumentException("stock symbol cannot be null");
        }else{
            this.stockSymbol = new String(stockSymbol);
        }
    }
    
    /**
     * Mutator method to setSharePrice
     * @para sharePrice to set share price
     */
    public void setSharePrice(double sharePrice){
        if(sharePrice < 0){
            throw new IllegalArgumentException("share price cannot be negative");
        }else{
            this.sharePrice = sharePrice;
        }
    }
    
    /**
     * Accessor method to getStockSymbol
     * @return stockSymbol
     */
    public String getStockSymbol(){
        return stockSymbol;
    }
    
    /**
     * Accessor method to getSharePrice
     * @return sharePrice
     */
    public double getSharePrice(){
        return sharePrice;
    }
    
    /**
     * Method to display info
     */
    public void displayInfo(){
        System.out.println("Stock Symbol: " + getStockSymbol());
        System.out.println("Share Price: " + getSharePrice());
    }
}
