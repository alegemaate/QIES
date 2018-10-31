/*
 * TicketCommands
 * Completes ticket transactions including sellTicket, cancelTicket, and
 * 		changeTicket. Also holds the list of ticketreceipts as a record of
 * 		completed ticketTransactions.
 * Spice Tests
 * 13/10/2018
 */

import java.util.*;

public class TicketCommands {
	
	public static int ticketsChanged = 0;
	public static int ticketsCancelled = 0;
	public static ArrayList<TicketReceipt> ticketreceipts = new ArrayList<>();
	
	/*
	 * asks the user for a service number and number of tickets
	 * checks if both are valid
	 * 
	 * returns -1 if errors occur, return 0 if the transaction was successful
	 */
	public static int sellTicket() {
		
		// prompt the user for a service number
		String serviceNumString = ScannerWrapper.getInput("Enter service number: ");
		int serviceNumber = Integer.parseInt(serviceNumString);
		
		// Ensure that service number exists
		while (Services.find(serviceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			serviceNumber = Integer.parseInt(ScannerWrapper.getInput("Enter service number: "));
		} // end while
		
		// prompt the user for a number of tickets
		String numTicketsString = ScannerWrapper.getInput("Enter number of tickets: ");
		int numTickets = Integer.parseInt(numTicketsString);
		
		// Ensure that the number of tickets is valid
		// NOTE: ticket constraints may need to be added
		// TODO: add ticket constraints if any apply here
		while (numTickets < 1) {
			System.out.println("Error: Invalid ticket number");
			numTickets = Integer.parseInt(ScannerWrapper.getInput("Enter number of tickets: "));
		} // end while
		
		// generating the ticket receipt for the transaction
		TicketReceipt receipt = new TicketReceipt(serviceNumber, numTickets);
		
		// adding the generated ticket receipt to the ticketreceipts array
		ticketreceipts.add(receipt);
		
		// adding the ticket transaction to the log
		numTicketsString = Integer.toString(numTickets);
		Log.addLine("SEL " + serviceNumString + " " + numTicketsString + " 00000 **** 0");
		
		return 0;
		
	} // end sellTicket method
	
	/*
	 * Asks the user for a service number and a number of tickets
	 * Checks if they are valid
	 * 
	 * Note: constraints in agent mode, no constraints in planner mode
	 * 
	 * returns -1 if errors occur, return 0 if the transaction was successful
	 */
	public static int cancelTicket() {
		
		// prompt the user for a service number
		String serviceNumString = ScannerWrapper.getInput("Enter service number: ");
		int serviceNumber = Integer.parseInt(serviceNumString);
		
		// Ensure that service number exists
		while (Services.find(serviceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			serviceNumber = Integer.parseInt(ScannerWrapper.getInput("Enter service number:"));
		} // end while

		// prompt the user for a number of tickets
		String numTicketsString = ScannerWrapper.getInput("Enter number of tickets: ");
		int numTickets = Integer.parseInt(numTicketsString);
		
		while (numTickets < 1 || (numTickets > 10 && CredentialCommands.userType.equals("agent"))) {
			System.out.println("Error: Invalid ticket number.");
			numTickets = Integer.parseInt(ScannerWrapper.getInput("Enter number of tickets: "));
		} // end while
		
		// Ensure that the number of tickets is valid
		// Agent cannot cancel more than 20 tickets per session
		if ((ticketsCancelled + numTickets) <= 20 || CredentialCommands.userType.equals("planner")) {
			// generating the ticket receipt for the transaction
			TicketReceipt receipt = new TicketReceipt(serviceNumber, numTickets);
			
			// adding the generated ticket receipt to the ticketreceipts array
			ticketreceipts.add(receipt);
			
			// adding the ticket transaction to the log
			numTicketsString = Integer.toString(numTickets);
			Log.addLine("CAN " + serviceNumString + " " + numTicketsString + " 00000 **** 0");
		} else {
			System.out.println("Cannot cancel more than 20 tickets per session as Agent.");
			return -1;
		} // end if/else
		
		return 0;
	} // end cancelTicket method
	
	/*
	 * Asks the user for the current service number, the new service
	 * 		number, and the number of tickets being changed
	 * Checks if they are valid
	 * 
	 * Note: constraints in agent mode, no constraints in planner mode
	 * 
	 * returns -1 if errors occur, return 0 if the transaction was successful
	 */
	public static int changeTicket() {

		// prompt the user for a source service number
		String sourceServiceNumString = ScannerWrapper.getInput("Enter a source service number: ");
		int sourceServiceNumber = Integer.parseInt(sourceServiceNumString);
		
		// Ensure that source service number exists
		while (Services.find(sourceServiceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			sourceServiceNumber = Integer.parseInt(ScannerWrapper.getInput("Enter a source service number: "));
		} // end while

		// prompt the user for a destination service number
		String destServiceNumString = ScannerWrapper.getInput("Enter a destination service number: ");
		int destServiceNumber = Integer.parseInt(destServiceNumString);
		
		// Ensure that destination service number exists
		while (Services.find(destServiceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			destServiceNumber = Integer.parseInt(ScannerWrapper.getInput("Enter a destination service number: "));
		} // end while
		
		// prompt the user for a number of tickets
		String numTicketsString = ScannerWrapper.getInput("Enter number of tickets: ");
		int numTickets = Integer.parseInt(numTicketsString);
		
		// Ensure that the number of tickets is valid
		// NOTE: ticket constraints may need to be added
		// TODO: add ticket constraints if any apply here
		while (numTickets < 1) {
			System.out.println("Error: Invalid ticket number");
			numTickets = Integer.parseInt(ScannerWrapper.getInput("Enter number of tickets: "));
		} // end while

		// generating the ticket receipt for the transaction
		TicketReceipt receipt = new TicketReceipt(sourceServiceNumber, numTickets);
		
		// adding the generated ticket receipt to the ticketReceipts array
		ticketreceipts.add(receipt);
		
		// adding the ticket transaction to the log
		numTicketsString = Integer.toString(numTickets);
		Log.addLine("CHG " + sourceServiceNumString + " " + numTicketsString + " " + destServiceNumString + " **** 0");
		
		return 0;
	} // end changeTicket method

} // end TicketCommands class
