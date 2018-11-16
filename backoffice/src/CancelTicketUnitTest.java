
public class CancelTicketUnitTest {
	public static void main(String[] args) {
		
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
			Service validService1 = new Service(11111, 1000, 2, "Gucci", new Date(2018, 11, 16));
			
			Services.cancelTicket(validService1, 1);
			
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
		
		// number sold greater than capacity check
		
		// input out of range exception throw number > capacity
		
		// set number sold attribute
		
		// return number sold
		
		//set message (input out of range exception)
		
	}
}
