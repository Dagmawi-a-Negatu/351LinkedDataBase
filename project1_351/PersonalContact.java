package project1CS_351;

public class PersonalContact extends Contact implements Cloneable { 
    
    private Label label;
    
    public PersonalContact(Long phoneNumber, String emailAddress, Address address, PersonalInfo personalInfo, Label label) {
        super(phoneNumber, emailAddress, address, personalInfo);
        this.label = label;
    }
    
    public Label getLabel() {
        return this.label;
    }

    @Override
    public PersonalContact clone() {
        PersonalContact theCopy = null;
        theCopy = (PersonalContact) super.clone(); // This clones the Contact part of PersonalContact
		// Since Label is an enum and thus inherently immutable and shared, we can simply assign it
		theCopy.label = this.label; // No need to clone, as enum values are static and immutable
        return theCopy;
    }

    
    @Override
    public String toString() {
        return "Catagory: " + this.getLabel() + "\n" + super.toString();
    }
    
    
}

  
    
    
    


