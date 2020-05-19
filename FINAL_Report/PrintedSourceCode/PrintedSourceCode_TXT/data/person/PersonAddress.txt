/**
 * @author Caroline Ta
 * @since 05.19.2020
 */
package com.company.data.person;

import org.jetbrains.annotations.NotNull;

/**
 * The type Person address.
 */
public class PersonAddress implements Comparable<PersonAddress>{
    /**
     * The street.
     */
    private String street;
    /**
     * The city.
     */
    private String city;
    /**
     * The state.
     */
    private String state;
    /**
     * The zip code.
     */
    private String zip;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------

    /**
     * Instantiates a new Person address.
     */
    public PersonAddress() {

    }

    /**
     * Instantiates a new Person address.
     *
     * @param street the street
     * @param city   the city
     * @param state  the state
     * @param zip    the zip
     * @throws Exception the exception
     */
    public PersonAddress(String street, String city, String state, String zip) throws Exception {
        setStreet(street);
        setCity(city);
        setState(state);
        setZip(zip);
    }

    // -------------------------------------------------------------------------
    // ACCESSORS - GETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Gets zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    // -------------------------------------------------------------------------
    // MUTATORS - SETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Sets street.
     *
     * @param street the street
     * @throws Exception the exception
     */
    public void setStreet(String street) throws Exception {
        checkStringValue(street, "street");
        this.street = street;
    }

    /**
     * Sets city.
     *
     * @param city the city
     * @throws Exception the exception
     */
    public void setCity(String city) throws Exception {
        checkStringValue(city, "city");
        this.city = city;
    }

    /**
     * Sets state.
     *
     * @param state the state
     * @throws Exception the exception
     */
    public void setState(String state) throws Exception {
        checkStringValue(state, "state");
        this.state = state;
    }

    /**
     * Sets zip.
     *
     * @param zip the zip
     * @throws Exception the exception
     */
    public void setZip(String zip) throws Exception {
        checkStringValue(zip, "zip");
        this.zip = zip;
    }

    // -------------------------------------------------------------------------
    // FUNCTIONALITY METHODS
    // -------------------------------------------------------------------------

    /**
     * Check string value.
     *
     * @param valueString   the value string
     * @param attributeName the attribute name
     * @throws Exception the exception
     */
    private void checkStringValue(String valueString, String attributeName) throws Exception {
        if (valueString == null || valueString.trim().equals("")) {
            throw new Exception(attributeName + " must be non-null and non-empty");
        }
    }

    // -------------------------------------------------------------------------
    // OVERRIDDEN METHODS
    // -------------------------------------------------------------------------

    /**
     * Override toString method.
     *
     * @return a string description for the PersonAddress class.
     */
    @Override
    public String toString()
    {
        return street + " St, " + city + ", " + state + ", " + zip;
    }

    /**
     * Override compareTo method.
     *
     * @param otherPerson other person address
     * @return comparision result (i.e -1, 0) between PersonAddresses
     */
    @Override
    public int compareTo(@NotNull PersonAddress otherPerson) {
        if (this.street.equalsIgnoreCase(otherPerson.street)
                && this.city.equalsIgnoreCase(otherPerson.city)
                && this.state.equalsIgnoreCase(otherPerson.state)
                && this.zip == otherPerson.zip) {
            return 0;
        }

        else
        {
            return -1;
        }
    }

    /**
     * Override equals method.
     *
     * @param obj object
     * @return the result of thisPersonAddress equals otherPersonAddress as a boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PersonAddress)) {
            return false;
        }

        return compareTo((PersonAddress) obj) == 0;
    }
}
