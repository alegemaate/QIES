/*
 * TicketReceipt
 * Tracks tickets sold
 * Spice Tests
 * 13/10/2018
 */

public class TicketReceipt {
	
	private int serviceNumber;
	private int quantity;
	private String transaction;
	
	/*
	 * TicketReceipt constructor.
	 * 
	 * Parameters: int for service number, int for quantity of tickets for 
	 * 			   that transaction
	 */
	public TicketReceipt(int serviceNumber, int quantity, String transaction) {
		this.serviceNumber = serviceNumber;
		this.quantity = quantity;
		this.transaction = transaction;
	} // end TicketReceipt constructor
	
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
	
	/* GETNUMSOLD: Retrieve number of tickets processed.
	 * 
	 * Input: none
	 * Output: number of tickets sold as int
	 */
	public int getNumSold() {
		return quantity;
	} // end getNumSold method
	
	//---------------------------------------------------------------------------------------------
	
	/* GETTXNTYPE: Retrieve transaction type.
	 * 
	 * Input: none
	 * Output: number of tickets sold as int
	 */
	public String getTxnType() {
		return transaction;
	} // end getNumSold method

}
