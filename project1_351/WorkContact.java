package project1CS_351;

public class WorkContact extends Contact implements Clonable {
	
    
	public String title;
    private String company;
    private String department;

    
    
    public WorkContact(Long phoneNumber, String emailAddress,
    		Address address, PersonalInfo personalInfo, String title, String company, String department) {
        super(phoneNumber, emailAddress, address, personalInfo);
     
        this.title = title;
        this.company = company;
        this.department = department;
    }
    
    
    public String getTitle() {
    	return (this.title);
    }
    
    public String getCompany() {
    	return (this.company);
    }
    
    public String getDepartment() {
    	return (this.department);
    }
    
    @Override
    public String toString() {
    	
    	return ("Job Title: "+ this.getTitle()+ "\n"+
    			"Company: " + this.getCompany() + "\n"+
    			"Department: " + this.getDepartment() +"\n"
    			+ super.toString());
    }
   
  
    
  @Override
  public WorkContact clone() {
        WorkContact theCopy = null;
        try {
            theCopy = (WorkContact)super.clone(); // clone Contact's fields
            theCopy.company = this.company;
            theCopy.department = this.department;
            theCopy.title = this.title;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return theCopy;
  }
  
  
  @Override
  public boolean hasValue(String attribute, String value) {
		
		
		if(exists(attribute)){
			if(attribute.equalsIgnoreCase("first")) {
				
				return (super.getPersonalInfo().getFristName().equalsIgnoreCase(value));
					
			}
					
			else if (attribute.equalsIgnoreCase("last")) {
					return (super.getPersonalInfo().getLastName().equalsIgnoreCase(value));
			}
			
			if(attribute.equalsIgnoreCase("title")) {
				return (this.getTitle().equalsIgnoreCase(value));
			}

		
		}
	
	return (false);
	
	
  }
  
  
  
  
}



