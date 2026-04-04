import java.util.HashMap;
import java.util.Scanner;

import service.ContactService;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ContactService> map = new HashMap<>();
        try {
             while (true) {

            System.out.println("""
                    \n----CONTACT BOOK-----
                    ENTER A TO ADD CONTACT.
                    ENTER V TO VIEW CONTACT LIST.
                    ENTER S TO SEARCH AND UPDATE CONTACT.

                    ENTER D TO DELETE CONTACT.
                    ENETR E TO EXIT CONTACT BOOK.
                            """);

            System.out.print("YOUR CHOICE : ");
            String choice = sc.nextLine().toLowerCase();

            model.Contact.controlContact(map, choice);
            // continue;

        }
        } catch (Exception e) {
          System.out.println("<<<<<<<<<<<<<<EXCEPTION HANDLED>>>>>>>>>>>>>>>>>>>>>");
        }

        

    }
}
