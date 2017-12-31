/*
* Write a method to check if a string is a palindrome.
*/

public class Palindrome {
    public static void main(String[] args) {
        Palindrome solution = new Palindrome();
        String str = "radar";

        if (solution.isPalindrome(str)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }

    private boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        // System.out.println(sb.reverse().toString());

        return sb.reverse().toString().equals(str);
    }
}
