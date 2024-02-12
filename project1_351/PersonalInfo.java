package project1CS351;

public class PersonalInfo {
	private String firstName; //First name
	private String lastName;  //Last name
	private Status martialStatus;
	
	enum Status {
        MARRIED("married"),
        SINGLE("single"),
        DIVORCED("divorced"),
        WIDOWED("widowed");

        private final String status;

        // Constructor for enum to set the string value
        Status(String status) {
            this.status = status;
        }

        // Getter for the string value
        public String getStatus() {
            return this.status;
        }
    }
	
	public PersonalInfo(String first, String last, Status status) {
		this.firstName = first;
		this.lastName = last;
		this.martialStatus = status;
	}
	
	public PersonalInfo(String first, String last) {
		this.firstName = first;
		this.lastName = last;
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
	
	
	//private void setFirstName(String firstName) {
		//this.firstName = firstName;
	//}
	
	//private void setLastName(String lastName) {
		//this.lastName = lastName;
	//}
	
	

}
