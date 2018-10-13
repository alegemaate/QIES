/*
 * ScannerWrapper
 * Reusable code for user input
 * Spice Tests
 * 13/10/2018
 */
import java.util.Scanner;

public class ScannerWrapper {
	// Scanner for user input
    public static Scanner scan = new Scanner(System.in);
	
    /*
     * Ask the user for input with no prompt
     * Return the user's input
     */
    public static String getInput() {
    		return getInput("");
    }
    
    /*
     * Ask the user for input with a prompt
     * Return the user's input
     */
    public static String getInput(String prompt) {
    	if (!prompt.isEmpty())
    		System.out.println(prompt);	
    		String userResponse = scan.next();
		return userResponse.trim();
    }
    
    // Close scanner
    public static void close() {
    		scan.close();
    }
}
