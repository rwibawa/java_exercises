import java.util.Stack;

/********************************************************************************
 * Copyright (c) 2018 Ryan Wibawa. All rights reserved.                         *
 *                                                                              *
 * The copyright to the computer software herein is the property of Ryan Wibawa.*
 * The software may be used and/or copied only with the written permission of   *
 * Ryan Wibawa or in accordance with the terms and conditions stipulated in the *
 * agreement/contract under which the software has been supplied.               *
 ********************************************************************************/

public class WelformedParentheses {
    public static void main(String[] args) {
        // "(())()" -> welformed
        // "())" -> BAD

        WelformedParentheses solution = new WelformedParentheses();
        String str = "())";
        System.out.println(str + "is " + solution.isWelformed(str));
    }

    private Boolean isWelformed(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (c.equals('(')) {
                stack.push(c);
                continue;
            }

            if (c.equals(')')) {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
