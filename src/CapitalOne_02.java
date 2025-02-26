/*
https://app.codesignal.com/assessments/practice

Imagine you're part of a team analyzing fictional alien technology logs.
You have a string alienCode, which represents activity codes from their devices.
Your task is to examine this string and count how many substrings of this code
represent numbers evenly divisible by 3.
It's important to note that none of these substrings should start with zero
unless the substring is the character "0" itself.

Note: You are not expected to provide the most optimal solution,
but a solution with time complexity not worse than O(alienCode.length3) will fit within the execution time limit.

Example:
For alienCode = "456", the output should be solution(alienCode) = 3.
Consider all substrings of the given string:
alienCode[0..0] = 4 isn't divisible by 3.
alienCode[1..1] = 5 isn't divisible by 3.
alienCode[2..2] = 6 is divisible by 3.
alienCode[0..1] = 45 is divisible by 3.
alienCode[1..2] = 56 isn't divisible by 3.
alienCode[0..2] = 456 is divisible by 3.
There are 3 substrings that meet the conditions, so the answer is 3.

For alienCode = "6666", the output should be solution(alienCode) = 10.
All substrings are divisible by 3 and have no leading zeros, so the answer is equal to the number of possible substrings, which is 10.
For alienCode = "303", the output should be solution(alienCode) = 5.
alienCode[0..0] = 3 is divisible by 3.
alienCode[1..1] = 0 is divisible by 3.
alienCode[2..2] = 3 is divisible by 3.
alienCode[0..1] = 30 is divisible by 3.
alienCode[1..2] = 03 is divisible by 3, but it has leading zeroes, so we don't count it.
alienCode[0..2] = 303 is divisible by 3.
There are 5 substrings that meet the conditions, so the answer is 5.

Input/Output
[execution time limit] 3 seconds (java)
[memory limit] 1 GB
[input] string alienCode
A string of digits representing alien device activity codes.
Guaranteed constraints:
2 ≤ alienCode.length ≤ 10,
10 ≤ (int)alienCode ≤ 109.
[output] integer
Return the number of substrings that form an integer divisible by 3.

int solution(String alienCode) {
}
 */

import java.math.BigInteger;

public class CapitalOne_02 {
    public static void main(String[] args) {
        CapitalOne_02 program = new CapitalOne_02();
        String alienCode = "303";
        int result = program.solution(alienCode);
        System.out.println(result); // Output: 5
        System.out.println();

        alienCode = "456";
        result = program.solution(alienCode);
        System.out.println(result); // Output: 3
        System.out.println();

        alienCode = "6666";
        result = program.solution(alienCode);
        System.out.println(result); // Output: 10
    }

    int solution(String alienCode) {
        int count = 0;
        for (int i = 0; i < alienCode.length(); i++) {
            for (int j = i; j < alienCode.length(); j++) {
                String sub = alienCode.substring(i, j + 1);
                System.out.println(sub + " (i: " + i + " j: " + j + ")");

                if (sub.length() > 0 && (sub.charAt(0) != '0' || sub.equals("0"))) {
                    try {
                        BigInteger num = new BigInteger(sub);
                        if (num.mod(new BigInteger("3")).equals(BigInteger.ZERO)) {
                            count++;
                        }
                    } catch (NumberFormatException e) {
                        //This handles cases where the substring is too large to fit in an Integer.
                        //Since the max value is 10^9, this shouldn't be needed.
                        e.printStackTrace();
                    }

                }
            }
        }

        return count;
    }
}

/*
Explanation and Improvements:

1. BigInteger for Large Numbers: The original prompt mentions that the input string can represent numbers up to 10^9. While an `int` in Java can hold numbers up to roughly 2 * 10^9, it's safer and clearer to use `BigInteger` to handle potentially large numbers represented by the substrings.  This avoids potential integer overflow issues.
2. Leading Zero Check: The code explicitly checks for leading zeros using `sub.charAt(0) != '0' || sub.equals("0")`.  This ensures that substrings starting with zero are only counted if the substring itself is "0".
3. Substring Generation: The nested loops efficiently generate all possible substrings.
4. Divisibility by 3: The `BigInteger.mod()` method is used to check divisibility by 3. If the remainder is 0, the substring represents a number divisible by 3, and the `count` is incremented.
5. NumberFormatException Handling (Unlikely but Included): The `try-catch` block is included to handle `NumberFormatException`. Although the problem constraints state the numbers won't be larger than what an integer can hold, it's good practice to include it when working with string-to-number conversions in case the constraints change or you're using this code elsewhere.

Time Complexity:

The time complexity of this solution is O(n^2) due to the nested loops, where n is the length of the `alienCode` string. This is within the acceptable time complexity mentioned in the problem description (O(n^3)).
 */