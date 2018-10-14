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
			return -1;
		} // end if
		
		// Prompt user for new service number
		String serviceNumString = ScannerWrapper.getInput("Enter a new service number: ");
		// Ensures valid service number
		int serviceNumber = validateServiceNum(serviceNumString);
		Services.add(serviceNumber);
		
		// Prompt user for new service name
		String serviceName = ScannerWrapper.getInput("Enter a new service name: ");
		serviceName = validateServiceName(serviceName);
		return 0;
	} // end createService method
	
	/*
	 * Prompts user for existing service number
	 * Ensures existing service number
     * Calls Services.remove with the unique service number
	 */
	public static void deleteService() {
		// TODO
	} // end deleteService method
	
	private static int validateServiceNum(String serviceNum) {
		// Ensures valid service number
		// Service number must be exactly 5 characters
		while (serviceNum.length() != 5) {
			System.out.println("Invalid input: service number must be exactly 5 characters.");
			serviceNum = ScannerWrapper.getInput("Enter a new service number: ");
		} // end if
		// Service number cannot start with 0
		while (serviceNum.charAt(0) == '0') {
			System.out.println("Invalid input: service number cannot begin with 0.");
			serviceNum = ScannerWrapper.getInput("Enter a new service number: ");
		} // end if
		
		// TODO: Verify that service number doesn't already exist in ArrayList
		
		int serviceNumber = Integer.parseInt(serviceNum);
		return serviceNumber;
	} // send validateServiceNum method
	
	private static String validateServiceName(String serviceName) {
		//Ensures valid service name
		// Service name 
		// TODO
		return null;
	}
	
} // end ServiceCommands class
