package project1CS351;

public class Contact implements ContactInterface, Cloneable{
	
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
	
	
	
	
	public Contact(int phoneNumber, String emailAddress) {
		
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.personalInfo = new PersonalInfo("", "", PersonalInfo.Status.DIVORCED);
		this.address = new Address("", "", "", 0000);
	}
		
	
	public int getPhoneNumber() {
		return (this.phoneNumber);
	}
	
	public String getEmailAddress() {
		return (this.emailAddress);
	}
	
	
	
	@Override
	public boolean exists(String attriubte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValue(String attribute, String value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
