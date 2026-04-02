package utils;

public class InputValidator {
    public static boolean isValideName(String name) {
        try {
            if (name.isEmpty() || name.isBlank()) {
                System.out.println("-----CONTACT  NAME SHOULD NOT BE EMPTY-----");
                return false;
            } else if (!name.matches("[a-zA-Z]+$")) {
                System.out.println("-----CONTACT  NAME SHOULD BE IN CHARACTER ONLY----");
                return false;
            }

        } catch (Exception e) {

        }

        return  false;
    }

    public static boolean isNumaric(String number) {

        if (number.isEmpty() || number.isBlank()) {
            System.out.println("-----CONTACT NUMBER SHOULD NOT BE EMPTY-----\n -----TRY AGAIN-----");
            return false;

        } else if (!number.matches("\\d+")) {
            System.out.println("------CONTACT NUMBER SHOULD BE NUMBER ONLY-----\n -----TRY AGAIN----- ");
            return false;

        } else if (number.length() < 10 || number.length() > 10 ) {
            System.out.println("-----CONTACT NUMBER SHOULD BE OF 10 DIGIT.---- \n -----TRY AGAIN-----");
            return   false;

        }

        return   true;

    }



    public static boolean isValideEmail(String  email){
        if( email==null ||  email.isEmpty() ){

            System.out.println("-----CONTACT  EMAIL SHOULD NOT BE EMPTY-----\n -----TRY AGAIN-----");
            return   false;
        }else if(email.contains("@")&& email.contains( ".com"))return true;
         return false;
    }
}
