package project1CS_351;


class Address implements Clonable {
	
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
	
	public String getCity() {
		return (this.city);
	}
	
	public String getState() {
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
	public String toString() {
		
		String sb = "";
		sb += this.getstreetAddress() +"\n";
		sb += "\t"+ this.getCity() + " " + this.getState() + " " + this.getZipCode() + "\n";
		
		
		return (sb.toString());
	}
	
	public boolean compare(Address address) {
		
		if ( this == address) {
			return (true);
		}
		
		if(address == null) {
			return (false);
		}
		
		if(this.getstreetAddress().equals(address.getstreetAddress()) &&
		this.getCity().equals(address.getCity()) &&
		this.getState().equals(address.getState()) &&
		this.getZipCode().equals(address.getZipCode())) {
	
			return (true);
		}
		
		return (false);
		
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
