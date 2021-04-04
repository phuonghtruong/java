package a01203138.io;

import java.time.DateTimeException;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	
	private static final Logger Log = LogManager.getLogger();
	
	public ApplicationException() {

	}

	public ApplicationException(String emailAddress) {
		Log.error("Invalid email: " + emailAddress);
	}

	public ApplicationException(int length, String[] customerInfo) {
		Log.error("Expected 9 but got " + length + " : " + Arrays.deepToString(customerInfo));
	}

	public ApplicationException(DateTimeException e) {
		Log.error(e.getMessage());
	}

}
