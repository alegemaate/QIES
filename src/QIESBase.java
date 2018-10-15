/*
 * QIES entry point
 * Program starts here
 * Spice Tests
 * 13/10/2018
 */

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;

public class QIESBase {
	// Input handler
	public static InputHandler input = new InputHandler();
	
	/* 
	 * Validate path
	 * Checks if file/directory exists
	 * Returns true on exists, false on not exists
	 */
	public static boolean validatePath(String path) {
		// Ensure valid services file exists
		File f2 = new File(path);
		if (!f2.exists()) {
			return false;
		}
		return true;
	}
	
	// Entry point
	public static void main(String [] args) {
		// Ensure we are receiving a input file and a directory for output
		if (args.length != 2) {
			System.out.println("You must provide a valid service file and a directory "
					+ "to output the transaction summary file as command line arguments.");
			System.exit(1);
		}
		
		// Validate vsf
		if (!validatePath(args[0])) {
			System.out.println("Valid service file '" + args[0] + "'  does not exist");
			System.exit(1);
		}
		else {
			Configuration.vsfPath = args[0];
			Services.readServices(args[0]);
		}
		
		// Validate tsf directory
		if (!validatePath(args[1])) {
			System.out.println("Directory '" + args[1] + "' does not exist");
			System.exit(1);
		}
		else {
			Configuration.tsfPath = args[1];
		}
		
		// Go to main case switch
		input.runQIES();
	}
}
