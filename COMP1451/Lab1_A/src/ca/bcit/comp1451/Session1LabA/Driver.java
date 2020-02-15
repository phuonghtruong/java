/**
 * 
 */
package ca.bcit.comp1451.Session1LabA;

/**
 * @author A01203138
 *
 */
public class Driver {
	
	public static void main(String[] args) {
		Dog dog1 = new Dog(args[0], args[1], Integer.parseInt(args[2]));
		Dog dog2 = new Dog(args[3], args[4], Integer.parseInt(args[5]));
		Kennel k1 = new Kennel();
		k1.addDog(dog1);
		k1.addDog(dog2);
		
		k1.displayDogs();
		k1.adopt(args[0]);
		k1.displayDogs();
	}
}
