
/*

You are working on an authentication system and there is a set of rules the users have to follow when picking a new password:

1. It has to be at least 16 characters long.
2. The password cannot contain the word "password". This rule is not case-sensitive.
3. The same character cannot be used more than 4 times. This rule is case-sensitive, "a" and "A" are different characters.
4. The password has to contain at least one uppercase and one lowercase letter.
5. The password has to contain at least one of the following special characters "*","#","@".

Write a function that takes in a password and returns a collection of any rule numbers that are not met.

password_1 = "Strongpwd9999#ac"              ==> []
password_2 = "Aess10#"                       ==> [1]
password_3 = "Password@"                     ==> [1,2]
password_4 = "#PassWord011111112222223x"     ==> [2,3]
password_5 = "PASSWORDz#1111111"             ==> [2,3]
password_6 = "aaaapassword$$"                ==> [1,2,3,4,5]
password_7 = "LESS10#"                       ==> [1,4]
password_8 = "SsSSSt#passWord"               ==> [1,2]
password_9 = "SsSSSt#passWordpassword"       ==> [2,3]
password_10 = "aZ*"                          ==> [1]


All test cases:

validate(password_1) ==> []
validate(password_2) ==> [1]
validate(password_3) ==> [1,2]
validate(password_4) ==> [2,3]
validate(password_5) ==> [2,3]
validate(password_6) ==> [1,2,3,4,5]
validate(password_7) ==> [1,4]
validate(password_8) ==> [1,2]
validate(password_9) ==> [2,3]
validate(password_10) ==> [1]


Complexity variables:

N = length of the password

*/


import java.util.*;
import java.util.regex.Pattern;

public class Walmart {

    public static void main(String[] argv) {
        String password_1 = "Strongpwd9999#ac";
        String password_2 = "Aess10#";
        String password_3 = "Password@";
        String password_4 = "#PassWord011111112222223x";
        String password_5 = "PASSWORDz#1111111";
        String password_6 = "aaaapassword$$";
        String password_7 = "LESS10#";
        String password_8 = "SsSSSt#passWord";
        String password_9 = "SsSSSt#passWordpassword";
        String password_10 = "aZ*";

        System.out.println("validate(password_1) ===> " + validate(password_1));
        System.out.println("validate(password_2) ===> " + validate(password_2));
        System.out.println("validate(password_3) ===> " + validate(password_3));
        System.out.println("validate(password_4) ===> " + validate(password_4));
        System.out.println("validate(password_5) ===> " + validate(password_5));
        System.out.println("validate(password_6) ===> " + validate(password_6));
        System.out.println("validate(password_7) ===> " + validate(password_7));
        System.out.println("validate(password_8) ===> " + validate(password_8));
        System.out.println("validate(password_9) ===> " + validate(password_9));
        System.out.println("validate(password_10) ===> " + validate(password_10));
    }

    public static List<Integer> validate(String password) {
        List<Integer> result = new ArrayList<>();

        // rule 1
        if (password.length() < 16) {
            result.add(1);
        }

        // rule 2
        if (password.toLowerCase().contains("password")) {
            result.add(2);
        }

        // rule 3
        Map<Character, Integer> counter = new HashMap<>();
        for (Character c : password.toCharArray()) {
            // System.out.println(c);
            int count = 0;

            if (counter.containsKey(c)) {
                count = counter.get(c);
                if (count >= 4) {
                    result.add(3);
                    break;
                }

                counter.put(c, new Integer(count + 1));
            } else {
                counter.put(c, new Integer(1));
            }

            if (count >= 4) {
                break;
            }
        }

        // rule 4
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        if (!(lowercasePattern.matcher(password).find() && uppercasePattern.matcher(password).find())) {
            result.add(4);
        }

        // rule 5
        if (!(password.contains("*") || password.contains("#") || password.contains("@"))) {
            result.add(5);
        }

        return result;
    }
}


