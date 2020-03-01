package ca.bcit.comp1451.lab7a;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Driver.java
 */

import java.util.ArrayList;

public class Driver {

	private static ArrayList<Electronics> listOfDevices;
	
	public static void main(String[] args) {
		listOfDevices = new ArrayList<Electronics>();
		
		Electronics cellphone = new Cellphone("Nokia TS200", 300, 18,3.5);
		Electronics desktop = new Computer("Dell D2100", 1000, 24, 2500, 512);
		Electronics laptop = new Laptop("HP N5170", 1500, 24, 1500, 256, 15);
		
		listOfDevices.add(cellphone);
		listOfDevices.add(desktop);
		listOfDevices.add(laptop);
		
		for(Electronics e:listOfDevices) {
			System.out.println(e.toString());
			System.out.println();
		}
		System.out.println("=================================");
		for(Electronics e:listOfDevices) {
			e.increasePrice(0.05);
			System.out.println(e);
			System.out.println();
		}
		
	}

}
