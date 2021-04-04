package a01203138.data.music;

import a01203138.data.MusicMedia;

public class CompactDisk extends MusicMedia {

	private int numberOfTracks;
	
	public CompactDisk() {
		numberOfTracks = 0;
	}

	public CompactDisk(String title, String artist, int numberOfTracks) {
		super(title, artist);
		setNumberOfTracks(numberOfTracks);
	}

	/**
	 * @return the numberOfTracks
	 */
	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	/**
	 * @param numberOfTracks the numberOfTracks to set
	 */
	public void setNumberOfTracks(int numberOfTracks) {
		if (numberOfTracks >= 0) {
			this.numberOfTracks = numberOfTracks;
		} else {
			throw new IllegalArgumentException("Number of tracks cannot be negative!");
		}
	}

	@Override
	public String toString() {
		return "CompactDisk [numberOfTracks=" + numberOfTracks + 
				", toString()=" + super.toString() +"]";
	}

	@Override
	public void play() {
		System.out.println("Playing \"" +this.getTitle() +"\" CD." );
	}

}
