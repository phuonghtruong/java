/**
 * 
 */
package ca.bcit.comp1451.lesson10_A;

/**
 * @author Brian Truong
 * Mar. 21, 2020
 * NumberReader.java
 */
public class NumberReader {
	private InputReader inputNumber;
	/**
	 * 
	 */
	public NumberReader() {
		// TODO Auto-generated constructor stub
		inputNumber = new InputReader();
	}
	/**
	 * 
	 * @return sum of numbers
	 */
	public int displaySumOfNumbers()
	{
		int sum = 0;
		System.out.println("Please enter numbers: ");
		int num = -1 ; 
		do {
			try {
				num = inputNumber.getNumber();
				sum += num;			
			}catch (InvalidInputException e){
				System.out.println(e.getMessage());
			}finally {
				//finally always executed
			}
		}while(num != 0);

		return sum;
	}

}
