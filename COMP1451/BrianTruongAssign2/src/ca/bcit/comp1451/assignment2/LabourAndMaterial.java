/**
 * 
 */
package ca.bcit.comp1451.assignment2;

import ca.bcit.comp1451.assignment2.Labour.Criteria;
import ca.bcit.comp1451.assignment2.Labour.TypeOfLabour;

/**
 * @author Brian Truong
 * Mar. 1, 2020
 * LabourAndMaterial.java
 */
public class LabourAndMaterial extends Labour implements Transferable {

	private double purchasePrice;
	private double volumeInCubicFoot;
	private double conveyingDistanceInKm;
	
	private static final double MARKUP_PERCENTAGE = 0.15;
	private static final double STANDARD_VOLUME = 10;
	private static final double FEE_RATE_FOR_OVER_STANDARD_VOL = 2;
	private static final double FEE_RATE_FOR_UNDER_STANDARD_VOL = 1.5;
	/**
	 * 
	 */
	public LabourAndMaterial(String projectName, int numberOfWorkingHours,
			double hourlyRate ,double travelDistanceInKm, 
			Criteria hourlyRateCriteria, TypeOfLabour type,
			double purchasePrice, double volumeInCubicFoot,
			double conveyingDistanceInKm) {
		// TODO Auto-generated constructor stub
		super(projectName,numberOfWorkingHours,hourlyRate,travelDistanceInKm, 
			  hourlyRateCriteria, type);
		setPurchasePrice(purchasePrice);
		setVolumeInCubicFoot(volumeInCubicFoot);
		setConveyingDistanceInKm(conveyingDistanceInKm);
	}

	public void setPurchasePrice(double purchasePrice) {
		if(purchasePrice <= 0) {
			throw new IllegalArgumentException("Purchase price cannot be negative or zero");
		}
		else {
			this.purchasePrice = purchasePrice;
		}
	}
	
	public double getPurchasePrice() {return purchasePrice;}
	
	public void setVolumeInCubicFoot(double volumeInCubicFoot) {
		if(volumeInCubicFoot <= 0) {
			throw new IllegalArgumentException("Volume cannot be negative or zero");
		}
		else {
			this.volumeInCubicFoot = volumeInCubicFoot;
		}
	}
	
	public double getVolumeInCubicFoot() {return volumeInCubicFoot;}
	
	public void setConveyingDistanceInKm(double conveyingDistanceInKm) {
		if(conveyingDistanceInKm <= 0) {
			throw new IllegalArgumentException("Distance cannot be negative or zero");
		}
		else {
			this.conveyingDistanceInKm = conveyingDistanceInKm;
		}
	}
	
	public double getConveyingDistanceInKm() {return conveyingDistanceInKm;}
	
	public double calculateTotalMaterialCost() {
		double cost = 0;
		double purchaseCost = getPurchasePrice();
		cost = purchaseCost + purchaseCost * MARKUP_PERCENTAGE;
		return cost;
	}
	
	@Override
	public double calculateConveyingFees() {
		// TODO Auto-generated method stub
		double fee = 0;
		double volume = getVolumeInCubicFoot();
		double distance = getConveyingDistanceInKm();
		if(volume >= STANDARD_VOLUME ) {
			fee = distance * FEE_RATE_FOR_OVER_STANDARD_VOL;
		}
		else {
			fee = distance * FEE_RATE_FOR_UNDER_STANDARD_VOL;
		}
		return fee;
	}
	
	@Override
	public double calculateTotalCost() {
		double totalCost = 0;
		double totalTaxFee = 0;
		double materialCost = calculateTotalMaterialCost();
		double conveyFees = calculateConveyingFees();
		
		totalTaxFee = super.TAX_PERCENTAGE * (conveyFees + materialCost);
		totalCost = super.calculateTotalCost() + materialCost + conveyFees + totalTaxFee;		
		return totalCost;
	}
	
	@Override
	public String toString() {
		if(this.getClass() == LabourAndMaterial.class) {
			return super.toString() + "\n" +
	           	"Material Cost: " + calculateTotalMaterialCost() + "\n" +
	           	"Conveying Cost: " + calculateConveyingFees() + "\n"+
				"Total Cost: " + calculateTotalCost();
		}
		else {
			return super.toString();
		}
	}

}
