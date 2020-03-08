package ca.bcit.comp1451.session5_B;

import java.util.ArrayList;

public class Transportation {

	private ArrayList<Vehicle> vehicleList;
	
	public Transportation() {
		// TODO Auto-generated constructor stub
		vehicleList = new ArrayList<Vehicle>();
	}
	/**
	 * 
	 * @param v1
	 */
	public void loadCollection(Vehicle v1) {
		if(v1 instanceof Car || v1 instanceof Boat || v1 instanceof Airplane) {
			vehicleList.add(v1);
		}
	}
	/**
	 * Method display details of all transportation
	 */
	public void displayAllDetails() {
		for(Vehicle v1 : vehicleList) {
			if(v1 instanceof Car) {
				((Car) v1).displayDetails();
			}
			else if(v1 instanceof Boat) {
				((Boat) v1).displayDetails();
			}
			else if(v1 instanceof Airplane) {
				((Airplane) v1).displayDetails();
			}
		}
	}

	/**
	 * Method display airplane details
	 */
	public void displayAirplaneDetails() {
		for(Vehicle v1 : vehicleList) {
			if(v1 instanceof Airplane) {
				((Airplane) v1).displayDetails();
			}
		}
	}
	
	public static void main(String[] args) {
		Transportation t1 = new Transportation();
		Car c1 = new Car(2018, "Toyota", "SUV", 180);
		Boat b1 = new Boat(2019, "ABC", "Cruise", true);
		Airplane a1 = new Airplane(2017, "Boeing", "787", 11000);
		
		t1.loadCollection(c1);
		t1.loadCollection(b1);
		t1.loadCollection(a1);
		
		t1.displayAirplaneDetails();
		System.out.println("============");
		t1.displayAllDetails();
	}
}
