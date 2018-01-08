import java.util.Arrays;

/* Veeva
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 * Given a list of non-negative integers, find the largest formed number.
 *
 * Example: [25, 55, 2, 42, 4] would return 55442252
 */

public class LargestFormedNumber {
    public static void main(String[] args) {
        //Call method to get largest formed number given an int array or
        //list of non-negative integers.


        // {55, 42, 25, 4, 2} -> Integer sort
        // {55, 4, 42, 25, 2} -> String sort

        // G1 = {55} -> 55
        // G2 = {42, 4} -> 424, 442 -> 442
        // G3 = {25,2} -> 252, 225 -> 252
        // G1+G2+G3 = 55442252

        Integer[] intArray = {25,55,2,42,4};
        Arrays.sort(intArray, (n1, n2) -> {
            Integer c1 = Integer.parseInt(n1.toString() + n2.toString());
            Integer c2 = Integer.parseInt(n2.toString() + n1.toString());
            return Integer.compare(c2, c1);
        });

        System.out.println(intArray.length);

        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
        }

    }
}
