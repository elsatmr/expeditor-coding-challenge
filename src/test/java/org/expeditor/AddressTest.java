package org.expeditor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
    Address addressA;
    Address addressB;
    Address needToSetSecondAddress;

    @Before
    public void setUp() {
        addressA = new Address("134 spring st.", "St. 130", "seattle", "Wa");
        addressB = new Address("100 Northgate Blvd.", "seattle", "Wa");
        needToSetSecondAddress = new Address("345 3rd Blvd. Apt. 200","Seattle","WA");
    }

    @Test
    public void testCheckFirstLine() {
        assertEquals("Apt. 200", needToSetSecondAddress.getSecondLine());
        assertEquals("345 3rd Blvd.", needToSetSecondAddress.getFirstLine());
    }

    @Test
    public void testGetFirstLine() {
        assertEquals("134 Spring St.", addressA.getFirstLine());
        assertEquals("100 Northgate Blvd.", addressB.getFirstLine());
    }

    @Test
    public void testSetFirstLine() {
        addressA.setFirstLine("2020 Ocean Street");
        assertEquals("2020 Ocean Street", addressA.getFirstLine());
    }

    @Test
    public void testGetSecondLine() {
        assertEquals(null, addressB.getSecondLine());
    }

    @Test
    public void testSetSecondLine() {
        addressB.setSecondLine("Apt. 723");
        assertEquals("Apt. 723", addressB.getSecondLine());
    }

    @Test
    public void testGetCity() {
        assertEquals("Seattle", addressA.getCity());
    }

    @Test
    public void testSetCity() {
        addressA.setCity("Portland");
        assertEquals("Portland", addressA.getCity());
    }

    @Test
    public void testGetState() {
        assertEquals("WA", addressA.getState());
    }

    @Test
    public void testSetState() {
        addressA.setState("OR");
        assertEquals("OR", addressA.getState());
    }

    @Test
    public void testTestEquals() {
        Address mockAddress = new Address("134 spring st.", "St. 130", "seattle", "Wa");
        assertTrue(mockAddress.equals(addressA));
        assertFalse(addressA.equals(addressB));
    }

    @Test
    public void testTestHashCode() {
        Address mockAddress = new Address("134 spring st.", "St. 130", "seattle", "Wa");
        assertTrue(mockAddress.hashCode() == addressA.hashCode());
        assertFalse(addressB.hashCode() == mockAddress.hashCode());
    }

    @Test
    public void testTestToString() {
        assertEquals("134 Spring St., St. 130, Seattle, WA", addressA.toString());
    }
}
