import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicate2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6,
            -1);

        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicates =
            numbers.stream()
            .filter(n -> !seen.add(n))
            .collect(Collectors.toSet());

        System.out.println(duplicates);

        List<String> names = List.of("Alice", "Bob", "Charlie", "Bob");

        Set<String> uniqueNames = new HashSet<>(names);
        // names.stream().collect(Collectors.toSet());
        // Result: [Alice, Bob, Charlie]
        System.out.println(uniqueNames);

        TreeSet<String> sortedNames = new TreeSet<>(names);
        // names.stream()
        //    .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(sortedNames);

    }
}
