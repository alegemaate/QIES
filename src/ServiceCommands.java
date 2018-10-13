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
	 * Prompts user for new service number
	 * Ensures valid service number
	 * Ensures unique service number
	 * Calls Services.add with the unique service number
	 */
	public static void createService() {
		String userInput = ScannerWrapper.getInput("Enter a new service number: ");
		int serviceNumber = Integer.parseInt(userInput);
		
		
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
