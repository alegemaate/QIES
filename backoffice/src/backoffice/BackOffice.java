package backoffice;

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
			System.out.println(e.getMessage());
			System.out.println("Error: TSF format incorrect.");
			System.exit(1);
		}

		
		// Write Files
		System.out.println("CSF:\n" + Services.getCSFString());
		System.out.println("VSF:\n" + Services.getVSFString());
		
		PrintWriter out;
		try {
			out = new PrintWriter("newcsf.txt");
			out.println(Services.getCSFString());
			out.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			out = new PrintWriter("vsf.txt");
			out.println(Services.getVSFString());
			out.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
