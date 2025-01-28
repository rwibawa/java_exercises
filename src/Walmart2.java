/*
We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

records1 = [
  ["Paul",     "enter"],
  ["Pauline",  "exit"],
  ["Paul",     "enter"],
  ["Paul",     "exit"],
  ["Martha",   "exit"],
  ["Joe",      "enter"],
  ["Martha",   "enter"],
  ["Steve",    "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Joe",      "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Joe",      "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Joe",      "enter"],
  ["Joe",      "enter"],
  ["Martha",   "exit"],
  ["Joe",      "exit"],
  ["Joe",      "exit"]
]

Expected output: ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]

Other test cases:

records2 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

records3 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

records4 = [
  ["Raj", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
  ["Raj", "enter"],
]

Expected output: ["Raj", "Paul"], ["Paul"]

All Test Cases:
mismatches(records1) => ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]
mismatches(records2) => [], []
mismatches(records3) => ["Paul"], ["Paul"]
mismatches(records4) => ["Raj", "Paul"], ["Paul"]

n: length of the badge records array
*/

import java.io.*;
import java.util.*;

public class Walmart2 {
    public static void main(String[] argv) {
        String[][] records1 = {
                {"Paul", "enter"},
                {"Pauline", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"},
        };

        String[][] records2 = {
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        String[][] records3 = {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        String[][] records4 = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"},
        };

//        List<List<String>> result = mismatches(records1);
        System.out.println("mismatches(records1) => " + mismatches2(records1));
    }

    public static List<List<String>> mismatches(String[][] records) {
        List<List<String>> result = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        result.add(list1);
        result.add(list2);

        Map<String, String[]> badges = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            // System.out.println(records[i][0]);
            String[] item = records[i];
            if (item[1] == "enter") {
                if (badges.containsKey(item[0])) {
                    list1.add(item[0]);
                } else {
                    badges.put(item[0], item);
                }

                // System.out.println(item[0]);
            } else {

            }
        }

        if (!badges.isEmpty()) {
            for (Map.Entry<String, String[]> item : badges.entrySet()) {
                String[] record = item.getValue();
                // System.out.println(record[1]);
                if (record[1] == "enter") {
                    list1.add(item.getKey());
                }
            }
        }

        return result;
    }

    public static List<Set<String>> mismatches2(String[][] records) {
        Set<String> noExit = new HashSet<>();
        Set<String> noEnter = new HashSet<>();
        Map<String, Integer> badgeUsage = new HashMap<>();

        for (String[] record : records) {
            //System.out.println("name: " + record[0] + ", action: " + record[1]);
            String name = record[0];
            String action = record[1];

            if (action.equals("enter")) {
                if (badgeUsage.getOrDefault(name, 0) < 0) {
                    noExit.remove(name);
                }
                badgeUsage.put(name, badgeUsage.getOrDefault(name, 0) + 1);
            } else {
                if (badgeUsage.getOrDefault(name, 0) > 0) {
                    badgeUsage.put(name, badgeUsage.get(name) - 1);
                    if (badgeUsage.get(name) == 0) {
                        badgeUsage.remove(name);
                    }
                } else {
                    noEnter.add(name);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : badgeUsage.entrySet()) {
            if (entry.getValue() > 0) {
                noExit.add(entry.getKey());
            }
        }

        return Arrays.asList(noExit, noEnter);
    }
}
