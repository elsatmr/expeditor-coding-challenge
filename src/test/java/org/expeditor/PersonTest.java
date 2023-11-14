package org.expeditor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    Person personA;
    Address addressA;
    Address addressB;

    @Before
    public void setUp() {
        addressA = new Address("134 spring st.", "St. 130", "seattle", "Wa");
        addressB = new Address("100 Northgate Blvd.", "seattle", "Wa");
        personA = new Person("Elsa", "Tamara", "26", addressA);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Elsa", personA.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        personA.setFirstName("Mary");
        assertEquals("Mary", personA.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Tamara", personA.getLastName());
    }

    @Test
    public void testSetLastName() {
        personA.setLastName("Lamb");
        assertEquals("Lamb", personA.getLastName());
    }

    @Test
    public void testGetAge() {
        assertEquals(26, personA.getAge());
    }

    @Test
    public void testSetAge() {
        personA.setAge(27);
        assertEquals(27, personA.getAge());
    }

    @Test
    public void testGetAddress() {
        assertEquals("134 Spring St.", personA.getAddress().getFirstLine());
        assertEquals("St. 130", personA.getAddress().getSecondLine());
        assertEquals("Seattle", personA.getAddress().getCity());
        assertEquals("WA", personA.getAddress().getState());
    }

    @Test
    public void testSetAddress() {
        personA.setAddress(addressB);
        assertEquals("100 Northgate Blvd.", personA.getAddress().getFirstLine());
    }

    @Test
    public void testTestToString() {
        assertEquals("Tamara Elsa, 26, 134 Spring St., St. 130, Seattle, WA", personA.toString());
    }
}
