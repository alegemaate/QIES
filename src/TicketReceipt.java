/*
 * TicketReceipt
 * Tracks tickets sold
 * Spice Tests
 * 13/10/2018
 */

public class TicketReceipt {
	
	int serviceNumber;
	int numSold;
	
	// constructor for the TicketReceipt object
	public void TicketReceipt(int serviceNumber, int numSold) {
		setServiceNum(serviceNumber);
		setNumSold(numSold);
	}
	
	// sets the serviceNumber attribute
	public void setServiceNum(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	
	// sets the numSold attribute
	public void setNumSold(int numSold) {
		this.numSold = numSold;
	}

	//retrieve service number
	public int getServiceNum() {
		return serviceNumber;
	}
	
	//retrieve number of tickets sold
	public int getNumSold() {
		return numSold;
	}	

}
