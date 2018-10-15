import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Log
 * Stores data for transaction summary file
 * Spice Tests
 * 13/10/2018
 */

public class Log {
	
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
			if (lines.get(i) != null) {
				s += lines.get(i);
			}
		}
		System.out.println("ok");
		return s;	
	} //End toString()
	
	/* writes lines to transaction summary file
	 * 
	 * input: name of transaction summary file
	 * output: 
	 */
	
	public static void writeFile(String fileName) {
		PrintWriter transactionSummaryFile = null;
		
		try {
			transactionSummaryFile = new PrintWriter(fileName);
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
			System.exit(0);

		}
		
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i) != null) {
				transactionSummaryFile.println(lines.get(i));
			}
		}
		
		transactionSummaryFile.close();

	} //end writeFile(fileName)
	
	

}
