package ca.bcit.comp1451.lab7a;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Driver.java
 */

public abstract class Electronics {

	private String brand;
	private double price;
	private int warrantyInMonth;
	
	public static final int TOTAL_MONTHS = 12;
	
	/**
	 * 
	 * @param brand
	 * @param price
	 * @param warrantyInMonth
	 */
	public Electronics(String brand, double price, int warrantyInMonth) {
		// TODO Auto-generated constructor stub
		setBrand(brand);
		setPrice(price);
		setWarrantyInMonth(warrantyInMonth);
	}
	
	/**
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		if (brand == null || brand.isBlank() || brand.isEmpty()) {
			throw new IllegalArgumentException("Brand can not be null or emtpy string");
		}
		else {
			this.brand = brand;
		}
	}
	/**
	 * 
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		if(price <=0 ) {
			throw new IllegalArgumentException("price cannot be zero or negative");
		}
		else {
			this.price = price;
		}
	}
	/**
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param warrantyInMonth
	 */
	public void setWarrantyInMonth(int warrantyInMonth) {
		if(warrantyInMonth <1) {
			throw new IllegalArgumentException("Months must be in range from 1 to 12");
		}
		else {
			this.warrantyInMonth = warrantyInMonth;
		}
	}
	/**
	 * 
	 * @return warrantyInMonth
	 */
	public int getWarrantyInMonth() {return warrantyInMonth;}
	
	public abstract void increasePrice(double percentage);
	
	@Override
	public String toString() {
		return "The brand: " + getBrand() + ". The price: " + getPrice() +
				". The warranty in months: " + getWarrantyInMonth();
	}
}
