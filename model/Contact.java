package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contact {
    public static void addContact(String name, Integer number, HashMap<String, Integer> map) {
        map.put(name, number);
        System.out.println("------" + name + "  CONTACT  SUCESSFULLY ADDED.------");

    }

    public static void viewContact(HashMap<String, Integer> map) {

        for (Map.Entry<String, Integer> e : map.entrySet()) {

            System.out.print(e.getKey() + " : ");
            System.out.println(e.getValue());
        }

    }

    public static void searchContact(Scanner sc, String contact, HashMap<String, Integer> map) {
        if (map.containsKey(contact)) {
            int value = map.get(contact);
            System.out.println("-------CONTACT FOUND.-----");
            System.out.println("NAME : " + contact + " AND CONTACT NUMBER : " + value);

            System.out.print("ENTER U TO UPDATE CONTACT OR E TO EXIT SEARCH.");
            String uChoice = sc.nextLine();

            if (uChoice.equalsIgnoreCase("u")) {
                sc.nextLine();

                System.out.print("ENTER UPDATED NAME (LEAVE BLANK TO SKIP) : ");
                String updateName = sc.nextLine();
 
                System.out.print("ENTER UPDATED CONTACT NUMBER (LEAVE BLANK TO SKIP) : ");
                String updateNumber = sc.nextLine();
 
                if ((!updateName.isEmpty() && !updateName.isBlank())
                        && (!updateNumber.isEmpty() && !updateNumber.isBlank())) {
                    // update both
                    int parsedUpdateNumber = Integer.parseInt(updateNumber);
                    updateContact(sc, contact, updateName, parsedUpdateNumber, map);

                } else if (!updateName.isEmpty() || !updateName.isBlank()) {
                    // update name only
                    updateContact(sc, contact, updateName, null, map);

                } else if (!updateNumber.isEmpty() || !updateNumber.isBlank()) {
                    // update number only
                    int parsedUpdateNumber = Integer.parseInt(updateNumber);
                    updateContact(sc, contact, null, parsedUpdateNumber, map);
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

                System.out.println("ENTER NUMBER FOR " + newName + " contact");
                Integer newNumber = sc.nextInt();

                addContact(newName, newNumber, map);
            }
        }
    }

    public static void updateContact(Scanner sc, String contact, String updateName, Integer updateNumber,
            HashMap<String, Integer> map) {

        int oldContact = map.get(contact);

        if (updateName != null) {
            map.put(updateName, oldContact);
            map.remove(contact);
        } else if (updateNumber != null) {
            map.replace(contact, updateNumber);
        }
        System.out.println("-----NAME : " + updateName + "AND NUMBER : " + updateNumber + " SUCESSFULLY UPDATED.-----");
    }

    public static void deleteContact(String contact, HashMap<String, Integer> map) {
        map.remove(contact);
        if(map.remove(contact, map)){
        System.out.println("----" + contact + " CONTACT DELETED.----");
        }else{
            System.out.println("-----CONTACT NOT FOUND----");
        }
    }

}
