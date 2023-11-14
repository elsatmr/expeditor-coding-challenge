package org.expeditor;

import static org.expeditor.Utility.capitalizeEachLetter;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents an address
 */

public class Address {
    private String firstLine;
    private String secondLine;
    private String city;
    private String state;

    /**
     * Constructor for a complete address with first and second line, city, and state
     * @param firstLine first line of address
     * @param secondLine second line of address
     * @param city city
     * @param state state
     */
    public Address(String firstLine, String secondLine, String city, String state) {
        this.firstLine = capitalizeEachLetter(firstLine);
        this.secondLine = capitalizeEachLetter(secondLine);
        this.city = capitalizeEachLetter(city);
        this.state = state.toUpperCase();
    }

    /**
     * Constructor for addresses with first line, city, state, and w/o second line
     * @param firstLine first line of address
     * @param city city
     * @param state state
     */
    public Address(String firstLine, String city, String state) {
        this.firstLine = capitalizeEachLetter(firstLine);
        this.city = capitalizeEachLetter(city);
        this.state = state.toUpperCase();
        this.secondLine = null;
        checkFirstLine();
    }

    /**
     * Helper function to see if the user accidentally types
     * second line of address on the first line of the address
     * if so, it fixes the first line of address and sets the second line
     */
    public void checkFirstLine() {
        String[] splitFirstLine = this.getFirstLine().split(" ");
        if (splitFirstLine.length > 3) {
            StringBuilder firstAddress = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                firstAddress.append(splitFirstLine[i]).append(" ");
            }
            this.setFirstLine(firstAddress.toString().trim());
            this.setSecondLine(String.join(" ", Arrays.copyOfRange(splitFirstLine, 3, splitFirstLine.length)));
        }
    }


    /**
     * Returns the first line of the address
     * @return  first line of the address
     */
    public String getFirstLine() {
        return this.firstLine;
    }

    /**
     * Sets the first line of the address
     * @param firstLine first line of the address
     */
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    /**
     * Returns the second line of the address
     * @return  second line of the address
     */
    public String getSecondLine() {
        return this.secondLine;
    }

    /**
     * Sets the second line of the address
     * @param secondLine second line of the address
     */
    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    /**
     * Returns the city of the address
     * @return  city of the address
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of the address
     * @param city city of the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state of the address
     * @return state of the address
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of the address
     * @param state state of the address
     */
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address that = (Address) o;
        return this.firstLine.equals(that.firstLine) &&
                (Objects.equals(this.secondLine, that.secondLine))
                && this.city.equals(that.city) && this.state.equals(that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstLine, secondLine, city, state);
    }

    @Override
    public String toString() {
        return firstLine +  (secondLine != null ? ", " + secondLine : "") + ", " + city + ", " + state ;
    }
}
