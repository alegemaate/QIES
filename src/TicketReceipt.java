/*
 * TicketReceipt
 * Tracks tickets sold
 * Spice Tests
 * 13/10/2018
 */

public class TicketReceipt {
	
	private int serviceNumber;
	private int quantity;
	
	/*
	 * TicketReceipt constructor.
	 * 
	 * Parameters: int for service number, int for quantity of tickets for 
	 * 			   that transaction
	 */
	public TicketReceipt(int serviceNumber, int quantity) {
		setServiceNum(serviceNumber);
		setNumSold(quantity);
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
	public void setNumSold(int quantity) {
		this.quantity = quantity;
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
		return quantity;
	} // end getNumSold method

}
