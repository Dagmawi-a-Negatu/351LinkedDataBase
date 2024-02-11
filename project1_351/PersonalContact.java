public class PersonalContact extends Contact implements Cloneable {
	
	
    private Label label;
	
	enum Label {
        MOM,
		DAD,
		BROTHER,
		SISTER,
		FRIEND, 
		HUSBAND,
		WIFE
	}
	
	public PersonalContact(int phoneNumber, String emailAddress,
    Address address, PersonalInfo personalInfo, Label label) {
	    super(phoneNumber, emailAddress, address, personalInfo);
        this.label = label;
		// TODO Auto-generated constructor stub
	}

    @Override
    public PersonalContact clone() {
        PersonalContact theCopy = null;
        try {
            theCopy = (Contact)super.clone(); // clone Contact's fields
		theCopy.label = (Lable) label.clone;
        }
        catch(CloneNotSupportedException cnse) {
            System.out.println(cnse.getMessage());
        }
        return theCopy;
    }

}

