import java.util.ArrayList;

/*
 * Services class
 * Stores information for a service offered by the system in the ArrayList
 * Spice Tests
 * 13/10/2018
 */
public class Services {
	public static ArrayList<ServiceNumber> serviceList = new ArrayList<ServiceNumber>();
	
	/*
	 * Reads the input file and populates the list with valid services
	 */
	public void readServices() {
		// TODO
	} // end readServices method
	
	/*
	 * Adds service to the list of Services
	 */
	public static void add(int serviceNumber) {
		ServiceNumber serviceNum = new ServiceNumber(serviceNumber);
		serviceList.add(serviceNum);
	} // end add method
	
	/*
	 * Removes a service from the list of services
	 */
	public void remove(int serviceNumber) {
		serviceList.remove(serviceNumber);
	} // end remove method

} // end Services class
