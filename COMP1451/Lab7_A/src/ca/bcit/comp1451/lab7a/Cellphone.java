package ca.bcit.comp1451.lab7a;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Driver.java
 */

public class Cellphone extends Electronics{

	private double batteryLifeTime;
	public static final int PERIODS_INCREASE_IN_MONTHS = 6;
	/**
	 * 
	 * @param brand
	 * @param price
	 * @param warrantyInMonths
	 * @param batteryLifeTime
	 */
	public Cellphone(String brand, double price, int warrantyInMonths, double batteryLifeTime) {
		// TODO Auto-generated constructor stub
		super(brand,price,warrantyInMonths);
		setBatteryLifeTime(batteryLifeTime);
	}
	/**
	 * 
	 * @param batteryLifeTime
	 */
	public void setBatteryLifeTime(double batteryLifeTime) {
		if(batteryLifeTime <= 0) {
			throw new IllegalArgumentException("life time cannot be negative or zero");
		}
		else {
			this.batteryLifeTime = batteryLifeTime;
		}
	}
	/**
	 * 
	 * @return batteryLifeTime
	 */
	public double getBatteryLifeTime() {
		return batteryLifeTime;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\n" + "The battery life time: " + getBatteryLifeTime();
	}
	/**
	 * @param percentage
	 */
	public void increasePrice(double percentage) {
		double updatedPrice = 0;
		int updatedWarranty = 0;
		updatedPrice = getPrice() + getPrice()*percentage;
		updatedWarranty = getWarrantyInMonth() + PERIODS_INCREASE_IN_MONTHS;
		setPrice(updatedPrice);
		setWarrantyInMonth(updatedWarranty);
	}

}
