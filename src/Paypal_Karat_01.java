/*
You are running a classroom and suspect that some of your students are passing around
the answer to a multiple-choice question disguised as a random note.

Your task is to write a function that, given a list of words and a note, finds
and returns the word in the list that is scrambled inside the note, if any exists.
If none exist, it returns the result "-" as a string. There will be at most one matching word.
The letters don't need to be in order or next to each other. The letters cannot be reused.

Example:
words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"]
note1 = "ctay"
find(words, note1) => "cat"(the letters do not have to be in order)

note2 = "bcanihjsrrrferet"
find(words, note2) => "cat"(the letters do not have to be together)

note3 = "tbaykkjlga"
find(words, note3) => "-"(the letters cannot be reused)

note4 = "bbbblkkjbaby"
find(words, note4) => "baby"

note5 = "dad"
find(words, note5) => "-"

note6 = "breadmaking"
find(words, note6) => "bird"

note7 = "dadaa"
find(words, note7) => "dada"

All Test Cases:
find(words, note1) -> "cat"
find(words, note2) -> "cat"
find(words, note3) -> "-"
find(words, note4) -> "baby"
find(words, note5) -> "-"
find(words, note6) -> "bird"
find(words, note7) -> "dada"

Complexity analysis variables:

W = number of words in `words` -> O(W * S)
S = maximal length of each word or of the note -> O(S)
*/

import java.util.HashMap;
import java.util.Map;

public class Paypal_Karat_01 {

    public static void main(String[] argv) {
        String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
        String note1 = "ctay";
        String note2 = "bcanihjsrrrferet";
        String note3 = "tbaykkjlga";
        String note4 = "bbbblkkjbaby";
        String note5 = "dad";
        String note6 = "breadmaking";
        String note7 = "dadaa";

        System.out.println(find(words, note1)); // "cat"
        System.out.println(find(words, note2)); // "cat"
        System.out.println(find(words, note3)); // "-"
        System.out.println(find(words, note4)); // "baby"
        System.out.println(find(words, note5)); // "-"
        System.out.println(find(words, note6)); // "bird"
        System.out.println(find(words, note7)); // "dada"

    }

    public static String find(String[] words, String note) {
        for (String word : words) {
            if (canFormWord(word, note)) {
                return word;
            }
        }

        return "-";
    }

    private static boolean canFormWord(String word, String note) {
        if (word.length() > note.length()) {
            return false; // Optimization: Word can't be longer than the note
        }

        Map<Character, Integer> noteCharCounts = getCharacterCounts(note);
        Map<Character, Integer> wordCharCounts = getCharacterCounts(word);

        for (char c : wordCharCounts.keySet()) {
            if (!noteCharCounts.containsKey(c) || noteCharCounts.get(c) < wordCharCounts.get(c)) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> getCharacterCounts(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        return charCounts;
    }

}

/*
Explanation and Improvements:
1. Character Counting: The `getCharacterCounts` method efficiently counts the occurrences of each character in a string using a `HashMap`.  This is much faster than repeatedly searching the string.
2. canFormWord Method: This method checks if a word can be formed from the characters in the note.  It first does a quick check: if the word is longer than the note, it can't possibly be formed. Then it compares the character counts.  If the note has fewer occurrences of a character than the word, the word cannot be formed.
3. `find` Method: This method iterates through the words and calls `canFormWord` for each word.  It returns the first matching word or "-" if no match is found.
4. Early Exit Optimization: The `canFormWord` method includes an early exit optimization.  If the word is longer than the note, it immediately returns `false`. This avoids unnecessary character counting.
5. Clarity and Readability: The code is well-structured and uses descriptive variable names, making it easier to understand.
6. Efficiency: Using HashMaps for character counting makes the comparison process much more efficient than repeated string searches.  The time complexity is now closer to O(W * S) where W is the number of words, and S is the maximum length of the string.

 */