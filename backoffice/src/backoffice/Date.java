/*
 * Date
 * Object to hold the date information for the system.
 * Spice Tests
 * 02/11/2018
 */

package backoffice;

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
	public Date(int year, int month, int day) throws InputOutOfRangeException {
		setYear(year);
		setMonth(month);
		setDay(day);
	} // end setDate method
	
	//---------------------------------------------------------------------------------------------
	
	/*
	 * Date constructor:
	 * calls setYear, setMonth, and setDay methods
	 * after separating string in format YYYYMMDD
	 * if all successful, the date is set
	 * 
	 * Parameters:
	 * 		String date: the date in format YYYYMMDD
	 */
	public Date(String date) throws InputOutOfRangeException, InvalidDateFormatException {
		// Check length
		if (date.length() != 8) {
			throw new InvalidDateFormatException("Error: Invalid date format.");
		}
		
		// Validate numbers
		try {
			setYear(Integer.parseInt(date.substring(0,4)));
			setMonth(Integer.parseInt(date.substring(4,6)));
			setDay(Integer.parseInt(date.substring(6,8)));
		} catch (NumberFormatException e) {
			throw new InvalidDateFormatException("Error: Invalid date format.");
		} // end try/catch
		
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
	public void setYear(int year) throws InputOutOfRangeException {
		if (year < 1980) {
			throw new InputOutOfRangeException("Error: Year must be above 1979.");
		}
		if (year > 2999) {
			throw new InputOutOfRangeException("Error: Year must be below 2999.");
		}
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
	public void setMonth(int month) throws InputOutOfRangeException {
		if (month < 1 || month > 12) {
			throw new InputOutOfRangeException("Error: Month out of range.");
		}
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
	public void setDay(int day) throws InputOutOfRangeException {
		if (day < 1 || day > 31) {
			throw new InputOutOfRangeException("Error: Day out of range.");
		}
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
		return "" + year 
				  + String.format("%2s", "" + day).replace(" ", "0")
				  + String.format("%2s", "" + month).replace(" ", "0");
	} // end toString method

} // end Date class
