package ca.bcit.comp1451.session5_B;

public class Boat extends Vehicle{
	private boolean isMotorized;
	/**
	 * 
	 * @param yearManufactured
	 * @param vehicleMake
	 * @param vehicleModel
	 * @param isMotorized
	 */
	public Boat(int yearManufactured, String vehicleMake,String vehicleModel, boolean isMotorized) {
		// TODO Auto-generated constructor stub
		super(yearManufactured, vehicleMake, vehicleModel);
		setMotorized(isMotorized);
	}
	/**
	 * 
	 * @param isMotorized
	 */
	public void setMotorized(boolean isMotorized) {
		this.isMotorized = isMotorized;
	}
	/**
	 * 
	 * @return isMotorized
	 */
	public boolean getMotorized() {return isMotorized;}
	
	public void displayDetails() {
		System.out.println("Make: " + getVehicleMake());
		System.out.println("Model: " + getVehicleModel());
		System.out.println("Year Manufactured: " + getYearManufactured());
		if(getMotorized()) {
			System.out.println("Motorized: Yes");
		}
		else {
			System.out.println("Motorized: No");
		}
		System.out.println();
	}

}
