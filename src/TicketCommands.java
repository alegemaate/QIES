/*
 * TicketCommands
 * Completes ticket transactions including sellTicket, cancelTicket, and
 * 		changeTicket. Also holds the list of ticketReciepts as a record of
 * 		completed ticketTransactions.
 * Spice Tests
 * 13/10/2018
 */

import java.util.*;

public class TicketCommands {
	
	public static ArrayList<TicketReceipt> ticketReciepts = new ArrayList<>();
	
	/*
	 * asks the user for a service number and number of tickets
	 * checks if both are valid
	 * 
	 * returns -1 if errors occur, return 0 if the transaction was successful
	 */
	public static int sellTicket() {
		
		// prompt the user for a service number
		String serviceNumString = ScannerWrapper.getInput("Enter a new service number: ");
		int serviceNumber = Integer.parseInt(serviceNumString);
		
		// Ensure that service number exists
		if (Services.find(serviceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			return -1;
		} // end if
		
		// prompt the user for a number of tickets
		String numTicketsString = ScannerWrapper.getInput("Enter desired service number: ");
		int numTickets = Integer.parseInt(numTicketsString);
		
		// Ensure that the number of tickets is valid
		// NOTE: ticket constraints may need to be added
		// TODO: add ticket constraints if any apply here
		if (!(numTickets >= 0)) {
			System.out.println("Error: Invalid ticket number");
		}
		
		// generating the ticket reciept for the transaction
		TicketReceipt reciept = new TicketReceipt(serviceNumber, numTickets);
		
		// adding the generated ticket reciept to the ticketReciepts array
		ticketReciepts.add(reciept);
		
		// adding the ticket transaction to the log
		Log.addLine("SEL " + serviceNumString + " " + numTicketsString + " 0 **** 0");
		
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
		String serviceNumString = ScannerWrapper.getInput("Enter desired service number: ");
		int serviceNumber = Integer.parseInt(serviceNumString);
		
		// Ensure that service number exists
		if (Services.find(serviceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			return -1;
		} // end if

		// prompt the user for a number of tickets
		String numTicketsString = ScannerWrapper.getInput("Enter a new service number: ");
		int numTickets = Integer.parseInt(numTicketsString);
		
		// Ensure that the number of tickets is valid
		// NOTE: ticket constraints may need to be added
		// TODO: add ticket constraints if any apply here
		if (!(numTickets >= 0)) {
			System.out.println("Error: Invalid ticket number");
			return -1;
		}

		// generating the ticket reciept for the transaction
		TicketReceipt reciept = new TicketReceipt(serviceNumber, numTickets);
		
		// adding the generated ticket reciept to the ticketReciepts array
		ticketReciepts.add(reciept);
		
		// adding the ticket transaction to the log
		Log.addLine("CAN " + serviceNumString + " " + numTicketsString + " 0 **** 0");
		
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
		if (Services.find(sourceServiceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			return -1;
		} // end if

		// prompt the user for a destination service number
		String destServiceNumString = ScannerWrapper.getInput("Enter a destination service number: ");
		int destServiceNumber = Integer.parseInt(destServiceNumString);
		
		// Ensure that destination service number exists
		if (Services.find(destServiceNumber) == false) { 
			System.out.println("Error: Service number does not exist");
			return -1;
		} // end if
		

		// prompt the user for a number of tickets
		String numTicketsString = ScannerWrapper.getInput("Enter a new service number: ");
		int numTickets = Integer.parseInt(numTicketsString);
		
		// Ensure that the number of tickets is valid
		// NOTE: ticket constraints may need to be added
		// TODO: add ticket constraints if any apply here
		if (!(numTickets >= 0)) {
			System.out.println("Error: Invalid ticket number");
			return -1;
		}

		// generating the ticket reciept for the transaction
		TicketReceipt reciept = new TicketReceipt(sourceServiceNumber, numTickets);
		
		// adding the generated ticket reciept to the ticketReciepts array
		ticketReciepts.add(reciept);
		
		// adding the ticket transaction to the log
		Log.addLine("CHG " + sourceServiceNumString + " " + numTicketsString + " " + destServiceNumString + " **** 0");
		
		return 0;
	} // end changeTicket method

} // end TicketCommands class
