package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contact {

    String phoneNumber;
    String eMail;

    public Contact(String phoneNumber, String eMail) {
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public void display(String name) {
        System.out.println("NAME : " + name);
        System.out.println("NUMBER : " + phoneNumber);
        System.out.println("EMAIL : " + eMail);
        System.out.println("---------------------------");
    }

    public static void addContact(HashMap<String, Contact> map, String name, String phoneNumber, String email) {
        Contact c = new Contact(phoneNumber, email);
        map.put(name, c);
        System.out.println("------" + name + "  CONTACT  SUCESSFULLY ADDED.------");

    }

    public static void viewContact(HashMap<String, Contact> map) {
        if (map.isEmpty()) {
            System.out.println("-----NO CONTACT ADDED-----");

        } else {

            for (Map.Entry<String, Contact> e : map.entrySet()) {
                if (e.getValue() != null) {
                    e.getValue().display(e.getKey());

                } else {
                    System.out.println("ERROR CONTACT IS NULL FOR" + e.getKey());
                }

            }
        }

    }

    public static void searchContact(HashMap<String, Contact> map, Scanner sc, String searchContact) {
        if (map.containsKey(searchContact)) {
            System.out.println("-------CONTACT FOUND.-----");
            map.get(searchContact).display(searchContact);

            System.out.print("ENTER U TO UPDATE CONTACT OR E TO EXIT SEARCH.");
            String uChoice = sc.next();
            sc.nextLine();

            boolean isCorrectInput = true;
            while (isCorrectInput) {

                if (uChoice.equalsIgnoreCase("u")) {

                    System.out.print("ENTER UPDATED NAME (LEAVE BLANK TO SKIP) : ");
                    String updateName = sc.nextLine();

                    System.out.print("ENTER UPDATED NUMBER (LEAVE BLANK TO SKIP) : ");
                    String updateNumber = sc.nextLine();

                    System.out.print("ENTER UPDATED EMAIL (LEAVE BLANK TO SKIP) : ");
                    String updateEmail = sc.nextLine();

                    if ((!updateName.isBlank() && !updateNumber.isBlank() && !updateEmail.isBlank())) {

                        // update all
                        updateContact(map, sc, searchContact, updateName, updateNumber, updateEmail);

                    }
                    if (!updateName.isEmpty() && !updateName.isBlank()) {
                        boolean isValidName = utils.InputValidator.isValideUpdateName(updateName);
                        if (!isValidName) {
                            continue;
                        }

                        // update name only
                        updateContactName(map, sc, searchContact, updateName);

                    }
                    if (!updateNumber.isEmpty() && !updateNumber.isBlank()) {
                        boolean isValidNum = utils.InputValidator.isValideUpdateNumber(updateNumber);
                        if (isValidNum) {
                        continue;
                        }

                        // update phoneNumber only
                        updateContactNumber(map, sc, searchContact, updateNumber);
                    }
                    if (!updateEmail.isEmpty() && !updateEmail.isBlank()) {

                        boolean isValidEmail = utils.InputValidator.isValideUpdateEmail(updateEmail);
                        if (isValidEmail) {
                        continue;
                        }

                        // update email only
                        updateContactNumber(map, sc, searchContact, updateEmail);
                    }

                    isCorrectInput = false;

                } else {
                    return;
                }
            }

        } else {
            System.out.println("----CONTACT NOT FOUND.ENTER A TO ADD NEW CONTACT OR E TO EXIT SEARCH-----");
            System.out.print("YOUR CHOICE : ");

            String wantToAdd = sc.next();

            boolean isCorrectInput = true;
            while (isCorrectInput) {
                if (wantToAdd.equalsIgnoreCase("a")) {
                    // name
                    System.out.println("ENTER NAME : " + searchContact);

                    // number
                    System.out.print("ENTER NUMBER FOR " + searchContact + " : ");
                    String newNumber = sc.nextLine();
                    boolean isValidNum = utils.InputValidator.isNumaric(newNumber);
                    if (!isValidNum) {
                        continue;
                    }

                    // email
                    System.out.print("ENTER EMAIL FOR " + searchContact + " : ");
                    String newEmail = sc.nextLine();
                    boolean isValide = utils.InputValidator.isValideEmail(newEmail);
                    if (!isValide) {
                        System.out.println("-----EMAIL SHOULD CONTAIN @ AND .com----TRY AGAIN----");
                        continue;
                    }
                    System.out.println();

                    addContact(map, searchContact, newNumber, newEmail);
                    isCorrectInput = false;
                } else {
                    return;
                }
            }
        }
    }

    public static void updateContact(HashMap<String, Contact> map, Scanner sc, String searchContact, String updateName,
            String updateNumber,
            String updateEmail) {

        if (map.containsKey(searchContact)) {

            Contact c = map.get(searchContact);
            map.remove(searchContact);

            c.phoneNumber = updateNumber;
            c.eMail = updateEmail;
            map.put(updateName, c);

            System.out
                    .println("-----NAME : " + updateName + "\n NUMBER : " + updateNumber + " \n EMAIL : " + updateEmail
                            + " SUCESSFULLY UPDATED.-----");

        }

    }

    public static void updateContactName(HashMap<String, Contact> map, Scanner sc, String searchContact,
            String updateName) {
        

        if (map.containsKey(searchContact)) {
             

            Contact c = map.get(searchContact);
            map.remove( searchContact);
            map.put(updateName.toLowerCase(), c);
 
            System.out.println("\n-----NAME : " + updateName
                    + " SUCESSFULLY UPDATED.-----");
        }
         
    }

    public static void updateContactNumber(HashMap<String, Contact> map, Scanner sc, String searchContact,
            String updateNumber) {

        if (map.containsKey(searchContact)) {

            Contact c = map.get(searchContact);
            c.phoneNumber = updateNumber;
            
            System.out.println("\n-----NUMBER : " + updateNumber
                    + " SUCESSFULLY UPDATED.-----");

        }
    }

    public static void updateContactEmail(HashMap<String, Contact> map, Scanner sc, String searchContact,
            String updateEmail) {
        if (map.containsKey(searchContact)) {
            Contact c = map.get(searchContact);
            c.eMail = updateEmail;
            
           
            System.out.println("\n-----EMAIL : " + updateEmail
                    + " SUCESSFULLY UPDATED.-----");

        }
    }

    public static void deleteContact(HashMap<String, Contact> map, String searchContact) {

        if (map.remove(searchContact, map)) {
            map.remove(searchContact);
            System.out.println("----" + searchContact + " CONTACT DELETED.----");
        } else {
            System.out.println("-----CONTACT NOT FOUND----");
        }
    }

}
