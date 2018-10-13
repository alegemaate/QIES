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
	
	public static void main(String [] args) {
		// Ensure we are receiving a input file and a directory for output
		if (args.length != 3 && false) {
			System.out.println("You must provide a valid service file and a directory to output the transaction summary file.");
			System.exit(1);
		}
		
		// Read args
		String vsFile = "";//args[1];
		String transDir = "";//args[2];
		
		// Ensure directory exists
		File f = new File(transDir);
		if (!f.exists()) {
			System.out.println("Directory does not exist");
			//System.exit(1);
		}
		
		// Ensure valid services file exists
		File f2 = new File(vsFile);
		if (!f2.exists()) {
			System.out.println("Valid service file does not exist");
			//System.exit(1);
		}
		
		// Go to main case switch
		input.runQIES();
	}
}
