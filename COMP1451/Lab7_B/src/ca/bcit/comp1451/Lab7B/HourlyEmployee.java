/**
 * 
 */
package ca.bcit.comp1451.Lab7B;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * HourlyEmployee.java
 */
public class HourlyEmployee extends Employee {
	
	private int numberOfHours;
	private double payRate;
	/**
	 * Constructor
	 * @param name
	 * @param numberOfHours
	 * @param payRate
	 */
	public HourlyEmployee(String name, int numberOfHours, double payRate) {
		// TODO Auto-generated constructor stub
		super(name);
		setNumberOfHours(numberOfHours);
		setPayRate(payRate);
	}
	/**
	 * 
	 * @param numberOfHours
	 */
	public void setNumberOfHours(int numberOfHours) {
		if(numberOfHours <= 0) {
			throw new IllegalArgumentException("Number of hours cannot be negative or zero");
		}
		else {
			this.numberOfHours = numberOfHours;
		}
	}
	/**
	 * 
	 * @return numberOfHours
	 */
	public int getNumberOfHours() {return numberOfHours;}
	/**
	 * 
	 * @param payRate
	 */
	public void setPayRate(double payRate) {
		if(payRate <= 0) {
			throw new IllegalArgumentException("Pay rate cannot be negative or zero");
		}
		else {
			this.payRate = payRate;
		}
	}
	/**
	 * 
	 * @return payRate
	 */
	public double getPayRate() {return payRate;}
	
	/**
	 * return payRate * numberOfHours
	 */
	public double calculatePay() {
		return getPayRate()*getNumberOfHours();
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Type of Employees: Hourly" + "\n" +
				"Hourly Rate: " + getPayRate() + "\n" +
				"Number of hours: " + getNumberOfHours() + "\n"+
				"The pay: " + calculatePay();
	}
}
