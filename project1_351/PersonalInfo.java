package project1CS_351;

public class PersonalInfo {
	private String firstName; //First name
	private String lastName;  //Last name
	private Status martialStatus;
	
	
	public PersonalInfo(String last, String first, Status status) {
		this.firstName = first;
		this.lastName = last;
		this.martialStatus = status;
	}
	
	public PersonalInfo(String last, String first) {
		this.firstName = first;
		this.lastName = last;
	}
	
	public String getFristName() {
		return (this.firstName);
	}
	
	public String getLastName() {
		return (this.lastName);
	}
	
	public String setFristName(String firstName) {
		return (this.firstName = firstName);
	}
	
	public String setLastName(String lastName) {
		return (this.lastName = lastName);
	}
	
	public Status getMartialStatus() {
		return (this.martialStatus);
	}
	
	
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
