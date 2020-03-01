package ca.bcit.comp1451.lab7a;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Driver.java
 */

public class Laptop extends Computer {
	private double screenSize;
	/**
	 * 
	 * @param brand
	 * @param price
	 * @param warrantyInMonths
	 * @param cpuSpeed
	 * @param memorySizeInGB
	 * @param screenSize
	 */
	public Laptop(String brand, double price, int warrantyInMonths,
			int cpuSpeed, int memorySizeInGB, double screenSize) {
		// TODO Auto-generated constructor stub
		super(brand,price,warrantyInMonths,cpuSpeed,memorySizeInGB);
		setScreenSize(screenSize);
	}

	/**
	 * 
	 * @param screenSize
	 */
	public void setScreenSize(double screenSize) {
		if(screenSize <= 0) {
			throw new IllegalArgumentException("screen size cannot be negative or zero");
		}
		else {
			this.screenSize = screenSize;
		}
	}
	/**
	 * 
	 * @return screenSize
	 */
	public double getScreenSize() {return screenSize;}
	
	@Override
	public String toString() {
		return super.toString() +"\n" + "The screen size: " + getScreenSize();                
	}
	
}
