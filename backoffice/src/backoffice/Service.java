/*
 * Service
 * A single service
 * Spice Tests
 * 02/11/2018
 */
package backoffice;

public class Service {
	// Attributes
	private int number;
	private int capacity;
	private int numberSold;
	private String name;
	private Date date;
	
	// Constructor
	public Service(int number, int capacity, int numberSold, String name, Date date) 
			throws InputOutOfRangeException, InvalidServiceNameException {
		setNumber(number);
		setCapacity(capacity);
		setNumberSold(numberSold);
		setName(name);
		setDate(date);
	} // end Service constructor
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETNUMBER: Returns service number.
	 * 
	 * Input: none
	 * Output: service number as int
	 */
	public int getNumber() {
		return number;
	} 
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETCAPACITY: Returns service capacity.
	 * 
	 * Input: none
	 * Output: service capacity as int
	 */
	public int getCapacity() {
		return capacity;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETNUMBERSOLD: Returns number of tickets sold for service.
	 * 
	 * Input: none
	 * Output: number tickets sold as int
	 */
	public int getNumberSold() {
		return numberSold;
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETNAME: Returns service name.
	 * 
	 * Input: none
	 * Output: service name as String
	 */
	public String getName() {
		return name;
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETNUMBERSOLD: Returns service date.
	 * 
	 * Input: none
	 * Output: service date as Date
	 */
	public Date getDate() {
		return date;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETNUMBER: Checks service number and if valid, sets service
	 * 
	 * Input: service number
	 * Output: none
	 * Throws: InputOutOfRangeException
	 */
	private void setNumber(int number) throws InputOutOfRangeException {
		if (number < 10000) {
			throw new InputOutOfRangeException("Error: Service number must be above 9999.");
		}
		if (number > 99999) {
			throw new InputOutOfRangeException("Error: Service number must be below 100000.");
		}
		this.number = number;
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETCAPACITY: Checks service capacity and if valid, sets capacity
	 * 
	 * Input: service capacity
	 * Output: none
	 * Throws: InputOutOfRangeException
	 */
	private void setCapacity(int capacity) throws InputOutOfRangeException {
		if (capacity < 1) {
			throw new InputOutOfRangeException("Error: Capacity must be above 0.");
		}
		if (capacity > 1000) {
			throw new InputOutOfRangeException("Error: Capacity must be 1000 or below.");
		}
		this.capacity = capacity;
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETNUMBERSOLD: Validates and then sets number tickets sold
	 * 
	 * Input: number tickets sold
	 * Output: none
	 * Throws: InputOutOfRangeException
	 */
	private void setNumberSold(int numberSold) throws InputOutOfRangeException {
		if (numberSold < 0) {
			throw new InputOutOfRangeException("Error: Number of tickets sold can not be below 0.");
		}
		if (numberSold > this.capacity) {
			throw new InputOutOfRangeException("Error: Number of tickets sold must be under capacity.");
		}
		this.numberSold = numberSold;
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETNAME: Validates and then sets name of service
	 * 
	 * Input: service name
	 * Output: none
	 * Throws: InvalidServiceNameException
	 */
	private void setName(String name) throws InvalidServiceNameException {
		// Cannot start or end with spaces
		if (name.trim().length() != name.length()) {
			throw new InvalidServiceNameException("Service name cannot start or end with whitespace.");
		}
		
		// Cannot be less than 3 characters
		if (name.length() < 3) {
			throw new InvalidServiceNameException("Service name must be at least 3 characters.");
		}
		
		// Cannot be greater than 39 characters
		if (name.length() > 39) {
			throw new InvalidServiceNameException("Service name can not be greater than 39 characters.");
		}
		
		// Cannot contain anything but letters and '
		if (!name.matches("[a-zA-Z']+")) {
			throw new InvalidServiceNameException("Service name can not contain characters other than alpha and '.");
		}
		
		this.name = name;
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETNUMBERSOLD: Sets service date
	 *   Already validated when date object created
	 *   No need to validate here
	 * Input: service date
	 * Output: none
	 */ 
	private void setDate(Date date) {
		this.date = date;
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * TOSTRING: Returns the service as a string formatted for CSF.
	 * 
	 * Input: none
	 * Output: service as String
	 */
	@Override
	public String toString() {
		return "" + number + " "
				  + capacity + " " 
				  + numberSold + " " 
				  + name + " "
				  + date.toString();
	} // end toString method
}
