/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * ProjectInvoice.java
 */
public abstract class ProjectInvoice implements Comparable<ProjectInvoice> {

	private String invoiceNumber;
	private String projectName;
	private int numberOfWorkingHours;
	private double hourlyRate;
	
	private static int invoiceIndex = 1000;
	/**
	 * 
	 * @param projectName
	 * @param numberOfWorkingHours
	 * @param hourlyRate
	 */
	public ProjectInvoice(String projectName, int numberOfWorkingHours,
							double hourlyRate) {
		// TODO Auto-generated constructor stub
		createInvoiceNumber();
		setProjectName(projectName);
		setNumberOfWorkingHours(numberOfWorkingHours);
		setHourlyRate(hourlyRate);
	}
	/**
	 * Create invoice number
	 */
	public void createInvoiceNumber() {
		invoiceIndex += 1;
		this.invoiceNumber="INVC" + invoiceIndex;
	}
	/**
	 * 
	 * @return invoiceNumber
	 */
	public String getInvoiceNumber() {return invoiceNumber;}
	/**
	 * 
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		if(projectName == null || projectName.isBlank() || projectName.isEmpty()) {
			throw new IllegalArgumentException("Project name cannot be null or empty string");
		}
		else {
			this.projectName = projectName;
		}
	}
	/**
	 * 
	 * @return projectName
	 */
	public String getProjectName() {return projectName;}
	/**
	 * 
	 * @param numberOfWorkingHours
	 */
	public void setNumberOfWorkingHours(int numberOfWorkingHours) {
		if(numberOfWorkingHours <= 0) {
			throw new IllegalArgumentException("Number of working hours cannot be negative or zero");
		}
		else {
			this.numberOfWorkingHours = numberOfWorkingHours;
		}
	}
	/**
	 * 
	 * @return numberOfWorkingHours
	 */
	public int getNumberOfWorkingHours() {return numberOfWorkingHours;}
	/**
	 * 
	 * @param hourlyRate
	 */
	public void setHourlyRate(double hourlyRate) {
		if(hourlyRate <=0) {
			throw new IllegalArgumentException("Hourly rate cannot be negative or zero");
		}
		else {
			this.hourlyRate = hourlyRate;
		}
	}
	/**
	 * 
	 * @return hourlyRate
	 */
	public double getHourlyRate() {return hourlyRate;}
	
	public abstract double calculateTotalCost();
	
	@Override
	public int compareTo(ProjectInvoice p) {
		return (int)(this.calculateTotalCost() - p.calculateTotalCost());
	}
	
	@Override
	public String toString() {
		return "Invoice number: " + getInvoiceNumber() + "\n" +
				"Project name: " + getProjectName() + "\n" +
				"Number of Working hours: " + getNumberOfWorkingHours() + "\n" +
				"Hourly rate: " + getHourlyRate();
	}
}
