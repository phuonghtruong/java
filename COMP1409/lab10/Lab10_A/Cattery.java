
/**
 * Write a description of class Cattery here.
 *
 * @author Brian
 * @version 01
 */

import java.util.*;

public class Cattery
{
    // instance variables - replace the example below with your own
    private String businessName;
    private ArrayList<Cat> catList;

    /**
     * Constructor for objects of class Cattery
     */
    public Cattery()
    {
        // initialise instance variables
        businessName = "unknown";
        catList = new ArrayList<Cat>();
    }
    /**
     * Constructor for objects of class Cattery
     * @para businessName to set the name of business
     */
    public Cattery(String businessName){
        setBusinessName(businessName);
        catList = new ArrayList<Cat>();
    }
    /**
     * Mutator method to set business name
     * @para businessName to set the name of business
     */
    public void setBusinessName(String businessName){
        if(businessName != null){
            this.businessName = businessName;
        }
        else{
            throw new IllegalArgumentException("business name cannot be null");
        }
    }
    /**
     * Method to add cat to cat list
     */
    public void addCat(Cat newCat){
        if(newCat != null){
            catList.add(newCat);
        }
    }
    /**
     * Method to retrieve a specific cat
     * @para index to set position of cat in the catList
     */
    public void getCat (int index){
        if(index >=0 && index < catList.size()){
            Cat c = catList.get(index);
            c.displayDetails();            
        }
        else{
            System.out.println("Invalid index");
        }
    }
    /**
     * Method to remove cat
     * @para index to set position of cat in the catList
     */
    public void removeCat(int index){
        if(index >= 0 && index < catList.size()){
            catList.remove(index);
        }
        else{
            System.out.println("Invalid index");
        }
    }
    /**
     * Method to display cat name
     */
    public void displayCatName(){
        for(Cat c : catList){
            System.out.println(c.getName());
        }
    }
    
    public static void main(String[] args){
        Cattery cattery = new Cattery();
        Cat c1 = new Cat("A",5, 3.6);
        Cat c2 = new Cat("B",1, 15.2);
        Cat c3 = new Cat("C",3, 6.8);
        
        cattery.addCat(c1);
        cattery.addCat(c2);
        cattery.addCat(c3);
        
        cattery.getCat(4);
        cattery.getCat(2);
        
        cattery.displayCatName();
        cattery.removeCat(4);
        cattery.removeCat(2);
        cattery.displayCatName();        
    }
}
