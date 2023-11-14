package org.expeditor;

import static org.expeditor.Utility.capitalizeEachLetter;
import static org.expeditor.Utility.sortByLastThenFirstName;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilityTest {
    String address = " 120 main street ";

    @Test
    public void testCapitalizeEachLetter() {
        String output = capitalizeEachLetter(address);
        assertEquals(output, "120 Main Street"); // white space removed and capitalized
    }

    @Test
    public void testSortByLastThenFirstName() {
        Address addressA = new Address("134 spring st.", "St. 130", "seattle", "Wa");
        Address addressB = new Address("100 Northgate Blvd.", "seattle", "Wa");
        Person personA = new Person("Elsa", "Tamara", "26", addressA);
        Person personB = new Person("Elsa", "Apple", "26", addressA);
        Person personC = new Person("Apple", "Lamb", "30", addressB);
        List<Person> people = new ArrayList<>();
        people.add(personC);
        people.add(personA);
        people.add(personB);
        people = sortByLastThenFirstName(people);
        assertEquals("Apple", people.get(0).getLastName());
        assertEquals("Lamb", people.get(1).getLastName());
        assertEquals("Tamara", people.get(2).getLastName());
    }
}
