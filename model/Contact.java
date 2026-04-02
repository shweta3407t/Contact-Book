package model;

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

    public  void display(String name){
        System.out.println("NAME : "+name);
        System.out.println("NUMBER : "+phoneNumber);
        System.out.println("EMAIL : "+eMail);
        System.out.println("---------------------------");
    }

     

    public static void addContact(String name, String phoneNumber, String email, HashMap<String, Contact> map) {
        Contact c = new Contact(phoneNumber, email);
        map.put(name, c);
        System.out.println("------" + name + "  CONTACT  SUCESSFULLY ADDED.------");

    }

    public static void viewContact(HashMap<String, Contact> map) {
        if(map.isEmpty()){ 
            System.out.println("-----NO CONTACT ADDED-----");

        } else {

        for (Map.Entry<String, Contact> e : map.entrySet()) {
            // Contact c=new Contact(null, null);


            e.getValue().display(e.getKey());
 
            

             

             
            
        }}

    }

    public static void searchContact(Scanner sc, String searchContact, HashMap<String, Contact> map) {
        if (map.containsKey(searchContact)) {
             System.out.println("-------CONTACT FOUND.-----");
            map.get(searchContact).display(searchContact);;
            

            System.out.print("ENTER U TO UPDATE CONTACT OR E TO EXIT SEARCH.");
            String uChoice = sc.next();

            // is loop me jaa hi nahi raha hai

            if (uChoice.equalsIgnoreCase("u")) {
                sc.nextLine();

                System.out.print("ENTER UPDATED NAME (LEAVE BLANK TO SKIP) : ");
                String updateName = sc.nextLine();

                System.out.print("ENTER UPDATED CONTACT NUMBER (LEAVE BLANK TO SKIP) : ");
                String updateNumber = sc.nextLine();

                System.out.print("ENTER UPDATED CONTACT NUMBER (LEAVE BLANK TO SKIP) : ");
                String updateEmail = sc.nextLine();

                if ((!updateName.isEmpty() && !updateName.isBlank())
                        && (!updateNumber.isEmpty() && !updateNumber.isBlank())) {
                    // update both
                    updateContact(sc, searchContact, updateName, updateNumber, updateEmail, map);

                } else if (!updateName.isEmpty() || !updateName.isBlank()) {
                    // update name only
                    updateContactName(sc, searchContact, updateName, map);

                } else if (!updateNumber.isEmpty() || !updateNumber.isBlank()) {
                    // update phoneNumber only
                    // int parsedUpdateNumber = Integer.parseInt(updateNumber);
                    updateContactNumber(sc, searchContact, updateNumber, map);
                } else if (!updateEmail.isEmpty() || !updateEmail.isBlank()) {
                    // update email only
                    updateContactNumber(sc, searchContact, updateNumber, map);
                } else {
                    System.out.println("---NOTHING TO UPDATE---");
                }

            } else {
                return;
            }
        } else {
            System.out.println("----CONTACT NOT FOUND.ENTER A TO ADD NEW CONTACT OR E TO EXIT SEARCH-----");
            System.out.print("YOUR CHOICE : ");

            String wantToAdd = sc.next();

            if (wantToAdd.equalsIgnoreCase("a")) {
                System.out.print("ENTER NAME : ");
                String newName = sc.next();

                System.out.println("ENTER NUMBER FOR " + newName + " searchContact");
                String newNumber = sc.nextLine();

                System.out.println("ENTER EMAIL FOR" + newName + " : ");
                String newEmail = sc.nextLine();

                addContact(newName, newNumber, newEmail, map);
            }
        }
    }

    public static void updateContact(Scanner sc, String searchContact, String updateName, String updateNumber,
            String updateEmail,
            HashMap<String, Contact> map) {
        if (map.containsKey(searchContact)) {
            Contact c = new Contact(updateNumber, updateEmail);
            map.replace(updateName, c);

            System.out
                    .println("-----NAME : " + updateName + "\n NUMBER : " + updateNumber + " \n EMAIL : " + updateEmail
                            + " SUCESSFULLY UPDATED.-----");

        }
    }

    public static void updateContactName(Scanner sc, String searchContact, String updateName,
            HashMap<String, Contact> map) {

        if (map.containsKey(searchContact)) {
            Contact c = new Contact(null, null);
            map.replace(updateName, c);
            System.out.println("-----NAME : " + updateName
                    + " SUCESSFULLY UPDATED.-----");
        }

    }

    public static void updateContactNumber(Scanner sc, String searchContact, String updateNumber,
            HashMap<String, Contact> map) {
        if (map.containsKey(searchContact)) {
            Contact c = new Contact(null, updateNumber);
            map.replace(updateNumber, c);
            System.out.println("-----\n NUMBER : " + updateNumber
                    + " SUCESSFULLY UPDATED.-----");

        }
    }

    public static void updateContactEmail(Scanner sc, String searchContact, String updateEmail,
            HashMap<String, Contact> map) {
        if (map.containsKey(searchContact)) {
            Contact c = new Contact(null, updateEmail);
            map.replace(updateEmail, c);
            System.out.println("-----\n EMAIL : " + updateEmail
                    + " SUCESSFULLY UPDATED.-----");

        }
    }

    public static void deleteContact(String searchContact, HashMap<String, Contact> map) {
        map.remove(searchContact);
        if (map.remove(searchContact, map)) {
            System.out.println("----" + searchContact + " CONTACT DELETED.----");
        } else {
            System.out.println("-----CONTACT NOT FOUND----");
        }
    }

}
