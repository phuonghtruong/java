/**
 * 
 */
package ca.bcit.comp1451.session5_A;

/**
 * @author A01203138
 *
 */
public class Magazine extends ReadingMaterial{

	/**
	 * 
	 */
	private String scheduledPubication;
	private int numberOfSubscribers;
	
	public Magazine(String title, int numberOfPages,
			String scheduledPublication, int numberOfSubcribers) {
		// TODO Auto-generated constructor stub
		super(title, numberOfPages);
		setScheduledPublication(scheduledPublication);
		setNumberOfSubcribers(numberOfSubscribers);
	}
	
	public void setScheduledPublication(String scheduledPublication) {
		if(scheduledPublication == null || scheduledPublication.isBlank() || scheduledPublication.isEmpty()) {
			throw new IllegalArgumentException("scheduled publication cannot be null or empty string");
		}
		else {
			this.scheduledPubication = scheduledPublication;
		}
	}
	
	public String getScheduledPublication() {return scheduledPubication;}

	public void setNumberOfSubcribers(int numberOfSubscribers) {
		if(numberOfSubscribers < 0) {
			throw new IllegalArgumentException("number of subscribers cannot be negative");
		}
		else {
			this.numberOfSubscribers = numberOfSubscribers;
		}
	}
	
	public int getNumberOfSubscribers() {return numberOfSubscribers;}
	
	public void displayDetails() {
		System.out.println("title: " + getTitle());
		System.out.println("Scheduled publications: " + getScheduledPublication());
		System.out.println("Number of subscribers: " + getNumberOfSubscribers());
	}
}
