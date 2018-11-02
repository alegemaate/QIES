/*
 * InvalidServiceNameException
 * Exception type for invalid service name
 * Spice Tests
 * 02/11/2018
 */

package backoffice;

public class InvalidServiceNameException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3812513180943768796L;

	public InvalidServiceNameException(String message) {
		super(message);
	}
}
