/*
 * CredentialCommands
 * Handle login and logout commands
 * Spice Tests
 * 13/10/2018
 */

import java.util.ArrayList;
import java.util.Arrays;

public class CredentialCommands {
	// Static flag for logged in state
	public static boolean loggedIn = false;
	
	// User type, empty when logged out
	public static String userType = "";
	
	// List of valid 'userType' logins
	private static ArrayList<String> validUsers = new ArrayList<>(Arrays.asList("planner", "agent"));
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * LOGIN: Validate user login.
	 * 		a) Validates that login is either planner or agent.
	 * 		b) Validates that user not already logged in
	 * 		c) Sets logged in flag to true
	 * 
	 * Input: none
	 * Output: boolean (true if login successful, false otherwise)
	 */
	public static boolean login() {
		// Ensure login allowed
		if (loggedIn) {
			System.out.println("Error: You are already logged in.");
			return false;
		} // end if
		
		// Get user type
		userType = ScannerWrapper.getInput("Enter user type");
		if (!validUsers.contains(userType)) {
			System.out.println("Error: User type " + userType + " does not exist.");
			return false;
		} // end if
		
		// Success
		loggedIn = true;
		System.out.println("Successfully logged in as " + userType + ".");
		
		return true;
	} // end login method
	
	//---------------------------------------------------------------------------------------------
	
	/* LOGOUT: Validate user logout.
	 * 		a) Validates that user is already logged in
	 * 		b) Sets logged in flag to false
	 * 
	 * Input: none
	 * Output: boolean (true if logout successful, false otherwise)
	 */
	public static boolean logout() {
		if (!loggedIn) {
			System.out.println("Error: You are not logged in.");
			return false;
		} // end if
		
		// Success! Logout
		loggedIn = false;
		System.out.println("Successfully logged out.");
		userType = "";
		
		// Write txn summary file
		Log.writeFile(Configuration.tsfPath);
		
		// Logout successful
		return true;
	} // end logout method
	
} // end CredentialCommands class
