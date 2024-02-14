package project1CS351;

public class Contact implements ContactInterface, Cloneable {
    
    private PersonalInfo personalInfo;
    private Address address;
    private Long phoneNumber;
    private String emailAddress;
    
    public Contact(Long phoneNumber, String emailAddress, Address address, PersonalInfo personalInfo) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.personalInfo = personalInfo;
        this.address = address;
    }
	
	
	
	 public Long getPhoneNumber() {
	    	return (this.phoneNumber);
	 }
	    
	 public String getEmailAddress() {
	    	return (this.emailAddress);
	 }
	    
	 public Address getAdress() {
	    	return (this.address);
	 }
	    
	 public PersonalInfo getPersonalInfo() {
	    	return (this.personalInfo);
	 }
	 
	 public String toString() {
	        String sb = "\t" + this.personalInfo.toString() +
	                    " \tPhone: " + this.getPhoneNumber() + "\n" +
	                   "\t" + this.address.toString() + "----------------------------------------------------------\n";
	        return sb;
	 }
	
	
	public boolean compare(Contact contact) {
		if (this == contact) {
			return (true);
		}
		
		if(contact == null) {
			return (false);
		}
		
		
		
		if(this.personalInfo.compare(contact.personalInfo) &&
		this.address.compare(contact.address)  &&
		
		this.getPhoneNumber().equals(contact.getPhoneNumber())	
		
		
		) {
			
			return (true);
		}
		
		return (false);
	}
	
	
	@Override
    public Contact clone() {
        try {
            Contact theCopy = (Contact) super.clone();
            theCopy.address = this.address.clone();
            // Consider also cloning personalInfo if it's mutable
            return theCopy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should not happen since we are Cloneable
        }
    }

    @Override
	public boolean exists(String attribute) {
		
    	if(attribute.equalsIgnoreCase("first")||
    	attribute.equalsIgnoreCase("last") ||
    	attribute.equalsIgnoreCase("title")) {
    		return (true);
    	}
    	
    	return (false);
		
    }

	/**
	 * Check to see if a record has an attribute containing a specific value.
	 * Should not be case sensitive.
	 * @param attribute possible attribute within a record.
	 * @param value desired value of the attribute.
	 * @return true if the value is contained in the object, false otherwise.
	 * @throws IllegalArgumentExcpetion if the attirubte is invalid.
	 */
	
	public boolean hasValue(String attribute, String value) {
		
			
			if(exists(attribute)){
				if(attribute.equalsIgnoreCase("first")) {
					
					return (this.personalInfo.getFristName().equalsIgnoreCase(value));
						
				}
						
				else if (attribute.equalsIgnoreCase("last")) {
						return (this.personalInfo.getLastName().equalsIgnoreCase(value));
				}

			
			}
		
		return (false);
    }

	@Override
	public void setValue(String attribute, String value) 
    throws IllegalArgumentException {
		
		if(attribute.equals("first")) {
			
			this.personalInfo.setFristName(value);
		}else if(attribute.equals("last")) {
			this.personalInfo.setLastName(value);
		}
		
		
		
    }
}
