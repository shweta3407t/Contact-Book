package model;

 
import java.util.HashMap;
import java.util.Scanner;

import  service.Contact;

public class ContactService {

    public static void controlContact(HashMap<String, Contact> map, String choice) {
        Scanner sc = new Scanner(System.in);
       

        switch (choice) {
            case "a":

                boolean isCorrectInput = true;
                while (isCorrectInput) {

                    // name
                    System.out.print("ENETR NAME : ");
                    String name = sc.nextLine();
                    boolean isValid = utils.InputValidator.isValideName(name);
                    if (!isValid) {
                        continue;
                    }
                    if (map.containsKey(name)) {
                        System.out.println("--CONTACT ALREADY EXIST----");
                    }

                    // phoneNumber
                    System.out.print("ENTER NUMBER : ");
                    String phoneNumber = sc.nextLine();

                    boolean isValidNum = utils.InputValidator.isNumaric(phoneNumber);
                    if (!isValidNum) {
                        continue;
                    }

                    // email
                    System.out.print("ENTER EMAIL : ");
                    String eMail = sc.nextLine();

                    boolean isValide = utils.InputValidator.isValideEmail(eMail);
                    if (!isValide) {
                        System.out.println("-----EMAIL SHOULD CONTAIN @ AND .com----TRY AGAIN----");
                        continue;
                    }

                    // Contact c = new Contact(phoneNumber, eMail);

                    // map.put(name, c);

                     service.Contact.addContact(map, name.toLowerCase(), phoneNumber, eMail);

                 

                    isCorrectInput = false;

                }
                break;

            case "v":
                System.out.println("-------ALL CONTACT LIST------");
                 service.Contact.viewContact(map);

                 
                break;
            case "s":
                System.out.print("ENTER  NAME TO SEARCH CONTACT :");
                String contact = sc.nextLine().toLowerCase();
                 service.Contact.searchContact(map, sc, contact);
              
                break;
            case "d":
                System.out.println("ENTER  NAME TO DELETE CONTECT.");
                String dContact = sc.nextLine();
                 service.Contact.deleteContact(map, dContact);
                
                break;

            case "e":
                System.out.println("<<<<<<<EXITING CONTACT BOOK>>>>>>>");
                System.exit(0);
            default:
                System.out.println("<<<<<INVALIDE CHOICE SELECTED.TRY AGAIN>>>>>>");

                
        }

    }
}
