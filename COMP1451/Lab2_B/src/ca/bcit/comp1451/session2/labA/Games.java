/**
 * 
 */
package ca.bcit.comp1451.session2.labA;

/**
 * @author A01203138    
 *
 */
import ca.bcit.comp1451.session2.labB.Dice;
import java.util.*;

public class Games {
	private Scanner input;
	private ArrayList<String> listOfWords;
	private ArrayList<Integer> listOfIntegers;
	private ArrayList<Double> listOfDoubles;
	
	public static final int START_ROUND = 2;
	public static final int END_ROUND = 12;
	
	public Games() {
		input = new Scanner(System.in);
		listOfWords = new ArrayList<String>();
		listOfIntegers = new ArrayList<Integer>();
		listOfDoubles = new ArrayList<Double>();
	}
	
	public void textParser() {
		int numberOfWords = 0;
		int numberOfInteger = 0;
		int numberOfDouble = 0;
		
		System.out.println("Enter script: ");
		while(input.hasNext()) {
			if(input.hasNextInt()) {
				numberOfInteger++;
				listOfIntegers.add(Integer.parseInt(input.next()));
			}
			else if(input.hasNextDouble()) {
				numberOfDouble++;
				listOfDoubles.add(Double.parseDouble(input.next()));
			}
			else {
				numberOfWords++;
				listOfWords.add(input.next());
			}
		}
		System.out.println("number of words " + numberOfWords);
		System.out.println(listOfWords);

		System.out.println("number of Integer " + numberOfInteger);
		System.out.println(listOfIntegers);
		
		System.out.println("number of double " + numberOfDouble);
		System.out.println(listOfDoubles);
	}
	
	public void playChicago() {
		int roundNumber = 0;
		int firstDie = 0;
		int secondDie = 0;
		int earnedPoints = 0;
		
		for(roundNumber = START_ROUND; roundNumber <= END_ROUND; roundNumber++) {
			System.out.println("Round number " + roundNumber);
			
			Dice d1 = new Dice();
			Dice d2 = new Dice();
			firstDie = d1.getFaceValue();
			secondDie = d2.getFaceValue();
			System.out.println("First die value was " + firstDie);
			System.out.println("Second die value was " + secondDie);
			
			if(roundNumber == firstDie + secondDie) {
				earnedPoints++;
				System.out.println("Points earned 1");
			}
			System.out.println();
		}
		System.out.println("Total earned points " + earnedPoints);
	}
}
