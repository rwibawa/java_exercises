java.util.stream.Collectors is a final utility class that provides a comprehensive set of pre-built reduction operations for Java's Stream API. It allows you to package the elements of a stream into collections, strings, maps, or summarized statistical data.
You pass these implementations directly into the terminal stream operation: .collect(Collectors...).

📦 1. Basic Accumulators (Lists, Sets, Collections)

The most common use case is pulling stream data back out into a standard Java collection.
• toList(): Collects elements into a List. (Note: Java 16+ introduces .toList() directly on the Stream interface as a shorter alternative).
• toSet(): Collects elements into a Set, automatically removing duplicates.
• toCollection(Supplier): Collects elements into a specific type of collection (e.g., ArrayList::new, TreeSet::new).
java
List<String> names = List.of("Alice", "Bob", "Charlie", "Bob");

Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
// Result: [Alice, Bob, Charlie]

TreeSet<String> sortedNames = names.stream()
.collect(Collectors.toCollection(TreeSet::new));
Use code with caution.

🗺️ 2. Key-Value Mapping (toMap)

Transforms streams into a Map. It requires a function for the key and a function for the value.
• toMap(keyMapper, valueMapper): Throws an IllegalStateException if duplicate keys are found.
• toMap(keyMapper, valueMapper, mergeFunction): Safely handles duplicate keys by using a merge rule.
java
List<String> frameworkList = List.of("Spring", "React", "Angular");

// Basic mapping (String -> String Length)
Map<String, Integer> map = frameworkList.stream()
.collect(Collectors.toMap(f -> f, String::length));

// Handling duplicates with a merge function (keeps the longer string)
List<String> duplicates = List.of("Apple", "Apricot", "Banana");
Map<Character, String> safeMap = duplicates.stream()
.collect(Collectors.toMap(
s -> s.charAt(0),
s -> s,
(existing, replacement) -> existing.length() >= replacement.length() ? existing : replacement
));
// Result: {A=Apricot, B=Banana}
Use code with caution.

📊 3. Grouping, Partitioning & Summarizing

These tools are ideal for data classification and analytical reporting.
• groupingBy(classifier): Groups elements into a Map<K, List<T>> based on a property, similar to SQL's GROUP BY.
• partitioningBy(predicate): A special case of grouping that splits data into exactly two groups: true and false.
• summarizingInt/Long/Double: Extracts statistics (min, max, average, sum, count) in a single pass.
java
List<String> items = List.of("Apple", "Banana", "Avocado", "Cherry");

// Grouping by starting letter
Map<Character, List<String>> grouped = items.stream()
.collect(Collectors.groupingBy(s -> s.charAt(0)));
// Result: {A=[Apple, Avocado], B=[Banana], C=[Cherry]}

// Partitioning by string length > 5
Map<Boolean, List<String>> partitioned = items.stream()
.collect(Collectors.partitioningBy(s -> s.length() > 5));
// Result: {false=[Apple], true=[Banana, Avocado, Cherry]}

// Full statistics summary
IntSummaryStatistics stats = items.stream()
.collect(Collectors.summarizingInt(String::length));
System.out.println(stats.getAverage()); // Tracks average length
Use code with caution.

🧵 4. Text Manipulation & Arithmetic

Quick transformations for formatting output strings or making math calculations directly.
• joining(): Merges stream elements into a single String.
• joining(delimiter, prefix, suffix): Formats the string with separation rules.
• counting(): Counts elements (often nested inside a groupingBy).
• averagingInt / summingInt: Calculates averages or totals.
java
List<String> words = List.of("Java", "Stream", "API");

String csv = words.stream().collect(Collectors.joining(", ", "[", "]"));
// Result: "[Java, Stream, API]"
Use code with caution.

🔗 5. Downstream Collectors (Nested Operations)

Many collector methods accept a second collector as an argument. This allows you to perform secondary reductions on grouped items.
java
List<String> namesList = List.of("Alice", "Bob", "Charlie", "Anna");

// Group by first letter, then COUNT the occurrences in each group
Map<Character, Long> countsPerLetter = namesList.stream()
.collect(Collectors.groupingBy(
s -> s.charAt(0),
Collectors.counting() // Downstream collector
));
// Result: {A=2, B=1, C=1}
Use code with caution.
Would you like to explore how to build a custom Collector for an unsupported collection type, or are you working on a nested data transformation that you need help writing?
