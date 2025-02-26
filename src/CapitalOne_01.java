/*
https://app.codesignal.com/assessments/practice

Imagine a video game where the player controls a character to go through several levels.
The character has an initial health value of initialHealth,
and this value changes as the player goes through levels of the game.

You are given an array of integers deltas, defining each health value change.
Specifically, the ith level (0-indexed) changes the character's current health value by deltas[i].
Note that whenever the current health value becomes less than 0, it immediately gets set to 0. Similarly,
whenever the current health value becomes greater than 100, it immediately gets set to 100.

Your task is to return the character's final health value after the player goes through all levels of the game.
Note: You are not expected to provide the most optimal solution,
but a solution with time complexity not worse than O(deltas.length3) will fit within the execution time limit.

Example:
For initialHealth = 12 and deltas = [-4, -12, 6, 2], the output should be solution(initialHealth, deltas) = 8.

Let's consider each level:
At the beginning, the current health value is currentHealth = initialHealth = 12.
After completing the 0th level, the current health value becomes currentHealth + deltas[0] = 12 + -4 = 8.
After completing the 1st level, the current health value becomes currentHealth + deltas[1] = 8 + -12 = -4, but since the health value cannot be less than 0, it gets set to 0.
After completing the 2nd level, the current health value becomes currentHealth + deltas[2] = 0 + 6 = 6.
After completing the 3rd level, the current health value becomes currentHealth + deltas[2] = 6 + 2 = 8, which is the final answer.

Input/Output
[execution time limit] 3 seconds (java)
[memory limit] 1 GB
[input] integer initialHealth
An integer representing the initial health value of the player.
Guaranteed constraints:
0 ≤ initialHealth ≤ 100.
[input] array.integer deltas
An array of integers representing changes to the current health value after the player completes each level.
Guaranteed constraints:
1 ≤ deltas.length ≤ 100,
-100 ≤ deltas[i] ≤ 100.
[output] integer
An integer representing the final health value of the player.

int solution(int initialHealth, int[] deltas) {
}
 */

public class CapitalOne_01 {
    public static void main(String[] args) {
        CapitalOne_01 program = new CapitalOne_01();
        int initialHealth = 12;
        int[] deltas = {-4, -12, 6, 2};
        int finalHealth = program.solution(initialHealth, deltas);
        System.out.println(finalHealth); // Output: 8
    }

    public int solution(int initialHealth, int[] deltas) {
        int currentHealth = initialHealth;

        for (int delta : deltas) {
            currentHealth += delta;

            if (currentHealth < 0) {
                currentHealth = 0;
            } else if (currentHealth > 100) {
                currentHealth = 100;
            }
        }

        return currentHealth;
    }
}

/*
Explanation:
1. Initialization:
    * `currentHealth` is initialized with the `initialHealth` value.
2. Iterating through Deltas:
    * The code iterates through each `delta` value in the `deltas` array using an enhanced `for` loop (for-each loop). This simplifies the loop and makes it easier to read.
3. Updating Health:
    * Inside the loop, `currentHealth` is updated by adding the current `delta` value.
4. Clamping Health:
    * After updating the health, the code checks if `currentHealth` is less than 0 or greater than 100.
    * If it's less than 0, `currentHealth` is set to 0.
    * If it's greater than 100, `currentHealth` is set to 100. This ensures that the health stays within the valid range.
5. Returning Final Health:
    * After processing all the deltas, the final `currentHealth` value is returned.

Time Complexity:
The code iterates through the `deltas` array once. Therefore, the time complexity is O(n), where n is the length of the `deltas` array. This meets the requirement of not being worse than O(n^3).
 */