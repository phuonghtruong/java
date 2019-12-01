
/**
 * Write a description of class Customer here.
 *
 * @author Brian
 * @version 01
 */

import java.util.*;

public class Customer
{
    // instance variables - replace the example below with your own
    private String customerName;
    private String customerMailingAddress;
    private boolean isSubscribed;
    private ArrayList<ClothingItem> shoppingCart;
    
    public static final double DISCOUNT_PERCENTAGE = 0.1;
    public static final double DISCOUNT_SUBSCRIBER = 0.05;

    /**
     * Constructor for objects of class Customer
     * @para customerName
     * @para customerMailingAddress
     * @para isSubscribed 
     */
    public Customer(String customerName, String customerMailingAddress, boolean isSubscribed)
    {
        // initialise instance variables
        setCustomerName(customerName);
        setCustomerMailingAddress(customerMailingAddress);
        setIsSubscribed(isSubscribed);
        shoppingCart = new ArrayList <ClothingItem> ();
    }
    
    /**
     * Mutator method setCustomerName
     * @para customerName
     */
    public void setCustomerName(String customerName){
        if(customerName != null){
            this.customerName = customerName;
        }
        else{
            throw new IllegalArgumentException("Customer Name cannot be null");
        }
    }
    
    /**
     * Accessor method getCustomerName
     * @return customerName
     */
    public String getCustomerName(){
        return customerName;
    }
    
    /**
     * Mutator method setCustomerMailingAddress
     * @para customerMailingAddress
     */
    public void setCustomerMailingAddress(String customerMailingAddress){
        if(customerMailingAddress != null){
            this.customerMailingAddress = customerMailingAddress;
        }else
        {
            throw new IllegalArgumentException("Customer mailing address cannot be null");
        }
    }
    
    /**
     * Accessor method getCustomerMailingAddress
     * @return customerMailingAddress
     */
    public String getCustomerMailingAddress(){
        return customerMailingAddress;
    }
    
    /**
     * Mutator method setIsSubscribed
     * @para isSubscribed
     */
    public void setIsSubscribed(boolean isSubscribed){
        this.isSubscribed = isSubscribed;
    }
    
    /**
     * Accessor method getIsSubscribed
     * @return isSubscribed
     */
    public boolean getIsSubscribed(){
        return isSubscribed;
    }
    
    /**
     * Method addItem
     * @para item
     */
    public void addItem(ClothingItem item){
        if(item != null){
            shoppingCart.add(item);
        }
    }
    
    /**
     * method displayItemDetails
     * @para itemDescription
     */
    public void displayItemDetails(String itemDescription){
        for(ClothingItem item : shoppingCart){
            if(item.getItemDescription().equalsIgnoreCase(itemDescription)){
                item.printDetails();
                System.out.println();
            }
        }
    }
    
    /**
     * method calculateTotalPrice
     * @return totalPrice
     */
    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for(ClothingItem item : shoppingCart){
            if(item.getIsOnSale()){
                totalPrice += item.getPriceInCAD()*(1 - DISCOUNT_PERCENTAGE);
            }
            else{     
                totalPrice += item.getPriceInCAD();
            }
        }
        return totalPrice;
    }
    
    /**
     * method getNumberOfOnSaleItems
     * @return numberOfSaleItems
     */
    public int getNumberOfOnSaleItems(){
        int numberOfSaleItems = 0;
        for(ClothingItem item : shoppingCart){
            if(item.getIsOnSale()){
                numberOfSaleItems++;
            }
        }
        return numberOfSaleItems;
    }
    
    /**
     * method getSubscribedDiscount
     *
     */
    public void getSubscribedDiscount(){
        if(getIsSubscribed()){
            double finalPrice = calculateTotalPrice() * (1 - DISCOUNT_SUBSCRIBER);
            System.out.println("You got extra 5% discount as a subscriber");
            System.out.println("Your total price : " + finalPrice);
        }
        else{
            System.out.println("You are NOT subscribed");
        }
    }
    
    /**
     * method editShoppingCart
     * @para itemDescription
     */
    public void editShoppingCart(String itemDescription){
        Iterator<ClothingItem> iter = shoppingCart.iterator();
        while(iter.hasNext()){
            ClothingItem item = iter.next();
            if(item.getItemDescription()== itemDescription){
                iter.remove();
            }
        }
    }
    
    /**
     * method displayDetails
     * 
     */
    public void displayDetails(){
        for(ClothingItem item : shoppingCart){
            item.printDetails();
            System.out.println();
        }
    }
    
    /**
     * 
     */
    public static void main(String[] args){
        Customer customer1 = new Customer("Brian", "Vancouver", true);
        
        ClothingItem item1 = new ClothingItem("Tshirt", 24.99, "s", false);
        ClothingItem item2 = new ClothingItem("trouser", 35.99, "xl", true);
        ClothingItem item3 = new ClothingItem("heattech", 19.99, "l", false);
        
        customer1.addItem(item1);
        customer1.addItem(item2);
        customer1.addItem(item3);
        
        System.out.println();
        customer1.displayItemDetails("tshirt");
        
        System.out.println();
        System.out.println("Total items on sale : " + customer1.getNumberOfOnSaleItems());
        
        System.out.println();
        System.out.println("Total Price : " + customer1.calculateTotalPrice());
        
        System.out.println();
        customer1.getSubscribedDiscount();
        
        System.out.println();
        customer1.editShoppingCart("trouser");
        
        System.out.println();
        customer1.displayDetails();
    }
    
}
