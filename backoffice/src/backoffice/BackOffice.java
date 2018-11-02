package backoffice;

public class BackOffice {

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
