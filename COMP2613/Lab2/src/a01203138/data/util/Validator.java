/**
 * 
 */
package a01203138.data.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Brian Truong
 * Jan 17, 2021
 * Validator.java
 */
public class Validator {
	public static final String VALID_EMAIL_ADDRESS_REGEX = 
			"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private static final Pattern pattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);

	public static boolean isValidEmail(final String emailStr) {
        Matcher matcher = pattern.matcher(emailStr);
        return matcher.matches();
	}

}
