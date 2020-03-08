package ca.bcit.comp1451.session5_B;

public class Car extends Vehicle{

	private int horsePower;
	/**
	 * 
	 * @param yearManufactured
	 * @param vehicleMake
	 * @param vehicleModel
	 * @param horsePower
	 */
	public Car(int yearManufactured, String vehicleMake,
			String vehicleModel, int horsePower) {
		// TODO Auto-generated constructor stub
		super(yearManufactured, vehicleMake, vehicleModel);
		setHorsePower(horsePower);
	}
	/**
	 * 
	 * @param horsePower
	 */
	public void setHorsePower(int horsePower) {
		if(horsePower <= 0) {
			throw new IllegalArgumentException("horse power cannot be negative or zero");
		}
		else {
			this.horsePower = horsePower;
		}
	}
	/**
	 * 
	 * @return horsePower
	 */
	public int getHorsePower() {return horsePower;}
	
	public void displayDetails() {
		System.out.println("Year Manufactured: " + getYearManufactured());
		System.out.println("Make: " + getVehicleMake());
		System.out.println("Model: " + getVehicleModel());
		System.out.println("Horse Power: " + getHorsePower());
		System.out.println();
	}

}
