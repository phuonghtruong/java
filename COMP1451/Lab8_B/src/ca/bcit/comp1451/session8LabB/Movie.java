/**
 * 
 */
package ca.bcit.comp1451.session8LabB;

/**
 * @author Brian Truong
 * Mar. 7, 2020
 * Movie.java
 */
public class Movie extends AudioMaterial{
	private String directorName;
	private int numberOfActors;
	/**
	 * 
	 */
	public Movie(String name, double playingTimeInMinutes, 
			String directorName, int numberOfActors) {
		// TODO Auto-generated constructor stub
		super(name, playingTimeInMinutes);
		setDirectorName(directorName);
		setNumberOfActors(numberOfActors);
	}
	/**
	 * @return the directorName
	 */
	public String getDirectorName() {
		return directorName;
	}
	/**
	 * @param directorName the directorName to set
	 */
	public void setDirectorName(String directorName) {
		if(directorName == null || directorName.isBlank() || directorName.isEmpty()) {
			throw new IllegalArgumentException("Director name cannot be null or empty string");
		}
		else {
			this.directorName = directorName;
		}
	}
	/**
	 * @return the numberOfActors
	 */
	public int getNumberOfActors() {
		return numberOfActors;
	}
	/**
	 * @param numberOfActors the numberOfActors to set
	 */
	public void setNumberOfActors(int numberOfActors) {
		if(numberOfActors <= 0) {
			throw new IllegalArgumentException("Number of Actors cannot be negative");
		}
		else {
			this.numberOfActors = numberOfActors;
		}
	}

	
}
