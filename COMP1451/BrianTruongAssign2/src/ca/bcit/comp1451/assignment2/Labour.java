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
	/**
	 * 
	 * @param travelDistanceInKm
	 */
	public void setTravelDistanceInKm(double travelDistanceInKm) {
		if(travelDistanceInKm <= 0) {
			throw new IllegalArgumentException("Distance cannot be negative or zero");
		}
		else {
			this.travelDistanceInKm = travelDistanceInKm;
		}
	}
	/**
	 * 
	 * @return travelDistanceInKm
	 */
	public double getTravelDistanceInKm() {return travelDistanceInKm;}
	
	/**
	 * 
	 * @param hourlyRateCriteria
	 */
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
	/**
	 * 
	 * @return hourlyRateCriteria
	 */
	public Criteria getHourlyRateCriteria() {return hourlyRateCriteria;}
	/**
	 * 
	 * @param type for type of labour
	 */
	public void setTypeOfLabour(TypeOfLabour type) {
		if(type != null && (type == TypeOfLabour.EXPERIENCED ||
				            type == TypeOfLabour.INEXPERIENCED)) {
			this.type = type;
		}
		else {
			this.type = TypeOfLabour.INEXPERIENCED;
		}
	}
	/**
	 * 
	 * @return type of labour
	 */
	public TypeOfLabour getTypeOfLabour() {return type;}
	/**
	 * 
	 * @return travel distance cost
	 */
	public double calculateTravalledDistanceCost() {
		double cost = 0;
		cost = COST_INDEX * getTravelDistanceInKm();
		return cost;
	}
	/**
	 * 
	 * @return labour cost
	 */
	public double calculateLabourCost() {
		double labourCost = 0;
		Criteria criteria = getHourlyRateCriteria();
		double hourlyRate = getHourlyRate();
		int numberOfWorkingHours = getNumberOfWorkingHours();
		if(criteria == Criteria.REGULAR) {
			labourCost = REGULAR_RATE * hourlyRate * numberOfWorkingHours;
		}
		else if(criteria == Criteria.OVERTIME) {
			labourCost = OVERTIME_RATE * hourlyRate * numberOfWorkingHours;
		}
		else if(criteria == Criteria.HOLIDAY) {
			labourCost = HOLIDAY_RATE * hourlyRate * numberOfWorkingHours;
		}
		return labourCost;
	}
	/**
	 * return total cost
	 */
	public double calculateTotalCost() {
		double totalCost = 0;		
		totalCost = this.calculateLabourCost() + this.calculateTravalledDistanceCost();
		totalCost += totalCost*TAX_PERCENTAGE;
		return totalCost;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Hourly rate criteria: " + getHourlyRateCriteria().name() + "\n"+
				"Type of labour: " + getTypeOfLabour().name() + "\n"+
				"Cost of labour: " + calculateLabourCost() + "\n" +
				"Travel distance cost: " + calculateTravalledDistanceCost() +
				((this.getClass() == Labour.class ) ? "\nTotal cost: " + calculateTotalCost() : "");
	}
}
