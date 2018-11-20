
public class CancelTicketUnitTest {
	public static void main(String[] args) {
		
		//----------------------------------------------------------------------------------------------
		// TEST 1
		// Covers:	ticket num < 0 check
		//			set message (input out of range exception)
		try {
			Service validService = new Service(11111, 1000, 2, "Gucci", new Date(2018, 11, 16));
			
			Services.cancelTicket(validService, -1);
			
		} catch (InputOutOfRangeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidServiceNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// TEST 2:
		// Covers:	null service check
		// 			null pointer exception throw
		Service nullService = null;
		
		try {
			Services.cancelTicket(nullService, 1);
		} catch (InputOutOfRangeException e) {
			// TODO Auto-generated catch block
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
			
		} catch (InputOutOfRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidServiceNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// TEST 4
		// Covers:	number sold < 0 check
		//			input out of range execption throw number < 0
		try {
			
			Service validService = new Service(11111, 1000, 2, "Gucci", new Date(2018, 11, 16));
			
			Services.cancelTicket(validService, 3);
			
		} catch (InputOutOfRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidServiceNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// number sold greater than capacity check
		// input out of range exception throw number > capacity
		// unreachable code
		
	} // end main method
	
} // end CancelTicketUnitTest class
