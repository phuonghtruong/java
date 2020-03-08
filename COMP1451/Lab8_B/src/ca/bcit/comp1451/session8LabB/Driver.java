/**
 * 
 */
package ca.bcit.comp1451.session8LabB;

/**
 * @author Brian Truong
 * Mar. 7, 2020
 * Driver.java
 */
import java.util.ArrayList;
import java.util.Collections;

public class Driver {
	private static ArrayList<AudioMaterial> list;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list = new ArrayList<AudioMaterial>();
		
		AudioMaterial a1 = new AudioBook("Introduction of AudioBook", 60, 200, "Phil");
		AudioMaterial a2 = new Album("Crazy album", 25, 15, "Collin");
		AudioMaterial a3 = new Movie("Lord of the rings", 180, "Stephen King", 450);
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		Collections.sort(list);
		
		for(AudioMaterial a : list) {
			System.out.println(a);
		}		
	}
}
