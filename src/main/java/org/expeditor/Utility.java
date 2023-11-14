package org.expeditor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Utility class, contains helper method for other classes
 */

public class Utility {

    /**
     * Capitalize each word in a string, removes trailing and leading whitespace
     * @param str string to capitalize and remove whitespace
     * @return a string with each word capitalized and no white space
     */
    public static String capitalizeEachLetter(String str) {
        str = str.trim();
        String[] words = str.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            String trimmed = word.trim();
            capitalized.append(trimmed.substring(0, 1).toUpperCase() + word.substring(1)).append(" ");
        }
        return capitalized.toString().trim();
    }

    /**
     * Sorts a list of Person by last name, and then by first name
     * @param people list of Person
     * @return sorted list of Person
     */
    public static List<Person> sortByLastThenFirstName(List<Person> people) {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int lastNameComparison = p1.getLastName().compareTo(p2.getLastName());

                if (lastNameComparison != 0) {
                    return lastNameComparison;
                }

                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        });
        return people;
    }
}
