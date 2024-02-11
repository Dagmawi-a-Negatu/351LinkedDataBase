import java.util.Scanner;

public class ContactList {
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cl1;
        String cl2;

        System.out.println("Enter filename for contact list 1> ");
        cl1 = scan.nextLine();
        System.out.println("Enter filename for contact list 2> ");
        cl2 = scan.nextLine();

        System.out.println("Welcome to database display");
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
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
            choice = scan.nextInt();
            
        } while (choice != 0);
    }
}
