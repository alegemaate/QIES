/*
 * BackOffice entry point
 * 	Takes 4 parameters in the command line. 
 * 		A path to a 
 *		transaction summary file and central service file.
 *		and an output path to
 *		the new csf and a valid service file
 *	Outputs valid service file and updated central service
 *		file to running directory with specified names
 *
 *  You must have java installed on your system
 *  	run java -h to check if it is installed
 *
 *  BackOffice can be built, or you can use the provided .class files.
 *  	To build QUIES navigate to ./src/ directory and execute:
 *  	javac BackOffice.java -d ../bin/
 *
 *	To run BackOffice navigate to ./build/ directory and execute:
 *		java -cp ../bin "BackOffice" "csf.txt" "tsf.txt" "newcsf.txt" "vsf.txt"
 *
 * Spice Tests TEAM 13
 * 08/11/2018
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class BackOffice {

	/*
	 * MAIN METHOD: starting point for program.
	 * 
	 * Input: Merged TXN Summary File, Central Services File
	 * Output: New Central Service File, New VSF
	 */
	public static void main(String[] args) {
		// Ensure we are receiving 2 inputs
		if (args.length < 4) {
			System.out.println("You must provide a Merged TXN Summary File and Central Services File as well as paths to an output CSF and VSF.");
			System.exit(1);
		}
		
		// Too many parameters
		if (args.length > 4) {
			System.out.println("Too many arguments. You must only provide a Merged TXN Summary File and Central Services File as well as paths to an output CSF and VSF.");
			System.exit(1);
		}
		
		// Load CSF
		try {
			Services.readCSF(args[0]);
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Error: CSF read issue.");
			System.out.println("CSF:\n" + Services.getCSFString());
			System.out.println("VSF:\n" + Services.getVSFString());
		}
		catch (InvalidInputFileException e) {
			System.out.println(e.getMessage());
			System.out.println("Error: CSF format incorrect.");
		}
		
		// Load TSF
		try {
			Services.readTSF(args[1]);
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Error: TSF read issue.");
		}
		catch (InvalidInputFileException e) {
			System.out.println(e.getMessage());
			System.out.println("Error: TSF format incorrect.");
		}

		
		// Write Files
		System.out.println("CSF:\n" + Services.getCSFString());
		System.out.println("VSF:\n" + Services.getVSFString());
		
		PrintWriter out;
		try {
			out = new PrintWriter(args[2]);
			out.print(Services.getCSFString());
			out.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			out = new PrintWriter(args[3]);
			out.print(Services.getVSFString());
			out.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
