/*
 * InputHandler
 * Main loop of program. 
 * Directs CLI commands to the handlers
 * Spice Tests
 * 13/10/2018
 */


public class InputHandler {
    // Prompts user input and directs commands
	public void runQIES() {
		String input = "";
		
		while (input != "exit") {
			// Get input
			input = promptUser();
			
			// Direct commands
			switch (input) {
				case "login":
					CredentialCommands.login();
					break;
				case "logout":
					CredentialCommands.logout();
					break;
				case "createservice":
					ServiceCommands.createService();
					break;
				case "deleteservice":
					ServiceCommands.deleteService();
					break;
				case "sellticket":
					TicketCommands.sellTicket();
					break;
				case "cancelticket":
					TicketCommands.cancelTicket();
					break;
				case "changeticket":
					TicketCommands.changeTicket();
					break;
				case "exit":
					System.out.println("Force exiting...");
					break;
				default:
					System.out.println(input + " is not a valid command.");
					break;
			}
		}
		
		// Close scanner
		ScannerWrapper.close();
	}
	
	
	/*
	 * Prompts the user to enter a command and returns their input 
	 * 		(Used in the runQIES() method to get user input)
	 * 
	 * Input: none
	 * Output: String with user input
	 */
	public String promptUser() {
		// Return filtered response
		return ScannerWrapper.getInput("Enter Command");
	} // end promptUser method
	
} // end InputHandler class
