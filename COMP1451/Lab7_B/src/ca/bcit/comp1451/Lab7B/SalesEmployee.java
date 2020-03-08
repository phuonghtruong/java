/**
 * 
 */
package ca.bcit.comp1451.Lab7B;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * SalesEmployee.java
 */
public class SalesEmployee extends Employee{

	private int numberOfSoldUnits;
	private double commissionRatePerUnit;
	/**
	 * Constructor
	 * @param name
	 * @param numberOfSoldUnits
	 * @param commissionRatePerUnit
	 */
	public SalesEmployee(String name, int numberOfSoldUnits,
			              double commissionRatePerUnit) {
		// TODO Auto-generated constructor stub
		super(name);
		setNumberOfSoldUnits(numberOfSoldUnits);
		setCommissionRatePerUnit(commissionRatePerUnit);
	}
	/**
	 * 
	 * @param numberOfSoldUnits
	 */
	public void setNumberOfSoldUnits(int numberOfSoldUnits) {
		if(numberOfSoldUnits <= 0) {
			throw new IllegalArgumentException("Number of sold units cannot be negative or zero");
		}
		else {
			this.numberOfSoldUnits = numberOfSoldUnits;
		}
	}
	/**
	 * 
	 * @return numberOfSoldUnits
	 */
	public int getNumberOfSoldUnits() {return numberOfSoldUnits;}
	/**
	 * 
	 * @param commissionRatePerUnit
	 */
	public void setCommissionRatePerUnit(double commissionRatePerUnit) {
		if(commissionRatePerUnit <= 0) {
			throw new IllegalArgumentException("Commission cannot be negative or zero");
		}
		else {
			this.commissionRatePerUnit = commissionRatePerUnit;
		}
	}
	/**
	 * 
	 * @return comissionRatePerUnit
	 */
	public double getCommissionRatePerUnit() {return commissionRatePerUnit;}
	/**
	 * return numberOfSoldUnits * CommissionRatePerUnit
	 */
	public double calculatePay() {
		return getNumberOfSoldUnits()*getCommissionRatePerUnit();
	}

	@Override
	public String toString() {
		return super.toString() + "\n"+
	           "Type of Employee: sales" + "\n" +
			   "Number of unit sold: " + getNumberOfSoldUnits() + "\n" +
	           "Commission rate per unit: " + getCommissionRatePerUnit() + "\n" +
			   "The pay: " + calculatePay();
	}
}
