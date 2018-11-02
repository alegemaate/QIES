/*
 * InvalidDateFormat
 * Exception type for invalid date format
 * Spice Tests
 * 02/11/2018
 */

package backoffice;

public class InvalidDateFormatException extends Exception {
	private static final long serialVersionUID = 7279050877570678636L;

	public InvalidDateFormatException(String message) {
		super(message);
	}
}
