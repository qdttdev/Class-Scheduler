/**
 * @author Caroline Ta
 * @since 05.19.2020
 */
package com.company.data.person;

import org.jetbrains.annotations.NotNull;

/**
 * The type Person name.
 */
public class PersonName implements Comparable<PersonName> {

    /**
     * The Person first name.
     */
    private String firstName;
    /**
     * The Person middle name.
     */
    private String midName;
    /**
     * The Person last name.
     */
    private String lastName;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------

    /**
     * Instantiates a new Person name.
     */
    public PersonName() {
    }

    /**
     * Instantiates a new Person name.
     *
     * @param firstName the first name
     * @param midName   the mid name
     * @param lastName  the last name
     * @throws Exception the exception
     */
    public PersonName(String firstName, String midName, String lastName) throws Exception {
        setFirstName(firstName);
        setMidName(midName);
        setLastName(lastName);
    }

    // -------------------------------------------------------------------------
    // ACCESSORS - GETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets mid name.
     *
     * @return the mid name
     */
    public String getMidName() {
        return midName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    // -------------------------------------------------------------------------
    // MUTATORS - SETTER METHODS
    // -------------------------------------------------------------------------

    /**
     * Sets first name.
     *
     * @param firstName the first name
     * @throws Exception the exception
     */
    public void setFirstName(String firstName) throws Exception {
        checkStringValue(firstName, "Firstname");
        this.firstName = firstName;
    }

    /**
     * Sets mid name.
     *
     * @param midName the mid name
     * @throws Exception the exception
     */
    public void setMidName(String midName) throws Exception {
        checkStringValue(firstName, "Midname");
        this.midName = midName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     * @throws Exception the exception
     */
    public void setLastName(String lastName) throws Exception {
        checkStringValue(firstName, "Lastname");
        this.lastName = lastName;
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
     * @return a string description for the PersonName class.
     */
    @Override
    public String toString() {
        return firstName + " " + midName + " " + lastName;
    }

    /**
     * Override compareTo method.
     *
     * @param otherPerson other person name
     * @return comparision result (i.e. -1, 0) between PersonNames.
     */
    @Override
    public int compareTo(@NotNull PersonName otherPerson) {
        if (this.firstName.equalsIgnoreCase(otherPerson.firstName)
                && this.midName.equalsIgnoreCase(otherPerson.midName)
                && this.lastName.equalsIgnoreCase(otherPerson.lastName)) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Override equals method.
     *
     * @param obj object
     * @return the result of thisPersonName equals otherPersonName as a boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PersonName)) {
            return false;
        }

        return compareTo((PersonName) obj) == 0;
    }
}
