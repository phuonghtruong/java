package ca.bcit.comp1451.lab7a;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Driver.java
 */

public class Computer extends Electronics {

	private int cpuSpeed;
	private int memorySizeInGB;
	public static final int PERIODS_INCREASE_IN_MONTHS = 12;
	/**
	 * 
	 * @param brand
	 * @param price
	 * @param warrantyInMonths
	 * @param cpuSpeed
	 * @param memorySizeInGB
	 */
	public Computer(String brand, double price, int warrantyInMonths,
			int cpuSpeed, int memorySizeInGB) {
		// TODO Auto-generated constructor stub
		super(brand,price,warrantyInMonths);
		setCpuSpeed(cpuSpeed);
		setMemorySizeInGB(memorySizeInGB);
	}
	/**
	 * 
	 * @param cpuSpeed
	 */
	public void setCpuSpeed(int cpuSpeed) {
		if(cpuSpeed <= 0) {
			throw new IllegalArgumentException("cpu speed cannot be negative or zero");
		}
		else {
			this.cpuSpeed = cpuSpeed;
		}
	}
	/**
	 * 
	 * @return cpuSpeed
	 */
	public int getCpuSpeed() {return cpuSpeed;}
	/**
	 * 
	 * @param memorySizeInGB
	 */
	public void setMemorySizeInGB(int memorySizeInGB) {
		if(memorySizeInGB <= 0) {
			throw new IllegalArgumentException("memory size cannot be negative or zero");
		}
		else {
			this.memorySizeInGB = memorySizeInGB;
		}
	}
	/**
	 * 
	 * @return memorySizeInGB
	 */
	public int getMemorySizeInGB() { return memorySizeInGB;}

	@Override
	public String toString() {
		return super.toString() +"\n" + "The CPU speed: " + getCpuSpeed() +
		                         "\n" + "The memory size in GB: " + getMemorySizeInGB();
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
