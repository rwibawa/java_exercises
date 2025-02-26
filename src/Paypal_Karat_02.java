/*

    You are running a classroom and suspect that some of your students are passing around the answer
    to a multiple-choice question in 2D grids of letters.
    The word may start anywhere in the grid, and consecutive letters can be
    either immediately below or immediately to the right of the previous letter.

    Given a grid and a word, write a function that returns the location of the word in the grid
    as a list of coordinates. If there are multiple matches, return any one.

    grid1 = [
        ['b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'],
        ['b', 'a', 'c', 'c', 'e', 's', 'c', 'n'],
        ['a', 'l', 't', 'e', 'w', 'c', 'e', 'w'],
        ['a', 'l', 'o', 's', 's', 'e', 'c', 'c'],
        ['w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'],
        ['i', 'b', 'w', 'o', 'w', 'w', 'o', 'w']
    ]

    word1_1 = "access"      # [(1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4)]
    word1_2 = "balloon"     # [(0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (1, 7)]

    word1_3 = "wow"         # [(4, 3), (5, 3), (5, 4)] OR 
                                    # [(5, 2), (5, 3), (5, 4)] OR 
                                    # [(5, 5), (5, 6), (5, 7)]
                                      
    word1_4 = "sec"         # [(3, 4), (3, 5), (3, 6)] OR 
                                    # [(3, 4), (3, 5), (4, 5)]    

    word1_5 = "bbaal"       # [(0, 0), (1, 0), (2, 0), (3, 0), (3, 1)]


    grid2 = [
              ['a'],
            ]
    word2_1 = "a"

    grid3 = [
                ['c', 'a'],
                ['t', 't'],
                ['h', 'a'],
                ['a', 'c'],
                ['t', 'g']
            ]
    word3_1 = "cat"
    word3_2 = "hat"

    grid4 = [
                ['c', 'c', 'x', 't', 'i', 'b'],
                ['c', 'a', 't', 'n', 'i', 'i'],
                ['a', 'x', 'n', 'x', 'p', 't'],
                ['t', 'x', 'i', 'x', 't', 't']
            ]
    word4_1 = "catnip"      # [(1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)] OR
                        # [(0, 1), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)]


    All test cases:

    search(grid1, word1_1) => [(1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4)]
    search(grid1, word1_2) => [(0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (1, 7)]
    search(grid1, word1_3) => [(4, 3), (5, 3), (5, 4)] OR 
                                      [(5, 2), (5, 3), (5, 4)] OR 
                                      [(5, 5), (5, 6), (5, 7)]
    search(grid1, word1_4) => [(3, 4), (3, 5), (3, 6)] OR
                          [(3, 4), (3, 5), (4, 5)]                           
    search(grid1, word1_5) => [(0, 0), (1, 0), (2, 0), (3, 0), (3, 1)]

    search(grid2, word2_1) => [(0, 0)]

    search(grid3, word3_1) => [(0, 0), (0, 1), (1, 1)]
    search(grid3, word3_2) => [(2, 0), (3, 0), (4, 0)]

    search(grid4, word4_1) => [(1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)] OR
                          [(0, 1), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)]

    Complexity analysis variables:

    r = number of rows
    c = number of columns
    w = length of the word
*/

import java.util.*;
import javafx.util.Pair;

public class Paypal_Karat_02 {
    public static void main(String[] argv) {
        char[][] grid1 = {
                {'b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'},
                {'b', 'a', 'c', 'c', 'e', 's', 'c', 'n'},
                {'a', 'l', 't', 'e', 'w', 'c', 'e', 'w'},
                {'a', 'l', 'o', 's', 's', 'e', 'c', 'c'},
                {'w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'},
                {'i', 'b', 'w', 'o', 'w', 'w', 'o', 'w'}
        };
        String word1_1 = "access";
        String word1_2 = "balloon";
        String word1_3 = "wow";
        String word1_4 = "sec";
        String word1_5 = "bbaal";

        System.out.println(search(grid1, word1_1)); // [(1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4)]
        System.out.println(search(grid1, word1_2)); // [(0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (1, 7)]
        System.out.println(search(grid1, word1_3)); // [(4, 3), (5, 3), (5, 4)] or other valid coordinates
        System.out.println(search(grid1, word1_4)); // [(3, 4), (3, 5), (3, 6)] or other valid coordinates
        System.out.println(search(grid1, word1_5)); // [(0, 0), (1, 0), (2, 0), (3, 0), (3, 1)]
    }

    public static List<Pair<Integer, Integer>> search(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                List<Pair<Integer, Integer>> result = new ArrayList<>();
                if (dfs(grid, word, 0, i, j, result)) {
                    return result;
                }
            }
        }
        return Collections.emptyList();
    }

    private static boolean dfs(char[][] grid, String word, int index, int x, int y, List<Pair<Integer, Integer>> result) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != word.charAt(index)) {
            return false;
        }

        result.add(new Pair<>(x, y));
        char temp = grid[x][y];
        grid[x][y] = '#'; // Mark the cell as visited

        boolean found = dfs(grid, word, index + 1, x + 1, y, result) ||
                dfs(grid, word, index + 1, x, y + 1, result);

        grid[x][y] = temp; // Unmark the cell
        if (!found) {
            result.remove(result.size() - 1);
        }
        return found;
    }
}


/*
This code uses a depth-first search (DFS) approach to find the word in the grid.
It starts from each cell in the grid and searches for the word by moving either right or down.
If a match is found, it returns the coordinates of the letters in the grid.

Time and Space Complexity:
* Time Complexity: O(r * c * 2^w), where r is the number of rows, c is the number of columns, and w is the length of the word. In the worst case, you might explore all possible paths (right and down) of length w from each cell in the grid.
* Space Complexity: O(w), primarily due to the recursion depth and the path list, which can store at most w coordinates. The space used by the grid itself is O(r * c), but that's the input and cannot be avoided. If we consider only the additional space used by the algorithm, it's O(w).

 */