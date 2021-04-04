package a01203138.book.data;

public class Customer {
	public static final int ATTRIBUTE_COUNT = 9;
	
	private int id;
	private String firstName;
	private String lastName;
	private String streetName;
	private String city;
	private String postalCode;
	private String phone;
	private String emailAddress;
	private String joinDate;

	public static class Builder {
		// Required parameters
		private final int id;
		private final String phone;

		// Optional parameters
		private String streetName;
		private String city;
		private String postalCode;
		private String firstName;
		private String lastName;
		private String emailAddress;
		private String joinDate;

		public Builder(int id, String phone) {
			this.id = id;
			this.phone = phone;
		}

		public Builder firstName(String val) {
			firstName = val;
			return this;
		}

		public Builder lastName(String val) {
			lastName = val;
			return this;
		}

		public Builder streetName(String val) {
			streetName = val;
			return this;
		}

		public Builder city(String val) {
			city = val;
			return this;
		}

		public Builder postalCode(String val) {
			postalCode = val;
			return this;
		}

		public Builder emailAddress(String val) {
			emailAddress = val;
			return this;
		}

		public Builder joinDate(String val) {
			joinDate = val;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}

	private Customer(Builder builder) {
		id = builder.id;
		firstName = builder.firstName;
		lastName = builder.lastName;
		streetName = builder.streetName;
		city = builder.city;
		postalCode = builder.postalCode;
		phone = builder.phone;
		emailAddress = builder.emailAddress;
		joinDate = builder.joinDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the joinDate
	 */
	public String getJoinDate() {
		return joinDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetName="
				+ streetName + ", city=" + city + ", postalCode=" + postalCode + ", phone=" + phone + ", emailAddress="
				+ emailAddress + ", joinDate=" + joinDate + "]";
	}

}
