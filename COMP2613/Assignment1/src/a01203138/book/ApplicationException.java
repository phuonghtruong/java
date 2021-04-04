/**
 * Project: Bcmc
 * File: ApplicationException.java
 * Date: Aug 18, 2016
 * Time: 1:59:25 PM
 */

package a01203138.book;

import java.time.DateTimeException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Sam Cirka, A00123456
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	private static final Logger Log = LogManager.getLogger();
	/**
	 * Construct an ApplicationException
	 * 
	 * @param message
	 *            the exception message.
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * Construct an ApplicationException
	 * 
	 * @param throwable
	 *            a Throwable.
	 */
	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

	
	
	public ApplicationException(DateTimeException e) {
		Log.error(e.getMessage());
	}
}
