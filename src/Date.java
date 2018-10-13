/*
 * Date
 * object to hold the date information for the system
 * Spice Tests
 * 13/10/2018
 */

public class Date {
	
	int year;
	int month;
	int day;
	
	/*
	 * returns int year
	 */
	public int getYear() {
		return year;
	} // end getYear method
	
	/*
	 * returns int month
	 */
	public int getMonth() {
		return month;
	} // end getMonth method
	
	/* 
	 * returns int day
	 */
	public int getDay() {
		return day;
	} // end getDay method
	
	/*
	 * validates that the year is within range
	 * if the year is valid (between 1980 and 2999 inclusive), sets year attribute
	 */
	public void setYear(int year) {
		if (year >= 1980 && year <= 2999) {
			this.year = year;
		} 
		else {
			System.out.println("Error: invalid year in date");
		}
	} // end setYear method
	
	/*
	 * validates that the month is within range
	 * if the month is valid (between 1 and 12 inclusive), sets month attribute
	 */
	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} 
		else {
			System.out.println("Error: invalid month in date");
		}
	} // end setMonth method
	
	/*
	 * validates that the day is within range
	 * if the day is valid (between 1 and 31 inclusive), sets day attribute
	 */
	public void setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		} 
		else {
			System.out.println("Error: invalid day in date");
		}
	} // end setDay method
	
	/*
	 * calls setYear, setMonth, and setDay methods
	 * if all successful, the date is set
	 * 
	 * Parameters:
	 * 		int year: the year for the date
	 * 		int month: the numeral month for the date
	 * 		int day: the numeral day for the date
	 */
	public void setDate(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	} // end setDate method
	
	/*
	 * returns the date as a string formatted as YYYYMMDD
	 */
	@Override
	public String toString() {
		return Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
	} // end toString method

} // end Date class
