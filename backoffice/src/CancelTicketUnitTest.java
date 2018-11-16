
public class CancelTicketUnitTest {
	public static void main(String[] args) {
		
		// NOTE: some of these may need to be combined into just one test where we mention which blocks
		//		the text executes (only need to do this for repeated tests)
		
		//ticket num < 0 check
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
		// null service check
		// null pointer exception throw
		Service nullService = null;
		
		try {
			Services.cancelTicket(nullService, 1);
		} catch (InputOutOfRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------------------------------------
		// cancel ticket operation
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
		// number sold < 0 check
		// input out of range execption throw number < 0
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
		
		//----------------------------------------------------------------------------------------------
		// set number sold attribute
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
		// return number sold
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
		//set message (input out of range exception)
		try {
			
			Service validService = new Service(11111, 1000, 2, "Gucci", new Date(2018, 11, 16));
			
			Services.cancelTicket(validService, -1);
			
		} catch (InputOutOfRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidServiceNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
