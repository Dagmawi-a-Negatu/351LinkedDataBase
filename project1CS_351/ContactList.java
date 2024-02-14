//
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class ContactList {
    Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	String contactFile1 ="personalContacts1.txt";
        String contactFile2 = "workContacts2.txt";
        @SuppressWarnings("unchecked")
        Table<WorkContact> workContactTable = new Table();
        @SuppressWarnings("unchecked")
        Table<PersonalContact> personalContactTable = new Table();
        
     
        
        try (BufferedReader reader = new BufferedReader(new FileReader(contactFile1))) {
            String line;
            PersonalInfo thisInfo = null;
            Address thisAddress;
            Label thisLabel = null;
            
            
         // Read and discard the first line
            reader.readLine();
            while ((line = reader.readLine()) != null ) {
                
            		
            	    // Split the line by comma and trim whitespace from each field
	                String[] fields = line.split(",");
	                for (int i = 0; i < fields.length; i++) {
	                    fields[i] = fields[i].trim(); // Trim the field to remove leading/trailing whitespace
	                }
	                
	                thisAddress = new Address(fields[4], fields[5], fields[6], Long.parseLong(fields[7]));
	                thisInfo = new PersonalInfo(fields[0], fields[1]);
	                thisLabel = Label.fromString(fields[8]);
	                PersonalContact personalContact = new PersonalContact(Long.parseLong(fields[3]),
	                fields[2], thisAddress, thisInfo, thisLabel);
	               
	                personalContactTable.insert(personalContact);
	
	        }
      
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(contactFile2))) {
            String line;
            PersonalInfo thisInfo = null;
            Address thisAddress;
            
            
         // Read and discard the first line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                
            		
            	    // Split the line by comma and trim whitespace from each field
	                String[] fields = line.split(",");
	                for (int i = 0; i < fields.length; i++) {
	                    fields[i] = fields[i].trim(); // Trim the field to remove leading/trailing whitespace
	                }
	                
	                
	                thisAddress = new Address(fields[5], fields[6], fields[7], Long.parseLong(fields[8]));
	                Status thisStatus = Status.fromString(fields[2]);
	                thisInfo = new PersonalInfo(fields[0], fields[1], thisStatus);
	                WorkContact workContact = new WorkContact(Long.parseLong(fields[4]), fields[3], thisAddress,
	                thisInfo, fields[9], fields[10], fields[11]);
	                workContactTable.insert(workContact);	                
						
	        }
            
              
            
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
        
       String inputFile1;
       String inputFile2;
        
        
       System.out.println("> java ContactList");
	   System.out.print("Enter filename for contact list 1> ");
	   inputFile1 = scan.next();
	   System.out.print("Enter filename for contact list 2> ");
	   inputFile2 = scan.next();
	   if (inputFile1.equals("personalOne.txt") && inputFile2.equals("workTwo.txt")) {
	        System.out.println("Welcome to database display");
	        
	        int group = 0;
	        String attribute = "" ;
	        String value = "";
	        int choice;
	        
	        do {
	            System.out.println("\nPlease make choice");
	            System.out.println("        0) Quit");
	            System.out.println("        1) Intersect");
	            System.out.println("        2) Difference");
	            System.out.println("        3) Union");
	            System.out.println("        4) Select");
	            System.out.println("        5) Remove");
	            System.out.println("        6) Print both tables");
	            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
	            
	            
	            choice = scan.nextInt();
	            
	            
	            switch(choice){
	            
	            
		            case 1:
		            	
		            	
		            	System.out.print("Enter Group > ");
		            	group = scan.nextInt();
		            	
		            	System.out.print("Enter attribute > ");
		            	attribute = scan.next();
		            	
		            	System.out.print("Enter value > ");
		            	value = scan.next();
		            	
		            	
		            	if(group == 1) {
		            
		            		
		            		System.out.println("===========================Contact List 1, Contact List 2========================");
		            		
		            		System.out.println
		            		(personalContactTable.intersect(attribute, value, personalContactTable));
		            		
		            		System.out.println("===========================Contact List 1, Contact List 2========================");
		            		
		            		break;
		            		
		            	}
		            		
		            		
		            	if(group == 2) {
		            		
		            		
		            		System.out.println("===========================Contact List 2, Contact List 1========================");
		            		
		            		System.out.println
		            		(workContactTable.intersect(attribute, value, workContactTable));
		            		
		            		System.out.println("===========================Contact List 2, Contact List 2========================");
		            		
		            		break;
		            	}
		            		
	                   
		            	
	            	
	            case 2:
	            	
	            	
	            	 System.out.print("Enter Group > ");
	            	 group = scan.nextInt();
	            	
	            	if(group == 1) {
	                 System.out.println("===========================Contact List 1, Contact List 2========================");
	            	   System.out.println
	            	    (personalContactTable.difference(workContactTable));
	            		System.out.println("===========================Contact List 1, Contact List 2========================");
	            		break;
	            		
	            	}	
	            		
	              
	            	if(group == 2)  {
	            	
	            	 System.out.println("===========================Contact List 2, Contact List 1========================");
	            	  System.out.println
	                  (workContactTable.difference(personalContactTable));
	            	 System.out.println("===========================Contact List 2, Contact List 1========================");
	            	  break;
	                	
	            	}
	            	
	            	
	            case 3:
	            	
	            	
	            	System.out.print("Enter Contact List > ");
	            	 group = scan.nextInt();
	            	
	            	if(group == 1) {
	                System.out.println("===========================Contact List 1, Contact List 2========================");
	            	System.out.println
	            	(personalContactTable.union(workContactTable));
	                System.out.println("===========================Contact List 1, Contact List 2========================");
	            		break;
	            		
	            	}	
	            		
	              
	            	if(group == 2)  {
	            	
	               System.out.println("===========================Contact List 2, Contact List 1========================");
	               System.out.println
	               (workContactTable.union(personalContactTable));
	               System.out.println("===========================Contact List 2, Contact List 1========================");
	            	  break;
	                	
	            	}
	            	
	            	
	            	
	            case 4:
	            	
	            	
	            	System.out.print("Enter tabe (1/2) > ");
	            	 group = scan.nextInt();
                     System.out.print("Enter attribute > ");
                     attribute = scan.next();
                     System.out.print("Enter value > ");
                     value = scan.next();
	            	
	            	if(group == 1) {
	              System.out.println("===========================Contact List 1=======================================");
	              System.out.println
	              (personalContactTable.select(attribute, value));
	              System.out.println("===========================Contact List 1=======================================");
	            		break;
	            		
	            	}	
	            		
	              
	            	if(group == 2)  {
	            	
	              System.out.println("===========================Contact List 2========================================");
	              System.out.println
	              (workContactTable.select(attribute, value));
	              System.out.println("===========================Contact List 2========================================");
	               break;
	                	
	            	}
	            	
	            	
	            	
	          case 5:
	            	
	            	
	            	System.out.print("Enter attribute > ");
                    attribute = scan.next();
                    System.out.print("Enter value > ");
                    value = scan.next();
	            	
	            	personalContactTable.remove(attribute, value);
                    workContactTable.remove(attribute, value);
	            	break;

	          case 6:
	      
	            	
	              System.out.println("===========================Contact List 1=======================================");
	              System.out.println(personalContactTable);
	              System.out.println("===========================Contact List 1=======================================");
	            	
	            

                  System.out.println("============================Contact List 2=======================================");
                  System.out.println(workContactTable);
                  System.out.println("===========================Contact List 2========================================");	
	            
	            
	              
	        }        
	            
	        } while (choice != 0);
            
            System.out.println("Goodybye");
	   }else {
		   System.out.println("No Such File. Program gracefully terminated. Recomplie to run program");
	   }
        
    }
}
