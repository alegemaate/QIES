/*
 * QIES entry point
 * Program starts here
 * Spice Tests
 * 13/10/2018
 */
public class QIESBase {
	// Input handler
	public static InputHandler input = new InputHandler();
	
	public static int main(String [] args) {
		// Ensure we are receiving a input file and a directory for output
		if (args.length != 3) {
			System.out.println("You must provide a valid input file and a directory to output the transaction summary file.");
			return -1;
		}
		
		// Validate files here
		
		
		// Go to main case switch
		input.runQIES();
		
		// Exit
		return 0;
	}
}
