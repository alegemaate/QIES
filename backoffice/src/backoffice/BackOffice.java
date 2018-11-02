package backoffice;

import java.io.File;

public class BackOffice {

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
	 * MAIN METHOD: starting point for program.
	 * 
	 * Input: Merged TXN Summary File, Central Services File
	 * Output: New Central Service File, New VSF
	 */
	public static void main(String[] args) {
		System.out.println("Backoffice!");
		
		// First parse CSF and load into services
		
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
		
	}

}
