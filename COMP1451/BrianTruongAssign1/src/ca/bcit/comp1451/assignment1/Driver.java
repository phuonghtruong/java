/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author Brian Truong
 *
 */
public class Driver {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date birthday1 = new Date(1,1,1990);
		Date birthday2 = new Date(10,9,1992);
		Date birthday3 = new Date(31,7,1996);
		Date birthday4 = new Date(5,11,1980);
		
		Customer c1 = new Customer("Brian McAdams", "Vancouver", birthday1);
		Customer c2 = new Customer("Aiden May", "Burnaby", birthday2);
		Customer c3 = new Customer("Lilly James", "Toronto", birthday3);
		Customer c4 = new Customer("Peter Jackson", "Quebec", birthday4);
		
		Date accCreatedDay1 = new Date(25,12,2019);
		Date accCreatedDay2 = new Date(3,2,2020);
		Date accCreatedDay3 = new Date(9,8,2018);
		Date accCreatedDay4 = new Date(15,1,2020);
		
		Account acc1 =  new Account(c1, accCreatedDay1, 0);
		Account acc2 =  new Account(c2, accCreatedDay2, 50);
		Account acc3 =  new Account(c3, accCreatedDay3, 125.5);
		Account acc4 =  new Account(c4, accCreatedDay4, 200.25);
		
		Bank bank1 = new Bank("OMG");
		bank1.addAccount(acc1);
		bank1.addAccount(acc2);
		bank1.addAccount(acc3);
		bank1.addAccount(acc4);
		
		System.out.println();
		bank1.displayAccountNumbers();
		System.out.println();
		bank1.makeTransaction();		

	}

}
