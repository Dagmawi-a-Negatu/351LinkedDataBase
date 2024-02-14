package project1CS_351;

/**
 * Interface e for checking and changing attributes of records
 */
public interface ContactInterface {
	public final static int MAX_PHONE_NUM = 10;
	
	/**
	 * Check to see if a record has an attribute. Should not be case sensitive
	 * @param attribute possible attribute within a record.
	 * @return true if the value is contained in the object, false otherwise.
	 */

	public boolean exists(String attriubte);
	
	/**
	 * Check to see if a record has an attribute containing a specfic value.
	 * Should not be case sensitive.
	 * @param attribute possible attribute within a record.
	 * @param value desire value of the attributed.
	 * @return true if the value is contained in the object, false otherwise.
	 * @throws IllegalArgumentExcpetion fit he attirubte is invalid.
	 */
	public boolean hasValue(String attribute, String value) 
			throws IllegalArgumentException;
	
	/**
	 * Change the value of a specific attribute.
	 * @param attribute possible attribute with a record.
	 * @param value new value of the attribute. 
	 * @throws IllegalArgumentExcpetion if the attribute is invalid.
	 */
	public void setValue(String attribute, String value) throws
	IllegalArgumentException;
	default public void checkPhone(String number) {
		if(number.length() != MAX_PHONE_NUM || !(number.chars().allMatch(ch ->
		Character.isDigit(ch)))) {
			throw new IllegalStateException("Invalid phone number: " + number);
		}
	}
			
	
}
