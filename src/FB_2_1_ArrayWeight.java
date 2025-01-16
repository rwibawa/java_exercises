/*
 *Imagine an array that contains both integers and nested arrays, such as the following: [8, 4, [5, [9], 3], 6]. The depth sum is described as the weighted sum of each integer, weighted by their respective depths. In the example, 8's depth is 1, while 9's is 3.

Given such an array, calculate its depth sum.

For example:


Input: [4, [5, 6]]

Output: 4 + 2 * 5 + 2 * 6 = 26

Input: [8, 4, [5, [9], 3], 6]

Output: 8 + 4 + 2 * 5 + 3 * 9 + 2 * 3 + 6 = 61
 */

import java.util.ArrayList;
import java.util.List;

public class FB_2_1_ArrayWeight {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        list1.add(4);

        List<Object> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);

        list1.add(list2);

        System.out.println("Depth sum: " + depthSum(list1, 1));

        List<Object> list3 = new ArrayList<>();
        list3.add(8);
        list3.add(4);

        List<Object> list4 = new ArrayList<>();
        list4.add(5);

        List<Object> list5 = new ArrayList<>();
        list5.add(9);

        list4.add(list5);
        list4.add(3);

        list3.add(list4);
        list3.add(6);

        System.out.println("Depth sum: " + depthSum(list3, 1));
    }

    public static int depthSum(List<Object> list, int depth) {
        int result = 0;
        for (Object item : list) {
            if (item instanceof List) {
                result += depthSum((List<Object>) item, depth + 1);
            } else {
                result += (int) item * depth;
            }
        }

        return result;
    }
}
