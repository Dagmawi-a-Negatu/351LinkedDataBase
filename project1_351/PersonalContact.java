package project1CS351;

public class PersonalContact extends Contact implements Clonable {
	
	
    private Label label;
    
    
	public PersonalContact(Long phoneNumber, String emailAddress,
    Address address, PersonalInfo personalInfo, Label label) {
	    super(phoneNumber, emailAddress, address, personalInfo);
        this.label = label;
		// TODO Auto-generated constructor stub
	}

    @Override
    public PersonalContact clone() {
        PersonalContact theCopy = null;
        theCopy = (PersonalContact)super.clone(); // clone Contact's fields
		theCopy.label = (Label) this.label;
        return theCopy;
    }
    
  
    
    
    

}
