/*
 * QIES entry point
 * This is the QIES ticket purchasing program for CISC 327
 * 	It is intended to imitate a system where users can sell tickets
 * 	and create services
 * 	Takes two files as parameters, a valid service file and
 * Spice Tests
 * 13/10/2018
 */

import java.io.File;

public class QIESBase {
	// Input handler
	public static InputHandler input = new InputHandler();
	
	/* 
	 * VALIDATEPATH: Checks if file/directory exists
	 * 
	 * Input: String representing file path
	 * Output: boolean (true on exists, false on not exists)
	 */
	public static boolean validatePath(String path) {
		// Ensure valid services file exists
		File f2 = new File(path);
		if (!f2.exists()) {
			return false;
		} // end if
		return true;
	} // end validatePath method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * MAIN METHOD: starting point for program.
	 * 
	 * Input: Valid Services File (input file), Directory for Transaction Summary
	 * 		  File output
	 * Output: none
	 */
	public static void main(String [] args) {
		// Ensure we are receiving a input file and a directory for output
		if (args.length != 1) {
			System.out.println("You must provide a valid service file as a command line argument.");
			System.exit(1);
		} // end if
		
		// Validate vsf
		if (!validatePath(args[0])) {
			System.out.println("Valid service file '" + args[0] + "'  does not exist");
			System.exit(1);
		} else {
			Configuration.vsfPath = args[0];
			Services.readServices(args[0]);
		} // end if/else
		
		// Validate tsf directory
		String tsfDirectory = "transactions";
		if (!validatePath(tsfDirectory)) {
			System.out.println("Directory '" + args[1] + "' does not exist");
			System.exit(1);
		} else {
			Configuration.tsfPath = tsfDirectory;
		} // end if/else

		// Go to main case switch
		input.runQIES();
	} // end main
	
} // end QIESBase class
