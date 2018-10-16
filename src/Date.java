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
	public int setYear(int year) {
		if (year >= 1980 && year <= 2999) {
			this.year = year;
			return 0;
		} else {
			System.out.println("Error: invalid year in date");
			return -1;
		} // end if/else
	} // end setYear method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETMONTH: Validates that the month is within range.
	 * 		If the month is valid (between 1 and 12 inclusive), sets month attribute.
	 * 
	 * Input: int representing month
	 * Output: return status (0 if valid, -1 otherwise)
	 */
	public int setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
			return 0;
		} else {
			System.out.println("Error: invalid month in date");
			return -1;
		} // end if/else
	} // end setMonth method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * SETDAY: Validates that the day is within range.
	 * 		If the day is valid (between 1 and 31 inclusive), sets day attribute.
	 * 
	 * Input: int representing day
	 * Output: return status (0 if valid, -1 otherwise)
	 */
	public int setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
			return 0;
		} else {
			System.out.println("Error: invalid day in date");
			return -1;
		} // end if/else
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
		return Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
	} // end toString method

} // end Date class
