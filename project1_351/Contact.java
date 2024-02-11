public class Contact implements ContactInterface, Clonable{
	
	private PersonalInfo personalInfo;
	private Address address;
	private int phoneNumber;
	private String emailAddress;
	
	
	class Address{
		
	    private String streetAddress;
		private String city;
		private String state;
		private int zipCode;
		
		public Address(String streetAddress, String city, String state,
				int zipCode) {
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
		
		
			public String getstreetAddress(){
				return (this.streetAddress);
			}
			
			public String city() {
				return (this.city);
			}
			
			public String state() {
				return (this.state);
			}
			
			public int getZipCode() {
				return (this.zipCode);
			}

        }
		
	}
	
	
	public Contact(int phoneNumber, String emailAddress, Address, address,
    PersonalInfo personalInfo) {
		
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.personalInfo = personalInfo;
		this.address = address;
	}
		
	
	public int getPhoneNumber() {
		return (this.phoneNumber);
	}
	
	public String getEmailAddress() {
		return (this.emailAddress);
	}

	
    @Override
    public Contact clone() {
        Contact theCopy = null;
        try {
            theCopy = (Contact)super.clone(); // clone Contact's fields
            theCopy.address = (Address) address.clone;
        }
        catch(CloneNotSupportedException cnse) {
            System.out.println(cnse.getMessage());
        }
        return theCopy;
    }

    @Override
	public boolean exists(String attriubte) {
		List<Field> attributes = getAllFields(this);
		for (Field field : attributes) {
			if (attriubte.equalsIgnoreCase(field.getName()) {
				return true;
			}
		try {
			this.getClass().getDeclaredField(attriubte);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * Check to see if a record has an attribute containing a specific value.
	 * Should not be case sensitive.
	 * @param attribute possible attribute within a record.
	 * @param value desire value of the attribute.
	 * @param value desired value of the attribute.
	 * @return true if the value is contained in the object, false otherwise.
	 * @throws IllegalArgumentExcpetion if the attirubte is invalid.
	 */
	@Override
	public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
		List<Field> attributes = getAllFields(this);
		for (Field field : attributes) {
			if (attriubte.equalsIgnoreCase(field.getName()) && field.get(this).equalsIgnoreCase(value)) {
		  		return true;
            }
		if (!exists(attribute)) {
			throw new IllegalArgumentException();
		} else {
			try {
				String val = (String)this.getClass().getDeclaredField(attribute).get(this);
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
		return false;
    }

   }
	@Override
	public void setValue(String attribute, String value) throws IllegalArgumentException {
		// TODO Auto-generated method stub

		if(!exists(attribute)) {
			throw new IllegalArgumentException();
        }
	    else {
			try {
				this.getClass().getDeclaredField(attribute)
                field.setAccessible(true);
                field.set(this, value);
			} catch (NoSuchFieldException nsfe) {
				System.out.println(nsfe.getMessage());
			} catch (IllegalAccessException iae) {
				System.out.println(iae.getMessage());
			}
		}
    }

}
