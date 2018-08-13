package com.in28minutes.rest.webservices.restfulwebservices.versioning;

public class Name {

    private String firstName;
    private String lastName;

    /**
     * @param firstName
     * @param lastName
     */
    public Name(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}
