import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {

            System.out.println("""
                    ENTER A TO ADD CONTACT.
                    ENTER V TO VIEW CONTACT LIST.
                    ENTER S TO SEARCH AND UPDATE CONTACT.

                    ENTER D TO DELETE CONTACT.
                    ENETR E TO EXIT CONTACT BOOK.
                            """);
            System.out.print("YOUR CHOICE : ");
            String choice = sc.nextLine().toLowerCase();

            service.ContactService.controlContact(choice, map);
            // continue;

        }

    }
}
