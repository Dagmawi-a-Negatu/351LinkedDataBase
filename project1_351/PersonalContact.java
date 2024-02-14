/*
 * The purpose of this class is to represent the information for a Personal Contact.
 */

package project1CS_351;

public class PersonalContact extends Contact implements Cloneable { 
    
    // Label field for the contact
    private Label label;
    
    // Personal Contact constructor
    public PersonalContact(Long phoneNumber, String emailAddress, Address address, PersonalInfo personalInfo, Label label) {
        super(phoneNumber, emailAddress, address, personalInfo);
        this.label = label;
    }
    
    /**
     * Gets the label of the contact
     * @return the label of the contact
     */
    public Label getLabel() {
        return this.label;
    }

    /**
     * Clone method for the personal contact
     * @return a clone of the personal contact
     */
    @Override
    public PersonalContact clone() {
        PersonalContact theCopy = null;
        theCopy = (PersonalContact) super.clone(); // This clones the Contact part of PersonalContact
		// Since Label is an enum and thus inherently immutable and shared, we can simply assign it
		theCopy.label = this.label; // No need to clone, as enum values are static and immutable
        return theCopy;
    }

    /**
     * To string method for the contact. 
     * @return the information of the contact as a formatted string.
     */
    @Override
    public String toString() {
        return "Catagory: " + this.getLabel() + "\n" + super.toString();
    }
    
    
}

  
    
    
    


