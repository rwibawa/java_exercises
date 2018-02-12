/********************************************************************************

 ********************************************************************************/

public class FB {
    public static void main(String[] args) {
        System.out.printf("test");
    }
}

/*
# Given two parameters (your choice of command line args, STDIN, etc) $count and $file
# print out the $count words that occur the most in $file.
#
# For example I might give you the text of a long news article and want to know the
# 3 most frequently occurring words.

$ concordance book.txt 10
the     8230
and     5067
of      4139
to      3651
a       3017
in      2659
it      2082
his     2008
i       1972
that    1950

  // (415) 465-7926

public class TopWords {
  public static void main(String[] args) {
    String filename = args[0];
    int top = args[1];

    File file = new FileStream(filename);
    Scanner scan = new Scanner(file);
    List<KeyValueSet> result = countWords(filename, top);
    result.forEach(k -> System.out.println(k.key + "\t\t" + k.value));
  }

  public List<KeyValueSet> countWords(Scanner scanner, int top) {
    List<KeyValueSet> result = new ArrayList<>();
    Map<String, Integer> dict = new HashMap<>();

    while (scanner.hasNext()) {
      String word = scanner.getString();
      if (dict.contains(word)) {
        Integer counter = dict.get(word);
        counter++;
      } else {
        dict.put(word, new Integer(1));
      }
    }


    Set<KeyValueSet> set = new TreeSet<>();
    dict.forEach(kv -> set.add(kv), (kv1, kv2) -> Integer.compare(kv1, kv2));

    for (int i=0; i < top; i++) {
      result.add(set.get(i));
    }

    return result;
  }

}

# A critical service is being upgraded.
# The old version listens on port A.  The new version listens on port B.
#
# Given a file of hosts being migrated, write a program that will determine how
# far along the migration is. Your program should have special output for hosts
# that are running both versions, and hosts that aren't running any version or are down.

host1
host2

./checker port1 port2 < hosts.txt
port1: 10
port2: 2
fail: 5

public void migrationReport(String filename, int port1, int port2) {
  int port1Counter = 0;
  int port2Counter = 0;
  int failCounter = 0;

 Scanner scanner = new Scanner(filename);
  while (scanner.hasNextLine()) {
    String host = scanner.getString();
    try {
      if (isListening(host, port1) {
        port1Counter++;
        continue;
      }

      if (isListening(host, port2) {
        port2Counter++;
        continue;
      }

      failCounter++;
    } catch (Exception e) {
      failCounter++;
    }
  }

  System.out.println("port1: " + port1Counter + "\n" + "port2: " + port2Counter + "\n" + "fail: " + failCounter);
}

 */