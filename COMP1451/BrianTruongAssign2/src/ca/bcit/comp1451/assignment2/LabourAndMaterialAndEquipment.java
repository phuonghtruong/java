/**
 * 
 */
package ca.bcit.comp1451.assignment2;

import ca.bcit.comp1451.assignment2.Labour.Criteria;
import ca.bcit.comp1451.assignment2.Labour.TypeOfLabour;

/**
 * @author Brian Truong
 * Mar. 1, 2020
 * LabourAndMaterialAndEquipment.java
 */
public class LabourAndMaterialAndEquipment extends LabourAndMaterial {

	private double equipmentValueInCAD;
	private int numberOfHoursRented;
	
	private static double HOURLY_RENTAL_RATE = 0.05;
	private static double EQUIP_VALUE_RATE = 0.02;
	/**
	 * 
	 */
	public LabourAndMaterialAndEquipment(String projectName, int numberOfWorkingHours,
			double hourlyRate ,double travelDistanceInKm, 
			Criteria hourlyRateCriteria, TypeOfLabour type,
			double purchasePrice, double volumeInCubicFoot,
			double conveyingDistanceInKm, double equipmentValueInCAD,
			int numberOfHoursRented) {
		// TODO Auto-generated constructor stub
		super(projectName, numberOfWorkingHours, hourlyRate ,travelDistanceInKm, 
			hourlyRateCriteria, type, purchasePrice,volumeInCubicFoot,
			conveyingDistanceInKm);
		setEquipmentValueInCAD(equipmentValueInCAD);
		setNumberOfHoursRented(numberOfHoursRented);
	}
	
	public void setEquipmentValueInCAD(double equipmentValueInCAD) {
		if(equipmentValueInCAD <=0) {
			throw new IllegalArgumentException("value cannot be negative or zero");
		}
		else {
			this.equipmentValueInCAD = equipmentValueInCAD;
		}
	}
	
	public double getEquipmentValueInCAD() {return equipmentValueInCAD;}
	
	public void setNumberOfHoursRented(int numberOfHoursRented) {
		if(numberOfHoursRented < 0) {
			throw new IllegalArgumentException("number of hours cannot be negative");
		}
		else {
			this.numberOfHoursRented = numberOfHoursRented;
		}
	}
	
	public int getNumberOfHoursRented() {return numberOfHoursRented;}
	
	public double calculateRentalFees() {
		double rentalFees = 0; 
		rentalFees = HOURLY_RENTAL_RATE * getEquipmentValueInCAD() *
				              getNumberOfHoursRented();		
		return rentalFees;
	}
	
	public double calculateTrainingFees() {
		TypeOfLabour type = getTypeOfLabour();
		double trainingFees = 0;
		double equipValue = getEquipmentValueInCAD();
		if(type == TypeOfLabour.INEXPERIENCED) {
			trainingFees = equipValue * (EQUIP_VALUE_RATE * equipValue);
		}
		return trainingFees;
		
	}
	
	@Override
	public double calculateTotalCost() {
		double totalCost = 0;
		double totalTaxFee = 0;
		double rentalFees = calculateRentalFees();
		double trainingFees = calculateTrainingFees();
		
		totalTaxFee = super.TAX_PERCENTAGE * (rentalFees + trainingFees);
		totalCost = super.calculateTotalCost() + rentalFees + trainingFees + totalTaxFee;		
		return totalCost;
	}
	
	@Override
	public String toString() {
		String outputString;
		TypeOfLabour type = getTypeOfLabour();
		outputString = super.toString() + "\n" +
						"Number of hours rented: " + getNumberOfHoursRented() + "\n" +
				        "Equipment Rental Fees: " + calculateRentalFees();
		if(type == TypeOfLabour.INEXPERIENCED) {
			outputString = outputString + "\n" +
		                "Training Fees: " + calculateTrainingFees() ;
		}
		return outputString;
	}

}
