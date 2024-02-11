public class WorkContact extends Contact, Clonable {
	
   private String title;
   private String company;
   private String department;

   public workContact(int phoneNumber, String emailAdress,
   Address address, PersonalInfo personalInfo, String title,
   String company, String department){
       super(phoneNumber, emailAddress, address, personalInfo);
       this.title = title;
       this.company = company;
       this.department = department;
   }


   
  @Overide
  public WorkContact clone() {
        WorkContact theCopy = null;
        try {
            theCopy = (Contact)super.clone(); // clone Contact's fields
            theCopy.company = this.company;
            theCopy.department = this.department;
            theCopy.title = this.title;
        }
        catch(CloneNotSupportedException cnse) {
            System.out.println(cnse.getMessage());
        }

        return theCopy;
  }
  	

}
