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
	public static ArrayList<ServiceNumber> serviceList = new ArrayList<ServiceNumber>();
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Reads the input file and populates the list with valid services.
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end try/catch
		
	} // end readServices method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Adds service to the list of Services
	 */
	public static void add(int serviceNumber) {
		ServiceNumber serviceNum = new ServiceNumber(serviceNumber);
		serviceList.add(serviceNum);
	} // end add method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Removes a service from the list of services
	 */
	public static void remove(int serviceNumber) {
		ServiceNumber serviceNum = new ServiceNumber(serviceNumber);
		serviceList.remove(serviceNumber);
	} // end remove method

} // end Services class
