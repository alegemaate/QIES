import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Services class
 * Stores information for a service offered by the system in the ArrayList
 * Spice Tests
 * 13/10/2018
 */
public class Services {
	private static ArrayList<ServiceNumber> serviceList = new ArrayList<ServiceNumber>();
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Reads the input file and populates the list with valid services.
	 * 
	 * Input: String containing file path
	 * Output: none
	 */
	public static void readServices(String filePath) {
		Scanner readLine;
		try {
			// Add services from file to list
			readLine = new Scanner(new File(filePath));
			while (readLine.hasNext()){
				String line = readLine.next();
				int nextServiceNum = Integer.parseInt(line);
			    add(nextServiceNum);
			} // end while
			readLine.close();
			
		// File not found
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} // end try/catch
		
	} // end readServices method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Adds service to the list of Services
	 * 
	 * Input: int representing service number
	 * Output: none
	 */
	public static void add(int serviceNumber) {
		ServiceNumber serviceNum = new ServiceNumber(serviceNumber);
		serviceList.add(serviceNum);
	} // end add method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Removes a service from the list of services
	 * 
	 * Input: int representing service number
	 * Output: none
	 */
	public static void remove(int serviceNumber) {
		ServiceNumber serviceNum = new ServiceNumber(serviceNumber);
		serviceList.remove(serviceNum);
	} // end remove method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Finds a service in a list of services
	 * 
	 * Input: int representing service number
	 * Output: true or false if exists
	 */
	public static boolean find(int serviceNumber) {
		for (int i = 0; i < serviceList.size(); i++) {
			if (serviceList.get(i).getNumber() == serviceNumber) {
				return true;
			}
		}
		return false;
	} // end find method


} // end Services class
