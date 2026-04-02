package service;

import java.util.HashMap;
import java.util.Scanner;

import model.Contact;

public class ContactService {

    public static void controlContact(String choice, HashMap<String, Contact> map) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            switch (choice) {
                case "a":

                    boolean isCorrectInput = true;
                    while (isCorrectInput) {

                        // name
                        System.out.print("ENETR CONTACT NAME : ");
                        String name = sc.nextLine();
                        boolean isValid = utils.InputValidator.isValideName(name);
                        if (!isValid) {
                            continue;
                        }
                        if (map.containsKey(name)) {
                            System.out.println("--CONTACT ALREADY EXIST----");
                        }

                        // phoneNumber
                        System.out.print("ENTER CONTACT NUMBER : ");
                        String phoneNumber = sc.nextLine();

                        // boolean isValidNum = utils.InputValidator.isNumaric(phoneNumber);
                        // if (!isValidNum) {
                        // continue;
                        // }
                        // int parsedIntNumber = Integer.parseInt(phoneNumber);

                        // email
                        System.out.print("ENTER EMAIL : ");
                        String eMail = sc.nextLine();

                        boolean isValide = utils.InputValidator.isValideEmail(eMail);
                        if (!isValide) {
                            System.out.println("-----EMAIL SHOULD CONTAIN @ AND .com----TRY AGAIN----");
                            continue;
                        }

                        Contact c = new Contact(phoneNumber, eMail);

                        map.put(name, c);

                        model.Contact.addContact(name.toLowerCase(), phoneNumber, eMail, map);

                        isRunning = false;

                        isCorrectInput = false;

                    }
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
                case "d":
                    System.out.println("ENTER  NAME TO DELETE CONTECT.");
                    String dContact = sc.nextLine();
                    model.Contact.deleteContact(dContact, map);
                    isRunning = false;
                    break;

                case "e":
                    isRunning = false;
                    break;

                default:
                    System.out.println("<<<<<INVALIDE CHOICE SELECTED.TRY AGAIN>>>>>>");

                    isRunning = false;
            }

        }
    }
}
