/*
https://app.codesignal.com/assessments/practice

Given a matrix of integers, with each element containing either 0, 1, or 2,
your task is to find the longest diagonal segment
which matches the following pattern: 1, 2, 0, 2, 0, 2, 0, ...
(where the first element is 1, and then 2 and 0 are repeating infinitely),
and return the length of this diagonal segment.

The diagonal segment:
May start and end at any matrix element
May go toward any possible diagonal direction

See the example videos below.
Note: You are not expected to provide the most optimal solution,
but a solution with time complexity not worse than
O(matrix.length2 · matrix[0].length2) will fit within the execution time limit.

Example:
For matrix = [
    [0, 0, 1, 1],
    [2, 2, 2, 0],
    [2, 1, 0, 1]
]
the output should be solution(matrix) = 3.

Expand to see the example video.
Note: If you are not able to see the video, use this link to access it.

Diagonal segments should start from an element containing 1,
and there are three such elements in the given matrix.
For each of these elements, try to go in all four diagonal directions
until the pattern 1, 2, 0, 2, 0, ... breaks or a matrix border is reached,
and update the best result (count of longest segment) if applicable.

For matrix = [
    [2, 1, 2, 2, 0],
    [0, 2, 0, 2, 0],
    [0, 0, 0, 0, 0],
    [0, 2, 2, 2, 2],
    [2, 1, 2, 2, 1],
    [0, 2, 0, 0, 2]
]
the output should be solution(matrix) = 4.

Expand to see the example video.
Note: If you are not able to see the video, use this link to access it.

There are four elements containing 1 in this matrix,
so four possible starting points for diagonal segments.
Try starting from all of these elements one by one,
and moving in all directions to find the longest possible diagonal segment
which matches the specified pattern.

Input/Output
[execution time limit] 3 seconds (java)
[memory limit] 1 GB
[input] array.array.integer matrix
A matrix consisting of integers 0, 1, and/or 2.
Guaranteed constraints:
1 ≤ matrix.length ≤ 100,
1 ≤ matrix[i].length ≤ 100,
0 ≤ matrix[i][j] ≤ 2.
[output] integer
The length of the longest diagonal segment within the matrix
which matches the following pattern: 1, 2, 0, 2, 0, 2, 0, ....

int solution(int[][] matrix) {
}
 */
public class CapitalOne_03 {
    public static void main(String[] args) {
        CapitalOne_03 program = new CapitalOne_03();

        int[][] matrix = {
            {0, 0, 1, 1},
            {2, 2, 2, 0},
            {2, 1, 0, 1}
        };
        int result = program.solution(matrix);
        System.out.println(result); // Output: 3

        matrix = new int[][]{
            {2, 1, 2, 2, 0},
            {0, 2, 0, 2, 0},
            {0, 0, 0, 0, 0},
            {0, 2, 2, 2, 2},
            {2, 1, 2, 2, 1},
            {0, 2, 0, 0, 2}
        };
        result = program.solution(matrix);
        System.out.println(result); // Output: 4
    }


    public int solution(int[][] matrix) {
        int maxLen = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Diagonal directions: up-left, up-right, down-left, and down-right.
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    for (int[] dir : directions) {
                        int len = 0;
                        int r = i;
                        int c = j;
                        int expected = 1;

                        while (
                            r >= 0 && r < rows &&
                            c >= 0 && c < cols &&
                            matrix[r][c] == expected)
                        {
                            len++;

                            r += dir[0];
                            c += dir[1];

                            if (expected == 1) {
                                expected = 2;
                            } else if (expected == 2) {
                                expected = 0;
                            } else {
                                expected = 2;
                            }

                        }

                        maxLen = Math.max(maxLen, len);
                    }
                }
            }
        }

        return maxLen;
    }
}

/*
Explanation and Improvements:

1. Directions Array:  The `directions` array stores the four possible diagonal movement directions: up-left, up-right, down-left, and down-right.
2. Iterating through Matrix: The code iterates through each cell of the matrix using nested loops.
3. Checking for Starting '1': It checks if the current cell's value is 1, as diagonal segments must start with 1.
4. Iterating through Directions: If a '1' is found, it then iterates through all four diagonal directions.
5. `len` and `expected` Variables:
    * `len` keeps track of the current diagonal segment's length.
    * `expected` stores the next value expected in the pattern (1, 2, 0, 2, 0...). It starts with 1.
6. `while` Loop for Diagonal Traversal: The `while` loop continues as long as:
    * The current row and column are within the matrix bounds.
    * The current cell's value matches the `expected` value.
7. Updating `len`, `r`, `c`, and `expected`: Inside the loop:
    * `len` is incremented.
    * The row (`r`) and column (`c`) are updated based on the current direction.
    * `expected` is updated to the next value in the 1, 2, 0, 2, 0... pattern.
8. Updating `maxLen`: After the `while` loop finishes (either the pattern breaks or the boundary is reached), the `maxLen` is updated with the maximum length found so far using `Math.max()`.
9. Return `maxLen`: Finally, the function returns the `maxLen`, which represents the length of the longest diagonal segment found.

Time Complexity:

The code iterates through each cell of the matrix (O(rows * cols)).
For each cell, it checks all four diagonal directions. In the worst case, the `while` loop inside can iterate up to `Math.max(rows, cols)` times. Therefore, the overall time complexity is O(rows * cols * Math.max(rows, cols)), which simplifies to O(rows^2 * cols^2) in the worst case (when rows and cols are roughly equal). This meets the requirement of not being worse than O(matrix.length^2 * matrix[0].length^2).

 */