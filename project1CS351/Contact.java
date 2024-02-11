package project1CS351;

public class Contact implements ContactInterface, Cloneable {
	
	private PersonalInfo personalInfo;
	private Address address;
	private int phoneNumber;
	private String emailAddress;
	
	
	class Address {
		
		private String streetAddress;
		private String city;
		private String state;
		private int zipCode;
		
		public Address (String streetAddress, String city, String state,
				int zipCode) {
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
		}

		public String getStreetAddress() {
			return this.streetAddress;
		}
		
		public String getCity() {
			return this.city;
		}
		
		public String getState() {
			return this.state;
		}
		
		public int getZipCode() {
			return this.zipCode;
		}
	}
	
	
	public Contact(int phoneNumber, String emailAddress) {
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.personalInfo = new PersonalInfo("", "", PersonalInfo.Status.DIVORCED);
		this.address = new Address("", "", "", 00000);
	}
		
	
	public int getPhoneNumber() {
		return (this.phoneNumber);
	}
	
	public String getEmailAddress() {
		return (this.emailAddress);
	}
	
	/**
	 * Check to see if a record has an attribute. Should not be case sensitive
	 * @param attribute possible attribute within a record.
	 * @return true if the value is contained in the object, false otherwise.
	 */
	@Override
	public boolean exists(String attriubte) {
		try {
			this.getClass().getDeclaredField(attriubte);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
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
	}

	/**
	 * Change the value of a specific attribute.
	 * @param attribute possible attribute with a record.
	 * @param value new value of the attribute. 
	 * @throws IllegalArgumentExcpetion if the attribute is invalid.
	 */
	@Override
	public void setValue(String attribute, String value) throws IllegalArgumentException {
		if(!exists(attribute)) {
			throw new IllegalArgumentException();
		} else {
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

