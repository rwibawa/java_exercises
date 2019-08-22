import java.util.HashMap;

public class HintMD {
// nums = [4, 5, 7, 1, 9, 2]
// target = 7
// Return the indices of the two numbers that add up to the target number
// Return -1 if no such pair exists

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 2, 5, 1, 9, 33 };
        int target = 7;
//        solution1(nums, target);
        solution2(nums, target);
    }

    private static void solution1(int[] nums, int target) {
        int l = nums.length;
        for (int i=0; i<l-1 ; i++) {
            for (int j=i+1; j<l; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.printf("nums[%d]=%d + nums[%d]=%d, target=%d\n",
                            i, nums[i], j, nums[j], target);
                }
            }
        }
    }

    //    current = 5
    //    target = 7
    // what I'm looking for = (target - current) = 2
/*
    Hashmap<Integer,Integer> numbers =
            (4,0)
            (2,1)
            (5,2)
            (1,3)
            (9,4)
            (33,5)
*/
    private static void solution2(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], i);
        }

        for (int i1 = 0; i1 < nums.length; i1++) {
            int v2 = target - nums[i1];
            Integer i2 = numbers.get(v2);
            if (i2 != null && i2 > i1) {
                System.out.printf("nums[%d]=%d + nums[%d]=%d, target=%d\n",
                    i1, nums[i1], i2, nums[i2], target);
            }
        }
    }

}
