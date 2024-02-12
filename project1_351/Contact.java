package project1CS351;

public class Contact implements ContactInterface, Cloneable {
	
	private PersonalInfo personalInfo;
	private Address address;
	private Long phoneNumber;
	private String emailAddress;
	
	
	
	public Contact(Long phoneNumber, String emailAddress, Address address,
    PersonalInfo personalInfo) {
		
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.personalInfo = personalInfo;
		this.address = address;
	}
		
	
	 public Long phoneNumber() {
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

	
    @Override
    public Contact clone() {
        Contact theCopy = null;
        try {
            theCopy = (Contact)super.clone(); // clone Contact's fields
            theCopy.address = (Address) address.clone();
        }
        catch(CloneNotSupportedException cnse) {
            System.out.println(cnse.getMessage());
        }
        return theCopy;
    }

    @Override
	public boolean exists(String attriubte) {
		try {
			this.getClass().getDeclaredField(attriubte);
			return true;
		} catch (Exception e) {
			return false;
		}
		
    }

	/**
	 * Check to see if a record has an attribute containing a specific value.
	 * Should not be case sensitive.
	 * @param attribute possible attribute within a record.
	 * @param value desired value of the attribute.
	 * @return true if the value is contained in the object, false otherwise.
	 * @throws IllegalArgumentExcpetion if the attirubte is invalid.
	 */
	@Override
	public boolean hasValue(String attribute, String value)
    throws IllegalArgumentException {
		if (!exists(attribute)) {
			throw new IllegalArgumentException();
		} else {
			try {
				String val = (String)this.getClass().getDeclaredField
				(attribute).get(this);
				if (val.equalsIgnoreCase(value)) {
					return true;
				} else {
					return false;
				}
			} catch (NoSuchFieldException nsfe) {
				System.out.println(nsfe.getMessage());
				return false;
			} catch (IllegalAccessException iae) {
				System.out.println(iae.getMessage());
				return false;
			}
		}
    }

	@Override
	public void setValue(String attribute, String value) 
    throws IllegalArgumentException {
		if (!exists(attribute)) {
			throw new IllegalArgumentException();
        }
	    else {
			try {
				this.getClass().getDeclaredField(attribute).set(this, value);
			} catch (NoSuchFieldException nsfe) {
				System.out.println(nsfe.getMessage());
			} catch (IllegalAccessException iae) {
				System.out.println(iae.getMessage());
			}
		}
    }
}
