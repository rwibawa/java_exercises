import java.util.*;

/********************************************************************************
 * Copyright (c) 2018 Ryan Wibawa. All rights reserved.                         *
 *                                                                              *
 * The copyright to the computer software herein is the property of Ryan Wibawa.*
 * The software may be used and/or copied only with the written permission of   *
 * Ryan Wibawa or in accordance with the terms and conditions stipulated in the *
 * agreement/contract under which the software has been supplied.               *
 ********************************************************************************/

public class DuplicatedNames {
    // TODO: The APP is not working yet. It needs some more debugging.
    private static String DICTIONARY = "robert, bob\nnate, nathan nathaniel\nrichard, dick";

    private static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    private static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        String[] firstNames = new String[]
                { "robert", "bob", "robert", "bob", "nate", "nathan", "nathaniel", "ralph", "lucas", "remy"};
        String[] lastNames = new String[]
                { "jones", "jones", "smith", "smith", "mcDaniel", "mcDaniel", "mcDaniel", "green", "black", "white"};
        for (int i = 0; i < firstNames.length; i++) {
            Person person = new Person(firstNames[i], lastNames[i]);
            persons.add(person);
        }

        return persons;
    }

    public static void main(String[] args) {
        List<Person> persons = getPersons();
        for (Person person : persons) {
            System.out.println("FirstName: " + person.getFirstName() + ", LastName: " + person.getLastName());
        }

        List<List<Person>> duplicatedPersons = getDuplicatedNames(persons);
        duplicatedPersons.forEach(d -> {
            System.out.println("\nCluster:\n");
            d.forEach(p -> System.out.println(p.getLastName() + ", " + p.getFirstName()));
        });
    }

    private static List<List<Person>> getDuplicatedNames(List<Person> persons) {
        List<List<Person>> result = new ArrayList<>();
        String[] shortNames = DICTIONARY.split("\n");
        for (String name : shortNames) {
            System.out.println(name);
        }

        Map<String, Map<String, List<Person>>> groupByFN = new HashMap<>();
        persons.forEach(person -> {
            String name = Arrays.stream(shortNames).filter(n -> n.contains(person.getFirstName())).findFirst().get();
            if (name == null) {
                return;
            }

            Map<String, List<Person>> groupByLastName;
            if (groupByFN.containsKey(name)) {
                groupByLastName = groupByFN.get(name);
            } else {
                groupByLastName = new HashMap<>();
            }

            List<Person> sameLastNames;
            if (groupByLastName.containsKey(person.getLastName())) {
                sameLastNames = groupByLastName.get(person.getLastName());
            } else {
                sameLastNames = new ArrayList<>();
            }

            sameLastNames.add(person);
        });

        groupByFN.values().forEach(groupByLastName -> {
            groupByLastName.values().forEach(g -> {
                if (g.size() > 1) {
                    result.add(g);
                }
            });
        });

        return result;
    }
}
