package a01203138;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * 
 * @author Brian Truong
 * Feb 28, 2021
 * Runner.java
 */

public class Runner extends Thread implements Comparable<Runner>{

	private int lane;
	private int bibNumber;
	private String country;
	private String firstName;
	private String lastName;
	private int reactionTime;
	private int distance = 1;
	private long timeInMs;
	
	
	
	@Override
	public int compareTo(Runner obj) {
		// TODO Auto-generated method stub
		return (int) (getTimeInMs() - obj.getTimeInMs());
	}

	public static class Builder {
		// Required parameters
		private final int bibNumber;

		// Optional parameters
		private int lane;
		private String firstName;
		private String lastName;
		private int reactionTime;
		private String country;

		public Builder(int bibNumber) {
			this.bibNumber = bibNumber;
		}

		/**
		 * @param firstName
		 * 			the firstName to set
		 */
		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		/**
		 * @param lastName
		 *            the lastName to set
		 */
		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		/**
		 * @param street
		 *            the street to set
		 */
		public Builder setLane(int lane) {
			this.lane = lane;
			return this;
		}

		/**
		 * @param city
		 *            the city to set
		 */
		public Builder setCountry(String country) {
			this.country = country;
			return this;
		}

		/**
		 * @param postalCode
		 *            the postalCode to set
		 */
		public Builder setReactionTime(int reactionTime) {
			this.reactionTime = reactionTime;
			return this;
		}

		public Runner build() {
			return new Runner(this);
		}
	}

	/**
	 * Default Constructor
	 */
	private Runner(Builder builder) {
		bibNumber = builder.bibNumber;
		firstName = builder.firstName;
		lastName = builder.lastName;
		country = builder.country;
		lane = builder.lane;
		reactionTime = builder.reactionTime;
	}




	/**
	 * @return the lane
	 */
	public int getLane() {
		return lane;
	}



	/**
	 * @return the bibNumber
	 */
	public int getBibNumber() {
		return bibNumber;
	}



	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @return the reactionTime
	 */
	public int getReactionTime() {
		return reactionTime;
	}



	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}



	/**
	 * @return the timeInMs
	 */
	public long getTimeInMs() {
		return timeInMs;
	}



	/**
	 * @param lane the lane to set
	 */
	public void setLane(int lane) {
		this.lane = lane;
	}



	/**
	 * @param bibNumber the bibNumber to set
	 */
	public void setBibNumber(int bibNumber) {
		this.bibNumber = bibNumber;
	}



	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @param reactionTime the reactionTime to set
	 */
	public void setReactionTime(int reactionTime) {
		this.reactionTime = reactionTime;
	}



	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}



	/**
	 * @param timeInMs the timeInMs to set
	 */
	public void setTimeInMs(long timeInMs) {
		this.timeInMs = timeInMs;
	}
	
	@Override
	public void run() {
		Instant startTime = Instant.now();
		
		Random randomDelay = new Random();
		long delay = 90L + randomDelay.nextInt(16);
		
		try {
			Thread.sleep(this.getReactionTime());
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		while(distance < 100) {
			distance++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Instant endTime = Instant.now();
		Duration duration = Duration.between(startTime, endTime);
		this.timeInMs = duration.toMillis();
	}
	
}
