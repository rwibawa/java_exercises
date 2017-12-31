import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        String string = "abcdef";
        System.out.println("The string is " + string);

        // Reverse the string with recursive method.
        String reversedString = solution.reverseString(string);
        System.out.println("The reversed string is " + reversedString);

        String reverseStringUsingStack = solution.reverseStringUsingStack(string);
        System.out.println("The reversed string is " + reverseStringUsingStack);
    }

    private String reverseStringUsingStack(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    public String reverseString(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }

        return s.substring(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }
}
