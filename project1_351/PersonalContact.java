package project1CS351;

public class PersonalContact extends Contact implements Clonable {
	
	
	
	enum Label{
		
		MOM,
		DAD,
		BROTHER,
		SISTER,
		FRIEND, 
		HUSBAND,
		WIFE
	}
	
	public PersonalContact(int phoneNumber, String emailAddress) {
		super(phoneNumber, emailAddress);
		// TODO Auto-generated constructor stub
	}

}

