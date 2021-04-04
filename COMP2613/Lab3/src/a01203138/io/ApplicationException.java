package a01203138.io;

import java.time.DateTimeException;
import java.util.Arrays;

@SuppressWarnings("serial")
public class ApplicationException extends Exception{
	public ApplicationException() {
		
	}
	
	public ApplicationException(String emailAddress) {
		System.out.println("Invalid email: " + emailAddress);
	}

	public ApplicationException(int length, String[] customerInfo) {
		System.out.println("Expected 9 but got " + length + " : " + Arrays.deepToString(customerInfo));
	}

	public ApplicationException(DateTimeException e) {
		System.out.println(e.getMessage());
	}
	
	
}
