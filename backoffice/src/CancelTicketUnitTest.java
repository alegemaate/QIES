
public class CancelTicketUnitTest {
	public static void main(String[] args) {
		
		//----------------------------------------------------------------------------------------------
		// TEST 1
		// Covers:	ticket num < 0 check
		//			set message (input out of range exception)
		try {
			Service validService = new Service(11111, 1000, 2, "Gucci", new Date(2018, 11, 16));
			
			Services.cancelTicket(validService, -1);
			
			System.out.println("Test 1: Success");
			
		} catch (InputOutOfRangeException e1) {
			System.out.println("Test 1: Error: InputOutOfRangeException");
			e1.printStackTrace();
		} catch (InvalidServiceNameException e1) {
			System.out.println("Test 1: Error: InvalidServiceNameException");
			e1.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// TEST 2:
		// Covers:	null service check
		// 			null pointer exception throw
		Service nullService = null;
		
		try {
			Services.cancelTicket(nullService, 1);
			
			System.out.println("Test 2: Success");
			
		} catch (InputOutOfRangeException e) {
			System.out.println("Test 2: Error: InputOutOfRangeException");
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// TEST 3
		// Covers:	cancel ticket operation
		//			set number sold attribute
		//			return number sold
		try {
			Service validService = new Service(11111, 1000, 2, "Gucci", new Date(2018, 11, 16));
			
			Services.cancelTicket(validService, 1);
			
			System.out.println("Test 3: Success");
			
		} catch (InputOutOfRangeException e) {
			System.out.println("Test 3: Error: InputOutOfRangeExceptionn");
			e.printStackTrace();
		} catch (InvalidServiceNameException e) {
			System.out.println("Test 3: Error: InvalidServiceNameException");
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// TEST 4
		// Covers:	number sold < 0 check
		//			input out of range execption throw number < 0
		try {
			
			Service validService = new Service(11111, 1000, 2, "Gucci", new Date(2018, 11, 16));
			
			Services.cancelTicket(validService, 3);
			
			System.out.println("Test 4: Success");
			
		} catch (InputOutOfRangeException e) {
			System.out.println("Test 4: Error: InputOutOfRangeException");
			e.printStackTrace();
		} catch (InvalidServiceNameException e) {
			System.out.println("Test 4: Error: InvalidServiceNameException");
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// number sold greater than capacity check
		// input out of range exception throw number > capacity
		// unreachable code
		
	} // end main method
	
} // end CancelTicketUnitTest class
