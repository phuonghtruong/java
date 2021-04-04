package a01203138.data;


public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String emailAddress;
	
	public static class Builder {
		// Required parameters
		private final String id;
		private final String emailAddress;
		
		// Optional parameters
		private String firstName;
		private String lastName;
		private String phone;
		
		public Builder(String id, String emailAddress) {
			this.id = id;
			this.emailAddress = emailAddress;
		}
		
		public Builder firstName(String val) {
			firstName = val;
			return this;
		}
		
		public Builder lastName(String val) {
			lastName = val;
			return this;
		}
		
		public Builder phone(String val) {
			phone = val;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}
	}
	
	private Student(Builder builder) {
		id = builder.id;
		firstName = builder.firstName;
		lastName = builder.lastName;
		phone = builder.phone;
		emailAddress = builder.emailAddress;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Student info:\n" + id + ": " + firstName + " " + lastName + 
				", " + emailAddress + ", " + phone;
	}
	
	
}
