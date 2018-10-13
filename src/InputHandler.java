/*
 * InputHandler
 * Main loop of program. 
 * Directs CLI commands to the handlers
 * Spice Tests
 * 13/10/2018
 */
import java.util.Scanner;

public class InputHandler {
    // Prompts user input and directs commands
	public void runQIES() {
		while (true) {
			// Get input
			String input = promptUser();
			
			// Direct commands
			switch (input) {
				case "command":
					System.out.println("Hey");
				default:
					System.out.println(input + " is not a valid command.");
			}
		}
	}
	
	// Ask for input
	public String promptUser() {
		// Scanner for user input
	    Scanner scan = new Scanner(System.in);
		
		// Ask for input
		System.out.println("Enter Command");
		String userResponse = scan.nextLine();
		
		// CLose scanner
		scan.close();
		
		// TODO: Filter out invalid inputs
		
		// Return filtered response
		return userResponse;
	}
}
