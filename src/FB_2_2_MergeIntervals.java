/*
Given two sorted, non-overlapping interval lists, return a 3rd interval list that is the union of the input interval lists.

For example:
Input:
        {[1,2], [3,9]}  -> [1,2,3,9]
        {[4,6], [8,10], [11,12]} -> [4,6,8,10,11,12]

        => [12]
Output should be:
        {[1,2], [3,10], [11,12]}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FB_2_2_MergeIntervals {
    public static void main(String[] args) {
        List<int[]> list1 = Arrays.asList(new int[]{1, 2}, new int[]{3, 9});
        List<int[]> list2 = Arrays.asList(new int[]{4, 6}, new int[]{8, 10}, new int[]{11, 12});

        List<int[]> result = mergeIntervalLists(list1, list2);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static List<int[]> mergeIntervalLists(List<int[]> list1, List<int[]> list2) {
        List<int[]> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);
        mergedList.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = mergedList.get(0);

        for (int i = 1; i < mergedList.size(); i++) {
            int[] interval = mergedList.get(i);
            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                result.add(currentInterval);
                currentInterval = interval;
            }
        }

        result.add(currentInterval);
        return result;
    }
}
