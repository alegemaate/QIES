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
     * GETINPUT: Ask the user for input with no prompt.
     * 
     * Input: none
     * Output: user input
     */
    public static String getInput() {
    		return getInput("");
    } // end getInput method
    
    /*
     * GETINPUT: Ask the user for input with a prompt
     * 
     * Input: prompt for user input
     * Output: user input
     */
    public static String getInput(String prompt) {
    	if (!prompt.isEmpty())
    		System.out.println(prompt);	
    		String userResponse = scan.next();
		return userResponse.trim();
    } // end getInput method
    
    /*
     * CLOSE: Close scanner.
     * 
     * Input: none
     * Output: none
     */
    public static void close() {
    		scan.close();
    } // end close method
}
