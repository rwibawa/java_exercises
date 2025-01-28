// ------------------------------------
// Find the number of occurrences of the N in the sorted array

// arr = [10, 20, 20, 30, 30, 40, 50]
// N  = 20

// Res: 2

public class FB_3_2_OccuranceCounter {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 30, 30, 40, 50};
        int N = 20;

        int count = countOccurance(arr, N);
        System.out.println("N: " + N + "occurs " + count + " times");
    }

    public static int countOccurance(int[] arr, int N) {
        int count = 0;

        for (int num : arr) {
            if (num == N) {
                count++;
            }
        }
        return count;
    }
}