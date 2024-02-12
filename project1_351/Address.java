package project1CS351;


class Address {
	
    private String streetAddress;
	private String city;
	private String state;
	private Long zipCode;
	
	public Address(String streetAddress, String city, String state,
			Long zipCode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getstreetAddress(){
		return (this.streetAddress);
	}
	
	public String city() {
		return (this.city);
	}
	
	public String state() {
		return (this.state);
	}
	
	public Long getZipCode() {
		return (this.zipCode);
	}
	
	
	public void setstreetAddress(String streetAddress){
		this.streetAddress = streetAddress;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	

	@Override
	public Address clone() {
		Address copy = null;
		try {
			copy = (Address)super.clone();
		} catch (CloneNotSupportedException cnse){
			System.out.println(cnse.getMessage());
		}
		return copy;
	}
}
