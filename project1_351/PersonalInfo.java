public class PersonalInfo {
	private String firstName; //First name
	private String lastName;  //Last name
	private Status martialStatus;
	
	enum Status{
		MARIED,
		SINGLE,
		DIVORCED,
		WIDOWED;
	}
	
	public PersonalInfo(String first, String last, Status status) {
		this.firstName = first;
		this.lastName = last;
		this.martialStatus = status;
	}
	
	public String getFristName() {
		return (this.firstName);
	}
	
	public String getLastName() {
		return (this.lastName);
	}
	
	public Status getMartialStatus() {
		return (this.martialStatus);
	}
	
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
