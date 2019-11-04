
/**
 * Write a description of class CommissionSales here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class CommissionSales
{
    // instance variables - replace the example below with your own
    public static final double RATE_A = 0.05; 
    public static final double RATE_B = 0.10;  
    public static final double RATE_C = 0.13;  
    public static final double RATE_D = 0.18;  
    public static final double RATE_E=  0.22;  
    public static final int DIVISION_FACTOR = 10000;
    public static final int MAX_SALE_AMOUNT_IN_CAD = 59999;

    private String salesPersonName;
    private int salesAmountInCAD;
    private double payInCAD;

    /**
     * Constructor for objects of class CommissionSales
     * @param inputName to set salesPersonName
     * @param inputSaleAmountInCAD to set salesAmountInCAD
     */
    public CommissionSales(String inputName, int inputSaleAmountInCAD)
    {
        // initialise instance variables
        if(inputName != null){
            salesPersonName = inputName;
        }else{
            throw new IllegalArgumentException("Name cannot be null");
        }

        if(inputSaleAmountInCAD > 0 && inputSaleAmountInCAD <= MAX_SALE_AMOUNT_IN_CAD){
            salesAmountInCAD = inputSaleAmountInCAD;
        }else{
            throw new IllegalArgumentException("sale amount must in the range of 0 to 59999");
        }
    }

    /**
     * Constructor with no parameter
     */
    public CommissionSales(){
        salesPersonName = "unknown";
        salesAmountInCAD = 0;
        payInCAD = 0.0;
    }

    /**
     * Mutator method for salesAmountInCAD
     * @param inputSaleAmountInCAD to set salesAmountInCAD
     */
    public void setSalesAmountInCAD(int inputSaleAmountInCAD){
        if(inputSaleAmountInCAD > 0 && inputSaleAmountInCAD <= MAX_SALE_AMOUNT_IN_CAD){
            salesAmountInCAD = inputSaleAmountInCAD;
        }else{
            throw new IllegalArgumentException("sale amount must in the range of 0 to 59999");
        }
    }

    /**
     * Mutator method for salePersonName
     * @param inputName to set salesPersonName
     */
    public void setSalesPersonName(String inputName){
        if(inputName != null){
            salesPersonName = inputName;
        }else{
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    /**
     * Accessor method for salesPersonName
     * @return salesPersonName
     */
    public String getSalesPersonName(){
        return salesPersonName;
    }

    /**
     * Accessor method for salesAmountInCAD
     * @return salesAmountInCAD
     */
    public int getSalesAmountInCAD(){
        return salesAmountInCAD;
    }

    /**
     * Accessor method for payInCAD
     * @return payInCad
     */
    public double getPayInCAD(){
        return payInCAD;
    }

    /**
     * Method calculatePay
     * @return payInCAD
     */

    public double calculatePay(){
        switch(salesAmountInCAD / DIVISION_FACTOR){
            case 0 :
            case 1 : payInCAD = salesAmountInCAD * RATE_A;
            break;
            case 2 : payInCAD = salesAmountInCAD * RATE_B;
            break;
            case 3 : payInCAD = salesAmountInCAD * RATE_C;
            break;
            case 4 : payInCAD = salesAmountInCAD * RATE_D;
            break;
            case 5 : payInCAD = salesAmountInCAD * RATE_E;
            break;
            default : System.out.println("Invalid sales amount or out of the acceptable range");
        }
        return payInCAD;
    }

    /**
     * Method displayDetails
     */
    public void displayDetails(){
        System.out.println("Sales person name: " + salesPersonName);
        System.out.println("Sales amount in CAD: $" + salesAmountInCAD);
        System.out.println("Pay amount in CAD: $" + payInCAD);
    }
    
    
    
}
