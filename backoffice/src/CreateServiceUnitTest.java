/*
 * CreateServiceUnitTest
 * Harness for testing create service
 * Spice Tests
 * 16/11/2018
 */

public class CreateServiceUnitTest {
	// Entry point for unit test
	public static void main(String[] args) {
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, 0, "service", null);
			System.out.println("Path 1 Reached.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 1 Error.");
		}
		
		// 1, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(0, 10, 0, "service", null);
			System.out.println("Path 2 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 2 Reached.");
		}
		
		// 1, 2, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(100000, 10, 0, "service", null);
			System.out.println("Path 3 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 3 Reached.");
		}
		
		// 1, 2, 3, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 0, 0, "service", null);
			System.out.println("Path 4 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 4 Reached.");
		}
		
		// 1, 2, 3, 4, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10000, 0, "service", null);
			System.out.println("Path 5 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 5 Reached.");
		}
		
		// 1, 2, 3, 4, 5, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, 11, "service", null);
			System.out.println("Path 6 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 6 Reached.");
		}
		
		// 1, 2, 3, 4, 5, 6, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, -1, "service", null);
			System.out.println("Path 7 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 7 Reached.");
		}
		
		// 1, 2, 3, 4, 5, 6, 7, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, 0, " service", null);
			System.out.println("Path 8 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 8 Reached.");
		}
		
		// 1, 2, 3, 4, 5, 6, 7, 8, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, 0, "se", null);
			System.out.println("Path 9 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 9 Reached.");
		}
		
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, 0, "serviceserviceserviceserviceserviceservice", null);
			System.out.println("Path 10 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 10 Reached.");
		}
		
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, 0, "ser@vice", null);
			System.out.println("Path 11 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 11 Reached.");
		}
		
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, END
		try {
			Service serv = new Service(10000, 10, 0, "service", null);
			Services.addService(serv);
			
			Service serv2 = new Service(10000, 10, 0, "service", null);
			Services.addService(serv2);
			System.out.println("Path 12 Error.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException | InvalidInputFileException e) {
			System.out.println("Path 12 Reached.");
		} 
		
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, END
		try {
			@SuppressWarnings("unused")
			Service serv = new Service(10000, 10, 0, "service", null);
			
			@SuppressWarnings("unused")
			Service serv2 = new Service(10001, 10, 0, "service", null);
			System.out.println("Path 13 Reached.");
		} 
		catch (InputOutOfRangeException | InvalidServiceNameException e) {
			System.out.println("Path 13 Error.");
		}
	}
}
