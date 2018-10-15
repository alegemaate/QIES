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
	//static String[] lines = new String [] {"test1","test2","test3","test4","test5"};


	
	
	//Add line to lines array
	public static void addLine(String line) {
		lines.add(line);
	} // end addLine
	
	// Delete line from lines array
	public static void deleteLine(String line) {
		lines.remove(line);
	} // end deleteLine
	
	//convert all lines to one string for display
	@Override
	public String toString() {
		String s;
		return null;
		
	}
	
	//writes lines to transaction summary file
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

	}
	
	public static void main(String args[]) {
		
				
		
	}

}
