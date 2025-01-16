import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toMap;

public class WordCount {
    // https://shekhargulati.com/2015/09/19/word-count-example-in-java-8/
    // The better solution is using toMap collector as shown below.
    public static void main(String[] args) throws IOException {
        Map<String, Integer> wordCount =
            Files.lines(Paths.get("src/main/resources/book.txt"))
            .flatMap(line -> Arrays.stream(line.trim().split(" ")))
//            .flatMap(line -> Arrays.stream(line.split("[\s.!]")))
//            .forEach(System.out::println);
            .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
            .collect(toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2));

        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
        System.out.println();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        // list of top 5
        list.stream().limit(5).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));


        /*
        Map<String, Integer> wordCount =
            Arrays.stream(line.split(" "))
            .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
         */
    }

    // Even better version can be written using grouping and counting collector as shown below.
    /*
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/book.txt");
        Map<String, Long> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split("\s")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));

Map wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(“\s”)))
.map(word -> word.replaceAll(“[^a-zA-Z]”, “”).toLowerCase().trim())
.filter(word -> word.length() > 0)
// .map(word -> new SimpleEntry(word, 1))
.collect(groupingBy(word, counting()));

        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

    }
    */
}
