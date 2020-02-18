/**
 * 
 */
package ca.bcit.comp1451.session5_A;

/**
 * @author A01203138
 *
 */

public class ReadingMaterial {
	private String title;
	private int numberOfPages;
	
	public ReadingMaterial(String title, int numberOfPages) {
		setTitle(title);
		setNumberOfPages(numberOfPages);
	}
	
	public void setTitle(String title) {
		if(title == null || title.isBlank() || title.isEmpty()) {
			this.title = "unknown";
		}
		else {
			this.title = title;
		}
	}
	
	public String getTitle() {return title;}
	
	public void setNumberOfPages(int numberOfPages) {
		if(numberOfPages <= 0) {
			throw new IllegalArgumentException("Pages number can not be negative or zero");
		}
		else {
			this.numberOfPages = numberOfPages;
		}
	}
	
	public int getNumberOfPages() {return numberOfPages;}
	
	
}
