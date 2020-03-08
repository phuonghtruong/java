/**
 * 
 */
package ca.bcit.comp1451.session5_A;

/**
 * @author A01203138
 *
 */
public class TextBook extends ReadingMaterial{

	/**
	 * 
	 */
	private int editionNumber;
	private String authorName;
	private String subject;
	
	public TextBook(String title, int numberOfPages, int editionNumber,
			String authorName, String subject) {
		// TODO Auto-generated constructor stub
		super(title, numberOfPages);
		setEditionNumber(editionNumber);
		setAuthorName(authorName);
		setSubject(subject);
	}
	
	public void setEditionNumber(int editionNumber) {
		if(editionNumber <= 0) {
			throw new IllegalArgumentException("edition number cannot be negative or zero");
		}
		else {
			this.editionNumber = editionNumber;
		}
	}
	
	public int getEditionNumber() {return editionNumber;}
	
	public void setAuthorName(String authorName) {
		if(authorName == null || authorName.isBlank() || authorName.isEmpty()) {
			throw new IllegalArgumentException("author name cannot be null or empty string");
		}
		else {
			this.authorName = authorName;
		}
	}
	
	public String getAuthorName() {return authorName;}
	
	public void setSubject(String subject) {
		if(subject == null || subject.isBlank() || subject.isEmpty()) {
			throw new IllegalArgumentException("subject cannot be null or empty string");
		}
		else {
			this.subject = subject;
		}
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void displayDetails() {
		System.out.println("Title : " + getTitle());
		System.out.println("Number of pages: " + getNumberOfPages());
		System.out.println("Edition number: " + getEditionNumber());
		System.out.println("author name: " + getAuthorName());
		System.out.println("Subject: " + getSubject());
	}

}
