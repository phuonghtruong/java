
/**
 * Write a description of class ClothingItem here.
 *
 * @author Brian
 * @version 01
 */
public class ClothingItem
{
    // instance variables - replace the example below with your own
    private String itemDescription;
    private double priceInCAD;
    private String itemSize;
    private boolean isOnSale;
    
    public static final String SMALL_SIZE = "s";
    public static final String MEDIUM_SIZE = "m";
    public static final String LARGE_SIZE = "l";
    public static final String XLARGE_SIZE = "xl";
    /**
     * Constructor for objects of class ClothingItem
     * @para itemDescription
     * @para priceInCAD
     * @para itemSize
     * @para isOnSale
     */
    public ClothingItem(String itemDescription, double priceInCAD, String itemSize, boolean isOnSale)
    {
        // initialise instance variables
        setItemDescription(itemDescription);
        setPriceInCAD(priceInCAD);
        setItemSize(itemSize);
        setIsOnSale(isOnSale);
    }

    /**
     * Mutator method setItemDescription
     * @para itemDescription
     */
    public void setItemDescription(String itemDescription){
       if(itemDescription != null){
         this.itemDescription = itemDescription;  
        }
        else{
         throw new IllegalArgumentException("item description can not be null");   
        }
    }
    
    /**
     * Accessor method getItemDescription
     * @return itemDescription
     */
    public String getItemDescription(){
        return itemDescription;
    }
    
    /**
     * Mutator method setPriceInCAD
     * @para priceInCAD
     */
    public void setPriceInCAD(double priceInCAD){
        if(priceInCAD < 0){
            throw new IllegalArgumentException("Price can not be negative");
        }
        else{
            this.priceInCAD = priceInCAD;
        }
    }
    
    /**
     * Accessor method getPriceInCAD
     * @return priceInCAD
     */
    public double getPriceInCAD(){
        return priceInCAD;
    }
    
    /**
     * Mutator method setItemSize
     * @para itemSize
     */
    public void setItemSize(String itemSize){
        if(itemSize == null){
            throw new IllegalArgumentException("item size can not be null");
        }else if (itemSize.equalsIgnoreCase(SMALL_SIZE) || 
                    itemSize.equalsIgnoreCase(MEDIUM_SIZE) ||
                    itemSize.equalsIgnoreCase(LARGE_SIZE) ||
                    itemSize.equalsIgnoreCase(XLARGE_SIZE))
        {
                this.itemSize = itemSize;        
        }else{
            throw new IllegalArgumentException("Invalid size item");
        }
    }
    
    /**
     * Accessor method getItemSize
     * @return itemSize
     */
    public String getItemSize(){
        return itemSize;
    }
    
    /**
     * Mutator method setIsOnSale
     * @para isOnSale
     */
    public void setIsOnSale(boolean isOnSale){
        this.isOnSale = isOnSale;
    }
    
    /**
     * Accessor method getIsOnSale
     * @return isOnSale
     */
    public boolean getIsOnSale(){
        return isOnSale;
    }
    /**
     * Method printDetails
     */
    public void printDetails(){
        System.out.println("Description: " + getItemDescription());
        System.out.println("Price: " + getPriceInCAD());
        System.out.println("Size: " + getItemSize());
        if(getIsOnSale())
            System.out.println("Item is ON SALE");
        else
            System.out.println("Item is not on sale");
    }
}
