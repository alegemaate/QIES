/*
 * ServiceTemporary
 * A temporary service
 * Spice Tests
 * 02/11/2018
 */
package backoffice;

public class ServiceTemporary {
	// Attributes
	public String number;
	public int capacity;
	public int numberSold;
	public String name;
	public String date;
	
	// Constructor
	public ServiceTemporary(String number, int capacity, int numberSold, String name, String date) {
		this.number = number;
		this.capacity = capacity;
		this.numberSold = numberSold;
		this.name = name;
		this.date = date;
	}
}