/*
 * Services
 * Stores all services loaded from central service file
 * Spice Tests
 * 02/11/2018
 */

package backoffice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Services {
	private static ArrayList<Service> serviceList = new ArrayList<Service>();
	
	/* 
	 * VALIDATEPATH: Checks if file/directory exists
	 * 
	 * Input: String representing file path
	 * Output: boolean (true on exists, false on not exists)
	 */
	public static boolean validatePath(String path) {
		// Ensure valid services file exists
		File f2 = new File(path);
		if (!f2.exists()) {
			return false;
		} // end if
		return true;
	} // end validatePath method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * READCSF: Reads CSF into data structure
	 * 
	 * Input: location of CSF
	 * Output: none
	 */
	public static void readCSF(String csfPath) throws InvalidInputFileException, IOException {
		// Validate path
		if (!validatePath(csfPath)) {
			throw new FileNotFoundException("Error: Central service file does not exist.");
		}
		
		// Create file object
		File file = new File(csfPath); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
		String line; 
		while ((line = br.readLine()) != null) {
			String[] splitLine = line.split(" ");
			
			// Throw exception
			if (splitLine.length != 5) {
				br.close();
				throw new InvalidInputFileException("Error: Central service file has invalid line with length " + splitLine.length);
			}
			
			// Create and add service
			Service serv;
			try {
				serv = new Service(Integer.parseInt(splitLine[0]), 
								   Integer.parseInt(splitLine[1]), 
								   Integer.parseInt(splitLine[2]), 
								   splitLine[3], 
								   new Date(splitLine[4]));
			} 
			catch (NumberFormatException e) {
				br.close();
				System.out.println(e.getMessage());
				throw new InvalidInputFileException("Error: Invalid Central Service File.");
			}
			catch (InputOutOfRangeException e) {
				br.close();
				System.out.println(e.getMessage());
				throw new InvalidInputFileException("Error: Invalid Central Service File.");
			}
			catch (InvalidServiceNameException e) {
				br.close();
				System.out.println(e.getMessage());
				throw new InvalidInputFileException("Error: Invalid Central Service File.");
			}
			catch (InvalidDateFormatException e) {
				br.close();
				System.out.println(e.getMessage());
				throw new InvalidInputFileException("Error: Invalid Central Service File.");
			}
			
			// Success, add service
			addService(serv);
	  	}
		
		// Close
		br.close();
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * READTSF: Reads TSF into data structure
	 * 
	 * Input: location of TSF
	 * Output: none
	 */
	public static void readTSF(String tsfPath) throws IOException, InvalidInputFileException {
		// Validate path
		if (!validatePath(tsfPath)) {
			throw new FileNotFoundException("Error: Transaction summary file does not exist.");
		}
		
		// Create file object
		File file = new File(tsfPath); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
		// Load file into buffer
		String line; 
		ArrayList<String> lines = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		
		// Parse TXN SUM file
		//  Separate lines by service number
		//  Parse separated lines
		//    in case of create service, create the service
		//    sum transactions (del are negative sel are positive)
		//    in case of reaching a delete, sum = 0; delete service
		//    there may be a case where the service is then created
		//    again.. if there is another line it MUST be create service
		//    sum starts again...
		//  Take sums for each service (if not deleted) and add to services
		for (String txn : lines) {
			// Split line
			String[] splitLine = txn.split(" ");
			
			// Throw exception
			if (splitLine.length != 6) {
				br.close();
				throw new InvalidInputFileException("Error: Transaction summary file has invalid line with length " + splitLine.length);
			}
			
			// Check type
			if (splitLine[0].equals("CRE")) {
				// Create and add service
				Service serv;
				try {
					serv = new Service(Integer.parseInt(splitLine[1]), 
									   1000, 
									   0, 
									   splitLine[4], 
									   new Date(splitLine[5]));
				} 
				catch (NumberFormatException e) {
					br.close();
					System.out.println(e.getMessage());
					throw new InvalidInputFileException("Error: Invalid Central Service File.");
				}
				catch (InputOutOfRangeException e) {
					br.close();
					System.out.println(e.getMessage());
					throw new InvalidInputFileException("Error: Invalid Central Service File.");
				}
				catch (InvalidServiceNameException e) {
					br.close();
					System.out.println(e.getMessage());
					throw new InvalidInputFileException("Error: Invalid Central Service File.");
				}
				catch (InvalidDateFormatException e) {
					br.close();
					System.out.println(e.getMessage());
					throw new InvalidInputFileException("Error: Invalid Central Service File.");
				}
				
				// Success, add service
				addService(serv);
			}
			
			// Check type
			if (splitLine[0].equals("DEL")) {
				removeService(Integer.parseInt(splitLine[1]));
			}
		}
		
		// Close
		br.close();
	}
		
	//---------------------------------------------------------------------------------------------
	
	/*
	 * ADDSERVICE: Adds service to list.
	 * 
	 * Input: New service to add
	 * Output: none
	 */
	public static void addService(Service newService) {
		serviceList.add(newService);
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * REMOVESERVICE: Removes service from list.
	 * 
	 * Input: Service number to remove
	 * Output: none
	 */
	public static void removeService(int serviceNumber) {
		for (Service ser : serviceList) {
			if (ser.getNumber() == serviceNumber) {
				serviceList.remove(ser);
				return;
			}
		}
	}

	//---------------------------------------------------------------------------------------------
	
	/*
	 * GetVSFString: Returns list of service numbers
	 * 
	 * Input: none
	 * Output: String for output to VSF
	 */
	public static String getVSFString() {
		// Parse services and add numbers to serviceNumberStr
		String serviceNumberStr = "";
		for (Service ser : serviceList) {
			serviceNumberStr += ser.getNumber() + "\n";
		}
		return serviceNumberStr;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETCSFSTRING: Returns the service as a string formatted for CSF.
	 * 
	 * Input: none
	 * Output: service as String
	 */
	public static String getCSFString() {
		// Parse services and add to serviceListStr
		String serviceListStr = "";
		for (Service ser : serviceList) {
			serviceListStr += ser.toString() + "\n";
		}
		return serviceListStr;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * findService: looks through the serviceList and finds the required service object
	 * 
	 * Input: valid service number
	 * Output: Service object, corresponding to the input service number
	 */
	public static Service findService(int serviceNum) {
		// TODO: Implement this plzzzzz
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * sellTicket: adds the given number of tickets to the given service object
	 * 
	 * Input: Service object to be updated, number of tickets sold
	 * Output: updated Service object
	 */
	public static Service sellTicket(Service service, int ticketNum) {
		// TODO: Implement this plzzzzz
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * cancelTicket: cancels the given number of tickets from the given service object
	 * 
	 * Input: Service object to be updated, number of tickets canceled
	 * Output: updated Service object
	 */
	public static Servie cancelTicket(Service service, int ticketNum) {
		// TODO: Implement this plzzzzz
	}
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * changeTicket: changes the given number of tickets from the original service to the destination
	 * 		service
	 * 
	 * Input: original Service object, destination Service object, number of tickets changed
	 * Output: array of updated Service objects [updated original Service object, updated destination Service object]
	 */
	public static Service[] changeTicket(Service originalService, Service destinationService, int ticketNum) {
		// TODO: Implement this plzzzzz
	}
	

} // end Services class
