/**
 * 
 */
package a01203138.data.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import a01203138.io.ApplicationException;

/**
 * @author Brian Truong Feb 2, 2021 Validator.java
 */
public class Validator {
	public static final String VALID_EMAIL_ADDRESS_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	private static final String YYYYMMDD_PATTERN = "(20\\d{2})(\\d{2})(\\d{2})"; // valid for years 2000-2099
	private static final Pattern pattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);

	public static boolean isValidEmail(final String emailStr) {
		Matcher matcher = pattern.matcher(emailStr);
		return matcher.matches();
	}

	public static boolean validateJoinedDate(String yyyymmdd) {
		return yyyymmdd.matches(YYYYMMDD_PATTERN);
	}
}
