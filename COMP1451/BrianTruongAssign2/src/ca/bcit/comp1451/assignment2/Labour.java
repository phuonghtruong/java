/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Labour.java
 */
public class Labour extends ProjectInvoice{

	private double travelDistanceInKm;
	enum Criteria {
		REGULAR,
		OVERTIME,
		HOLIDAY;
	}
	
	enum TypeOfLabour{
		EXPERIENCED,
		INEXPERIENCED;
	}
	
	private Criteria hourlyRateCriteria;
	private TypeOfLabour type;
	
	private static final double COST_INDEX = 1.2;
	
	private static final double REGULAR_RATE = 1;
	private static final double OVERTIME_RATE = 1.5;
	private static final double HOLIDAY_RATE = 3;
	
	public static final double TAX_PERCENTAGE = 0.05;
	
	private static final double EXPERIENCED_RATE = 1.5;
	private static final double INEXPERIENCED_RATE = 1;
	
	/**
	 * 
	 */
	public Labour(String projectName, int numberOfWorkingHours,
			double hourlyRate ,double travelDistanceInKm, 
			Criteria hourlyRateCriteria, TypeOfLabour type) {
		// TODO Auto-generated constructor stub
		super(projectName, numberOfWorkingHours, hourlyRate);
		setTravelDistanceInKm(travelDistanceInKm);
		setHourlyRateCriteria(hourlyRateCriteria);
		setTypeOfLabour(type);
	}
	
	public void setTravelDistanceInKm(double travelDistanceInKm) {
		if(travelDistanceInKm <= 0) {
			throw new IllegalArgumentException("Distance cannot be negative or zero");
		}
		else {
			this.travelDistanceInKm = travelDistanceInKm;
		}
	}
	
	public double getTravelDistanceInKm() {return travelDistanceInKm;}
	
	public void setHourlyRateCriteria(Criteria hourlyRateCriteria) {
		if(hourlyRateCriteria != null && 
				(hourlyRateCriteria == Criteria.REGULAR ||
				 hourlyRateCriteria == Criteria.OVERTIME ||
				 hourlyRateCriteria == Criteria.HOLIDAY)) {
			this.hourlyRateCriteria = hourlyRateCriteria;
		}
		else {
			this.hourlyRateCriteria = Criteria.REGULAR;
		}
	}
	
	public Criteria getHourlyRateCriteria() {return hourlyRateCriteria;}
	
	public void setTypeOfLabour(TypeOfLabour type) {
		if(type != null && (type == TypeOfLabour.EXPERIENCED ||
				            type == TypeOfLabour.INEXPERIENCED)) {
			this.type = type;
		}
		else {
			this.type = TypeOfLabour.INEXPERIENCED;
		}
	}
	
	public TypeOfLabour getTypeOfLabour() {return type;}

	public double calculateTravalledDistanceCost() {
		double cost = 0;
		cost = COST_INDEX * getTravelDistanceInKm();
		return cost;
	}
	
	public double calculateLaboutCost() {
		TypeOfLabour type = getTypeOfLabour();
		double hourlyRate = getHourlyRate();
		if(type == TypeOfLabour.EXPERIENCED) {
			setHourlyRate(EXPERIENCED_RATE * hourlyRate);
		}
		else if(type == TypeOfLabour.INEXPERIENCED) {
			setHourlyRate(INEXPERIENCED_RATE * hourlyRate);
		}
		return getHourlyRate() * getNumberOfWorkingHours();
	}
	
	public double calculateTotalCost() {
		double totalCost = 0;
		Criteria criteria = getHourlyRateCriteria();
		double hourlyRate = getHourlyRate();
		int numberOfWorkingHours = getNumberOfWorkingHours();
		if(criteria == Criteria.REGULAR) {
			totalCost = REGULAR_RATE * hourlyRate * numberOfWorkingHours;
		}
		else if(criteria == Criteria.OVERTIME) {
			totalCost = OVERTIME_RATE * hourlyRate * numberOfWorkingHours;
		}
		else if(criteria == Criteria.HOLIDAY) {
			totalCost = HOLIDAY_RATE * hourlyRate * numberOfWorkingHours;
		}
		totalCost += this.calculateTravalledDistanceCost();
		totalCost = totalCost + totalCost*TAX_PERCENTAGE;
		return totalCost;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Hourly rate criteria: " + getHourlyRateCriteria().name() + "\n"+
				"Type of labour: " + getTypeOfLabour().name() + "\n"+
				"Cost of labour: " + calculateLaboutCost() + "\n" +
				"Travel distance cost: " + calculateTravalledDistanceCost() + "\n"+
				"Total cost: " + calculateTotalCost();
	}
}
