/**
 * 
 */
package ca.bcit.comp1451.session5_B;

/**
 * @author Brian Truong
 * Feb. 17, 2020
 * Airplane.java
 */
public class Airplane extends Vehicle {
	
	private int maxHeightInFeet;
	/**
	 * Airplane constructor
	 */
	public Airplane(int yearManufactured, String vehicleMake,
			String vehicleModel, int maxHeightInFeet) {
		// TODO Auto-generated constructor stub
		super(yearManufactured, vehicleMake, vehicleModel);
		setMaxHeightInFeet(maxHeightInFeet);
	}
	/**
	 * 
	 * @param maxHeightInFeet
	 */
	public void setMaxHeightInFeet(int maxHeightInFeet) {
		if(maxHeightInFeet <= 0) {
			throw new IllegalArgumentException("Height can not be negative or zero");
		}
		else {
			this.maxHeightInFeet = maxHeightInFeet;
		}
	}
	/**
	 * 
	 * @return maxHeightInFeet
	 */
	public int getMaxHeightInFeet() {return maxHeightInFeet;}
	
	public void displayDetails() {
		System.out.println("Make: " + getVehicleMake());
		System.out.println("Model: " + getVehicleModel());
		System.out.println("Year Manufactured: " + getYearManufactured());
		System.out.println("Maximum Height in Feet: " + getMaxHeightInFeet());
		System.out.println();
	}

}
