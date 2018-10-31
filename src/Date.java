/*
 * Date
 * Object to hold the date information for the system.
 * Spice Tests
 * 13/10/2018
 */

public class Date {
	
	int year;
	int month;
	int day;
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Date constructor:
	 * calls setYear, setMonth, and setDay methods
	 * if all successful, the date is set
	 * 
	 * Parameters:
	 * 		int year: the year for the date
	 * 		int month: the numeral month for the date
	 * 		int day: the numeral day for the date
	 */
	public Date(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	} // end setDate method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETYEAR: Returns year.
	 * 
	 * Input: none
	 * Output: year as int
	 */
	public int getYear() {
		return year;
	} // end getYear method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * GETMONTH: Returns month.
	 * 
	 * Input: none
	 * Output: month as int
	 */
	public int getMonth() {
		return month;
	} // end getMonth method
	
	//---------------------------------------------------------------------------------------------
	
	/* 
	 * GETDAY: Returns day.
	 * 
	 * Input: none
	 * Output: day as int
	 */
	public int getDay() {
		return day;
	} // end getDay method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETYEAR: Validates that the year is within range.
	 * 		If the year is valid (between 1980 and 2999 inclusive), sets year attribute.
	 * 
	 * Input: int representing year
	 * Output: return status (0 if valid, -1 otherwise)
	 */
	public void setYear(int year) {
		while (year < 1980 || year > 2999) {
			System.out.println("Error: year cannot be less than 1980 or greater than 2999.");
			year = Integer.parseInt(ScannerWrapper.getInput("Enter year: "));
		} // end while
		this.year = year;
	} // end setYear method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETMONTH: Validates that the month is within range.
	 * 		If the month is valid (between 1 and 12 inclusive), sets month attribute.
	 * 
	 * Input: int representing month
	 * Output: return status (0 if valid, -1 otherwise)
	 */
	public void setMonth(int month) {
		while (month < 1 || month > 12) {
			System.out.println("Error: month cannot be less than 1 or greater than 12.");
			month = Integer.parseInt(ScannerWrapper.getInput("Enter month: "));
		} // end while
		this.month = month;
	} // end setMonth method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETDAY: Validates that the day is within range.
	 * 		If the day is valid (between 1 and 31 inclusive), sets day attribute.
	 * 
	 * Input: int representing day
	 * Output: return status (0 if valid, -1 otherwise)
	 */
	public void setDay(int day) {
		while (day < 1 || day > 12) {
			System.out.println("Error: day cannot be less than 1 or greater than 31.");
			day = Integer.parseInt(ScannerWrapper.getInput("Enter day: "));
		} // end while
		this.day = day;
	} // end setDay method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * TOSTRING: Returns the date as a string formatted as YYYYMMDD.
	 * 
	 * Input: none
	 * Output: date as String in YYYYMMDD format
	 */
	@Override
	public String toString() {
		String dayStr = Integer.toString(day);
		return Integer.toString(year) 
				+ Integer.toString(month) 
				+ String.format("%2s", dayStr).replace(" ", "0");
	} // end toString method

} // end Date class
