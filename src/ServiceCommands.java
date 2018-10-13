import java.util.Scanner;

/*
 * ServiceCommands
 * Validation for Services list
 * Spice Tests
 * 13/10/2018
 */
public class ServiceCommands {

	public static Scanner scan = new Scanner(System.in);
	
	/*
	 * Prompts user for new service number/name/date
	 * Ensures valid service number/name/date
	 * Ensures unique service number/name/date
	 * Calls Services.add with the unique service number
	 * Adds new service to Log
	 */
	public static int createService() {
		
		// Creating a service is only a planner operation
		if (CredentialCommands.userType.equals("agent")) {
			System.out.println("Cannot create a service during agent session.");
			return 0;
		} // end if
		
		// Prompt user for new service number
		String serviceNumString = ScannerWrapper.getInput("Enter a new service number: ");
		
		// Ensures valid service number
		while (serviceNumString.length() != 5) {
			System.out.println("Invalid input: service number must be exactly 5 characters.");
			serviceNumString = ScannerWrapper.getInput("Enter a new service number: ");
		} // end if
		while (serviceNumString.charAt(0) == '0') {
			System.out.println("Invalid input: service number cannot begin with 0.");
			serviceNumString = ScannerWrapper.getInput("Enter a new service number: ");
		} // end if
		
		// Once valid, make serviceNumber into an int
		int serviceNumber = Integer.parseInt(serviceNumString);
		// TODO
	} // end createService method
	
	/*
	 * Prompts user for existing service number
	 * Ensures existing service number
     * Calls Services.remove with the unique service number
	 */
	public static void deleteService() {
		// TODO
	} // end deleteService method
	
} // end ServiceCommands class
