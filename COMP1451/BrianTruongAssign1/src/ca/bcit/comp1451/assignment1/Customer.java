package ca.bcit.comp1451.assignment1;

/**
 * @author Brian Truong
 *
 */

public class Customer {

	private String name;
	private String address;
	private Date dateOfBirth;
	
	public Customer(String name, String address, Date dateOfBirth) {
		// TODO Auto-generated constructor stub
		setName(name);
		setAddress(address);
		setDateOfBirth(dateOfBirth);
	}
	
	public void setName(String name) {
		if(name == null || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be null or an empty String");
		}
		else {
			this.name = name;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		if(address == null || address.isBlank() || address.isEmpty()) {
			throw new IllegalArgumentException("address cannot be null or an empty String");
		}
		else {
			this.address = address;
		}
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		if(dateOfBirth != null) {
			this.dateOfBirth = dateOfBirth;
		}
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String formatName(String name) {
		String firstLetter = name.toUpperCase().substring(0, 1);
		String theRest = name.toLowerCase().substring(1);
		return firstLetter + theRest;
	}
	
	public void displayCustomerInformation() {
		System.out.println("Customer Name : " + formatName(getName()));
		System.out.println("Customer Address : " + getAddress());
		System.out.println("Customer date of birth : " + getDateOfBirth().displayDate());
	}
}
