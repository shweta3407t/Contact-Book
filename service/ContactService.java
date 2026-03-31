package service;

import java.util.HashMap;
import java.util.Scanner;

public class ContactService {

    public static void controlContact(String choice, HashMap<String, Integer> map) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            switch (choice) {
                case "a":

                    System.out.print("ENETR CONTACT NAME : ");
                    String name = sc.next();
                    System.out.print("ENTER CONTACT NUMBER : ");
                    int number = sc.nextInt();
                    model.Contact.addContact(name.toLowerCase(), number, map);
                    isRunning = false;

                    break;
                case "v":
                    System.out.println("-------ALL CONTACT LIST------");
                    model.Contact.viewContact(map);

                    isRunning = false;
                    break;
                case "s":
                    System.out.print("ENTER  NAME TO SEARCH CONTACT :");
                    String contact = sc.next().toLowerCase();
                    model.Contact.searchContact(sc, contact, map);
                    isRunning = false;
                    break;
                // case " u":
                //     System.out.print("ENTER  NAME TO  UPDATE CONTACT :");
                //     String uName = sc.nextLine().toUpperCase().toLowerCase();
                //     model.Contact. updateContact(sc, uName, map);
                //     isRunning = false;
                //     break;

                case "d":
                    System.out.println("ENTER  NAME TO DELETE CONTECT.");
                    String dContact = sc.nextLine();
                    model.Contact.deleteContact(dContact, map);
                    isRunning = false;
                    break;

                default:
                    System.out.println("INVALIDE CHOICE SELECTED.TRY AGAIN");
                    break;
            }
        }
    }
}
