
import java.util.*;
import java.util.stream.Collectors;

public class WordCount2 {
    public static void main(String[] args) {
        String line = "lorem ipsum dolor sit amet lorem ipsum lorem dolor";
        // Arrays.stream(line.trim().split(" "))
        //     .forEach(System.out::println);

        Map<String, Long> frequency =
            Arrays.stream(line.trim().split(" "))
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(frequency);
    }
}
