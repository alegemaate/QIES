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
	
	// Validate login 
	// Return true on success
	public static boolean login() {
		// Ensure login allowed
		if (loggedIn) {
			System.out.println("Error: You are already logged in.");
			return false;
		}
		
		// Get user type
		userType = ScannerWrapper.getInput("Enter user type");
		if (!validUsers.contains(userType)) {
			System.out.println("Error: User type " + userType + " does not exist.");
			return false;
		}
		
		// Success
		loggedIn = true;
		System.out.println("Successfully logged in as " + userType + ".");
		
		return true;
	}
	
	// Validate logout
	// Return true on success
	public static boolean logout() {
		if (!loggedIn) {
			System.out.println("Error: You are not logged in.");
			return false;
		}
		
		// Success! Logout
		loggedIn = false;
		System.out.println("Successfully logged out.");
		userType = "";
		
		// Write txn summary file
		Log.writeFile(Configuration.tsfPath);
		
		return true;
	}
}
