package project1CS351;

public class WorkContact extends Contact {
	
    private String title;
    private String company;
    private String department;

    public WorkContact(Long phoneNumber, String emailAddress, Address address, PersonalInfo personalInfo) {
        super(phoneNumber, emailAddress, address, personalInfo);
    }

    public WorkContact(Long phoneNumber, String emailAddress,
    		Address address, PersonalInfo personalInfo, String title, String company, String department) {
        super(phoneNumber, emailAddress, address, personalInfo);
        this.title = title;
        this.company = company;
        this.department = department;
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
  
}



