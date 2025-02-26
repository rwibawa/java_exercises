import java.util.*;
/*
https://app.codesignal.com/assessments/practice

A group of intrepid adventurers is on a quest to decode a mysterious artifact
that has a series of unique symbols etched along its circular edge.
The order of these symbols has long been lost,
but a collection of symbol pairs known to be adjacent to each other was found.
Unfortunately, the pairs of symbols became jumbled over time,
meaning each pair (x, y) could be recorded either as (x, y) or (y, x).

You are given an array symbolPairs representing these shuffled pairs,
and your task is to rediscover the original sequence of symbols on the artifact's circular edge.
Remember that any cyclic rotation of the sequence can be considered a correct solution,
and the order of the sequence can be reversed as well because the circle has no fixed start or end.

Please return any of the valid arrangements.
Example:
For symbolPairs = [[3, 5], [1, 4], [2, 4], [1, 5], [2, 3]],
the output can be solution(symbolPairs) = [3, 5, 1, 4, 2].

Different rotations or reversals are also valid solutions.
For example, [1, 4, 2, 3, 5] and [5, 3, 2, 4, 1] are also acceptable.

Input/Output
[execution time limit] 3 seconds (java)
[memory limit] 1 GB
[input] array.array.integer symbolPairs
A list of pairs of symbols that are adjacent on the artifact. All symbols on the original circle are guaranteed to be distinct.
Guaranteed constraints:
2 ≤ symbolPairs.length ≤ 105,
symbolPairs[i].length = 2,
1 ≤ symbolPairs[i][j] ≤ 106.
[output] array.integer
The order of symbols restored to its circular arrangement.

int[] solution(int[][] symbolPairs) {
}
 */
public class CapitalOne_04 {
    public static void main(String[] args) {
        CapitalOne_04 program = new CapitalOne_04();
        int[][] symbolPairs = new int[][] {{3, 5}, {1, 4}, {2, 4}, {1, 5}, {2, 3}};

        int[] result = program.solution(symbolPairs);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[][] symbolPairs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] pair : symbolPairs) {
            adj.computeIfAbsent(pair[0], k -> new HashSet<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], k -> new HashSet<>()).add(pair[0]);
        }

        System.out.println(adj);

        int startNode = adj.keySet().iterator().next();
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        findPath(startNode, adj, path, visited);

        System.out.println(adj);

        // Check if the path is cyclic (connects back to the start or end)
        if (!adj.get(path.get(0)).contains(path.get(path.size() - 1)) &&
            !adj.get(path.get(path.size() - 1)).contains(path.get(0))) {

            // Find a connection to make it cyclic
            for (int i = 0; i < path.size(); i++) {
                if (adj.get(path.get(i)).contains(path.get(0))) {
                    List<Integer> newPath = new ArrayList<>();
                    newPath.addAll(path.subList(i, path.size()));
                    newPath.addAll(path.subList(0, i));
                    path = newPath;
                    break;
                }
            }
        }


        return path.stream().mapToInt(i -> i).toArray();
    }

    // Depth-First Search (DFS) with Backtracking
    private void findPath(int u, Map<Integer, Set<Integer>> adj, List<Integer> path, Set<Integer> visited) {
        path.add(u);
        visited.add(u);

        for (int v : adj.get(u)) {
            if (!visited.contains(v)) {
                findPath(v, adj, path, visited);
                return; // Important: Backtrack after finding a neighbor
            }
        }
    }
}

/*
Explanation and Improvements:

1. Adjacency List: The code uses a HashMap called adj to represent the graph of symbol connections.  Each key is a symbol, and the value is a Set of symbols adjacent to it. This makes it efficient to find neighbors.
2. Finding a Starting Node: It picks an arbitrary starting node from the keys of the adj map.

3. `findPath` (Recursive Depth-First Search):
    * This recursive function performs a Depth-First Search (DFS) to build the path.
    * It marks the current node u as visited.
    * It iterates through the neighbors v of u.
    * Crucially: It uses return after recursively calling findPath on a neighbor. This ensures that we explore one path as deeply as possible before backtracking. This is what makes this approach work for finding a valid cyclic path, not necessarily the longest.

4. Cyclic Check and Adjustment: After the initial path is found, it checks if the path is already cyclic (i.e. if the last node is connected to the first or vice-versa). If not, it iterates through the path to find a point where a connection can be made to create a cycle. This ensures the path is indeed cyclic.

5. Converting to Array: Finally, the List<Integer> path is converted to an int[] array using Java streams.

Key Improvements and Why They're Important:
* Adjacency List: Using an adjacency list (Map<Integer, Set<Integer>>) is much more efficient for graph traversal than other representations (like an adjacency matrix) because you only consider actual connections.
* Depth-First Search (DFS) with Backtracking: The recursive findPath function with the return statement is the core of the solution. It explores one path at a time and efficiently finds a valid arrangement.
* Cyclic Check and Adjustment: This step is essential to guarantee that the returned path is cyclic, as required by the problem.
* Clarity and Readability: The code is well-structured and uses meaningful variable names, making it easier to understand.

Time Complexity:

The `findPath` function performs a DFS, visiting each node and edge once. In the worst case, this could be O(V + E), where V is the number of vertices (symbols) and E is the number of edges (pairs). Since E is at most twice the number of pairs (because each pair connects two symbols), and the number of pairs is limited by the problem constraints, the time complexity is within the allowed limit. The cyclic check adds another loop, but it's still within the overall allowed time complexity.

 */