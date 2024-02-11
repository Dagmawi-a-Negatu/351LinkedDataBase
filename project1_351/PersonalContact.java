public class PersonalContact extends Contact implements Clonable {
	
	
    private Lable lable;
	
	enum Label{
		
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
	    super(phoneNumber, emailAdress, address, personalInfo);
        this.lable = label;
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

