/**
 * 
 */
package ca.bcit.comp1451.session5_B;

/**
 * @author Brian Truong
 * Feb. 17, 2020
 * Vehicle.java
 */
public class Vehicle {

	private int yearManufactured;
	private String vehicleMake;
	private String vehicleModel;
	
	/**
	 * 
	 * @param yearManufactured
	 * @param vehicleMake
	 * @param vehicleModel
	 */
	
	public Vehicle(int yearManufactured, String vehicleMake, String vehicleModel) {
		// TODO Auto-generated constructor stub
		setYearManufactured(yearManufactured);
		setVehicleMake(vehicleMake);
		setVehicleModel(vehicleModel);
	}
	/**
	 * 
	 * @param yearManufactured
	 */
	public void setYearManufactured(int yearManufactured) {
		if(yearManufactured < 0) {
			throw new IllegalArgumentException("year manufactured can not be negative or zero");
		}
		else {
			this.yearManufactured = yearManufactured;
		}
	}
	/**
	 * 
	 * @return yearManufactured
	 */
	public int getYearManufactured() {return yearManufactured;}
	/**
	 * 
	 * @param vehicleMake
	 */
	public void setVehicleMake(String vehicleMake) {
		if(vehicleMake == null || vehicleMake.isBlank() || vehicleMake.isEmpty()) {
			throw new IllegalArgumentException("vehicle make can not be null or empty string");
		}
		else {
			this.vehicleMake = vehicleMake;
		}
	}
	/**
	 * 
	 * @return vehicleMake
	 */
	public String getVehicleMake() {return vehicleMake;}
	
	/**
	 * 
	 * @param vehicleModel
	 */
	public void setVehicleModel(String vehicleModel) {
		if(vehicleModel == null || vehicleModel.isBlank() || vehicleModel.isEmpty()) {
			throw new IllegalArgumentException("vehicle model can not be null or empty string");
		}
		else {
			this.vehicleModel = vehicleModel;
		}
	}
	/**
	 * 
	 * @return vehicleModel
	 */
	public String getVehicleModel() {return vehicleModel;}

}
