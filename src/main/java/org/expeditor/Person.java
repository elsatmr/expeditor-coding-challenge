package org.expeditor;

import static org.expeditor.Utility.capitalizeEachLetter;

/**
 * Represents a person
 */

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;

    /**
     * Constructor for a person
     * @param firstName first name of the person
     * @param lastName last name of the person
     * @param age age of the person
     * @param address address of the person
     */
    public Person(String firstName, String lastName, String age, Address address) {
        this.firstName = capitalizeEachLetter(firstName);
        this.lastName = capitalizeEachLetter(lastName);
        this.age = Integer.parseInt(age);
        this.address = address;
    }

    /**
     * Returns the first name of the person
     * @return first name of the person
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the first name of a person
     * @param firstName first name of the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the person
     * @return last name of the person
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the last name of the person
     * @param lastName last name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the age of the person
     * @return age of the person
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets the age of a person
     * @param age sets the age of a person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the address of the person
     * @return address of the person
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Sets the address of a person
     * @param address address of a person
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return lastName + ' ' + firstName + ", " + age + ", " + address;
    }
}
