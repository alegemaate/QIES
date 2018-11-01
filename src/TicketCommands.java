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
	public static ArrayList<TicketReceipt> ticketreceipts = new ArrayList<>();
	
	/*
	 * asks the user for a service number and number of tickets
	 * checks if both are valid
	 * 
	 * returns -1 if errors occur, return 0 if the transaction was successful
	 */
	public static int sellTicket() {
		// Ensure logged in
		if (!CredentialCommands.loggedIn) {
			System.out.println("Error: You are not logged in.");
			return 0;
		} // end if
		
		// prompt the user for a service number
		int serviceNumber = 0;
		while (true) {
			serviceNumber = ScannerWrapper.getInputInt("Enter service number: ");
			if (serviceNumber < 10000 || serviceNumber > 99999) {
				System.out.println("Service number out of range");
				continue;
			}
			if (Services.find(serviceNumber) == false) {
				System.out.println("Error: Service number does not exist");
				continue;
			}
			break;
		} // end while
		
		// prompt the user for a number of tickets
		// Ensure that the number of tickets is valid
		// NOTE: ticket constraints may need to be added
		// TODO: add ticket constraints if any apply here
		int numTickets = 0;
		while (true) {
			numTickets = ScannerWrapper.getInputInt("Enter number of tickets: ");
			if (numTickets < 1 || numTickets > 1000) {
				System.out.println("Invalid");
				continue;
			}
			break;
		} // end while
		
		// generating the ticket receipt for the transaction
		TicketReceipt receipt = new TicketReceipt(serviceNumber, numTickets, "SEL");
		
		// adding the generated ticket receipt to the ticketreceipts array
		ticketreceipts.add(receipt);
		
		// adding the ticket transaction to the log
		Log.addLine("SEL " + serviceNumber + " " + numTickets + " 00000 **** 0");
		
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
		// Ensure logged in
		if (!CredentialCommands.loggedIn) {
			System.out.println("Error: You are not logged in.");
			return 0;
		} // end if
		
		// Ensure have not cancelled over max amount
		if (ticketsProcessedSession("CAN") >= 20 && CredentialCommands.userType.equals("agent")) {
			System.out.println("Error: Max number tickets sold in this session");
			return 0;
		}
		
		// prompt the user for a service number
		int serviceNumber = 0;
		
		// Ensure that service number exists
		while (true) { 
			serviceNumber = ScannerWrapper.getInputInt("Enter service number: ");
			if (Services.find(serviceNumber) == false) {
				System.out.println("Error: Service number does not exist");
				continue;
			}
			if (ticketsProcessedService(serviceNumber, "CAN") >= 10 && CredentialCommands.userType.equals("agent")) {
				System.out.println("Error: Max number tickets sold for this service");
				return 0;
			}
			break;
		} // end while

		// prompt the user for a number of tickets
		int numTickets = 0;
		while (true) {
			numTickets = ScannerWrapper.getInputInt("Enter number of tickets: ");
			if (numTickets + ticketsProcessedSession("CAN") > 20 && CredentialCommands.userType.equals("agent")) {
				System.out.println("Error: Ticket count above max allowed for this session");
				continue;
			}
			if (numTickets + ticketsProcessedService(serviceNumber, "CAN") > 10 && CredentialCommands.userType.equals("agent")) {
				System.out.println("Error: Too many tickets sold for this service");
				continue;
			}
			if (numTickets < 1 || numTickets > 1000) {
				System.out.println("Error: Invalid ticket number");
				continue;
			}
			break;
		} // end while
		
		// generating the ticket receipt for the transaction
		TicketReceipt receipt = new TicketReceipt(serviceNumber, numTickets, "CAN");
		
		// adding the generated ticket receipt to the ticketreceipts array
		ticketreceipts.add(receipt);
		
		// adding the ticket transaction to the log
		Log.addLine("CAN " + serviceNumber + " " + numTickets + " 00000 **** 0");
		
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
		// Ensure logged in
		if (!CredentialCommands.loggedIn) {
			System.out.println("Error: You are not logged in.");
			return 0;
		} // end if
		
		// Ensure have not changed over max amount
		if (ticketsProcessedSession("CHG") >= 20 && CredentialCommands.userType.equals("agent")) {
			System.out.println("Error: Max number tickets changed in this session");
			return 0;
		}
		
		// prompt the user for a source service number
		int sourceServiceNumber = 0;
		while (true) { 
			sourceServiceNumber = ScannerWrapper.getInputInt("Enter a source service number: ");
			if (!ServiceCommands.validateServiceNum(sourceServiceNumber)) {
				continue;
			}
			// Ensure that service number doesn't already exist
			if (!Services.find(sourceServiceNumber)) { 
				System.out.println("Service number does not exist.");
				continue;
			} // end if
			break;
		} // end while
		
		// prompt the user for a source service number
		int destServiceNumber = 0;
		while (true) { 
			destServiceNumber = ScannerWrapper.getInputInt("Enter a destination service number: ");
			if (!ServiceCommands.validateServiceNum(destServiceNumber)) {
				continue;
			}
			// Ensure that service number doesn't already exist
			if (!Services.find(destServiceNumber)) { 
				System.out.println("Service number does not exist.");
				continue;
			} // end if
			break;
		} // end while
		
		// prompt the user for a number of tickets
		int numTickets = 0;
		
		// Ensure that the number of tickets is valid
		// NOTE: ticket constraints may need to be added
		// TODO: add ticket constraints if any apply here
		while (true) {
			numTickets = ScannerWrapper.getInputInt("Enter number of tickets: ");
			if (numTickets < 1 || numTickets > 1000 || (numTickets + ticketsProcessedSession("CHG") > 20 && CredentialCommands.userType.equals("agent"))) {
				System.out.println("Error: Invalid Number");
				continue;
			}
			break;
		} // end while

		// generating the ticket receipt for the transaction
		TicketReceipt receipt = new TicketReceipt(sourceServiceNumber, numTickets, "CHG");
		
		// adding the generated ticket receipt to the ticketReceipts array
		ticketreceipts.add(receipt);
		
		// adding the ticket transaction to the log
		Log.addLine("CHG " + sourceServiceNumber + " " + numTickets + " " + destServiceNumber + " **** 0");
		
		return 0;
	} // end changeTicket method
	
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * TICKETSSOLDSESSION counts tickets sold for service
	 * 
	 * Input: none
	 * Output: number tickets sold this session
	 */
	private static int ticketsProcessedSession(String txnType) {
		int num = 0;
		for (int i = 0; i < ticketreceipts.size(); i++) {
			if (ticketreceipts.get(i).getTxnType() == txnType) {
				num += ticketreceipts.get(i).getNumSold();
			}
		}
		return num;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * TICKETSSOLDSERVICE counts tickets sold for service
	 * 
	 * Input: serviceNum
	 * Output: number tickets sold for this service
	 */
	private static int ticketsProcessedService(int serviceNum, String txnType) {
		int num = 0;
		for (int i = 0; i < ticketreceipts.size(); i++) {
			if (ticketreceipts.get(i).getServiceNum() == serviceNum && ticketreceipts.get(i).getTxnType() == txnType) {
				num += ticketreceipts.get(i).getNumSold();
			}
		}
		return num;
	}

} // end TicketCommands class
