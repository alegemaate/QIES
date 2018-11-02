/*
 * Services
 * Stores all services loaded from central service file
 * Spice Tests
 * 02/11/2018
 */

package backoffice;

import java.util.ArrayList;

public class Services {
	private static ArrayList<Service> serviceList = new ArrayList<Service>();
	

	//---------------------------------------------------------------------------------------------
	
	/*
	 * ADDSERVICE: Adds service to list.
	 * 
	 * Input: New service to add
	 * Output: none
	 */
	public void addService(Service newService) {
		serviceList.add(newService);
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * GetVSFString: Returns list of service numbers
	 * 
	 * Input: none
	 * Output: String for output to VSF
	 */
	public String getVSFString(Service newService) {
		// Parse services and add numbers to serviceNumberStr
		String serviceNumberStr = "";
		for (Service ser : serviceList) {
			serviceNumberStr += ser.getNumber() + ",\n";
		}
		return serviceNumberStr;
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
		// Parse services and add to serviceListStr
		String serviceListStr = "";
		for (Service ser : serviceList) {
			serviceListStr += ser.toString() + "\n";
		}
		return serviceListStr;
	}
}
