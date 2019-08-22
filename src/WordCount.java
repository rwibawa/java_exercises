import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

//import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toMap;

public class WordCount {
    // https://shekhargulati.com/2015/09/19/word-count-example-in-java-8/
    // The better solution is using toMap collector as shown below.
    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("src/main/resources/book.txt");
        String line = "lorem ipsum dolor sit amet";
        Map<String, Integer> wordCount =
//                Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split("s")))
                Arrays.stream(line.split(" "))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2));

        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
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
