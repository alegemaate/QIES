import java.util.Scanner;

/*
 * ServiceCommands
 * 
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
		
		System.out.println("Enter Command");
		String userResponse = scan.next();
		userResponse = userResponse.trim();
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
