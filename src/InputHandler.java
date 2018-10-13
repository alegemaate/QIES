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
		
		// CLose scanner
		ScannerWrapper.close();
	}
	
	// Ask for input
	public String promptUser() {
		// Return filtered response
		return ScannerWrapper.getInput("Enter Command");
	}
}
