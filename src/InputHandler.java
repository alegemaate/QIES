/*
 * InputHandler
 * Main loop of program. 
 * Directs CLI commands to the handlers
 * Spice Tests
 * 13/10/2018
 */
import java.util.Scanner;

public class InputHandler {
	// Scanner for user input
    public static Scanner scan = new Scanner(System.in);
	
    // Prompts user input and directs commands
	public void runQIES() {
		String input = "";
		
		while (input != "exit") {
			// Get input
			input = promptUser();
			
			// Direct commands
			switch (input) {
				case "command":
					
					break;
				default:
					System.out.println(input + " is not a valid command.");
					break;
			}
		}
		
		// CLose scanner
		scan.close();
	}
	
	// Ask for input
	public String promptUser() {
		// Ask for input
		System.out.println("Enter Command");
		String userResponse = scan.next();
		
		// Filter out invalid inputs
		userResponse = userResponse.trim();
		
		// Return filtered response
		return userResponse;
	}
}
