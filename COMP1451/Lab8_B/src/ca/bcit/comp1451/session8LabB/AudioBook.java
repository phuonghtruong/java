/**
 * 
 */
package ca.bcit.comp1451.session8LabB;

/**
 * @author Brian Truong
 * Mar. 7, 2020
 * AudioBook.java
 */
public class AudioBook extends AudioMaterial {
	private int totalNumberOfPages;
	private String authorName;
	/**
	 * 
	 */
	public AudioBook(String name, double playingTimeInMinutes, int totalNumberOfPages, String authorName) {
		// TODO Auto-generated constructor stub
		super(name, playingTimeInMinutes);
		setTotalNumberOfPages(totalNumberOfPages);
		setAuthorName(authorName);
	}
	/**
	 * 
	 * @param totalNumberOfPages
	 */
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		if(totalNumberOfPages <= 0) {
			throw new IllegalArgumentException("Total number of pages cannot be negative");
		}
		else {
			this.totalNumberOfPages = totalNumberOfPages;
		}
	}
	/**
	 * 
	 * @return totalNumberOfPages
	 */
	public int getTotalNumberOfPages() {return totalNumberOfPages;}
	
	/**
	 * 
	 * @param authorName
	 */
	public void setAuthorName(String authorName) {
		if(authorName == null || authorName.isBlank() || authorName.isEmpty()) {
			throw new IllegalArgumentException("Author name cannot be null or emtpy string");
		}
		else {
			this.authorName = authorName;
		}
	}
	/**
	 * 
	 * @return authorName
	 */
	public String getAuthorName() {return authorName;}
	

}
