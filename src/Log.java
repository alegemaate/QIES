/*
 * Log
 * Stores data for transaction summary file
 * Spice Tests
 * 13/10/2018
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Log {
	// Holds each TXN summary line
	static ArrayList<String> lines = new ArrayList<String>();

	/* Add line to lines array
	 * 
	 * input: String line (transaction summary)
	 * output:
	 */
	public static void addLine(String line) {
		lines.add(line);	
	} //end addLine(line)
	
	/* convert all lines to one string for display
	 * 
	 * input: 
	 * output: 
	 */
	@Override
	public String toString() {
		String s = null;
		
		for (int i = 0; i < lines.size(); i++) {
			if (!lines.get(i).equals("")) {
				s += lines.get(i);
			}
		}
		return s;	
	} //End toString()

	// Delete line from lines array
	public static void deleteLine(String line) {
		lines.remove(line);
	} // end deleteLine
	
	// Writes lines to transaction summary file
	public static void writeFile(String directory) {
		PrintWriter transactionSummaryFile = null;
		String fileName = directory + "/txnsum.txt";
		boolean success = true;
		
		try {
			transactionSummaryFile = new PrintWriter(fileName);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file '" + fileName + "'.");
			success = false;
		}
		
		if (success) {
			for (int i = 0; i < lines.size(); i++) {
				if (lines.get(i) != null) {
					transactionSummaryFile.println(lines.get(i));
				}
			}
			transactionSummaryFile.println("EOS 0000 0 0000 **** 0");
			transactionSummaryFile.close();
		}
	} //end writeFile(fileName)
}
