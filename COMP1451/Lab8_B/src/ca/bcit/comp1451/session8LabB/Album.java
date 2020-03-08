/**
 * 
 */
package ca.bcit.comp1451.session8LabB;

/**
 * @author Brian Truong
 * Mar. 7, 2020
 * Album.java
 */
public class Album extends AudioMaterial{
	private int numberOfSongs;
	private String artistName;
	/**
	 * 
	 */
	public Album(String name, double playingTimeInMinutes, int numberOfSongs, String artistName) {
		// TODO Auto-generated constructor stub
		super(name, playingTimeInMinutes);
		setNumberOfSongs(numberOfSongs);
		setArtistName(artistName);
	}
	/**
	 * @return the numberOfSongs
	 */
	public int getNumberOfSongs() {
		return numberOfSongs;
	}
	/**
	 * @param numberOfSongs the numberOfSongs to set
	 */
	public void setNumberOfSongs(int numberOfSongs) {
		if(numberOfSongs <= 0) {
			throw new IllegalArgumentException("Number of songs");
		}
		else {
			this.numberOfSongs = numberOfSongs;
		}
	}
	/**
	 * @return the artistName
	 */
	public String getArtistName() {
		return artistName;
	}
	/**
	 * @param artistName the artistName to set
	 */
	public void setArtistName(String artistName) {
		if(artistName == null || artistName.isBlank() || artistName.isEmpty()) {
			throw new IllegalArgumentException("Artist name cannot be null or empty");
		}
		else {
			this.artistName = artistName;
		}
	}

	
}
