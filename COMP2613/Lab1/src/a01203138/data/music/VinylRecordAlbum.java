package a01203138.data.music;

import a01203138.data.MusicMedia;

public class VinylRecordAlbum extends MusicMedia {

	public static final int STANDARD_WEIGHT = 120;

	private int numberOfTracks;
	private int weight;

	public VinylRecordAlbum() {
		numberOfTracks = 0;
		weight = 0;
	}
	
	public VinylRecordAlbum(String title, String artist, int numberOfTracks) {
		super(title, artist);
		setNumberOfTracks(numberOfTracks);
		weight = STANDARD_WEIGHT;
	}

	public VinylRecordAlbum(String title, String artist, int numberOfTracks, int weight) {
		super(title, artist);
		setNumberOfTracks(numberOfTracks);
		setWeight(weight);
	}

	@Override
	public void play() {
		System.out.println("Playing \"" +this.getTitle() +"\" record." );
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

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		if (weight > STANDARD_WEIGHT) {
			this.weight = weight;
		}
		if (weight < 0) {
			throw new IllegalArgumentException("Weight cannot be negative!");
		}
	}

	@Override
	public String toString() {
		return "VinylRecordAlbum [numberOfTracks=" + numberOfTracks + 
								", weight=" + weight + 
								", toString()=" + super.toString() + "]";
	}

}
