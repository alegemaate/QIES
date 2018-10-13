import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * Log
 * Stores data for transaction summary file
 * Spice Tests
 * 13/10/2018
 */

public class Log {
	
	String[] lines;
	
	
	//Add line to lines array
	public void addLine(String line) {
		
	}
	
	//convert all lines to one string for display
	@Override
	public String toString() {
		return null;
		
	}
	
	//writes lines to transaction summary file
	public boolean writeFile(String fileName) {
		PrintWriter TransactionSummaryFile = null;
		
		try {
			TransactionSummaryFile = new PrintWriter(fileName);
			return true;
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
			System.exit(0);

		}
		
		TransactionSummaryFile.close();
		return false;

	}

}
