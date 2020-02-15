/**
 * 
 */
package ca.bcit.comp1451.session3.LabB;

/**
 * @author Brian Truong
 *
 */
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author phuon
 *
 */
public class Utilities {

	/**
	 * 
	 */
	private HashMap<String, Integer> hashmap;
	private Scanner input;
	
	public Utilities() {
		hashmap = new HashMap<String,Integer>();
		input = new Scanner(System.in);
	}
	
	public void populateHashMap() {
		System.out.println("Enter a text: ");
		String text = input.nextLine();
		
		String[] words = text.split(" ");
		for(int index=0; index < words.length; index++) {
			if(hashmap.get(words[index]) == null) {
				hashmap.put(words[index], 1);
			}
			else {
				int count = Integer.valueOf(hashmap.get(words[index]));
				count++;
				hashmap.put(words[index], count);
			}
		}
		
	}
	
	public void displayCollection() {
		for(String word : hashmap.keySet()) {
			System.out.println("Word: " + word + "\tCounts: " + hashmap.get(word));
		}
	}
	
	/**
	 * 
	 * @param word
	 */
	public void getCount(String word) {
		if(hashmap.containsKey(word)) {
			System.out.println("Word: " + word + "\tCounts: " + hashmap.get(word));
		}
		else {
			System.out.println("The word was not found");
		}
	}
	
	/**
	 * 
	 * @param number
	 */
	public void displayTheWord(int number) {
		if(hashmap.containsValue(number)) {
			for(String word : hashmap.keySet()) {
				if(hashmap.get(word) == number) {
					System.out.println("Word: " + word  + "\tCounts: " + number);
				}
			}
		}
		else {
			System.out.println("There is no word which is repeated " + number + " times");
		}
	}
	
	/**
	 * 
	 * @param word
	 */
	public void removeWord(String word) {
		if(hashmap.containsKey(word)) {
			hashmap.remove(word);
		}
		else {
			System.out.println("The word can not be found");
		}
	}

}
