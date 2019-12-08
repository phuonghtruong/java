package test;

public class helloworld {
	private String name;
	private int age;
	private String address;
	
	public helloworld() {
		name = "unknown";
		age = 0;
		address = "unknown";
	}
	
	public helloworld(String name, int age, String address) {
		setName(name);
		setAge(age);
		setAddress(address);
	}
	
	public void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		else {
			this.name = name;
		}
	}

	public String getName() {return name;}
	
	public void setAge(int age) {
		if(age < 0 ) {
			throw new IllegalArgumentException("age cannot be negative");
		}
		else {
			this.age = age;
		}
	}
	
	public int getAge() {return age;}
	
	public void setAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException("address cannot be null");
		}
		else {
			this.address = address;
		}
	}
	
	public String getAddress() {return address;}
	
	public void displayDetail() {
		System.out.println("Your name: " + getName());
		System.out.println("Your age: " + getAge());
		System.out.println("Your address: " + getAddress());
	}
	
	public static void main(String[] args) {
		helloworld h1 = new helloworld();
		h1.setName("Brian");
		h1.setAge(29);
		h1.setAddress("vancouver");
		
		h1.displayDetail();
	}
}
