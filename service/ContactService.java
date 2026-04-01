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

                    boolean isCorrectInput = true;
                    while (isCorrectInput) {
                        // name
                        System.out.print("ENETR CONTACT NAME : ");
                        String name = sc.nextLine();
                        boolean isValid = utils.InputValidator.isValideName(name);
                        if (!isValid) {
                            continue;
                        }

                        // number
                        System.out.print("ENTER CONTACT NUMBER : ");
                        String number = sc.nextLine();

                        boolean isValidNum = utils.InputValidator.isNumaric(number);
                        if (!isValidNum) {
                            continue;
                        }

                        try {
                            int parsedIntNumber = Integer.parseInt(number);

                            model.Contact.addContact(name.toLowerCase(), parsedIntNumber, map);
                            isRunning = false;

                        } catch (Exception e) {

                        }

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
