package backoffice;

import java.io.File;
import java.io.IOException;

public class BackOffice {

	/*
	 * MAIN METHOD: starting point for program.
	 * 
	 * Input: Merged TXN Summary File, Central Services File
	 * Output: New Central Service File, New VSF
	 */
	public static void main(String[] args) {
		// Ensure we are receiving 2 inputs
		if (args.length < 2) {
			System.out.println("You must provide a Merged TXN Summary File and Central Services File.");
			System.exit(1);
		}
		
		// Too many parameters
		if (args.length > 2) {
			System.out.println("Too many arguments. You must only provide a Merged TXN Summary File and Central Services File.");
			System.exit(1);
		}
		
		// Load CSF
		try {
			Services.readCSF(args[0]);
		} 
		catch (IOException e) {
			System.out.println("Error: CSF read issue.");
			System.exit(1);
		}
		catch (InvalidInputFileException e) {
			System.out.println("Error: CSF format incorrect.");
			System.exit(1);
		}
		
		// Load TSF
		try {
			Services.readTSF(args[1]);
		} 
		catch (IOException e) {
			System.out.println("Error: TSF read issue.");
			System.exit(1);
		}
		catch (InvalidInputFileException e) {
			System.out.println("Error: TSF format incorrect.");
			System.exit(1);
		}

		
		// Write Files
		System.out.println("CSF:\n" + Services.getCSFString());
		System.out.println("VSF:\n" + Services.getVSFString());
	}

}
