import java.util.*;
/*
**Timestamp-Based Key-Value Store**

Modify the store so every value is associated with a timestamp. Implement the following:

1. Add a value with a timestamp for a specific key.
2. Retrieve the value associated with a key for the **most recent timestamp on or before** the given timestamp.

**Example:**

1. `put("a", "value1", 1)`
2. `put("a", "value2", 2)`
3. `get("a", 1)` → Returns `"value1"`
4. `get("a", 2)` → Returns `"value2"`
5. `get("a", 3)` → Returns `"value2"`
6. `put("b", "value3", 5)`
7. `get("b", 4)` → Returns `null`

*/

/**
 * Main
 */
public class Adobe {
    public static void main(String[] args) {
        MyMap map = new MyMap();

        map.put("a", "value1", 1);
        map.put("a", "value2", 4);
        System.out.println(map.get("a", 1));
        System.out.println(map.get("a", 2));
        System.out.println(map.get("a", 3));
    }

}

/**
 * MyMap
 */
class MyMap {
    Map<String, List<Entry>> map = new HashMap<>();

    public void put(String key, String value, int timestamp) {
        List<Entry> entryList = map.get(key);
        if (entryList == null) {
            entryList = new ArrayList<>();
        }

        entryList.add(new Entry(key, value, timestamp));
        map.put(key, entryList);
    }

    public String get(String key, int timestamp) {
        List<Entry> entryList = map.get(key);
        if (entryList == null) {
            return null;
        }

        int index = entryList.size() - 1;
        Entry entry = entryList.get(index);
        while (index >= 0 && timestamp <= entry.ts) {
            if (entry.ts < timestamp) {
                return entry.value;
            }

            if (entry.ts == timestamp) {
                return entry.value;
            }

            entry = entryList.get(--index);
        }

        return null;
    }
}

/**
 * Entry
 */
class Entry {
    public String key;
    public String value;
    public int ts;

    public Entry(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        ts = timestamp;
    }
}
