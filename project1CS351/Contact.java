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
		List<Field> attributes = getAllFields(this);
		for (Field field : attributes) {
			if (attriubte.equalsIgnoreCase(field)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check to see if a record has an attribute containing a specific value.
	 * Should not be case sensitive.
	 * @param attribute possible attribute within a record.
	 * @param value desire value of the attribute.
	 * @return true if the value is contained in the object, false otherwise.
	 * @throws IllegalArgumentExcpetion if the attirubte is invalid.
	 */
	@Override
	public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
		List<Field> attributes = getAllFields(this);
		for (Field field : attributes) {
			if (attriubte.equalsIgnoreCase(field) && field.get(this).equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Change the value of a specific attribute.
	 * @param attribute possible attribute with a record.
	 * @param value new value of the attribute. 
	 * @throws IllegalArgumentExcpetion if the attribute is invalid.
	 */
	@Override
	public void setValue(String attribute, String value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
}

