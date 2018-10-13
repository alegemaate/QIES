/*
 * CredentialCommands
 * Handle login and logout commands
 * Spice Tests
 * 13/10/2018
 */
public class CredentialCommands {
	// Static flag for logged in state
	public static boolean loggedIn = false;
	
	// Validate login 
	// Return true on success
	public static boolean login() {
		
		loggedIn = true;
		return true;
	}
	
	// Validate logout
	// Return true on success
	public static boolean logout() {
		
		loggedIn = false;
		return true;
	}
}
