/*
 * The purpose of this class is to represent the basic information for a person.
 */

package project1CS_351;

public class PersonalInfo {

	// First Name
	private String firstName;

	// Last Name
	private String lastName;

	// Marital Status
	private Status martialStatus;
	
	// Constructor with first and last name, and marital status
	public PersonalInfo(String last, String first, Status status) {
		this.firstName = first;
		this.lastName = last;
		this.martialStatus = status;
	}
	
	// Constructor with only first and last name
	public PersonalInfo(String last, String first) {
		this.firstName = first;
		this.lastName = last;
	}
	
	/**
	 * Get the first name of the person
	 * @return the person's first name
	 */
	public String getFirstName() {
		return (this.firstName);
	}
	
	/**
	 * Get the last name of the person
	 * @return the person's last name
	 */
	public String getLastName() {
		return (this.lastName);
	}
	
	/**
	 * Set the first name of the person
	 * @param firstName Value of the new first name
	 * @return the new first name
	 */
	public String setFirstName(String firstName) {
		return (this.firstName = firstName);
	}
	
	/**
	 * Set the last name of the person
	 * @param lastName Value of the new last name
	 * @return the new last name
	 */
	public String setLastName(String lastName) {
		return (this.lastName = lastName);
	}
	
	/**
	 * Get the marital status of the person
	 * @return the person's marital status
	 */
	public Status getMartialStatus() {
		return (this.martialStatus);
	}
	
	/**
	 * Compares this object to another personalInfo object for equality
	 * @param personalInfo the object to be compared
	 * @return true if equal, else false
	 */
	public boolean compare(PersonalInfo personalInfo) {
	    if (this == personalInfo) {
	    	return true; // Check for reference equality
		} 
	    if (personalInfo == null) return false; // Check for null to avoid NullPointerException
	    
	    
	    // Status.compare(Status status) method correctly compares two Status objects.
	    //if (this.martialStatus != null && !this.martialStatus.compare(personalInfo.getMartialStatus()))
	        //return false;
	    
	    if (!this.getFristName().equalsIgnoreCase(personalInfo.getFristName())) // Case insensitive comparison for names
	        return false;
	    
	    return (this.getLastName().equalsIgnoreCase(personalInfo.getLastName()));
	    	
	    	
	}


	/**
	 * To string method for the person's info.
	 * @returns info as a formatted string.
	 */
	@Override
	public String toString() {
		
		String sb = "";
		sb += this.getLastName() + ", " + this.getFristName()+": ";
		
		
		if(martialStatus != null) {
			sb += martialStatus.toString();
		}else{
			sb += " (NA)";
		}
		
		
		return (sb);
	}


}
