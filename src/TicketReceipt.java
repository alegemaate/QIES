/*
 * TicketReceipt
 * Tracks tickets sold
 * Spice Tests
 * 13/10/2018
 */

public class TicketReceipt {
	
	int serviceNumber;
	int numSold;
	
<<<<<<< HEAD
	// constructor for the TicketReceipt object
	public TicketReceipt(int serviceNumber, int numSold) {
=======
	/*
	 * TicketReceipt constructor.
	 * 
	 * Parameters: int for service number, int for number of tickets sold for 
	 * 			   that service
	 */
	public void TicketReceipt(int serviceNumber, int numSold) {
>>>>>>> 243b33db703cf30e0d9c1d15abbae1b9fc6745a9
		setServiceNum(serviceNumber);
		setNumSold(numSold);
	} // end TicketReceipt constructor
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETSERVICENUM: Sets the service number.
	 * 
	 * Input: int representing service number
	 * Output: none
	 */
	public void setServiceNum(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	} // end setServiceNum method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETNUMSOLD: Sets the number of tickets sold.
	 * 
	 * Input: int representing number of tickets sold
	 * Output: none
	 */
	public void setNumSold(int numSold) {
		this.numSold = numSold;
	} // end setNumSold method
	
	//---------------------------------------------------------------------------------------------

	/* GETSERVICENUM: Retrieves service number.
	 * 
	 * Input: none
	 * Output: service number as int
	 */
	public int getServiceNum() {
		return serviceNumber;
	} // end getServiceNum method
	
	//---------------------------------------------------------------------------------------------
	
	/* GETNUMSOLD: Retrieve number of tickets sold.
	 * 
	 * Input: none
	 * Output: number of tickets sold as int
	 */
	public int getNumSold() {
		return numSold;
	} // end getNumSold method

}
