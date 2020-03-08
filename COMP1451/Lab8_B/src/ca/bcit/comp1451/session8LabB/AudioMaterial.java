/**
 * 
 */
package ca.bcit.comp1451.session8LabB;

/**
 * @author Brian Truong
 * Mar. 7, 2020
 * AudioMaterial.java
 */
public abstract class AudioMaterial implements Comparable<AudioMaterial>{
	private String name;
	private double playingTimeInMinutes;	
	/**
	 * 
	 */
	public AudioMaterial(String name, double playingTimeInMinutes) {
		// TODO Auto-generated constructor stub
		setName(name);
		setPlayingTimeInMinutes(playingTimeInMinutes);
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if(name == null || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty string");
		}
		else {
			this.name = name;
		}
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {return name;}
	/**
	 * 
	 * @param playingTimeInMinutes
	 */
	public void setPlayingTimeInMinutes(double playingTimeInMinutes) {
		if(playingTimeInMinutes <= 0) {
			throw new IllegalArgumentException("Play time cannot be negative");
		}
		else {
			this.playingTimeInMinutes = playingTimeInMinutes;
		}
	}
	/**
	 * 
	 * @return playingTimeInMinutes
	 */
	public double getPlayingTimeInMinutes() {return playingTimeInMinutes;}

	@Override
	public int compareTo(AudioMaterial o) {
		return (int)(this.playingTimeInMinutes - o.playingTimeInMinutes );
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "\n"+
			   "Playing time: " + getPlayingTimeInMinutes();
	}
}
